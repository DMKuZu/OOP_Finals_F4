package scene.event;

import elements.creature.hero.Hero;
import game.Game;
import game.WhichScene;

import static game.WhichScene.SCENARIO;

public class _7_Rest extends Event{


    public _7_Rest(Hero hero, Game GAME) {
        super(hero, 69,7, GAME);
    }

    @Override
    protected String displayText_Display() {
        return String.format("""
                Congratulations! You have reached this far!
                
                Would you want to heal your HP?
                or
                Would you want to replenish your USES?
                
                Current HP : %d | %d
                
                Current USES:
                %s
                """,
                HERO.getCURRSTATS().getHP(),HERO.getSTATS().getHP(),
                HERO.skillUses()
        );
    }

    @Override
    protected String displayText_Choice() {
        return """
               Type the number of your choice!
               
               > 1 : Heal HP          -> Heal HP by 30% of total HP
               > 2 : Replenish USES   -> Fully replenish skill USES
               """;
    }

    @Override
    public void onInputReceived(String input) {
        switch (input){
            case"1":
                System.out.println("Chose healing...");
                HERO.rest(true);
                GAME.nextScene(SCENARIO);
                break;
            case"2":
                System.out.println("Chose replenishing...");
                HERO.rest(false);
                GAME.nextScene(SCENARIO);
                break;
            default:
                System.out.println("Invalid input: " + input);
        }
    }
}
