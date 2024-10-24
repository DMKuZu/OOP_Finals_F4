package elements.creature.enemy.enemyClass;

import elements.creature.enemy.Enemy;
import elements.creature.hero.Hero;
import elements.creature.value.Skills;

import java.util.ArrayList;
import java.util.Arrays;

public class Boss_Enemy extends Enemy {

    public Boss_Enemy(Hero hero, int currWorld){
        super(hero,1.1,2.4,0.6,0.5,0.4);

        SKILLS = new ArrayList<>(5);

        switch (hero.getNAME()){
            case "Radea":
                switch (currWorld){
                    case 1:
                        NAME = "Corrupted Zipau";
                        SKILLS = new ArrayList<>(Arrays.asList(
                                new Skills("Quick Slash",10,1),
                                new Skills("Flash Strike",15,15),
                                new Skills("Wind Walker",20,8),
                                new Skills("Bright Blade",30,6),
                                new Skills("Blade Dance",40,3)
                        ));
                        break;
                    case 2:
                        NAME = "Corrupted Mazupe";
                        SKILLS= new ArrayList<>(Arrays.asList(
                                new Skills("Basic Strike",20,1),
                                new Skills("Mountain Breaker",30,12),
                                new Skills("War Cry",10,15),
                                new Skills("Stone SKin",15,15),
                                new Skills("Titan's Grip",50,5)
                        ));
                        break;
                    case 3:
                        NAME = "Corrupted Radea";
                        SKILLS = new ArrayList<>(Arrays.asList(
                                new Skills("Shadow Strike",15,1),
                                new Skills("Psychic Drain",20,12),
                                new Skills("Mental Fortress",22,8),
                                new Skills("Thought Pierce",20,12),
                                new Skills("Mass Hysteria",35,6)
                        ));
                        break;
                }
                break;
            case "Mazupe":
                switch (currWorld){
                    case 1:
                        NAME = "Corrupted Radea";
                        SKILLS = new ArrayList<>(Arrays.asList(
                                new Skills("Shadow Strike",15,1),
                                new Skills("Psychic Drain",20,12),
                                new Skills("Mental Fortress",22,8),
                                new Skills("Thought Pierce",20,12),
                                new Skills("Mass Hysteria",35,6)
                        ));
                        break;
                    case 2:
                        NAME = "Corrupted Zipau";
                        SKILLS = new ArrayList<>(Arrays.asList(
                                new Skills("Quick Slash",10,1),
                                new Skills("Flash Strike",15,15),
                                new Skills("Wind Walker",20,8),
                                new Skills("Bright Blade",30,6),
                                new Skills("Blade Dance",40,3)
                        ));
                        break;
                    case 3:
                        NAME = "Corrupted Mazupe";
                        SKILLS= new ArrayList<>(Arrays.asList(
                                new Skills("Basic Strike",20,1),
                                new Skills("Mountain Breaker",30,12),
                                new Skills("War Cry",10,15),
                                new Skills("Stone SKin",15,15),
                                new Skills("Titan's Grip",50,5)
                        ));
                        break;
                }
                break;
            case "Zipau":
            default:
                switch (currWorld){
                    case 1:
                        NAME = "Corrupted Mazupe";
                        SKILLS= new ArrayList<>(Arrays.asList(
                                new Skills("Basic Strike",20,1),
                                new Skills("Mountain Breaker",30,12),
                                new Skills("War Cry",10,15),
                                new Skills("Stone SKin",15,15),
                                new Skills("Titan's Grip",50,5)
                        ));
                        break;
                    case 2:
                        NAME = "Corrupted Radea";
                        SKILLS = new ArrayList<>(Arrays.asList(
                                new Skills("Shadow Strike",15,1),
                                new Skills("Psychic Drain",20,12),
                                new Skills("Mental Fortress",22,8),
                                new Skills("Thought Pierce",20,12),
                                new Skills("Mass Hysteria",35,6)
                        ));
                        break;
                    case 3:
                        NAME = "Corrupted Zipau";
                        SKILLS = new ArrayList<>(Arrays.asList(
                                new Skills("Quick Slash",10,1),
                                new Skills("Flash Strike",15,15),
                                new Skills("Wind Walker",20,8),
                                new Skills("Bright Blade",30,6),
                                new Skills("Blade Dance",40,3)
                        ));
                        break;
                }
                break;
        }
    }


}
