package elements.creature.enemy.enemyClass;

import elements.creature.enemy.Enemy;
import elements.creature.hero.Hero;
import elements.creature.value.Skills;

import java.util.ArrayList;
import java.util.Arrays;

public class The_Entity_Enemy extends Enemy {

    public The_Entity_Enemy(Hero hero){
        super(hero,1.3,2.4,0.7,0.6,0.5);

        NAME = "The Entity";
        SKILLS = new ArrayList<>(Arrays.asList(
                new Skills("Void of Extinction", 10, 0),
                new Skills("Reality Collapse", 15, 0),
                new Skills("Corruption Manifest", 20, 0),
                new Skills("Eternal Darkness", 30, 0),
                new Skills("World Ender", 45, 0)
        ));
    }

}
