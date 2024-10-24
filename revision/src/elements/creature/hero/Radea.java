package elements.creature.hero;

import elements.creature.Creature;
import elements.creature.value.Effects;
import elements.creature.value.Skills;
import elements.creature.value.Stats;

import java.util.ArrayList;
import java.util.Arrays;

import static elements.creature.value.Effects.*;

public class Radea extends Hero {

    public Radea(){
        super();
        this.NAME = "Radea";
        this.STATS = new Stats(150,25,20,0.12,0.04);
        this.CURRSTATS = new Stats(150,25,20,0.12,0.04);
        this.SKILLS = new ArrayList<>(Radea_Skills);

        for(Skills skill: SKILLS){
            int uses = skill.getUses();
            TOTAL_USES.add(uses);
            CURR_USES.add(uses);
        }

    }

    @Override
    public String skillDesc() {
        return String.format(
                """
                > %s  ->  Deals damage and has unlimited uses.
                
                > %s  ->  Deals damage and applies WEAKEN to enemy for 2 turns.       -> %d | %d
                
                > %s  ->  Applies FORTIFY to self for 4 turns.                        -> %d | %d
                
                > %s  ->  Deals damage and applies FRAIL to enemy for 3 turns.        -> %d | %d

                > %s  ->  Deals damage and applies INFLICTION to enemy for 3 turns.   -> %d | %d
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

        switch (skillNum){
            case 2:
                msg = String.format(
                        """
                        %s used %s!
                        
                        %sDealt %d damage!
                        
                        Decreased %s's ATK by 20 for 2 turns!
                        """,
                        NAME, getSKILL_NAME(skillNum),
                        crit,damage,
                        creature.getNAME()
                        );
                creature.addEffects(effects,2,20);
                break;
            case 3:
                msg = String.format(
                        """
                        %s used %s!
                        
                        Increased DEF by 30 for 4 turns!
                        """,
                        NAME, getSKILL_NAME(skillNum)
                );
                addEffects(effects,4,30);
                break;
            case 4:
                msg = String.format(
                        """
                        %s used %s!
                        
                        %sDealt %d damage!
                        
                        Decreased %s's DEF by 20 for 3 turns!
                        """,
                        NAME, getSKILL_NAME(skillNum),
                        crit,damage,
                        creature.getNAME()
                );
                creature.addEffects(effects,3,20);
                break;
            case 5:
                msg = String.format(
                        """
                        %s used %s!
                        
                        %sDealt %d damage!
                        
                        Inflict 20 damage to %s for 3 turns!
                        """,
                        NAME, getSKILL_NAME(skillNum),
                        crit,damage,
                        creature.getNAME()
                );
                creature.addEffects(effects,3,20);
                break;
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
