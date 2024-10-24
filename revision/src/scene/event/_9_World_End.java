package scene.event;

import elements.creature.hero.Hero;
import game.Game;

import static game.WhichScene.MENU;
import static game.WhichScene.START;


public class _9_World_End extends Event {

    public _9_World_End(Hero HERO, int currWorld, Game GAME){
        super(HERO,currWorld,0,GAME);
    }

    @Override
    protected String displayText_Display() {
        switch (HERO.getNAME()){
            case "Radea":
                switch (currWorld){
                    case 1:
                        return "The end world 1";
                    case 2:
                        return "The end world 2 ";
                    case 3:
                        return "The end world 3";
                    default:
                        return "Bang patay na The Entity\n" +
                                "Thank you for watching OUR demo!";
                }
            case "Mazupe":
                switch (currWorld){
                    case 1:
                        return "The end world 1 ";
                    case 2:
                        return "The end world 2";
                    case 3:
                        return "The end world 3";
                    default:
                        return "Bang patay na The Entity\n" +
                                "Thank you for watching OUR demo!";
                }
            case "Zipau":
            default:
                switch (currWorld){
                    case 1:
                        return "The end world 1";
                    case 2:
                        return "The end world 2";
                    case 3:
                        return "The end world 3";
                    default:
                        return "Bang patay na The Entity\n" +
                                "Thank you for watching OUR demo!";
                }
        }

    }



    @Override
    public void onInputReceived(String input) {
        GAME.resetEncounter();
        HERO.refresh_world();

        if(currWorld ==4){
            GAME.resetWorld();

            System.out.println("Going back to Menu...");
            GAME.nextScene(MENU);
        }
        else{
            GAME.nextWorld();

            System.out.println("Going to _0_World_Start...");
            GAME.nextScene(START);
        }
    }
}
