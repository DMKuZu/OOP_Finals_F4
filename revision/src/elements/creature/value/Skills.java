package elements.creature.value;

public class Skills {
    private final String name;
    private final int baseDmg;
    private final int uses;
    private final Effects effects;

    public Skills(String name, int basDmg, int uses,Effects effects){
        this.name = name;
        this.baseDmg = basDmg;
        this.uses = uses;
        this.effects = effects;
    }

    public Skills(Skills skills){
        this.name = skills.getName();
        this.baseDmg = skills.getBaseDmg();
        this.uses = skills.getUses();
        this.effects = skills.getEffects();
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
    public Effects getEffects() {
        return effects;
    }
}
