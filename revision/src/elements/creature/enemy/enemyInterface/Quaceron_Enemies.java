package elements.creature.enemy.enemyInterface;

import elements.creature.value.Skills;

import java.util.Arrays;
import java.util.List;

import static elements.creature.value.Effects.*;
import static elements.creature.value.Effects.FRAIL;

public interface Quaceron_Enemies {
    List<String> Qua_Norm_List = Arrays.asList(
            "Quaceron Initiate",
            "Quaceron Sentinel",
            "Quaceron Smashkin",
            "Quaceron Warden",
            "Quaceron Brawler"
    );

    List<String> Qua_Elite_List = Arrays.asList(
            "Warlord of Ruin",
            "Titan of the Abyss"
    );

    List<Skills> QuaSkills = Arrays.asList(
            new Skills("Skill 1",20,0,NONE),
            new Skills("Skill 2",25,0,EMPOWER),
            new Skills("Skill 3",30,0,FORTIFY),
            new Skills("Skill 4",40,0,REGEN)
    );
}
