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
    public void addESSENCE(int essence) {
        this.ESSENCE += essence;
    }


    ////////////////////////////////////////////////////////////////////////setter
    public void useESSENCE(){ this.ESSENCE--;}
    public void addBLESSING(Blessing blessing){
        BLESSING.add(blessing);
    }
    public String swapFavor(int favorNum){
        Favor swapped = FAVOR.useFavor(favorNum);
        Favor pulled = FAVOR.offer();
        return "Exchanged " + swapped.getName() + " with " + pulled.getName() + "!";
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



    ////////////////////////////////////////////////////////////////////////hero stuff

    protected String skill(int skillNum, boolean isCrit, int damage, Creature creature) {
        if(isCrit) return "Used " + getSKILL_NAME(skillNum) + ".\n|| CRIT! Dealt " + damage + " damage!";
        else return "Used " + getSKILL_NAME(skillNum) + ".\n|| Dealt " + damage + " damage!";
    }

    public String use_skill(int skillNum, Enemy enemy){
        int damage = 0, uses;
        boolean isAHit = false, hasUses = true;
        boolean[] isCrit = new boolean[1];
        String msg = "";


        switch (skillNum){
            case 1:
                damage = calc.calculate_damage(SKILLS.get(0).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                break;
            case 2:
                damage = calc.calculate_damage(SKILLS.get(1).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                uses = CURR_USES.get(1);
                if(uses > 0) CURR_USES.set(1, uses -1);
                else hasUses = false;


                break;
            case 3:
                damage = calc.calculate_damage(SKILLS.get(2).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                uses = CURR_USES.get(2);
                if(uses > 0) CURR_USES.set(2, uses -1);
                else hasUses = false;


                break;
            case 4:
                damage = calc.calculate_damage(SKILLS.get(3).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                uses = CURR_USES.get(3);
                if(uses > 0) CURR_USES.set(3, uses -1);
                else hasUses = false;


                break;
            case 5:
                damage = calc.calculate_damage(SKILLS.get(4).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                uses = CURR_USES.get(4);
                if(uses > 0) CURR_USES.set(4, uses -1);
                else hasUses = false;


                break;
        }

        msg = skill(skillNum,isCrit[0],damage,enemy);

        ///checks if skill has uses and is a hit
        int enemyHP = enemy.getCURRSTATS().getHP();
        if(hasUses){
            if(isAHit){
                enemy.getCURRSTATS().setHP(Math.max(enemyHP - damage,0));

                return msg;
            }
            else{
                return "Skill missed!";
            }
        }
        else{
            return "Skill has no uses.";
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
