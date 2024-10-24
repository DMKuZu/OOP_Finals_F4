package elements.creature.enemy.enemyClass;

import elements.creature.enemy.Enemy;
import elements.creature.hero.Hero;
import elements.creature.value.Skills;

import java.util.ArrayList;
import java.util.Random;

public class Norm_Enemy extends Enemy {

    public Norm_Enemy(Hero hero, int currWorld, int currEncounter){
        super(hero,0.7,2.0,0.4,0.3,0.2);

        SKILLS = new ArrayList<>(3);

        switch (hero.getNAME()) {
            case "Radea":
                switch (currWorld) {
                    case 1:
                        switch (currEncounter) {
                            case 1:
                                NAME = Azr_Norm_List.get(0);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(AzrNormV1_SKILL_NAME.get(i), Azr_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 2:
                                NAME = Azr_Norm_List.get(1);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(AzrNormV2_SKILL_NAME.get(i), Azr_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 4:
                                NAME = Azr_Norm_List.get(2);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(AzrNormV3_SKILL_NAME.get(i), Azr_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 5:
                                NAME = Azr_Norm_List.get(3);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(AzrNormV4_SKILL_NAME.get(i), Azr_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 6:
                                NAME = Azr_Norm_List.get(4);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(AzrNormV5_SKILL_NAME.get(i), Azr_BASE_DMG.get(i), 0));
                                }
                                break;
                        }
                        break;
                    case 2:
                        switch (currEncounter) {
                            case 1:
                                NAME = Qua_Norm_List.get(0);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(QuaNormV1_SKILL_NAME.get(i), Qua_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 2:
                                NAME = Qua_Norm_List.get(1);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(QuaNormV2_SKILL_NAME.get(i), Qua_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 4:
                                NAME = Qua_Norm_List.get(2);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(QuaNormV3_SKILL_NAME.get(i), Qua_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 5:
                                NAME = Qua_Norm_List.get(3);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(QuaNormV4_SKILL_NAME.get(i), Qua_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 6:
                                NAME = Qua_Norm_List.get(4);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(QuaNormV5_SKILL_NAME.get(i), Qua_BASE_DMG.get(i), 0));
                                }
                                break;
                        }
                        break;
                    case 3:
                        switch (currEncounter) {
                            case 1:
                                NAME = Sar_Norm_List.get(0);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(SarNormV1_SKILL_NAME.get(i), Sar_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 2:
                                NAME = Sar_Norm_List.get(1);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(SarNormV2_SKILL_NAME.get(i), Sar_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 4:
                                NAME = Sar_Norm_List.get(2);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(SarNormV3_SKILL_NAME.get(i), Sar_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 5:
                                NAME = Sar_Norm_List.get(3);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(SarNormV4_SKILL_NAME.get(i), Sar_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 6:
                                NAME = Sar_Norm_List.get(4);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(SarNormV5_SKILL_NAME.get(i), Sar_BASE_DMG.get(i), 0));
                                }
                                break;
                        }
                        break;
                }
                break;
            case "Mazupe":
                switch (currWorld) {
                    case 1:
                        switch (currEncounter) {
                            case 1:
                                NAME = Sar_Norm_List.get(0);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(SarNormV1_SKILL_NAME.get(i), Sar_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 2:
                                NAME = Sar_Norm_List.get(1);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(SarNormV2_SKILL_NAME.get(i), Sar_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 4:
                                NAME = Sar_Norm_List.get(2);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(SarNormV3_SKILL_NAME.get(i), Sar_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 5:
                                NAME = Sar_Norm_List.get(3);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(SarNormV4_SKILL_NAME.get(i), Sar_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 6:
                                NAME = Sar_Norm_List.get(4);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(SarNormV5_SKILL_NAME.get(i), Sar_BASE_DMG.get(i), 0));
                                }
                                break;
                        }
                        break;
                    case 2:
                        switch (currEncounter) {
                            case 1:
                                NAME = Azr_Norm_List.get(0);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(AzrNormV1_SKILL_NAME.get(i), Azr_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 2:
                                NAME = Azr_Norm_List.get(1);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(AzrNormV2_SKILL_NAME.get(i), Azr_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 4:
                                NAME = Azr_Norm_List.get(2);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(AzrNormV3_SKILL_NAME.get(i), Azr_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 5:
                                NAME = Azr_Norm_List.get(3);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(AzrNormV4_SKILL_NAME.get(i), Azr_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 6:
                                NAME = Azr_Norm_List.get(4);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(AzrNormV5_SKILL_NAME.get(i), Azr_BASE_DMG.get(i), 0));
                                }
                                break;
                        }
                        break;
                    case 3:
                        switch (currEncounter) {
                            case 1:
                                NAME = Qua_Norm_List.get(0);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(QuaNormV1_SKILL_NAME.get(i), Qua_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 2:
                                NAME = Qua_Norm_List.get(1);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(QuaNormV2_SKILL_NAME.get(i), Qua_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 4:
                                NAME = Qua_Norm_List.get(2);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(QuaNormV3_SKILL_NAME.get(i), Qua_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 5:
                                NAME = Qua_Norm_List.get(3);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(QuaNormV4_SKILL_NAME.get(i), Qua_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 6:
                                NAME = Qua_Norm_List.get(4);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(QuaNormV5_SKILL_NAME.get(i), Qua_BASE_DMG.get(i), 0));
                                }
                                break;
                        }
                        break;
                }
                break;
            case "Zipau":
            default:
                switch (currWorld) {
                    case 1:
                        switch (currEncounter) {
                            case 1:
                                NAME = Qua_Norm_List.get(0);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(QuaNormV1_SKILL_NAME.get(i), Qua_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 2:
                                NAME = Qua_Norm_List.get(1);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(QuaNormV2_SKILL_NAME.get(i), Qua_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 4:
                                NAME = Qua_Norm_List.get(2);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(QuaNormV3_SKILL_NAME.get(i), Qua_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 5:
                                NAME = Qua_Norm_List.get(3);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(QuaNormV4_SKILL_NAME.get(i), Qua_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 6:
                                NAME = Qua_Norm_List.get(4);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(QuaNormV5_SKILL_NAME.get(i), Qua_BASE_DMG.get(i), 0));
                                }
                                break;
                        }
                        break;
                    case 2:
                        switch (currEncounter) {
                            case 1:
                                NAME = Sar_Norm_List.get(0);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(SarNormV1_SKILL_NAME.get(i), Sar_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 2:
                                NAME = Sar_Norm_List.get(1);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(SarNormV2_SKILL_NAME.get(i), Sar_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 4:
                                NAME = Sar_Norm_List.get(2);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(SarNormV3_SKILL_NAME.get(i), Sar_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 5:
                                NAME = Sar_Norm_List.get(3);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(SarNormV4_SKILL_NAME.get(i), Sar_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 6:
                                NAME = Sar_Norm_List.get(4);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(SarNormV5_SKILL_NAME.get(i), Sar_BASE_DMG.get(i), 0));
                                }
                                break;
                        }
                        break;
                    case 3:
                        switch (currEncounter) {
                            case 1:
                                NAME = Azr_Norm_List.get(0);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(AzrNormV1_SKILL_NAME.get(i), Azr_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 2:
                                NAME = Azr_Norm_List.get(1);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(AzrNormV2_SKILL_NAME.get(i), Azr_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 4:
                                NAME = Azr_Norm_List.get(2);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(AzrNormV3_SKILL_NAME.get(i), Azr_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 5:
                                NAME = Azr_Norm_List.get(3);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(AzrNormV4_SKILL_NAME.get(i), Azr_BASE_DMG.get(i), 0));
                                }
                                break;
                            case 6:
                                NAME = Azr_Norm_List.get(4);
                                
                                for (int i = 0; i < 3; i++) {
                                    SKILLS.add(new Skills(AzrNormV5_SKILL_NAME.get(i), Azr_BASE_DMG.get(i), 0));
                                }
                                break;
                        }
                        break;
                }
        }

    }

    @Override
    public String attack() {
        Random rand = new Random();
        int skillNum = rand.nextInt(3) + 1;

        return useSkill(skillNum);
    }


}
