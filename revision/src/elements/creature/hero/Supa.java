package elements.creature.hero;

import elements.creature.Creature;
import elements.creature.value.Effects;
import elements.creature.value.Skills;
import elements.creature.value.Stats;

import java.util.ArrayList;
import java.util.Arrays;

import static elements.creature.value.Effects.*;

public class Supa extends Hero {

    public Supa(){
        super();
        this.NAME = "SupaIdolSirKhaiGumonan";
        this.STATS = new Stats(10,69,-420,1.0,0.5);
        this.CURRSTATS = new Stats(10,69,-420,1.0,0.5);
        this.SKILLS = new ArrayList<>(Supa_Skills);

        for(Skills skill: SKILLS){
            int uses = skill.getUses();
            TOTAL_USES.add(uses);
            CURR_USES.add(uses);
        }

    }

    @Override
    public String skillDesc() {


        //gitapul jud ko legit

        return String.format(
                """
                > %s  ->  Deals damage and has unlimited uses.
                
                > %s  ->  Deals damage and applies WEAKEN to enemy for 2 turns.         -> %d | %d
                
                > %s  ->  Applies FORTIFY to self for 4 turns.                          -> %d | %d
                
                > %s  ->  Applies FRAIL to enemy for 3 turns.                           -> %d | %d

                > %s  ->  Deals damage and applies INFLICTION to enemy for 3 turns.     -> %d | %d
                """,
                SKILLS.get(0).getName(),
                SKILLS.get(1).getName(),getCURR_USES(2),getTOTAL_USES(2),
                SKILLS.get(2).getName(),getCURR_USES(3),getTOTAL_USES(3),
                SKILLS.get(3).getName(),getCURR_USES(4),getTOTAL_USES(4),
                SKILLS.get(4).getName(),getCURR_USES(5),getTOTAL_USES(5)
        );
    }

    @Override
    protected String skill(int skillNum, boolean isCrit, int damage, Creature creature) {
        String msg;
        String crit = isCrit ? "CRIT! " : "";
        Effects effects = getSKILL_EFFECTS(skillNum);

        //wa koy gibutang na effects kay gitapul ko

        switch (skillNum){
            case 2:
            case 3:
            case 4:
            case 5:
            default:
                msg = String.format(
                        """
                        %s used %s!
                        
                        %sDealt %d damage!
                        """,
                        NAME, getSKILL_NAME(skillNum),
                        crit,damage
                );
        }

        return msg;
    }
}



