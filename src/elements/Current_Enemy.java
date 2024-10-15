package elements;

public class Current_Enemy {
    private String NAME;
    private int HP;
    private int P_ATK;
    private int P_DEF;
    private int M_ATK;
    private int M_DEF;

    public Current_Enemy(String name, int hp, int p_atk, int p_def, int m_atk, int m_def){
        NAME = name;
        HP = hp;
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
