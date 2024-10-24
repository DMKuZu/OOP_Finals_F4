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
        super();
        this.HERO = hero;
        int HP = (int) Math.min(hero.getSTATS().getHP() * hp,500);
        int ATK = (int) Math.min(hero.getSTATS().getATK() * atk,500);
        int DEF = (int) Math.min(hero.getSTATS().getDEF() * def,500);

        STATS = new Stats(HP,ATK,DEF,dodge,crit);
        CURRSTATS = new Stats(HP,ATK,DEF,dodge,crit);

    }

    public String attack() {
        Random rand = new Random();
        int skillNum = rand.nextInt(5) + 1;

        return useSkill(skillNum);
    }

    protected String useSkill(int skillNum) {
        boolean isAHit = CALC.hit_chance(HERO.getCURRSTATS().getDODGE());
        if(!isAHit){
            return NAME + "'s skill missed!";
        }

        boolean[] isCrit = new boolean[1];
        int damage = CALC.calculate_damage(SKILLS.get(skillNum-1).getBaseDmg(), CURRSTATS.getATK(), CURRSTATS.getCRIT(),HERO.getCURRSTATS().getDEF(),isCrit);

        int heroHP = HERO.getCURRSTATS().getHP();
        HERO.getCURRSTATS().setHP(Math.max(heroHP - damage, 0));

        return skill(skillNum,isCrit[0],damage,HERO);
    }



}
