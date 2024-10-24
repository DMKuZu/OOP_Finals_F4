package elements.creature.hero.supaidolsirkhai;

import elements.creature.hero.Hero;
import elements.creature.value.Skills;
import elements.creature.value.Stats;

import java.util.ArrayList;
import java.util.Arrays;

public class Supa extends Hero {

    public Supa(){
        super();
        this.NAME = "SupaIdolSirKhaiGumonan";
        this.STATS = new Stats(1,6969,1,1.0,1.0);
        this.CURRSTATS = new Stats(6969,6969,-6969,1.0,1.0);
        this.SKILLS = new ArrayList<>(Arrays.asList(
                new Skills("Reality Warp",10,1),
                new Skills("Dimensional Shift",15,9),
                new Skills("Entropy Wave",20,7),
                new Skills("Void Embrace",25,5),
                new Skills("Ultimate Erasure",30,3)
        ));

        for(Skills skill: SKILLS){
            int uses = skill.getUses();
            TOTAL_USES.add(uses);
            CURR_USES.add(uses);
        }

    }


}



