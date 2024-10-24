package scene.event;

import elements.creature.hero.Hero;
import elements.creature.value.Skills;
import game.Game;

import java.util.Arrays;

import static game.WhichScene.*;

public class _11_Scenario extends Event {

    public _11_Scenario(Hero HERO, int currWorld, int currEncounter, Game GAME){
        super(HERO,currWorld,currEncounter,GAME);

    }

    @Override
    protected String displayText_Display() {
        switch (HERO.getNAME()){
            case "Radea":
                switch (currWorld){
                    case 1:
                        switch (currEncounter){
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            default:
                                return "scenario texts world 1 for radea";
                        }
                    case 2:
                        switch (currEncounter){
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            default:
                            return "scenario texts world 2 for radea";
                        }
                    case 3:
                    default:
                        switch (currEncounter){
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            default:
                            return "scenario texts world 3 for radea";
                    }
                }
            case "Mazupe":
                switch (currWorld){
                    case 1:
                        switch (currEncounter){
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            default:
                                return "scenario texts world 1 for mazupe";
                        }
                    case 2:
                        switch (currEncounter){
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            default:
                                return "scenario texts world 2 for mazupe";
                        }
                    case 3:
                    default:
                        switch (currEncounter){
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            default:
                                return "scenario texts world 3 for mazupe";
                        }
                }
            case "Zipau":
            default:
                switch (currWorld){
                    case 1:
                        switch (currEncounter){
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            default:
                                return "scenario texts world 1 for zipau";
                        }
                    case 2:
                        switch (currEncounter){
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            default:
                                return "scenario texts world 2 for zipau";
                        }
                    case 3:
                    default:
                        switch (currEncounter){
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            default:
                                return "scenario texts world 3 for zipau";
                        }
                }
        }
    }


    @Override
    public void onInputReceived(String input) {
        switch (input.toLowerCase()) {
            case "back":
            case "":
                GAME.nextEncounter();
                switch (currEncounter+1){
                    case 1:
                        System.out.println("Going to next _1_Norm...");
                        GAME.nextScene(EVENT1);
                        break;
                    case 2:
                        System.out.println("Going to next _2_Norm...");
                        GAME.nextScene(EVENT2);
                        break;
                    case 3:
                        System.out.println("Going to next _3_Elite...");
                        GAME.nextScene(EVENT3);
                        break;
                    case 4:
                        System.out.println("Going to next _4_Norm...");
                        GAME.nextScene(EVENT4);
                        break;
                    case 5:
                        System.out.println("Going to next _5_Norm...");
                        GAME.nextScene(EVENT5);
                        break;
                    case 6:
                        System.out.println("Going to next _6_Choose...");
                        GAME.nextScene(EVENT6);
                        break;
                    case 7:
                        System.out.println("Going to next _7_Rest...");
                        GAME.nextScene(EVENT7);
                        break;
                    case 8:
                        System.out.println("Going to next _8_Boss...");
                        GAME.nextScene(EVENT8);
                        break;
                }
                break;
            default:
                System.out.println("Invalid input: " + input);
                break;
        }

    }
}
