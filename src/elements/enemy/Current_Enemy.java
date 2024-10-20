package elements.enemy;


public abstract class Current_Enemy {
    private String NAME;
    private int HP;
    private int P_ATK;
    private int P_DEF;
    private int M_ATK;
    private int M_DEF;

    private String SKILL1_NAME;
    private int DMG1_TYPE;   /// 1 for p_atk , 0 for m_atk, -1 for no damage
    private int DMG1;

    private String SKILL2_NAME;
    private int DMG2_TYPE;   /// 1 for p_atk , 0 for m_atk, -1 for no damage
    private int DMG2;

    private String SKILL3_NAME;
    private int DMG3_TYPE;   /// 1 for p_atk , 0 for m_atk, -1 for no damage
    private int DMG3;

    // Getters
    public String getNAME() {
        return NAME;
    }

    public int getHP() {
        return HP;
    }

    public int getP_ATK() {
        return P_ATK;
    }

    public int getP_DEF() {
        return P_DEF;
    }

    public int getM_ATK() {
        return M_ATK;
    }

    public int getM_DEF() {
        return M_DEF;
    }

    public String getSKILL1_NAME() {
        return SKILL1_NAME;
    }

    public int getDMG1_TYPE() {
        return DMG1_TYPE;
    }

    public int getDMG1() {
        return DMG1;
    }

    public String getSKILL2_NAME() {
        return SKILL2_NAME;
    }

    public int getDMG2_TYPE() {
        return DMG2_TYPE;
    }

    public int getDMG2() {
        return DMG2;
    }

    public String getSKILL3_NAME() {
        return SKILL3_NAME;
    }

    public int getDMG3_TYPE() {
        return DMG3_TYPE;
    }

    public int getDMG3() {
        return DMG3;
    }

    // Setters
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setP_ATK(int P_ATK) {
        this.P_ATK = P_ATK;
    }

    public void setP_DEF(int P_DEF) {
        this.P_DEF = P_DEF;
    }

    public void setM_ATK(int M_ATK) {
        this.M_ATK = M_ATK;
    }

    public void setM_DEF(int M_DEF) {
        this.M_DEF = M_DEF;
    }

    public void setSKILL1_NAME(String SKILL1_NAME) {
        this.SKILL1_NAME = SKILL1_NAME;
    }

    public void setDMG1_TYPE(int DMG1_TYPE) {
        this.DMG1_TYPE = DMG1_TYPE;
    }

    public void setDMG1(int DMG1) {
        this.DMG1 = DMG1;
    }

    public void setSKILL2_NAME(String SKILL2_NAME) {
        this.SKILL2_NAME = SKILL2_NAME;
    }

    public void setDMG2_TYPE(int DMG2_TYPE) {
        this.DMG2_TYPE = DMG2_TYPE;
    }

    public void setDMG2(int DMG2) {
        this.DMG2 = DMG2;
    }

    public void setSKILL3_NAME(String SKILL3_NAME) {
        this.SKILL3_NAME = SKILL3_NAME;
    }

    public void setDMG3_TYPE(int DMG3_TYPE) {
        this.DMG3_TYPE = DMG3_TYPE;
    }

    public void setDMG3(int DMG3) {
        this.DMG3 = DMG3;
    }

    //Skills - weill return the damage values

    public abstract int skill1(int hero_p_def, int hero_m_def);
    public abstract int skill2(int hero_p_def, int hero_m_def);
    public abstract int skill3(int hero_p_def, int hero_m_def);

}
