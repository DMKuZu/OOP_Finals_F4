package elements.hero;

import calculator.Skill_Calculator;
import elements.blessing.Blessing;
import elements.favor.Favor;
import elements.value.Skills;
import elements.value.Stats;
import elements.enemy.Current_Enemy;
import elements.favor.Favors_Inventory;

import java.util.List;

public abstract class Chosen_Hero {
    protected  String NAME;
    protected  Stats STATS;
    protected  Stats CURRSTATS;
    protected  List<Skills> SKILLS;
    protected  List<Integer> TOTAL_USES;
    protected  List<Integer> CURR_USES;

    protected  Favors_Inventory FAVOR;
    protected  List<Blessing> BLESSING;
    protected int ESSENCE;

    protected Skill_Calculator skill_calc = new Skill_Calculator();

    ////////////////////////////////////////////////////////////////////////getter

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


    public void replenishUSES(){
        for(int i = 1; i < CURR_USES.size(); i++){
            int newUses = CURR_USES.get(i) + 5;
            CURR_USES.set(i,Math.min(newUses,TOTAL_USES.get(i)));
        }
    }

    public void healHP(){
        double plusHP = (STATS.getHP() * 0.30);
        int maxHP = STATS.getHP();
        int currHP = CURRSTATS.getHP();

        CURRSTATS.setHP(Math.min(maxHP,(int)Math.round(plusHP+currHP)));
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


    public abstract String use_skill(int skillNum, Current_Enemy enemy);


    //////////////////////////////////////////////////////////////////////// boss stuff


    public abstract String boss_use_skill(int skillNum, Chosen_Hero hero);

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
