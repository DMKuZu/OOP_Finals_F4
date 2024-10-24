package elements.creature.enemy.enemyInterface;

import elements.creature.value.Skills;

import java.util.Arrays;
import java.util.List;

import static elements.creature.value.Effects.*;
import static elements.creature.value.Effects.FRAIL;

public interface Saroian_Enemies {
    List<String> Sar_Norm_List = Arrays.asList(
            "Psionic Goblin",
            "Nightmare Sylph",
            "Spectral Serpent",
            "Spectral Harpy",
            "Ebon-Faced Dryad"
    );

    List<String> Sar_Elite_List = Arrays.asList(
            "Shadowmaster of the Void",
            "Abomination of the Deep"
    );


    List<Skills> SarSkills = Arrays.asList(
            new Skills("Skill 1",20,0,NONE),
            new Skills("Skill 2",25,0,FRAIL),
            new Skills("Skill 3",30,0,ENSHROUD),
            new Skills("Skill 4",40,0,INFLICTION)
    );


}
