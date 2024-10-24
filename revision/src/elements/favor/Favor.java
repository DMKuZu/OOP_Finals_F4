package elements.favor;

public class Favor implements List_of_Favors{
    private final String name;
    private final String stat;
    private int value;


    protected Favor(int listIndex){
        this.name = NAME_List.get(listIndex);
        this.stat = Favor_Stat.get(name).getStat();
        this.value = Favor_Stat.get(name).getValue();
    }

    protected Favor(){
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
        return switch (stat) {
            case "DODGE", "CRIT" -> name + " -> Increases " + stat + " by 0." + value + " while in battle.";
            case "USES" -> name + " -> Increases current skills uses by " + value + ".";
            case "HP" -> name + "-> Replenishes HP by " + value + ".";
            default -> name + " -> Increases " + stat + " by " + value + " while in battle.";
        };
    }
}
