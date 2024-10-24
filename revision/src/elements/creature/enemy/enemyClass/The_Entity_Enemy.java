package elements.creature.enemy.enemyClass;

import elements.creature.Creature;
import elements.creature.enemy.Enemy;
import elements.creature.hero.Hero;
import elements.creature.value.Effects;
import elements.creature.value.Skills;

import java.util.ArrayList;
import java.util.Arrays;

import static elements.creature.value.Effects.*;

public class The_Entity_Enemy extends Enemy {

    public The_Entity_Enemy(Hero hero){
        super(hero,1.3,2.4,0.7,0.6,0.5);

        NAME = "The Entity";
        SKILLS = new ArrayList<>(Arrays.asList(
                new Skills("Void of Extinction", 30, 0,NONE),
                new Skills("Reality Collapse", 50, 0,FRAIL),
                new Skills("Corruption Manifest", 60, 0,EMPOWER),
                new Skills("Eternal Darkness", 0, 0,WEAKEN),
                new Skills("World Ender", 100, 0,STUN)
        ));
    }

    @Override
    protected String skill(int skillNum, boolean isCrit, int damage, Creature creature) {
        String msg;
        String crit = isCrit ? "CRIT! " : "";
        Effects effects = getSKILL_EFFECTS(skillNum);

        switch (skillNum){
            case 2:
                msg = String.format(
                        """
                        %s used %s!
                        
                        %sDealt %d damage!
                        
                        Decreased %s's DEF by 30 for 2 turns!
                        """,
                        NAME, getSKILL_NAME(skillNum),
                        crit,damage,
                        creature.getNAME()
                );
                creature.addEffects(effects,2,30);
                break;
            case 3:
                msg = String.format(
                        """
                        %s used %s!
                        
                        %sDealt %d damage!
                        
                        Increased ATK by 30 for 2 turns!
                        """,
                        NAME, getSKILL_NAME(skillNum),
                        crit,damage
                );
                addEffects(effects,2,30);
                break;
            case 4:
                msg = String.format(
                        """
                        %s used %s!

                        Decreased %s's ATK by 30 for 2 turns!
                        """,
                        NAME, getSKILL_NAME(skillNum),
                        creature.getNAME()
                );
                creature.addEffects(effects,2,30);
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

        return msg;
    }
}
