package elements.creature.enemy;


import elements.creature.Creature;
import elements.creature.enemy.enemyInterface.Azrueian_Enemies;
import elements.creature.enemy.enemyInterface.Quaceron_Enemies;
import elements.creature.enemy.enemyInterface.Saroian_Enemies;
import elements.creature.value.Stats;
import elements.creature.hero.Hero;

import java.util.Random;


public abstract class Enemy extends Creature implements Azrueian_Enemies, Saroian_Enemies, Quaceron_Enemies {
    protected Hero HERO;

    protected Enemy(Hero hero,double hp,double atk,double def,double dodge, double crit){
        this.HERO = hero;
        int HP = (int) (hero.getSTATS().getHP() * hp);
        int ATK = (int) (hero.getSTATS().getATK() * atk);
        int DEF = (int) (hero.getSTATS().getDEF() * def);

        STATS = new Stats(HP,ATK,DEF,dodge,crit);
        CURRSTATS = new Stats(HP,ATK,DEF,dodge,crit);

    }

    public String attack() {
        Random rand = new Random();
        int skillNum = rand.nextInt(5) + 1;

        return useSkill(skillNum);
    }

    protected String useSkill(int skillNum) {
        int damage = 0;
        boolean isAHit = false;
        boolean[] isCrit = new boolean[1];

        switch (skillNum){
            case 1:
                damage = calc.calculate_damage(SKILLS.get(0).getBaseDmg(), CURRSTATS.getATK(), CURRSTATS.getCRIT(),HERO.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(HERO.getCURRSTATS().getDODGE());
                break;
            case 2:
                damage = calc.calculate_damage(SKILLS.get(1).getBaseDmg(), CURRSTATS.getATK(), CURRSTATS.getCRIT(),HERO.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(HERO.getCURRSTATS().getDODGE());
                break;
            case 3:
                damage = calc.calculate_damage(SKILLS.get(2).getBaseDmg(), CURRSTATS.getATK(), CURRSTATS.getCRIT(),HERO.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(HERO.getCURRSTATS().getDODGE());
                break;
            case 4:
                damage = calc.calculate_damage(SKILLS.get(3).getBaseDmg(), CURRSTATS.getATK(), CURRSTATS.getCRIT(),HERO.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(HERO.getCURRSTATS().getDODGE());
                break;
            case 5:
                damage = calc.calculate_damage(SKILLS.get(4).getBaseDmg(), CURRSTATS.getATK(), CURRSTATS.getCRIT(),HERO.getCURRSTATS().getDEF(),isCrit);
                isAHit = calc.hit_chance(HERO.getCURRSTATS().getDODGE());
                break;
        }

        int heroHP = HERO.getCURRSTATS().getHP();
        if(isAHit){
            HERO.getCURRSTATS().setHP(Math.max(heroHP - damage, 0));

            if(isCrit[0]) return "Used " + getSKILL_NAME(1) + ".\n|| CRIT! Dealt " + damage + " damage!";
            else return "Used " + getSKILL_NAME(1) + ".\n|| Dealt " + damage + " damage!";
        }
        else{
            return "Skill missed!";
        }
    }



}
