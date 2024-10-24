package elements.creature.hero;

import elements.blessing.Blessing;
import elements.creature.Creature;
import elements.favor.Favor;
import elements.creature.value.Skills;
import elements.creature.enemy.Enemy;
import elements.favor.Favors_Inventory;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero extends Creature {
    protected  List<Integer> TOTAL_USES;
    protected  List<Integer> CURR_USES;

    protected  Favors_Inventory FAVOR;
    protected  List<Blessing> BLESSING;
    protected  int ESSENCE;

    ////////////////////////////////////////////////////////////////////////getter

    protected Hero(){
        TOTAL_USES = new ArrayList<>();
        CURR_USES = new ArrayList<>();

        FAVOR = new Favors_Inventory();
        BLESSING = new ArrayList<>();
        ESSENCE = 0;
    }

    public int getTOTAL_USES(int skillNum) {
        return TOTAL_USES.get(skillNum-1);
    }
    public int getCURR_USES(int skillNum) {
        return CURR_USES.get(skillNum-1);
    }
    public int getESSENCE() {
        return ESSENCE;
    }
    public Favors_Inventory getFAVOR() {
        return FAVOR;
    }


    ////////////////////////////////////////////////////////////////////////setter
    public void useESSENCE(){ this.ESSENCE = (ESSENCE > 0) ? ESSENCE-1 : 0;}

    public void add_essence(int essence) {
        this.ESSENCE += essence;
    }

    public String swapFavor(int favorNum){
        Favor swapped = FAVOR.useFavor(favorNum);
        Favor pulled = FAVOR.offer();
        return "Exchanged " + swapped.getName() + " with " + pulled.getName() + "!";
    }


    public String use_favor(int favorNum){
        Favor used = FAVOR.useFavor(favorNum);
        switch(used.getStat()){
            case "HP":
                int newHP = CURRSTATS.getHP() + used.getValue();
                CURRSTATS.setHP(Math.min(newHP,STATS.getHP()));
                break;
            case "ATK":
                int newATK = CURRSTATS.getATK() + used.getValue();
                CURRSTATS.setATK(newATK);
                break;
            case "DEF":
                int newDEF = CURRSTATS.getDEF() + used.getValue();
                CURRSTATS.setDEF(newDEF);
                break;
            case "DODGE":
                double newDODGE = CURRSTATS.getDODGE() + (used.getValue()/100.0);
                CURRSTATS.setDODGE(newDODGE);
                break;
            case "CRIT":
                double newCRIT = CURRSTATS.getCRIT() + (used.getValue()/100.0);
                CURRSTATS.setCRIT(newCRIT);
                break;
            case "USES":
                for(int i = 1; i < CURR_USES.size(); i++){
                    int newUses = CURR_USES.get(i) + used.getValue();
                    CURR_USES.set(i,Math.min(newUses,TOTAL_USES.get(i)));
                }
                break;
        }

        return "Used " + used.getName();
    }

    public void refresh_encounter(){
        CURRSTATS.setATK(STATS.getATK());
        CURRSTATS.setDEF(STATS.getDEF());
        CURRSTATS.setDODGE(STATS.getDODGE());
        CURRSTATS.setCRIT(STATS.getCRIT());
    }

    public void refresh_world(){
        CURRSTATS.setHP(STATS.getHP());
        CURRSTATS.setATK(STATS.getATK());
        CURRSTATS.setDEF(STATS.getDEF());
        CURRSTATS.setDODGE(STATS.getDODGE());
        CURRSTATS.setCRIT(STATS.getCRIT());
        for(int i = 1; i < CURR_USES.size(); i++){
            CURR_USES.set(i,TOTAL_USES.get(i));
        }
    }

    public void rest(boolean isHeal){
        if(isHeal){
            CURRSTATS.setHP(Math.min((int)(STATS.getHP() * 0.30) + CURRSTATS.getHP(),STATS.getHP()));
        }
        else{
            for(int i = 1; i < CURR_USES.size(); i++){
                CURR_USES.set(i,TOTAL_USES.get(i));
            }
        }
    }



    public void add_blessing(Blessing blessing){
        BLESSING.add(blessing);

        switch (blessing.getStat()){
            case "HP":
                STATS.setHP(STATS.getHP() + blessing.getValue());
                CURRSTATS.setHP(CURRSTATS.getHP() + blessing.getValue());
                break;
            case "ATK":
                STATS.setATK(STATS.getATK() + blessing.getValue());
                break;
            case "DEF":
                STATS.setDEF(STATS.getDEF() + blessing.getValue());
                break;
            case "DODGE":
                STATS.setDODGE(STATS.getDODGE() + (blessing.getValue()/100.0));
                break;
            case "CRIT":
                STATS.setCRIT(STATS.getCRIT() + (blessing.getValue()/100.0));
                break;
        }
    }

    ////////////////////////////////////////////////////////////////////////HERO stuff

    protected String skill(int skillNum, boolean isCrit, int damage, Creature creature) {
        if(isCrit) return NAME + " used " + getSKILL_NAME(skillNum) + ".\nCRIT! Dealt " + damage + " damage!";
        else return NAME + " used " + getSKILL_NAME(skillNum) + ".\nDealt " + damage + " damage!";
    }

    public String use_skill(int skillNum, Enemy enemy){
        int damage, uses;
        boolean isAHit, hasUses = true;
        boolean[] isCrit = new boolean[1];
        String msg;

        damage = calc.calculate_damage(SKILLS.get(skillNum-1).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
        isAHit = calc.hit_chance(enemy.getCURRSTATS().getDODGE());

        if(skillNum > 1){
            uses = CURR_USES.get(skillNum-1);
            if(uses > 0) CURR_USES.set(skillNum-1, uses -1);
            else hasUses = false;
        }

        msg = skill(skillNum,isCrit[0],damage,enemy);

        ////checks if skill has uses and is a hit
        int enemyHP = enemy.getCURRSTATS().getHP();
        if(hasUses){
            if(isAHit){
                enemy.getCURRSTATS().setHP(Math.max(enemyHP - damage,0));

                return msg;
            }
            else{
                return NAME + "'s skill missed!";
            }
        }
        else{
            return "default rani kumbaga";
        }
    }

    public Boolean hasUses(int skillNum){
        return getCURR_USES(skillNum) > 0;
    }

    /////////////////////////////////////////////////////////////////////////////// descriptions
    public String statDesc(){
        return String.format(
                "HP    : %d | %d\n" +
                "ATK   : %d -> %d\n" +
                "DEF   : %d -> %d\n" +
                "DODGE : %d%% -> %d%%\n" +
                "CRIT  : %d%% -> %d%%\n",
                CURRSTATS.getHP(), STATS.getHP(),
                STATS.getATK(), CURRSTATS.getATK(),
                STATS.getDEF(), CURRSTATS.getDEF(),
                (int) (STATS.getDODGE() * 100), (int) (CURRSTATS.getDODGE() * 100),
                (int) (STATS.getCRIT() * 100), (int) (CURRSTATS.getCRIT() * 100)
        );


    }

    public String skillUses(){
        StringBuilder description = new StringBuilder();
        int i = 0;
        for (Skills skill : SKILLS) {
            i++;
            if(i == 1){
                description.append(String.format("> %s\n", skill.getName()));
            }
            else description.append(String.format("> %s  ->  %d | %d\n", skill.getName(),getCURR_USES(i),getTOTAL_USES(i)));
        }
        return description.toString();
    }

    public String skillDesc(){
        StringBuilder description = new StringBuilder();
        int i = 0;
        for (Skills skill : SKILLS) {
            i++;
            if(i == 1){
                description.append(String.format("%s -> deals damage\n", skill.getName()));
            }
            else description.append(String.format("%s -> deals damage -> %d | %d\n", skill.getName(),getCURR_USES(i),getTOTAL_USES(i)));
        }
        return description.toString();
    }

    public String chooseSkill(){
        StringBuilder description = new StringBuilder();
        int i = 0;
        for (Skills skill : SKILLS) {
            i++;
            if(getCURR_USES(i)<= 0) continue;
            description.append(String.format("%d : %s\n", i,skill.getName()));
        }
        return description.toString();
    }

    public String blessingDesc() {
        StringBuilder description = new StringBuilder();
        for (Blessing blessing : BLESSING) {
            description.append(String.format("%s\n", blessing.toString()));
        }
        return description.toString();
    }


}
