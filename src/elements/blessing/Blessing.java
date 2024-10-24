package elements.blessing;

public class Blessing {
    private String name;
    private String stat;
    private int value;

    public Blessing(String name, String stat, int value) {
        this.name = name;
        this.stat = stat;
        this.value = value;
    }

    public String getName() {
        return name;
    }
    public String getStat() {
        return stat;
    }
    public int getValue() {
        return value;
    }

    @Override
    public String toString(){
        switch (stat){
            case "DODGE":
            case "CRIT":
                return name + " -> Increases " + stat + " by 0." + value + ".";
            default:
                return name + " -> Increases " + stat + " by " + value + ".";
        }
    }

}
