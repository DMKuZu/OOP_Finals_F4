package elements.creature.enemy.enemyClass;

import elements.creature.enemy.Enemy;
import elements.creature.hero.Hero;
import elements.creature.value.Skills;

import java.util.ArrayList;
import java.util.Random;

public class Elite_Enemy extends Enemy {

    public Elite_Enemy(Hero hero, int currWorld, int currEncounter){
        super(hero,0.9,2.2,0.5,0.4,0.3);

        SKILLS = new ArrayList<>(4);

        switch (hero.getNAME()){
            case "Radea":
                switch (currWorld){
                    case 1:
                        switch (currEncounter){
                            case 3:
                                NAME = Azr_Elite_List.get(0);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(AzrEliteV1_SKILL_NAME.get(i),Azr_BASE_DMG.get(i),0));
                                }
                                break;
                            case 6:
                                NAME = Azr_Elite_List.get(1);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(AzrEliteV2_SKILL_NAME.get(i),Azr_BASE_DMG.get(i),0));
                                }
                                break;
                        }
                        break;
                    case 2:
                        switch (currEncounter){
                            case 3:
                                NAME = Qua_Elite_List.get(0);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(QuaEliteV1_SKILL_NAME.get(i),Qua_BASE_DMG.get(i),0));
                                }
                                break;
                            case 6:
                                NAME = Qua_Elite_List.get(1);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(QuaEliteV2_SKILL_NAME.get(i),Qua_BASE_DMG.get(i),0));
                                }
                                break;
                        }
                        break;
                    case 3:
                        switch (currEncounter){
                            case 3:
                                NAME = Sar_Elite_List.get(0);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(SarEliteV1_SKILL_NAME.get(i),Sar_BASE_DMG.get(i),0));
                                }
                                break;
                            case 6:
                                NAME = Sar_Elite_List.get(1);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(SarEliteV2_SKILL_NAME.get(i),Sar_BASE_DMG.get(i),0));
                                }
                                break;
                        }
                        break;
                }
                break;
            case "Mazupe":
                switch (currWorld){
                    case 1:
                        switch (currEncounter){
                            case 3:
                                NAME = Sar_Elite_List.get(0);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(SarEliteV1_SKILL_NAME.get(i),Sar_BASE_DMG.get(i),0));
                                }
                                break;
                            case 6:
                                NAME = Sar_Elite_List.get(1);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(SarEliteV2_SKILL_NAME.get(i),Sar_BASE_DMG.get(i),0));
                                }
                                break;
                        }
                        break;
                    case 2:
                        switch (currEncounter){
                            case 3:
                                NAME = Azr_Elite_List.get(0);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(AzrEliteV1_SKILL_NAME.get(i),Azr_BASE_DMG.get(i),0));
                                }
                                break;
                            case 6:
                                NAME = Azr_Elite_List.get(1);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(AzrEliteV2_SKILL_NAME.get(i),Azr_BASE_DMG.get(i),0));
                                }
                                break;
                        }
                        break;
                    case 3:
                        switch (currEncounter){
                            case 3:
                                NAME = Qua_Elite_List.get(0);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(QuaEliteV1_SKILL_NAME.get(i),Qua_BASE_DMG.get(i),0));
                                }
                                break;
                            case 6:
                                NAME = Qua_Elite_List.get(1);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(QuaEliteV2_SKILL_NAME.get(i),Qua_BASE_DMG.get(i),0));
                                }
                                break;
                        }
                        break;

                }
                break;
            case "Zipau":
            default:
                switch (currWorld){
                    case 1:
                        switch (currEncounter){
                            case 3:
                                NAME = Qua_Elite_List.get(0);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(QuaEliteV1_SKILL_NAME.get(i),Qua_BASE_DMG.get(i),0));
                                }
                                break;
                            case 6:
                                NAME = Qua_Elite_List.get(1);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(QuaEliteV2_SKILL_NAME.get(i),Qua_BASE_DMG.get(i),0));
                                }
                                break;
                        }
                        break;
                    case 2:
                        switch (currEncounter){
                            case 3:
                                NAME = Sar_Elite_List.get(0);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(SarEliteV1_SKILL_NAME.get(i),Sar_BASE_DMG.get(i),0));
                                }
                                break;
                            case 6:
                                NAME = Sar_Elite_List.get(1);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(SarEliteV2_SKILL_NAME.get(i),Sar_BASE_DMG.get(i),0));
                                }
                                break;
                        }
                        break;
                    case 3:
                        switch (currEncounter){
                            case 3:
                                NAME = Azr_Elite_List.get(0);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(AzrEliteV1_SKILL_NAME.get(i),Azr_BASE_DMG.get(i),0));
                                }
                                break;
                            case 6:
                                NAME = Azr_Elite_List.get(1);
                                for(int i = 0; i < 4; i++){
                                    SKILLS.add(new Skills(AzrEliteV2_SKILL_NAME.get(i),Azr_BASE_DMG.get(i),0));
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
        int skillNum = rand.nextInt(4) + 1;

        return useSkill(skillNum);
    }



}
