package elements.creature;

import calculator.Skill_Calculator;
import elements.creature.value.Effects;
import elements.creature.value.Skills;
import elements.creature.value.Stats;
import elements.creature.value.Status;

import java.util.ArrayList;
import java.util.List;

public abstract class Creature {
    protected String NAME;
    protected Stats STATS;
    protected Stats CURRSTATS;
    protected List<Skills> SKILLS;

    protected List<Status> STATUS;
    protected Skill_Calculator CALC;
    protected boolean isStunned;

    protected Creature(){
        this.STATUS = new ArrayList<>();
        this.CALC = new Skill_Calculator();
        this.isStunned = false;
    }

    public String getNAME() {
        return NAME;
    }
    public Stats getSTATS() {
        return STATS;
    }
    public Stats getCURRSTATS() {
        return CURRSTATS;
    }
    public boolean isDead(){return CURRSTATS.getHP() <= 0;}
    public boolean isStunned(){return isStunned;}


    protected String getSKILL_NAME(int skillNum){
        return SKILLS.get(skillNum-1).getName();
    }
    protected Effects getSKILL_EFFECTS(int skillNum){
        return SKILLS.get(skillNum-1).getEffects();
    }


    public void addEffects(Effects effect, int turns, int value){
        STATUS.add(new Status(effect,turns,value));
    }
    public void inflictEffects(){
        for(Status status : STATUS){
            status.nextTurn();
            status.applyEffect(this);
        }
    }
    public void revertEffects(){
        int i = 0;
        while(!STATUS.isEmpty() && i < STATUS.size()){
            if(STATUS.get(i).isExpired()){
                STATUS.remove(i).revertEffect();
            }
            else i++;
        }
    }
    public void stunned(){this.isStunned = true;}
    public void notStunned(){this.isStunned = false;}


    public String statusDisplay(){
        StringBuilder description = new StringBuilder();
        for (Status status : STATUS) {
            description.append(String.format("> %s\n",status.toString()));
        }
        return description.toString();
    }

    protected abstract String skill(int skillNum, boolean isCrit, int damage, Creature creature);
}
