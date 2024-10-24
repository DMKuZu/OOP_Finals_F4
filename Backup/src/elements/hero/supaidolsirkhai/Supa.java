package elements.hero.supaidolsirkhai;

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

public class Supa extends Chosen_Hero {

    public Supa(){
        this.NAME = "SupaIdolSirKhaiGumonan";
        this.STATS = new Stats(6969,6969,-6969,1.0,1.0);
        this.CURRSTATS = new Stats(6969,6969,-6969,1.0,1.0);
        this.SKILLS = Arrays.asList(
                new Skills("Reality Warp",10,1),
                new Skills("Dimensional Shift",15,9),
                new Skills("Entropy Wave",20,7),
                new Skills("Void Embrace",25,5),
                new Skills("Ultimate Erasure",30,3)
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




///////////////////////////////////////////////////////////////////////////////////////////////////////////// useless
    protected String skill1(boolean isCrit, int damage, Chosen_Hero hero) {
        return "";
    }
    protected String skill2(boolean isCrit, int damage, Chosen_Hero hero) {
        return "";
    }
    protected String skill3(boolean isCrit, int damage, Chosen_Hero hero) {
        return "";
    }
    protected String skill4(boolean isCrit, int damage, Chosen_Hero hero) {
        return "";
    }
    protected String skill5(boolean isCrit, int damage, Chosen_Hero hero) {
        return "";
    }
    public String boss_use_skill(int skillNum, Chosen_Hero hero) {
        return "";
    }
}



