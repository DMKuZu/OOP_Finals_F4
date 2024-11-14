package elements.hero.mazupe;

import calculator.Skill_Calculator;
import elements.blessing.Blessing;
import elements.enemy.Current_Enemy;
import elements.favor.Favor;
import elements.favor.Favors_Inventory;
import elements.hero.Chosen_Hero;
import elements.value.Skills;
import elements.value.Stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mazupe extends Chosen_Hero  {
    private final String NAME;
    private final Stats STATS;
    private final Stats CURRSTATS;
    private final List<Skills> SKILLS;
    private final List<Integer> TOTAL_USES;
    private final List<Integer> CURR_USES;

    private final Favors_Inventory FAVOR;
    private final List<Blessing> BLESSING;
    private int ESSENCE;

    private final Skill_Calculator skill_calc = new Skill_Calculator();

    public Mazupe(){
        this.NAME = "Mazupe";
        this.STATS = new Stats(200,20,30,0.02,0.06);
        this.CURRSTATS = new Stats(200,20,30,0.02,0.06);
        this.SKILLS= Arrays.asList(
                new Skills("Basic Strike",20,1),
                new Skills("Mountain Breaker",30,12),
                new Skills("War Cry",0,15),
                new Skills("Stone SKin",0,15),
                new Skills("Titan's Grip",50,5)
        );
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

    public Mazupe(Stats STATS, Stats CURRSTATS){    //evil mazupe
        this.NAME = "Corrupted Mazupe";
        this.STATS = new Stats(STATS);
        this.CURRSTATS = new Stats(CURRSTATS);
        this.SKILLS= Arrays.asList(
                new Skills("Basic Strike",20,1),
                new Skills("Mountain Breaker",30,12),
                new Skills("War Cry",0,15),
                new Skills("Stone SKin",0,15),
                new Skills("Titan's Grip",50,5)
        );

        /////////////////////////////////// none below matters since this is the boss
        TOTAL_USES = null;
        CURR_USES = null;

        FAVOR = null;
        BLESSING = null;
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

    //uses decrements should be in the use_skill method
    //damage and the enemy stat set should be done on the skills method
    protected String skill1(boolean isCrit, int damage, Current_Enemy enemy) {

        if(isCrit) return "Used " + getSKILL_NAME(1) + ".\n|| CRIT! Dealt " + damage + " damage!";
        else return "Used " + getSKILL_NAME(1) + ".\n|| Dealt " + damage + " damage!";
    }

    protected String skill2(boolean isCrit, int damage, Current_Enemy enemy) {

        if(isCrit) return "Used " + getSKILL_NAME(2) + ".\n|| CRIT! Dealt " + damage + " damage!";
        else return "Used " + getSKILL_NAME(2) + ".\n|| Dealt " + damage + " damage!";
    }

    protected String skill3(boolean isCrit, int damage, Current_Enemy enemy) {

        if(isCrit) return "Used " + getSKILL_NAME(3) + ".\n|| CRIT! Dealt " + damage + " damage!";
        else return "Used " + getSKILL_NAME(3) + ".\n|| Dealt " + damage + " damage!";
    }

    protected String skill4(boolean isCrit, int damage, Current_Enemy enemy) {

        if(isCrit) return "Used " + getSKILL_NAME(4) + ".\n|| CRIT! Dealt " + damage + " damage!";
        else return "Used " + getSKILL_NAME(4) + ".\n|| Dealt " + damage + " damage!";
    }

    protected String skill5(boolean isCrit, int damage, Current_Enemy enemy) {

        if(isCrit) return "Used " + getSKILL_NAME(5) + ".\n|| CRIT! Dealt " + damage + " damage!";
        else return "Used " + getSKILL_NAME(5) + ".\n|| Dealt " + damage + " damage!";
    }

    public String use_skill(int skillNum, Current_Enemy enemy){
        int damage = 0, uses;
        boolean isAHit = false, hasUses = true;
        boolean[] isCrit = new boolean[1];
        String msg = "";


        switch (skillNum){
            case 1:
                damage = skill_calc.calculate_damage(SKILLS.get(0).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                msg = skill1(isCrit[0],damage,enemy);

                break;
            case 2:
                damage = skill_calc.calculate_damage(SKILLS.get(1).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                uses = CURR_USES.get(1);
                if(uses > 0) CURR_USES.set(1, uses -1);
                else hasUses = false;

                msg = skill2(isCrit[0],damage,enemy);

                break;
            case 3:
                damage = skill_calc.calculate_damage(SKILLS.get(2).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                uses = CURR_USES.get(2);
                if(uses > 0) CURR_USES.set(2, uses -1);
                else hasUses = false;

                msg = skill3(isCrit[0],damage,enemy);

                break;
            case 4:
                damage = skill_calc.calculate_damage(SKILLS.get(3).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                uses = CURR_USES.get(3);
                if(uses > 0) CURR_USES.set(3, uses -1);
                else hasUses = false;

                msg = skill4(isCrit[0],damage,enemy);

                break;
            case 5:
                damage = skill_calc.calculate_damage(SKILLS.get(4).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                uses = CURR_USES.get(4);
                if(uses > 0) CURR_USES.set(4, uses -1);
                else hasUses = false;

                msg = skill5(isCrit[0],damage,enemy);

                break;
        }

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
            return "no uses";
        }
    }


    protected String skill1(boolean isCrit, int damage, Chosen_Hero hero) {

        if(isCrit) return "Used " + getSKILL_NAME(1) + ".\n|| CRIT! Dealt " + damage + " damage!";
        else return "Used " + getSKILL_NAME(1) + ".\n|| Dealt " + damage + " damage!";
    }

    protected String skill2(boolean isCrit, int damage, Chosen_Hero hero){

        if(isCrit) return "Used " + getSKILL_NAME(2) + ".\n|| CRIT! Dealt " + damage + " damage!";
        else return "Used " + getSKILL_NAME(2) + ".\n|| Dealt " + damage + " damage!";
    }

    protected String skill3(boolean isCrit, int damage, Chosen_Hero hero) {

        if(isCrit) return "Used " + getSKILL_NAME(3) + ".\n|| CRIT! Dealt " + damage + " damage!";
        else return "Used " + getSKILL_NAME(3) + ".\n|| Dealt " + damage + " damage!";
    }

    protected String skill4(boolean isCrit, int damage, Chosen_Hero hero) {

        if(isCrit) return "Used " + getSKILL_NAME(4) + ".\n|| CRIT! Dealt " + damage + " damage!";
        else return "Used " + getSKILL_NAME(4) + ".\n|| Dealt " + damage + " damage!";
    }

    protected String skill5(boolean isCrit, int damage, Chosen_Hero hero) {

        if(isCrit) return "Used " + getSKILL_NAME(5) + ".\n|| CRIT! Dealt " + damage + " damage!";
        else return "Used " + getSKILL_NAME(5) + ".\n|| Dealt " + damage + " damage!";
    }

    public String boss_use_skill(int skillNum,Chosen_Hero hero){
        int damage = 0;
        boolean isAHit = false;
        boolean[] isCrit = new boolean[1];
        String msg = "";


        switch (skillNum){
            case 1:
                damage = skill_calc.calculate_damage(SKILLS.get(0).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(hero.getCURRSTATS().getDODGE());

                msg = skill1(isCrit[0],damage,hero);

                break;
            case 2:
                damage = skill_calc.calculate_damage(SKILLS.get(1).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(hero.getCURRSTATS().getDODGE());

                msg = skill2(isCrit[0],damage,hero);

                break;
            case 3:
                damage = skill_calc.calculate_damage(SKILLS.get(2).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(hero.getCURRSTATS().getDODGE());

                msg = skill3(isCrit[0],damage,hero);

                break;
            case 4:
                damage = skill_calc.calculate_damage(SKILLS.get(3).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(hero.getCURRSTATS().getDODGE());

                msg = skill4(isCrit[0],damage,hero);

                break;
            case 5:
                damage = skill_calc.calculate_damage(SKILLS.get(4).getBaseDmg(),CURRSTATS.getATK(),CURRSTATS.getCRIT(),hero.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(hero.getCURRSTATS().getDODGE());

                msg = skill5(isCrit[0],damage,hero);

                break;
        }

        ///checks if skill is a hit
        int heroHP = hero.getCURRSTATS().getHP();

        if(isAHit){
            hero.getCURRSTATS().setHP(Math.max(heroHP - damage,0));

            return msg;
        }
        else{
            return "Skill missed!";
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
