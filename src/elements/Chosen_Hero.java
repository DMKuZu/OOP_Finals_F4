package elements;

public class Chosen_Hero {
    private String NAME;
    private int HP;
    private int MANA;
    private int P_ATK;
    private int P_DEF;
    private int M_ATK;
    private int M_DEF;

    public Chosen_Hero(String name, int hp, int mana, int p_atk, int p_def, int m_atk, int m_def){
        NAME = name;
        HP = hp;
        MANA = mana;
        P_ATK = p_atk;
        P_DEF = p_def;
        M_ATK = m_atk;
        M_DEF = m_def;
    }

    public String getNAME(){
        return NAME;
    }

    public int getHP(){
        return HP;
    }

    public int getMANA(){
        return MANA;
    }

    public int getP_ATK(){
        return P_ATK;
    }

    public int getP_DEF(){
        return P_DEF;
    }

    public int getM_ATK(){
        return M_ATK;
    }

    public int getM_DEF(){
        return M_DEF;
    }

//*********************************************************************

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setMANA(int MANA) {
        this.MANA = MANA;
    }

    public void setP_ATK(int p_ATK) {
        P_ATK = p_ATK;
    }

    public void setP_DEF(int p_DEF) {
        P_DEF = p_DEF;
    }

    public void setM_ATK(int m_ATK) {
        M_ATK = m_ATK;
    }

    public void setM_DEF(int m_DEF) {
        M_DEF = m_DEF;
    }
}
