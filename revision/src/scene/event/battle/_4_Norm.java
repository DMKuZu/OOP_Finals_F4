package scene.event.battle;

import elements.creature.enemy.enemyClass.Norm_Enemy;
import elements.creature.hero.Hero;
import game.Game;

public class _4_Norm extends Fight{

    public _4_Norm(Hero HERO, int currWorld, Game GAME){
        super(HERO,new Norm_Enemy(HERO,currWorld,4),currWorld,4,GAME);
    }

}
