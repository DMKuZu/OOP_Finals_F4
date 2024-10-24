package elements.creature.hero.radea;

import elements.creature.hero.Hero;
import elements.creature.value.Skills;
import elements.creature.value.Stats;

import java.util.ArrayList;
import java.util.Arrays;

public class Radea extends Hero {

    public Radea(){
        super();
        this.NAME = "Radea";
        this.STATS = new Stats(150,25,20,0.12,0.04);
        this.CURRSTATS = new Stats(150,25,20,0.12,0.04);
        this.SKILLS = new ArrayList<>(Arrays.asList(
                new Skills("Shadow Strike",15,1),
                new Skills("Psychic Drain",20,12),
                new Skills("Mental Fortress",0,8),
                new Skills("Thought Pierce",20,12),
                new Skills("Mass Hysteria",35,6)
        ));

        for(Skills skill: SKILLS){
            int uses = skill.getUses();
            TOTAL_USES.add(uses);
            CURR_USES.add(uses);
        }

    }

}
