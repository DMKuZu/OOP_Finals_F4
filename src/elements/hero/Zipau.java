package elements.hero;

import elements.value.Skills;
import elements.value.Stats;

import java.util.Arrays;
import java.util.List;

public interface Zipau  {
    String name = "Zipau";
    Stats stats = new Stats(100,30,15,0.4,0.12);
    List<Skills> skills = Arrays.asList(
            new Skills("Quick Slash",10,1),
            new Skills("Flash Strike",15,15),
            new Skills("Wind Walker",0,8),
            new Skills("Bright Blade",20,6),
            new Skills("Blade Dance",35,3)
    );
}
