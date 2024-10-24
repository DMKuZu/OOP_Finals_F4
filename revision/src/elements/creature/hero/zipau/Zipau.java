package elements.creature.hero.zipau;

import elements.creature.hero.Hero;
import elements.creature.value.Skills;
import elements.creature.value.Stats;

import java.util.ArrayList;
import java.util.Arrays;

public class Zipau extends Hero {

    public Zipau(){
        super();
        this.NAME = "Zipau";
        this.STATS = new Stats(100,30,15,0.04,0.12);
        this.CURRSTATS = new Stats(100,30,15,0.04,0.12);
        this.SKILLS = new ArrayList<>(Arrays.asList(
                new Skills("Quick Slash",10,1),
                new Skills("Flash Strike",15,15),
                new Skills("Wind Walker",0,8),
                new Skills("Bright Blade",30,6),
                new Skills("Blade Dance",40,3)
        ));

        for(Skills skill: SKILLS){
            int uses = skill.getUses();
            TOTAL_USES.add(uses);
            CURR_USES.add(uses);
        }
    }

}
