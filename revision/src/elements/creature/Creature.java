package elements.creature;

import calculator.Skill_Calculator;
import elements.creature.value.Skills;
import elements.creature.value.Stats;

import java.util.List;

public abstract class Creature {
    protected String NAME;
    protected Stats STATS;
    protected Stats CURRSTATS;
    protected List<Skills> SKILLS;
    protected Skill_Calculator calc = new Skill_Calculator();

    public String getNAME() {
        return NAME;
    }
    public Stats getSTATS() {
        return STATS;
    }
    public Stats getCURRSTATS() {
        return CURRSTATS;
    }
    public String getSKILL_NAME(int skillNum){
        return SKILLS.get(skillNum-1).getName();
    }

}
