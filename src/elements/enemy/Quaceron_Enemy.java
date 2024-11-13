package elements.enemy;

import elements.hero.List_of_Characters;

import java.util.ArrayList;
import java.util.List;

public class Quaceron_Enemy implements List_of_Quaceron_Enemies, List_of_Characters {
    private final String name;
    private final List<String> SKILL_NAME;
    private final List<Integer> BASE_DMG;

    private final String enemyType;

    protected void init(Current_Enemy enemy){
        enemy.setNAME(name);
        enemy.setSKILL_NAME(SKILL_NAME);
        enemy.setBASE_DMG(BASE_DMG);
        enemy.setEnemyType(enemyType);
    }

    protected Quaceron_Enemy(int encounterCtr, boolean isNorm){

        switch (encounterCtr){
            case 1:
                name = Norm_List.get(0);
                SKILL_NAME = QuaNormV1_SKILL_NAME;
                BASE_DMG = Qua_BASE_DMG;
                enemyType = "norm";
                break;
            case 3:
                name = Norm_List.get(1);
                SKILL_NAME = QuaNormV2_SKILL_NAME;
                BASE_DMG = Qua_BASE_DMG;
                enemyType = "norm";
                break;
            case 5:
                name = Elite_List.get(0);
                SKILL_NAME = QuaEliteV1_SKILL_NAME;
                BASE_DMG = Qua_BASE_DMG;
                enemyType = "elite";
                break;
            case 7:
                name = Norm_List.get(2);
                SKILL_NAME = QuaNormV3_SKILL_NAME;
                BASE_DMG = Qua_BASE_DMG;
                enemyType = "norm";
                break;
            case 9:
                name = Norm_List.get(3);
                SKILL_NAME = QuaNormV4_SKILL_NAME;
                BASE_DMG = Qua_BASE_DMG;
                enemyType = "norm";
                break;
            case 11:
            default:
                if(isNorm){
                    name = Norm_List.get(4);
                    SKILL_NAME = QuaNormV5_SKILL_NAME;
                    BASE_DMG = Qua_BASE_DMG;
                    enemyType = "norm";
                }
                else {
                    name = Elite_List.get(1);
                    SKILL_NAME = QuaEliteV2_SKILL_NAME;
                    BASE_DMG = Qua_BASE_DMG;
                    enemyType = "elite";
                }
                break;
        }
    }
}
