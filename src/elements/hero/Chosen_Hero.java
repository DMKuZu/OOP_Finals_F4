package elements.hero;

import calculator.Skill_Calculator;
import elements.blessing.Blessing;
import elements.favor.Favor;
import elements.stat.Stats;
import elements.enemy.Current_Enemy;
import elements.favor.Favors_Inventory;

import java.util.ArrayList;
import java.util.List;

public class Chosen_Hero implements List_of_Characters {
    private final String NAME;
    private Stats STATS;
    private Stats CURRSTATS;

    private final List<String> SKILL_NAME;
    private final List<Integer> BASE_DMG;
    private final List<Integer> TOTAL_USES;
    private List<Integer> CURR_USES;

    private final Skill_Calculator skill_calc = new Skill_Calculator();

    private Favors_Inventory FAVOR;

    private List<Blessing> BLESSING;

    private int ESSENCE;

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
        return SKILL_NAME.get(skillNum-1);
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
    public List<Blessing> getBLESSING() {
        return BLESSING;
    }
    public Blessing getBLESSING(int index) {
        return BLESSING.get(index);
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
        Favor pulled = FAVOR.gacha();
        return "Exchanged " + swapped.getName() + " with " + pulled.getName() + "!";
    }

    public Chosen_Hero(String hero){
        NAME = NAME_List.get(hero);
        STATS = new Stats(HP_List.get(hero), ATK_List.get(hero), DEF_List.get(hero), DODGE_List.get(hero), CRIT_List.get(hero));
        CURRSTATS = new Stats(HP_List.get(hero), ATK_List.get(hero), DEF_List.get(hero), DODGE_List.get(hero), CRIT_List.get(hero));

        SKILL_NAME = SKILL_NAME_List.get(hero);
        BASE_DMG = BASE_DMG_List.get(hero);
        TOTAL_USES = TOTAL_USES_List.get(hero);
        CURR_USES = new ArrayList<>(TOTAL_USES);

        FAVOR = new Favors_Inventory();
        ESSENCE = 0;
        BLESSING = new ArrayList<>();
    }


    public String use_skill(int skillNum, Current_Enemy enemy){
        int damage = 0,use;
        boolean isAHit = false, hasUses = true;
        boolean[] isCrit = new boolean[1];

        ///calculates damage and decrements uses
        switch (skillNum){
            case 1:
                damage = skill_calc.calculate_damage(BASE_DMG.get(0),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                break;
            case 2:
                damage = skill_calc.calculate_damage(BASE_DMG.get(1),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                use = CURR_USES.get(1);
                if(use > 0) CURR_USES.set(1,use-1);
                else hasUses = false;

                break;
            case 3:
                damage = skill_calc.calculate_damage(BASE_DMG.get(2),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                use = CURR_USES.get(2);
                if(use > 0) CURR_USES.set(2,use-1);
                else hasUses = false;

                break;
            case 4:
                damage = skill_calc.calculate_damage(BASE_DMG.get(3),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
                isAHit = skill_calc.hit_chance(enemy.getCURRSTATS().getDODGE());

                use = CURR_USES.get(3);
                if(use > 0) CURR_USES.set(3,use-1);
                else hasUses = false;

                break;
            case 5:
                damage = skill_calc.calculate_damage(BASE_DMG.get(4),CURRSTATS.getATK(),CURRSTATS.getCRIT(),enemy.getCURRSTATS().getDEF(),isCrit);
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
        for (String s : SKILL_NAME) {
            System.out.println("|| " + s + " -> damages the enemy");
        }
    }

    public void blessingDesc(){
        for(Blessing blessing : BLESSING){
            System.out.println("|| " + blessing.toString());
        }
    }
}
