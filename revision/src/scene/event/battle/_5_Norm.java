package scene.event.battle;

import elements.creature.enemy.enemyClass.Norm_Enemy;
import elements.creature.hero.Hero;
import game.Game;

public class _5_Norm extends Fight{

    public _5_Norm(Hero HERO, int currWorld, Game GAME){
        super(HERO,new Norm_Enemy(HERO,currWorld,5),currWorld,5,GAME);
    }

}
