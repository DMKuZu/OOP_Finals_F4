package elements.creature.enemy.enemyClass;

import elements.creature.Creature;
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
                            case 1 -> NAME = Azr_Norm_List.get(0);
                            case 2 -> NAME = Azr_Norm_List.get(1);
                            case 4 -> NAME = Azr_Norm_List.get(2);
                            case 5 -> NAME = Azr_Norm_List.get(3);
                            case 6 -> NAME = Azr_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(AzrSkills.get(i));
                        }
                        break;
                    case 2:
                        switch (currEncounter) {
                            case 1 -> NAME = Qua_Norm_List.get(0);
                            case 2 -> NAME = Qua_Norm_List.get(1);
                            case 4 -> NAME = Qua_Norm_List.get(2);
                            case 5 -> NAME = Qua_Norm_List.get(3);
                            case 6 -> NAME = Qua_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(QuaSkills.get(i));
                        }
                        break;
                    case 3:
                        switch (currEncounter) {
                            case 1 -> NAME = Sar_Norm_List.get(0);
                            case 2 -> NAME = Sar_Norm_List.get(1);
                            case 4 -> NAME = Sar_Norm_List.get(2);
                            case 5 -> NAME = Sar_Norm_List.get(3);
                            case 6 -> NAME = Sar_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(SarSkills.get(i));
                        }
                        break;
                }
                break;
            case "Mazupe":
                switch (currWorld) {
                    case 1:
                        switch (currEncounter) {
                            case 1 -> NAME = Sar_Norm_List.get(0);
                            case 2 -> NAME = Sar_Norm_List.get(1);
                            case 4 -> NAME = Sar_Norm_List.get(2);
                            case 5 -> NAME = Sar_Norm_List.get(3);
                            case 6 -> NAME = Sar_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(SarSkills.get(i));
                        }
                        break;
                    case 2:
                        switch (currEncounter) {
                            case 1 -> NAME = Azr_Norm_List.get(0);
                            case 2 -> NAME = Azr_Norm_List.get(1);
                            case 4 -> NAME = Azr_Norm_List.get(2);
                            case 5 -> NAME = Azr_Norm_List.get(3);
                            case 6 -> NAME = Azr_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(AzrSkills.get(i));
                        }
                        break;
                    case 3:
                        switch (currEncounter) {
                            case 1 -> NAME = Qua_Norm_List.get(0);
                            case 2 -> NAME = Qua_Norm_List.get(1);
                            case 4 -> NAME = Qua_Norm_List.get(2);
                            case 5 -> NAME = Qua_Norm_List.get(3);
                            case 6 -> NAME = Qua_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(QuaSkills.get(i));
                        }
                        break;
                }
                break;
            case "Zipau":
            default:
                switch (currWorld) {
                    case 1:
                        switch (currEncounter) {
                            case 1 -> NAME = Qua_Norm_List.get(0);
                            case 2 -> NAME = Qua_Norm_List.get(1);
                            case 4 -> NAME = Qua_Norm_List.get(2);
                            case 5 -> NAME = Qua_Norm_List.get(3);
                            case 6 -> NAME = Qua_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(QuaSkills.get(i));
                        }
                        break;
                    case 2:
                        switch (currEncounter) {
                            case 1 -> NAME = Sar_Norm_List.get(0);
                            case 2 -> NAME = Sar_Norm_List.get(1);
                            case 4 -> NAME = Sar_Norm_List.get(2);
                            case 5 -> NAME = Sar_Norm_List.get(3);
                            case 6 -> NAME = Sar_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(SarSkills.get(i));
                        }
                        break;
                    case 3:
                        switch (currEncounter) {
                            case 1 -> NAME = Azr_Norm_List.get(0);
                            case 2 -> NAME = Azr_Norm_List.get(1);
                            case 4 -> NAME = Azr_Norm_List.get(2);
                            case 5 -> NAME = Azr_Norm_List.get(3);
                            case 6 -> NAME = Azr_Norm_List.get(4);
                        }
                        for(int i = 0; i < 3; i++){
                            SKILLS.add(AzrSkills.get(i));
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


    @Override
    protected String skill(int skillNum, boolean isCrit, int damage, Creature creature) {
        return "";
    }
}
