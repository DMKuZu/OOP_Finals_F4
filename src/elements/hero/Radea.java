package elements.hero;

import elements.value.Skills;
import elements.value.Stats;

import java.util.Arrays;
import java.util.List;

public interface Radea {
    String name = "Radea";
    Stats stats = new Stats(150,25,20,0.12,0.4);
    List<Skills> skills = Arrays.asList(
            new Skills("Shadow Strike",15,1),
            new Skills("Psychic Drain",20,12),
            new Skills("Mental Fortress",0,8),
            new Skills("Thought Pierce",20,12),
            new Skills("Mass Hysteria",30,6)
    );
}
