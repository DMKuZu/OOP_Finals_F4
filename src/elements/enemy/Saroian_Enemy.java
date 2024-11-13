package elements.enemy;


import elements.hero.List_of_Characters;


import java.util.ArrayList;
import java.util.List;

public class Saroian_Enemy implements List_of_Saroian_Enemies, List_of_Characters {
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

    protected Saroian_Enemy(int encounterCtr, boolean isNorm){

        switch (encounterCtr){
            case 1:
                name = Norm_List.get(0);
                SKILL_NAME = SarNormV1_SKILL_NAME;
                BASE_DMG = Sar_BASE_DMG;
                enemyType = "norm";
                break;
            case 3:
                name = Norm_List.get(1);
                SKILL_NAME = SarNormV2_SKILL_NAME;
                BASE_DMG = Sar_BASE_DMG;
                enemyType = "norm";
                break;
            case 5:
                name = Elite_List.get(0);
                SKILL_NAME = SarEliteV1_SKILL_NAME;
                BASE_DMG = Sar_BASE_DMG;
                enemyType = "elite";
                break;
            case 7:
                name = Norm_List.get(2);
                SKILL_NAME = SarNormV3_SKILL_NAME;
                BASE_DMG = Sar_BASE_DMG;
                enemyType = "norm";
                break;
            case 9:
                name = Norm_List.get(3);
                SKILL_NAME = SarNormV4_SKILL_NAME;
                BASE_DMG = Sar_BASE_DMG;
                enemyType = "norm";
                break;
            case 11:
            default:
                if(isNorm){
                    name = Norm_List.get(4);
                    SKILL_NAME = SarNormV5_SKILL_NAME;
                    BASE_DMG = Sar_BASE_DMG;
                    enemyType = "norm";
                }
                else {
                    name = Elite_List.get(1);
                    SKILL_NAME = SarEliteV2_SKILL_NAME;
                    BASE_DMG = Sar_BASE_DMG;
                    enemyType = "elite";
                }
                break;
        }
    }

}
