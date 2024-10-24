package elements.stat;

public class Stats {
    private int HP;
    private int ATK;
    private int DEF;
    private double DODGE;
    private double CRIT;

    // Parameterized constructor
    public Stats(int HP, int ATK, int DEF, double DODGE, double CRIT) {
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.DODGE = DODGE;
        this.CRIT = CRIT;
    }

    // Getters for accessing fields}
    public int getHP() { return HP; }
    public int getATK() { return ATK; }
    public int getDEF() { return DEF; }
    public double getDODGE() { return DODGE; }
    public double getCRIT() { return CRIT; }

    // Setters
    public void setHP(int HP) { this.HP = HP; }
    public void setATK(int ATK) { this.ATK = ATK; }
    public void setDEF(int DEF) { this.DEF = DEF; }
    public void setDODGE(double DODGE) { this.DODGE = DODGE; }
    public void setCRIT(double CRIT) { this.CRIT = CRIT; }
}

