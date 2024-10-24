package scene.event;

import elements.blessing.Blessing;
import elements.blessing.Blessing_Gacha;
import elements.creature.hero.Hero;
import game.Game;

import static game.WhichScene.END;
import static game.WhichScene.TRANCE;

public class _12_Message extends Event {
    private boolean hasWon;
    private Blessing_Gacha REWARD;

    public _12_Message(Hero HERO, boolean hasWon, int currWorld ,int currEncounter,Blessing_Gacha REWARD, Game GAME){
        super(HERO,currWorld,currEncounter,GAME);
        this.hasWon = hasWon;
        this.REWARD = REWARD;
        this.HERO = HERO;
    }

///applyBlessing sa hero and refreshEncounter sa hero
    @Override
    protected String displayText_Display() {
        if(hasWon){
            if(currWorld == 4) {
                return """
                        You Won Against The Entity!
                        
                        Congratulations!!!
                        """;
            }
            else {
                Blessing blessing = REWARD.gacha(currEncounter);
                int essence = switch (currEncounter) {
                    case 1, 2, 4, 5 -> 1;
                    case 3, 6 -> 2;
                    default -> 3;
                };

                HERO.add_essence(essence);
                HERO.add_blessing(blessing);
                HERO.refresh_encounter();

                return String.format(
                        """
                                You Won!
                                
                                You have obtained:
                                
                                +%d essence  ->  Offering to The Being
                                
                                %s
                                """,
                        essence,
                        blessing.toString()
                );
            }
        }
        else{
            return """
                    You Lost!
                    
                    Better Luck next time!
                    
                    You going back to the Start Menu Bro!
                    """;
        }
    }

    @Override
    public void onInputReceived(String input) {
        if(currWorld == 4){
            System.out.println("Going to _9_World_End...");
            GAME.nextScene(END);
        }
        else {
            System.out.println("Going to trance...");
            GAME.nextScene(TRANCE);
        }
    }
}
