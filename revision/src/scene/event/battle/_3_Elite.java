package scene.event.battle;

import elements.creature.enemy.enemyClass.Elite_Enemy;
import elements.creature.hero.Hero;
import game.Game;

public class _3_Elite extends Fight{

    public _3_Elite(Hero HERO, int currWorld, Game GAME){
        super(HERO,new Elite_Enemy(HERO,currWorld,3),currWorld,3,GAME);
    }
}
