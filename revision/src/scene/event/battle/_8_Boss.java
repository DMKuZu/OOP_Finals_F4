package scene.event.battle;

import elements.creature.enemy.enemyClass.Boss_Enemy;
import elements.creature.hero.Hero;
import game.Game;

public class _8_Boss extends Fight{

    public _8_Boss(Hero HERO, int currWorld, Game GAME){
        super(HERO,new Boss_Enemy(HERO,currWorld),currWorld,8,GAME);
    }
}
