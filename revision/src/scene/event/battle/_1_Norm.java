package scene.event.battle;

import elements.creature.enemy.enemyClass.Norm_Enemy;
import elements.creature.hero.Hero;
import game.Game;

public class _1_Norm extends Fight {


    public _1_Norm(Hero HERO, int currWorld, Game GAME){
        super(HERO,new Norm_Enemy(HERO,currWorld,1),currWorld,1,GAME);
    }




}
