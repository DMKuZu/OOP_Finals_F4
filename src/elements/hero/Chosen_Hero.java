package elements.hero;

import calculator.Skill_Calculator;
import elements.blessing.Blessing;
import elements.favor.Favor;
import elements.value.Skills;
import elements.value.Stats;
import elements.enemy.Current_Enemy;
import elements.favor.Favors_Inventory;

import java.util.ArrayList;
import java.util.List;

public class Chosen_Hero implements Supa,Mazupe,Zipau,Radea {
    private final String NAME;
    private Stats STATS;
    private Stats CURRSTATS;

    private final List<Skills> SKILLS;
    private final List<Integer> TOTAL_USES;
    private List<Integer> CURR_USES;

    private Favors_Inventory FAVOR;
    private List<Blessing> BLESSING;
    private int ESSENCE;

    private final Skill_Calculator skill_calc = new Skill_Calculator();

    public Chosen_Hero(String choice){
        switch(choice.toLowerCase()){
            case "radea":
                this.NAME = Radea.name;
                this.STATS = new Stats(Radea.stats);
                this.CURRSTATS = new Stats(Radea.stats);
                this.SKILLS = new ArrayList<>(Radea.skills);
                break;
            case "mazupe":
                this.NAME = Mazupe.name;
                this.STATS = new Stats(Mazupe.stats);
                this.CURRSTATS = new Stats(Mazupe.stats);
                this.SKILLS = new ArrayList<>(Mazupe.skills);
                break;
            case "zipau":
                this.NAME = Zipau.name;
                this.STATS = new Stats(Zipau.stats);
                this.CURRSTATS = new Stats(Zipau.stats);
                this.SKILLS = new ArrayList<>(Zipau.skills);
                break;
            default:
                this.NAME = Supa.name;
                this.STATS = new Stats(Supa.stats);
                this.CURRSTATS = new Stats(Supa.stats);
                this.SKILLS = new ArrayList<>(Supa.skills);
        }

        TOTAL_USES = new ArrayList<>();
        CURR_USES = new ArrayList<>();
        for(Skills skill: SKILLS){
            int uses = skill.getUses();
            TOTAL_USES.add(uses);
            CURR_USES.add(uses);
        }

        FAVOR = new Favors_Inventory();
        BLESSING = new ArrayList<>();
        ESSENCE = 0;
    }




    public String getNAME() {
        return NAME;
    }
    public Stats getSTATS() {
        return STATS;
    }
    public Stats getCURRSTATS() {
        return CURRSTATS;
    }
    public String getSKILL_NAME(int skillNum){
        return SKILLS.get(skillNum-1).getName();
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

    public void addESSENCE(int essence) {
        this.ESSENCE += essence;
    }
    public void useESSENCE(){ this.ESSENCE--;}
    public void addBLESSING(Blessing blessing){
        BLESSING.add(blessing);
    }
    public String swapFavor(int favorNum){
        Favor swapped = FAVOR.useFavor(favorNum);
        Favor pulled = FAVOR.offer();
        return "Exchanged " + swapped.getName() + " with " + pulled.getName() + "!";
    }






////////////////////////////////////////////////////////////////////////affects hero
    public String use_skill(int skillNum, Current_Enemy enemy){
        int damage = 0,use;
        boolean isAHit = false, hasUses = true;
        boolean[] isCrit = new boolean[1];

        ///calculates damage and decrements uses
        switch (skillNum){
            case 1:
                damage = skill_calc.calculate_damage(SKILLS.get(0).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                break;
            case 2:
                damage = skill_calc.calculate_damage(SKILLS.get(1).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                use = CURR_USES.get(1);
                if(use > 0) CURR_USES.set(1,use-1);
                else hasUses = false;

                break;
            case 3:
                damage = skill_calc.calculate_damage(SKILLS.get(2).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                use = CURR_USES.get(2);
                if(use > 0) CURR_USES.set(2,use-1);
                else hasUses = false;

                break;
            case 4:
                damage = skill_calc.calculate_damage(SKILLS.get(3).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                use = CURR_USES.get(3);
                if(use > 0) CURR_USES.set(3,use-1);
                else hasUses = false;

                break;
            case 5:
                damage = skill_calc.calculate_damage(SKILLS.get(4).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                use = CURR_USES.get(4);
                if(use > 0) CURR_USES.set(4,use-1);
                else hasUses = false;

                break;
        }

        ///checks if skill has uses and is a hit
        int enemyHP = enemy.getCURRSTATS().getHP();
        if(hasUses){
            if(isAHit){
                enemy.getCURRSTATS().setHP(Math.max(enemyHP - damage,0));

                if(isCrit[0]) return "Used " + getSKILL_NAME(skillNum) + "->  CRIT! Dealt " + damage + " damage!";
                else return "Used " + getSKILL_NAME(skillNum) + "->  Dealt " + damage + " damage!";
            }
            else{
                return "Skill missed!";
            }
        }
        else{
            return "Skill has no uses left!";
        }
    }

    public String use_favor(int favorNum){
        if(FAVOR.getFavorName(favorNum).contains("none")) {
            return "no favors";
        }
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

    public void apply_blessing(Blessing blessing){
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


/////////////////////////////////////////////////////////////////////////////// descriptions
    public void statDesc(){
        System.out.printf ("|| HP   : %d | %d\n",CURRSTATS.getHP(),STATS.getHP());
        System.out.printf ("|| ATK  : %d -> %d \n",STATS.getATK(),CURRSTATS.getATK());
        System.out.printf ("|| DEF  : %d -> %d \n",STATS.getDEF(),CURRSTATS.getDEF());
        System.out.printf ("|| DODGE: %d%% -> %d%% \n",(int)(STATS.getDODGE()*100),(int)(CURRSTATS.getDODGE()*100));
        System.out.printf ("|| CRIT : %d%% -> %d%%\n",(int)(STATS.getCRIT()*100),(int)(CURRSTATS.getCRIT()*100));
    }

    public void skillDesc(){
        for (Skills s: SKILLS) {
            System.out.println("|| " + s.getName() + " -> damages the enemy");
        }
    }

    public void blessingDesc(){
        for(Blessing blessing : BLESSING){
            System.out.println("|| " + blessing.toString());
        }
    }
}
