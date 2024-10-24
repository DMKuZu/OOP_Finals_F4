package elements.favor;

public class Favor implements List_of_Favors{
    private String name;
    private String stat;
    private int value;


    public Favor(int listIndex){
        this.name = NAME_List.get(listIndex);
        this.stat = Favor_Stat.get(name).getStat();
        this.value = Favor_Stat.get(name).getValue();
    }

    public Favor(){
        this.name = "<none>";
        this.stat = null;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getStat() {
        return stat;
    }

    @Override
    public String toString(){
        switch (stat){
            case "DODGE":
            case "CRIT":
                return name + " -> Increases " + stat + " by 0." + value + " while in battle.";
            default:
                return name + " -> Increases " + stat + " by " + value + " while in battle.";
        }
    }
}
