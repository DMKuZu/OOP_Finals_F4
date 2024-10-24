package elements.creature.enemy.enemyClass;

import elements.creature.Creature;
import elements.creature.enemy.Enemy;
import elements.creature.hero.Hero;
import elements.creature.value.Skills;

import java.util.ArrayList;
import java.util.Random;

public class Elite_Enemy extends Enemy {

    public Elite_Enemy(Hero hero, int currWorld, int currEncounter){
        super(hero,0.9,2.2,0.5,0.4,0.3);

        switch (hero.getNAME()){
            case "Radea":
                switch (currWorld){
                    case 1:
                        switch (currEncounter) {
                            case 3 -> NAME = Azr_Elite_List.get(0);
                            case 6 -> NAME = Azr_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(AzrSkills);
                        break;
                    case 2:
                        switch (currEncounter) {
                            case 3 -> NAME = Qua_Elite_List.get(0);
                            case 6 -> NAME = Qua_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(QuaSkills);
                        break;
                    case 3:
                        switch (currEncounter) {
                            case 3 -> NAME = Sar_Elite_List.get(0);
                            case 6 -> NAME = Sar_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(SarSkills);
                        break;
                }
                break;
            case "Mazupe":
                switch (currWorld){
                    case 1:
                        switch (currEncounter) {
                            case 3 -> NAME = Sar_Elite_List.get(0);
                            case 6 -> NAME = Sar_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(SarSkills);
                        break;
                    case 2:
                        switch (currEncounter) {
                            case 3 -> NAME = Azr_Elite_List.get(0);
                            case 6 -> NAME = Azr_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(AzrSkills);
                        break;
                    case 3:
                        switch (currEncounter) {
                            case 3 -> NAME = Qua_Elite_List.get(0);
                            case 6 -> NAME = Qua_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(QuaSkills);
                        break;
                }
                break;
            case "Zipau":
            default:
                switch (currWorld){
                    case 1:
                        switch (currEncounter) {
                            case 3 -> NAME = Qua_Elite_List.get(0);
                            case 6 -> NAME = Qua_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(QuaSkills);
                        break;
                    case 2:
                        switch (currEncounter) {
                            case 3 -> NAME = Sar_Elite_List.get(0);
                            case 6 -> NAME = Sar_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(SarSkills);
                        break;
                    case 3:
                        switch (currEncounter) {
                            case 3 -> NAME = Azr_Elite_List.get(0);
                            case 6 -> NAME = Azr_Elite_List.get(1);
                        }
                        SKILLS = new ArrayList<>(AzrSkills);
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


    @Override
    protected String skill(int skillNum, boolean isCrit, int damage, Creature creature) {
        return "";
    }
}
