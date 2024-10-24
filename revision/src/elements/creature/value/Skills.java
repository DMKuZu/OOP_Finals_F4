package elements.creature.value;

public class Skills {
    private final String name;
    private final int baseDmg;
    private final int uses;

    public Skills(String name, int basDmg, int uses){
        this.name = name;
        this.baseDmg = basDmg;
        this.uses = uses;
    }

    public Skills(Skills skills){
        this.name = skills.getName();
        this.baseDmg = skills.getBaseDmg();
        this.uses = skills.getUses();
    }



    public String getName() {
        return name;
    }
    public int getBaseDmg() {
        return baseDmg;
    }
    public int getUses() {
        return uses;
    }
}
