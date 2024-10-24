package scene.event.offer;

import elements.creature.hero.Hero;
import game.Game;
import scene.event.Event;
import scene.event.operationClasses.Offer;

import static game.WhichScene.END;
import static game.WhichScene.SCENARIO;

public class _10_Trance extends Event {

    public _10_Trance(Hero HERO, int currWorld, int currEncounter, Game GAME){
        super(HERO,currWorld,currEncounter,GAME);
    }

    protected String displayText_Display(){
        return String.format("""
        A fog of uncertainty clouds your mind. The path ahead, once clear,
        now seems shrouded in mist. A sense of weariness settles over you,
        a heavy weight on your shoulders. 
        
        Suddenly, a chilling sensation grips your soul.
        You're pulled into a trance, a captive of an unseen force.
        A voice, ancient and powerful, echoes within your mind. 
        
        'Remember your purpose', it commands. 
        'The essence you've collected fuels your destiny.'
        
        A vision flashes before your eyes: a cosmic tapestry, intricate and vast. 
        You are a mere thread, a part of a grand design. 
        A sense of urgency returns, a renewed drive to fulfill your mission.
        
        Will you offer the essence to The Being?
        or
        Will you wake up and continue along your path?
        
        Your current Favor Inventory:
        %s
        """
        , HERO.getFAVOR().favorDesc()
        );
    }

    protected String displayText_Choice() {
        int essence = HERO.getESSENCE();
        int favorSize = HERO.getFAVOR().getFavorSize();

        return String.format("""
        You have %d essence and %d | 3 Favors.

        > 1 : Offer     -> 1 essence for 1 favor
        > 2 : Continue  -> Next encounter
        """,essence,favorSize);
    }

    public void onInputReceived(String input){
        switch (input.toLowerCase()){
            case "1":
            case "offer":
                if(HERO.getESSENCE() > 0){
                    System.out.println("Going to Offer...");
                    Offer market = new Offer(HERO,GAME);

                    if(HERO.getFAVOR().getFavorSize() < 3){
                        market.obtained();
                    }
                    else{
                        market.exchange();
                    }
                }
                else {
                    System.out.println("no more essence lil brokie...");
                }
                break;
            case "2":
            case "continue":
                if(currEncounter == 8){
                    System.out.println("Going to _9_World_End...");
                    GAME.nextScene(END);
                }
                else{
                    System.out.println("Going to scenario...");
                    GAME.nextScene(SCENARIO);
                }
                break;
            default:
                System.out.println("Invalid input: " + input);
        }
    }

}
