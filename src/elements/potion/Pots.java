package elements.potion;

public class Pots {
    private String name;
    private int target;
    private String stat_to_be_affected;
    private String effect;
    private int turns;

    public Pots(String name,int target, String stat, String effect,int turns){
        this.name = name;
        this.target = target;
        this.stat_to_be_affected = stat;
        this.effect = effect;
        this.turns = turns;
    }

    public Pots(){

        //make this null nya pagmake ug changes sa prompt na madisplay lang ug <none> without any extra stuff
        this.name = "<None>";
        this.target = 0;
        this.stat_to_be_affected = "<None>";
        this.effect = "<None>";
        this.turns = 0;
    }

    public String getNAME() {
        return name;
    }

    public int getTarget() {
        return target;
    }

    public String getStat_to_be_affected() {
        return stat_to_be_affected;
    }

    public String getEffect() {
        return effect;
    }

    public int getTurns() {
        return turns;
    }


    public void setNAME(String NAME) {
        this.name = NAME;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void setStat_to_be_affected(String stat_to_be_affected) {
        this.stat_to_be_affected = stat_to_be_affected;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }
}
