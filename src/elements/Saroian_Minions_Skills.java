package elements;

import java.util.Random;

public interface Saroian_Minions_Skills {
    Random rand = new Random();
    ///for effect
    // 0 - no effects
    // 1 - affects the chance to hit of the hero
    // 2 - debuff m_atk of hero
    // 3 - debuff p_def of hero

///temporary pa ni tanan

    // v1 skills
    String v1_s1_skill_name = "Mind Spike";
    int v1_s1_damage_type = 0;   /// 1 for p_atk , 0 for m_atk, -1 for no damage
//    int v1_s1_effect = 1;  // reduces hero accuracy by 2% for 1 turn
    int v1_s1_damage = rand.nextInt(6-4+1) + 4; // 4-6 damage

    String v1_s2_skill_name = "Mental Trickery";
    int v1_s2_damage_type = 0; /// 1 for p_atk , 0 for m_atk, -1 for no damage
//    int v1_s2_effect = 1; // increases evasion by 10% for 1 turn
    int v1_s2_damage = rand.nextInt(10-5+1) + 5; // 0 damage

    String v1_s3_skill_name = "Psionic Drain";
    int v1_s3_damage_type = 0; /// 1 for p_atk , 0 for m_atk, -1 for no damage
//    int v1_s3_effect = 2;  // reduces m_atk by 1% for 2 turns
    int v1_s3_damage = rand.nextInt(3-2+1) + 2; // 2-3 damage


    // v2 skills
    String v2_s1_skill_name = "Mind Spike";
    int v2_s1_damage_type = 0;   /// 1 for p_atk , 0 for m_atk, -1 for no damage
// int v2_s1_effect = 1;  // reduces hero accuracy by 2% for 1 turn
    int v2_s1_damage = rand.nextInt(6-4+1) + 4; // 4-6 damage

    String v2_s2_skill_name = "Mental Trickery";
    int v2_s2_damage_type = 0; /// 1 for p_atk , 0 for m_atk, -1 for no damage
// int v2_s2_effect = 1; // increases evasion by 10% for 1 turn
    int v2_s2_damage = rand.nextInt(10-5+1) + 5; // 0 damage

    String v2_s3_skill_name = "Psionic Drain";
    int v2_s3_damage_type = 0; /// 1 for p_atk , 0 for m_atk, -1 for no damage
// int v2_s3_effect = 2;  // reduces m_atk by 1% for 2 turns
    int v2_s3_damage = rand.nextInt(3-2+1) + 2; // 2-3 damage


    // v3 skills
    String v3_s1_skill_name = "Mind Spike";
    int v3_s1_damage_type = 0;   /// 1 for p_atk , 0 for m_atk, -1 for no damage
// int v3_s1_effect = 1;  // reduces hero accuracy by 2% for 1 turn
    int v3_s1_damage = rand.nextInt(6-4+1) + 4; // 4-6 damage

    String v3_s2_skill_name = "Mental Trickery";
    int v3_s2_damage_type = 0; /// 1 for p_atk , 0 for m_atk, -1 for no damage
// int v3_s2_effect = 1; // increases evasion by 10% for 1 turn
    int v3_s2_damage = rand.nextInt(10-5+1) + 5; // 0 damage

    String v3_s3_skill_name = "Psionic Drain";
    int v3_s3_damage_type = 0; /// 1 for p_atk , 0 for m_atk, -1 for no damage
// int v3_s3_effect = 2;  // reduces m_atk by 1% for 2 turns
    int v3_s3_damage = rand.nextInt(3-2+1) + 2; // 2-3 damage


    // v4 skills
    String v4_s1_skill_name = "Mind Spike";
    int v4_s1_damage_type = 0;   /// 1 for p_atk , 0 for m_atk, -1 for no damage
// int v4_s1_effect = 1;  // reduces hero accuracy by 2% for 1 turn
    int v4_s1_damage = rand.nextInt(6-4+1) + 4; // 4-6 damage

    String v4_s2_skill_name = "Mental Trickery";
    int v4_s2_damage_type = 0; /// 1 for p_atk , 0 for m_atk, -1 for no damage
// int v4_s2_effect = 1; // increases evasion by 10% for 1 turn
    int v4_s2_damage = rand.nextInt(10-5+1) + 5; // 0 damage

    String v4_s3_skill_name = "Psionic Drain";
    int v4_s3_damage_type = 0; /// 1 for p_atk , 0 for m_atk, -1 for no damage
// int v4_s3_effect = 2;  // reduces m_atk by 1% for 2 turns
    int v4_s3_damage = rand.nextInt(3-2+1) + 2; // 2-3 damage


    // v5 skills
    String v5_s1_skill_name = "Mind Spike";
    int v5_s1_damage_type = 0;   /// 1 for p_atk , 0 for m_atk, -1 for no damage
// int v5_s1_effect = 1;  // reduces hero accuracy by 2% for 1 turn
    int v5_s1_damage = rand.nextInt(6-4+1) + 4; // 4-6 damage

    String v5_s2_skill_name = "Mental Trickery";
    int v5_s2_damage_type = 0; /// 1 for p_atk , 0 for m_atk, -1 for no damage
// int v5_s2_effect = 1; // increases evasion by 10% for 1 turn
    int v5_s2_damage = rand.nextInt(10-5+1) + 5; // 0 damage

    String v5_s3_skill_name = "Psionic Drain";
    int v5_s3_damage_type = 0; /// 1 for p_atk , 0 for m_atk, -1 for no damage
// int v5_s3_effect = 2;  // reduces m_atk by 1% for 2 turns
    int v5_s3_damage = rand.nextInt(3-2+1) + 2; // 2-3 damage

}
