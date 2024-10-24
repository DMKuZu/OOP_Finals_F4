package elements.creature.hero.mazupe;

import elements.creature.hero.Hero;
import elements.creature.value.Skills;
import elements.creature.value.Stats;

import java.util.ArrayList;
import java.util.Arrays;

public class Mazupe extends Hero {

    public Mazupe(){
        super();
        this.NAME = "Mazupe";
        this.STATS = new Stats(200,20,25,0.02,0.06);
        this.CURRSTATS = new Stats(200,20,25,0.02,0.06);
        this.SKILLS= new ArrayList<>(Arrays.asList(
                new Skills("Basic Strike",20,1),
                new Skills("Mountain Breaker",30,12),
                new Skills("War Cry",1,15),
                new Skills("Stone SKin",2,15),
                new Skills("Titan's Grip",50,5)
        ));

        for(Skills skill: SKILLS){
            int uses = skill.getUses();
            TOTAL_USES.add(uses);
            CURR_USES.add(uses);
        }
    }
}
