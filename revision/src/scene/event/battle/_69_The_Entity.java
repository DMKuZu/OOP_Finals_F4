package scene.event.battle;

import elements.creature.enemy.enemyClass.The_Entity_Enemy;
import elements.creature.hero.Hero;
import game.Game;

public class _69_The_Entity extends Fight{

    public _69_The_Entity(Hero HERO, Game GAME){
        super(HERO,new The_Entity_Enemy(HERO),4,1,GAME);
    }
}
