package elements.creature.enemy.enemyClass;

import elements.creature.Creature;
import elements.creature.Hero_Skills;
import elements.creature.enemy.Enemy;
import elements.creature.hero.Hero;
import elements.creature.value.Effects;
import elements.creature.value.Skills;

import java.util.ArrayList;
import java.util.Arrays;

public class Boss_Enemy extends Enemy implements Hero_Skills {
    private final String whichHero;

    public Boss_Enemy(Hero hero, int currWorld){
        super(hero,1.1,2.4,0.6,0.5,0.4);

        SKILLS = new ArrayList<>(5);
        this.whichHero = hero.getNAME();

        switch (whichHero){
            case "Radea":
                switch (currWorld){
                    case 1:
                        NAME = "Corrupted Zipau";
                        SKILLS = new ArrayList<>(Zipau_Skills);
                        break;
                    case 2:
                        NAME = "Corrupted Mazupe";
                        SKILLS= new ArrayList<>(Mazupe_Skills);
                        break;
                    case 3:
                        NAME = "Corrupted Radea";
                        SKILLS = new ArrayList<>(Radea_Skills);
                        break;
                }
                break;
            case "Mazupe":
                switch (currWorld){
                    case 1:
                        NAME = "Corrupted Radea";
                        SKILLS = new ArrayList<>(Radea_Skills);
                        break;
                    case 2:
                        NAME = "Corrupted Zipau";
                        SKILLS = new ArrayList<>(Zipau_Skills);
                        break;
                    case 3:
                        NAME = "Corrupted Mazupe";
                        SKILLS= new ArrayList<>(Mazupe_Skills);
                        break;
                }
                break;
            case "Zipau":
            default:
                switch (currWorld){
                    case 1:
                        NAME = "Corrupted Mazupe";
                        SKILLS= new ArrayList<>(Mazupe_Skills);
                        break;
                    case 2:
                        NAME = "Corrupted Radea";
                        SKILLS = new ArrayList<>(Radea_Skills);
                        break;
                    case 3:
                        NAME = "Corrupted Zipau";
                        SKILLS = new ArrayList<>(Zipau_Skills);
                        break;
                }
                break;
        }
    }


    @Override
    protected String skill(int skillNum, boolean isCrit, int damage, Creature creature) {
        String msg;
        String crit = isCrit ? "CRIT! " : "";
        Effects effects = getSKILL_EFFECTS(skillNum);

        switch (this.whichHero){
            case "Radea":
                switch (skillNum){
                    case 2:
                        msg = String.format(
                                """
                                %s used %s!
                                
                                %sDealt %d damage!
                                
                                Decreased %s's ATK by 20 for 2 turns!
                                """,
                                NAME, getSKILL_NAME(skillNum),
                                crit,damage,
                                creature.getNAME()
                        );
                        creature.addEffects(effects,2,20);
                        break;
                    case 3:
                        msg = String.format(
                                """
                                %s used %s!
                                
                                Increased DEF by 30 for 4 turns!
                                """,
                                NAME, getSKILL_NAME(skillNum)
                        );
                        addEffects(effects,4,30);
                        break;
                    case 4:
                        msg = String.format(
                                """
                                %s used %s!
                                
                                %sDealt %d damage!
                                
                                Decreased %s's DEF by 20 for 3 turns!
                                """,
                                NAME, getSKILL_NAME(skillNum),
                                crit,damage,
                                creature.getNAME()
                        );
                        creature.addEffects(effects,3,20);
                        break;
                    case 5:
                        msg = String.format(
                                """
                                %s used %s!
                                
                                %sDealt %d damage!
                                
                                Inflict 20 damage to %s for 3 turns!
                                """,
                                NAME, getSKILL_NAME(skillNum),
                                crit,damage,
                                creature.getNAME()
                        );
                        creature.addEffects(effects,3,20);
                        break;
                    default:
                        msg = String.format(
                                """
                                %s used %s!
                                
                                %sDealt %d damage!
                                """,
                                NAME, getSKILL_NAME(skillNum),
                                crit,damage
                        );
                }
                break;
            case "Mazupe":
                switch (skillNum){
                    case 2:
                        msg = String.format(
                                """
                                %s used %s!
                                
                                %sDealt %d damage!
                                
                                Decreased %s's DEF by 20 for 3 turns!
                                """,
                                NAME, getSKILL_NAME(skillNum),
                                crit,damage,
                                creature.getNAME()
                        );
                        creature.addEffects(effects,3, 20);
                        break;
                    case 3:
                        msg = String.format(
                                """
                                %s used %s!
                                
                                Increased ATK by 20 for 6 turns!
                                """,
                                NAME, getSKILL_NAME(skillNum)
                        );
                        addEffects(effects,6, 20);
                        break;
                    case 4:
                        msg = String.format(
                                """
                                %s used %s!
                                
                                Regenerate 10 HP for 2 turns!
                                """,
                                NAME, getSKILL_NAME(skillNum)
                        );
                        addEffects(effects,2,10);
                        break;
                    case 5:
                        msg = String.format(
                                """
                                %s used %s!
                                
                                %sDealt %d damage!
                                
                                Stunned %s for 1 turn!
                                """,
                                NAME, getSKILL_NAME(skillNum),
                                crit,damage,
                                creature.getNAME()
                        );
                        creature.addEffects(effects,1,0);
                        break;
                    default:
                        msg = String.format(
                                """
                                %s used %s!
                                
                                %sDealt %d damage!
                                """,
                                NAME, getSKILL_NAME(skillNum),
                                crit,damage
                        );
                }
                break;
            case "Zipau":
            default:
                switch (skillNum){
                    case 2:
                        msg = String.format(
                                """
                                %s used %s!
                                
                                %sDealt %d damage!
                                
                                Increased ATK by 15 for 2 turns!
                                """,
                                NAME, getSKILL_NAME(skillNum),
                                crit,damage
                        );
                        addEffects(effects,2,15);
                        break;
                    case 3:
                        msg = String.format(
                                """
                                %s used %s!
                                
                                Increased DODGE by 10 for 4 turns!
                                """,
                                NAME, getSKILL_NAME(skillNum)
                        );
                        addEffects(effects,4,10);
                        break;
                    case 4:
                        msg = String.format(
                                """
                                %s used %s!
                                
                                %sDealt %d damage!
                                
                                Increased CRIT by 20 for 3!
                                """,
                                NAME, getSKILL_NAME(skillNum),
                                crit,damage
                        );
                        addEffects(effects,3,20);
                        break;
                    case 5:
                        msg = String.format(
                                """
                                %s used %s!
                                
                                %sDealt %d damage!
                                
                                Decreased %s's DEF by 20 for 3 turns!
                                """,
                                NAME, getSKILL_NAME(skillNum),
                                crit,damage,
                                creature.getNAME()
                        );
                        creature.addEffects(effects,3,20);
                        break;
                    default:
                        msg = String.format(
                                """
                                %s used %s!
                                
                                %sDealt %d damage!
                                """,
                                NAME, getSKILL_NAME(skillNum),
                                crit,damage
                        );
                }
                break;
        }

        return msg;
    }
}
