package elements.hero;

public class Chosen_Hero {
    private String NAME;
    private int HP;
    private int MANA;
    private int check_HP;
    private int check_MANA;
    private int P_ATK;
    private int P_DEF;
    private int M_ATK;
    private int M_DEF;

    private String SKILL1_NAME;
    private int DMG1_TYPE;   /// 1 for p_atk, 0 for m_atk, -1 for no damage
    private int DMG1;
    private int MANA_COST1;

    private String SKILL2_NAME;
    private int DMG2_TYPE;   /// 1 for p_atk, 0 for m_atk, -1 for no damage
    private int DMG2;
    private int MANA_COST2;

    private String SKILL3_NAME;
    private int DMG3_TYPE;   /// 1 for p_atk, 0 for m_atk, -1 for no damage
    private int DMG3;
    private int MANA_COST3;

    private String SKILL4_NAME;
    private int DMG4_TYPE;   /// 1 for p_atk, 0 for m_atk, -1 for no damage
    private int DMG4;
    private int MANA_COST4;

    private String SKILL5_NAME;
    private int DMG5_TYPE;   /// 1 for p_atk, 0 for m_atk, -1 for no damage
    private int DMG5;
    private int MANA_COST5;

    // final values
    public int getCheck_HP(){
        return check_HP;
    }
    public int getCheck_MANA(){
        return check_MANA;
    }
    public void setCheck_HP(int check_HP){
        this.check_HP = check_HP;
    }
    public void setCheck_MANA(int check_MANA){
        this.check_MANA = check_MANA;
    }



    // Getters
    public String getNAME() {
        return NAME;
    }

    public int getHP() {
        return HP;
    }

    public int getMANA(){
        return MANA;
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

    public int getMANA_COST1() {
        return MANA_COST1;
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

    public int getMANA_COST2() {
        return MANA_COST2;
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

    public int getMANA_COST3() {
        return MANA_COST3;
    }

    public String getSKILL4_NAME() {
        return SKILL4_NAME;
    }

    public int getDMG4_TYPE() {
        return DMG4_TYPE;
    }

    public int getDMG4() {
        return DMG4;
    }

    public int getMANA_COST4() {
        return MANA_COST4;
    }

    public String getSKILL5_NAME() {
        return SKILL5_NAME;
    }

    public int getDMG5_TYPE() {
        return DMG5_TYPE;
    }

    public int getDMG5() {
        return DMG5;
    }

    public int getMANA_COST5() {
        return MANA_COST5;
    }


    // Setters
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setMANA(int MANA) {
        this.MANA = MANA;
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

    public void setMANA_COST1(int MANA_COST1) {
        this.MANA_COST1 = MANA_COST1;
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

    public void setMANA_COST2(int MANA_COST2) {
        this.MANA_COST2 = MANA_COST2;
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

    public void setMANA_COST3(int MANA_COST3) {
        this.MANA_COST3 = MANA_COST3;
    }

    public void setSKILL4_NAME(String SKILL4_NAME) {
        this.SKILL4_NAME = SKILL4_NAME;
    }

    public void setDMG4_TYPE(int DMG4_TYPE) {
        this.DMG4_TYPE = DMG4_TYPE;
    }

    public void setDMG4(int DMG4) {
        this.DMG4 = DMG4;
    }

    public void setMANA_COST4(int MANA_COST4) {
        this.MANA_COST4 = MANA_COST4;
    }

    public void setSKILL5_NAME(String SKILL5_NAME) {
        this.SKILL5_NAME = SKILL5_NAME;
    }

    public void setDMG5_TYPE(int DMG5_TYPE) {
        this.DMG5_TYPE = DMG5_TYPE;
    }

    public void setDMG5(int DMG5) {
        this.DMG5 = DMG5;
    }

    public void setMANA_COST5(int MANA_COST5) {
        this.MANA_COST5 = MANA_COST5;
    }


    // Skills - will return the damage values
    public int skill1(int enemy_p_def, int enemy_m_def){
        return 0;
    }
    public int skill2(int enemy_p_def, int enemy_m_def){
        return 0;
    }
    public int skill3(int enemy_p_def, int enemy_m_def){
        return 0;
    }
    public int skill4(int enemy_p_def, int enemy_m_def){
        return 0;
    }
    public int skill5(int enemy_p_def, int enemy_m_def){
        return 0;
    }

}
