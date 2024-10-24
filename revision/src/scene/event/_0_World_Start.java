package scene.event;

import elements.creature.hero.Hero;
import game.Game;


import static game.WhichScene.SCENARIO;
import static game.WhichScene.THE_ENTITY;


public class _0_World_Start extends Event {

    public _0_World_Start(Hero HERO,int currWorld, Game GAME){
        super(HERO, currWorld,0,GAME);
    }

    @Override
    protected String displayText_Display() {
        switch (HERO.getNAME()){
            case "Radea":
                switch (currWorld){
                    case 1:
                        return "Filler text for World 1 in azrueia";
                    case 2:
                        return "Filler text for World 2 in quacero";
                    case 3:
                        return "Filler text for World 3 in saroia";
                    default:
                        return "Exposition about The Entity";
                }
            case "Mazupe":
                switch (currWorld){
                    case 1:
                        return "Filler text for World 1 in saroia";
                    case 2:
                        return "Filler text for World 2 in azrueia";
                    case 3:
                        return "Filler text for World 3 in quacero";
                    default:
                        return "Exposition about The Entity";
                }
            case "Zipau":
            default:
                switch (currWorld){
                    case 1:
                        return "Filler text for World 1 in quacero";
                    case 2:
                        return "Filler text for World 2 in saroia";
                    case 3:
                        return "Filler text for World 3 in azrueia";
                    default:
                        return "Exposition about The Entity";
                }
        }

    }



    @Override
    public void onInputReceived(String input) {
        if(currWorld == 4){
            System.out.println("Final battle against The Entity...");
            GAME.nextScene(THE_ENTITY);
        }
        else{
            System.out.println("Going to Scenario...");
            GAME.nextScene(SCENARIO);
        }
    }
}
