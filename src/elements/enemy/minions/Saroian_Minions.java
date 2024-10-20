package elements.enemy.minions;

import java.util.Random;
import calculate.Skill_Damage_Calculator;
import elements.enemy.Current_Enemy;

public class Saroian_Minions extends Current_Enemy implements Saroian_Minions_Stats, Saroian_Minions_Skills {
    private String NAME;
    private int HP;
    private int P_ATK;
    private int P_DEF;
    private int M_ATK;
    private int M_DEF;

    private String SKILL1_NAME;
    private int DMG1_TYPE;   // 1 for p_atk , 0 for m_atk, -1 for no damage
    private int DMG1;

    private String SKILL2_NAME;
    private int DMG2_TYPE;   // 1 for p_atk , 0 for m_atk, -1 for no damage
    private int DMG2;

    private String SKILL3_NAME;
    private int DMG3_TYPE;   // 1 for p_atk , 0 for m_atk, -1 for no damage
    private int DMG3;

    Skill_Damage_Calculator dmg_calc = new Skill_Damage_Calculator();

    public Saroian_Minions(){
        randomizeMinion();
        super.setNAME(NAME);
        super.setHP(HP);
        super.setP_ATK(P_ATK);
        super.setM_ATK(M_ATK);
        super.setP_DEF(P_DEF);
        super.setM_DEF(M_DEF);

        super.setSKILL1_NAME(SKILL1_NAME);
        super.setDMG1_TYPE(DMG1_TYPE);
        super.setDMG1(DMG1);

        super.setSKILL2_NAME(SKILL2_NAME);
        super.setDMG2_TYPE(DMG2_TYPE);
        super.setDMG2(DMG2);

        super.setSKILL3_NAME(SKILL3_NAME);
        super.setDMG3_TYPE(DMG3_TYPE);
        super.setDMG3(DMG3);
    }

    private void randomizeMinion() {
        Random random = new Random();
        int choice = random.nextInt(5) + 1; // Random value from 1 to 5

        switch (choice) {
            case 1:
                NAME = v1_name;
                HP = v1_hp;
                P_ATK = v1_p_atk;
                P_DEF = v1_p_def;
                M_ATK = v1_m_atk;
                M_DEF = v1_m_def;
                SKILL1_NAME = v1_s1_skill_name;
                DMG1_TYPE = v1_s1_damage_type;
                DMG1 = v1_s1_damage;
                SKILL2_NAME = v1_s2_skill_name;
                DMG2_TYPE = v1_s2_damage_type;
                DMG2 = v1_s2_damage;
                SKILL3_NAME = v1_s3_skill_name;
                DMG3_TYPE = v1_s3_damage_type;
                DMG3 = v1_s3_damage;
                break;
            case 2:
                NAME = v2_name;
                HP = v2_hp;
                P_ATK = v2_p_atk;
                P_DEF = v2_p_def;
                M_ATK = v2_m_atk;
                M_DEF = v2_m_def;
                SKILL1_NAME = v2_s1_skill_name;
                DMG1_TYPE = v2_s1_damage_type;
                DMG1 = v2_s1_damage;
                SKILL2_NAME = v2_s2_skill_name;
                DMG2_TYPE = v2_s2_damage_type;
                DMG2 = v2_s2_damage;
                SKILL3_NAME = v2_s3_skill_name;
                DMG3_TYPE = v2_s3_damage_type;
                DMG3 = v2_s3_damage;
                break;
            case 3:
                NAME = v3_name;
                HP = v3_hp;
                P_ATK = v3_p_atk;
                P_DEF = v3_p_def;
                M_ATK = v3_m_atk;
                M_DEF = v3_m_def;
                SKILL1_NAME = v3_s1_skill_name;
                DMG1_TYPE = v3_s1_damage_type;
                DMG1 = v3_s1_damage;
                SKILL2_NAME = v3_s2_skill_name;
                DMG2_TYPE = v3_s2_damage_type;
                DMG2 = v3_s2_damage;
                SKILL3_NAME = v3_s3_skill_name;
                DMG3_TYPE = v3_s3_damage_type;
                DMG3 = v3_s3_damage;
                break;
            case 4:
                NAME = v4_name;
                HP = v4_hp;
                P_ATK = v4_p_atk;
                P_DEF = v4_p_def;
                M_ATK = v4_m_atk;
                M_DEF = v4_m_def;
                SKILL1_NAME = v4_s1_skill_name;
                DMG1_TYPE = v4_s1_damage_type;
                DMG1 = v4_s1_damage;
                SKILL2_NAME = v4_s2_skill_name;
                DMG2_TYPE = v4_s2_damage_type;
                DMG2 = v4_s2_damage;
                SKILL3_NAME = v4_s3_skill_name;
                DMG3_TYPE = v4_s3_damage_type;
                DMG3 = v4_s3_damage;
                break;
            case 5:
                NAME = v5_name;
                HP = v5_hp;
                P_ATK = v5_p_atk;
                P_DEF = v5_p_def;
                M_ATK = v5_m_atk;
                M_DEF = v5_m_def;
                SKILL1_NAME = v5_s1_skill_name;
                DMG1_TYPE = v5_s1_damage_type;
                DMG1 = v5_s1_damage;
                SKILL2_NAME = v5_s2_skill_name;
                DMG2_TYPE = v5_s2_damage_type;
                DMG2 = v5_s2_damage;
                SKILL3_NAME = v5_s3_skill_name;
                DMG3_TYPE = v5_s3_damage_type;
                DMG3 = v5_s3_damage;
                break;
        }
    }


    @Override
    public int skill1(int hero_p_def, int hero_m_def) {
        int atk_stat = (DMG1_TYPE == 0) ? M_ATK:P_ATK;  //if 0 it will be equals to M_ATK else P_ATK
        int def_stat = (DMG1_TYPE == 0) ? hero_m_def:hero_p_def; //if 0 it will be equals to hero_m_def else hero_p_def

        return dmg_calc.minion_calculate_damage(DMG1,atk_stat,def_stat); ///returns the damage to be dealt along with crit
    }

    @Override
    public int skill2(int hero_p_def, int hero_m_def) {
        int atk_stat = (DMG2_TYPE == 0) ? M_ATK:P_ATK;  //if 0 it will be equals to M_ATK else P_ATK
        int def_stat = (DMG2_TYPE == 0) ? hero_m_def:hero_p_def; //if 0 it will be equals to hero_m_def else hero_p_def

        return dmg_calc.minion_calculate_damage(DMG2,atk_stat,def_stat); ///returns the damage to be dealt along with crit
    }

    @Override
    public int skill3(int hero_p_def, int hero_m_def) {
        int atk_stat = (DMG3_TYPE == 0) ? M_ATK:P_ATK;  //if 0 it will be equals to M_ATK else P_ATK
        int def_stat = (DMG3_TYPE == 0) ? hero_m_def:hero_p_def; //if 0 it will be equals to hero_m_def else hero_p_def

        return dmg_calc.minion_calculate_damage(DMG3,atk_stat,def_stat); ///returns the damage to be dealt along with crit
    }


}
