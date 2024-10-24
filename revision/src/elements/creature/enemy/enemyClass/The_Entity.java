package elements.creature.enemy.enemyClass;

import elements.creature.enemy.Enemy;
import elements.creature.hero.Hero;
import elements.creature.value.Skills;

import java.util.Arrays;

public class The_Entity extends Enemy {

    protected The_Entity(Hero hero){
        super(hero,1.5,1.6,0.7,0.6,0.5);

        NAME = "The Entity";
        SKILLS = Arrays.asList(
                new Skills("Void of Extinction", 10, 0),
                new Skills("Reality Collapse", 15, 0),
                new Skills("Corruption Manifest", 20, 0),
                new Skills("Eternal Darkness", 30, 0),
                new Skills("World Ender", 45, 0)
        );
    }

}
