package scene.event.battle;

import elements.creature.enemy.enemyClass.Norm_Enemy;
import elements.creature.hero.Hero;
import game.Game;

public class _2_Norm extends Fight{

    public _2_Norm(Hero HERO, int currWorld, Game GAME){
        super(HERO,new Norm_Enemy(HERO,currWorld,2),currWorld,2,GAME);
    }

}
