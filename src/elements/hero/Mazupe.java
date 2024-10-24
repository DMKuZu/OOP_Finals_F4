package elements.hero;

import elements.value.Skills;
import elements.value.Stats;

import java.util.Arrays;
import java.util.List;

public interface Mazupe {
    String name = "Mazupe";
    Stats stats = new Stats(200,20,30,0.2,0.6);
    List<Skills> skills = Arrays.asList(
            new Skills("Basic Strike",10,1),
            new Skills("Mountain Breaker",20,10),
            new Skills("War Cry",0,8),
            new Skills("Stone SKin",0,8),
            new Skills("Titan's Grip",30,5)
    );
}
