package scene.event.battle;

import elements.creature.enemy.enemyClass.Elite_Enemy;
import elements.creature.hero.Hero;
import game.Game;

public class _6_Elite extends Fight{
    public _6_Elite(Hero HERO, int currWorld, Game GAME){
        super(HERO,new Elite_Enemy(HERO,currWorld,6),currWorld,6,GAME);
    }
}
