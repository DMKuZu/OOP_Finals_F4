package elements;
import calculate.Damage_Calculator;

public class Radea extends Chosen_Hero{
    private final String NAME = "Radea";
    private final int HP = 150;
    private final int MANA = 200;
    private final int P_ATK = 45;
    private final int P_DEF = 60;
    private final int M_ATK = 185;
    private final int M_DEF = 140;

    private String SKILL1_NAME = "Mind Shatter";
    private int DMG1_TYPE = 0;   // 1 for p_atk , 0 for m_atk, -1 for no damage
    private int DMG1 = 74;
    private int MANA_COST1 = 45;

    private String SKILL2_NAME = "Psychic Drain";
    private int DMG2_TYPE = 0;   // 1 for p_atk , 0 for m_atk, -1 for no damage
    private int DMG2 = 45;
    private int MANA_COST2 = 35;

    private String SKILL3_NAME = "Mental Fortress";
    private int DMG3_TYPE = 0;   // 1 for p_atk , 0 for m_atk, -1 for no damage
    private int DMG3 = 20;
    private int MANA_COST3 = 40;

    private String SKILL4_NAME = "Thought Pierce";
    private int DMG4_TYPE = 0;   /// 1 for p_atk, 0 for m_atk, -1 for no damage
    private int DMG4 = 60;
    private int MANA_COST4 = 50;

    private String SKILL5_NAME = "Mass Hysteria";
    private int DMG5_TYPE = 0;   /// 1 for p_atk, 0 for m_atk, -1 for no damage
    private int DMG5 = 40;
    private int MANA_COST5 = 80;

    Damage_Calculator dmg_calc = new Damage_Calculator();

    public Radea(){
        super.setNAME(NAME);
        super.setHP(HP);
        super.setMANA(MANA);
        super.setP_ATK(P_ATK);
        super.setP_DEF(P_DEF);
        super.setM_ATK(M_ATK);
        super.setM_DEF(M_DEF);

        super.setSKILL1_NAME(SKILL1_NAME);
        super.setDMG1_TYPE(DMG1_TYPE);
        super.setDMG1(DMG1);
        super.setMANA_COST1(MANA_COST1);

        super.setSKILL2_NAME(SKILL2_NAME);
        super.setDMG2_TYPE(DMG2_TYPE);
        super.setDMG2(DMG2);
        super.setMANA_COST2(MANA_COST2);

        super.setSKILL3_NAME(SKILL3_NAME);
        super.setDMG3_TYPE(DMG3_TYPE);
        super.setDMG3(DMG3);
        super.setMANA_COST3(MANA_COST3);

        super.setSKILL4_NAME(SKILL4_NAME);
        super.setDMG4_TYPE(DMG4_TYPE);
        super.setDMG4(DMG4);
        super.setMANA_COST4(MANA_COST4);

        super.setSKILL5_NAME(SKILL5_NAME);
        super.setDMG5_TYPE(DMG5_TYPE);
        super.setDMG5(DMG5);
        super.setMANA_COST5(MANA_COST5);
    }


    @Override
    public int skill1(int enemy_p_def, int enemy_m_def) {
        int atk_stat = (DMG1_TYPE == 0) ? M_ATK:P_ATK;  //if 0 it will be equals to M_ATK else P_ATK
        int def_stat = (DMG1_TYPE == 0) ? enemy_m_def:enemy_p_def; //if 0 it will be equals to enemy_m_def else enemy_p_def

        return dmg_calc.hero_calculate_damage(DMG1,atk_stat,def_stat); ///returns the damage to be dealt along with crit

    }

    @Override
    public int skill2(int enemy_p_def, int enemy_m_def) {
        int atk_stat = (DMG2_TYPE == 0) ? M_ATK:P_ATK;  //if 0 it will be equals to M_ATK else P_ATK
        int def_stat = (DMG2_TYPE == 0) ? enemy_m_def:enemy_p_def; //if 0 it will be equals to enemy_m_def else enemy_p_def

        return dmg_calc.hero_calculate_damage(DMG2,atk_stat,def_stat); ///returns the damage to be dealt along with crit

    }

    @Override
    public int skill3(int enemy_p_def, int enemy_m_def) {
        int atk_stat = (DMG3_TYPE == 0) ? M_ATK:P_ATK;  //if 0 it will be equals to M_ATK else P_ATK
        int def_stat = (DMG3_TYPE == 0) ? enemy_m_def:enemy_p_def; //if 0 it will be equals to enemy_m_def else enemy_p_def

        return dmg_calc.hero_calculate_damage(DMG3,atk_stat,def_stat); ///returns the damage to be dealt along with crit

    }

    @Override
    public int skill4(int enemy_p_def, int enemy_m_def) {
        int atk_stat = (DMG4_TYPE == 0) ? M_ATK:P_ATK;  //if 0 it will be equals to M_ATK else P_ATK
        int def_stat = (DMG4_TYPE == 0) ? enemy_m_def:enemy_p_def; //if 0 it will be equals to enemy_m_def else enemy_p_def

        return dmg_calc.hero_calculate_damage(DMG4,atk_stat,def_stat); ///returns the damage to be dealt along with crit

    }

    @Override
    public int skill5(int enemy_p_def, int enemy_m_def) {
        int atk_stat = (DMG5_TYPE == 0) ? M_ATK:P_ATK;  //if 0 it will be equals to M_ATK else P_ATK
        int def_stat = (DMG5_TYPE == 0) ? enemy_m_def:enemy_p_def; //if 0 it will be equals to enemy_m_def else enemy_p_def

        return dmg_calc.hero_calculate_damage(DMG5,atk_stat,def_stat); ///returns the damage to be dealt along with crit

    }
}
