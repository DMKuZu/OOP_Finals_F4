package elements.creature.enemy.enemyInterface;

import elements.creature.value.Skills;

import java.util.Arrays;
import java.util.List;

import static elements.creature.value.Effects.*;

public interface Azrueian_Enemies {
    List<String> Azr_Norm_List = Arrays.asList(
            "Azrueian Skirmisher",
            "Azrueian Blade Dancer",
            "Azrueian Scout",
            "Azrueian WindRanger",
            "Azrueian Striker"
    );

    List<String> Azr_Elite_List = Arrays.asList(
            "Twisted Bladedancer",
            "Chronomancer of Dread"
    );

    List<Skills> AzrSkills = Arrays.asList(
            new Skills("Skill 1",20,0,NONE),
            new Skills("Skill 2",25,0,WEAKEN),
            new Skills("Skill 3",30,0,SHARPEN),
            new Skills("Skill 4",40,0,FRAIL)
    );

}
