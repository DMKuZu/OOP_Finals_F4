package game;

import elements.*;

import java.util.List;

public class Command_Runner implements List_of_Commands{
    private Input_Processor input = new Input_Processor();
    private Prompt_Display prompt = new Prompt_Display();
    private int cmdIndex = -1;                                      ////mao ning index para sa list sa sulod sa master List
    private Chosen_Hero hero;

    public void startMenu(){
        prompt.startMenu();
        cmdIndex = input.getInput(1);

        if(cmdIndex != -1){  ///should go to start menu
            callCommand(1);
        }
    }

    private void callCommand(int listIndex){
        List<String> cmdList = master.get(listIndex);
        String cmd = cmdList.get(cmdIndex);
        /// masterIndex
        /// 0 - exit a choice command
        /// 1 - start menu commands
        /// 2 - characters
        /// 3 - battle commands
        /// 4 - skills commands
        /// 5 - potions commands

        if (listIndex == 1) { /// start menu
            switch(cmd){
                case "start":
                    start();
                    break;
                case "atlas":
                    atlas();
                    break;
                /*case "help":
                    help();
                    break;*/
                case "credits":
                    credits();
                    break;
                case "exit":
                    exit();
                    break;
            }
        }
        else if(listIndex == 2){ /// character selection
            // change the battle() to choose_area()
            switch(cmd){
                case "radea":
                    hero = new Radea();
                    battle();
                    break;
                case "mazupe":
                    hero = new Mazupe();
                    battle();
                    break;
                case "zipau":
                    hero = new Zipau();
                    battle();
                    break;
            }
        }
        else if(listIndex == 3){  /// battle choice
            switch(cmd){
                case "skills":
                    skills();
                    break;
                case "potions":
                    potions();
                    break;
                case "flee":
                    flee();
                    break;
            }
        }
        else if(listIndex == 4){ /// skills choice
            ////paghimo sa current_enemy class ug mga class sa enemies
            switch(cmd){
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "back":

                    break;
            }
        }
        else if(listIndex == 5){ /// potions choice
            switch(cmd){
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "back":

                    break;
            }
        }
    }

//start commands
//************************************************************************************************************************************************************************************************
    private void start(){
        prompt.introPrompt();
        cmdIndex = input.getInput(2);

        if(cmdIndex != -1){ /// goes to character selection
            callCommand(2);
        }
    }

    private void atlas(){
        prompt.atlas();
        cmdIndex = input.getInput(0);

        if(cmdIndex != -1){ /// goes back to start menu
            startMenu();
        }
    }

    /*private void help(){                    ///figure out a way to be able to call help() in any part of the game and go back to the previous function call
        prompt.help();
        cmdIndex = input.getInput(2);

        if(cmdIndex != -1){ //just to make sure that i am not accessing incorrectly
            startMenu();
        }
    }*/

    private void credits(){
        prompt.credits();
        cmdIndex = input.getInput(0);

        if(cmdIndex != -1){ /// goes back to start menu
            startMenu();
        }
    }

    private void exit(){ /// should end the game
        prompt.exit();
    }

//choose area commands
//***********************************************************************************************************************************************************************************************
    private void choose_area(){
        //prompt
    }

//Battle commands
//************************************************************************************************************************************************************************************************
    private void battle(){
        prompt.encounter_battle_choice("Saroian hoe",69, hero.getNAME(), hero.getHP(), hero.getMANA());
        cmdIndex = input.getInput(3);

        if(cmdIndex != -1){ /// goes to battle
            callCommand(3);
        }
    }

    private void skills(){
        prompt.encounter_battle_skills("Saroian hoe",69, hero.getNAME(), hero.getHP(), hero.getMANA(),"slash","block","whip","shoot","dash");
        cmdIndex = input.getInput(4);

        if(cmdIndex != -1){ /// goes to choose skills
            callCommand(4);
        }
    }

    private void potions(){
        prompt.encounter_battle_potions("Saroian hoe",69, hero.getNAME(), hero.getHP(), hero.getMANA(),"helaing galing","mana padako","pagahi");
        cmdIndex = input.getInput(5);

        if(cmdIndex != -1){ /// goes to choose potions
            callCommand(5);
        }
    }

    private void flee(){
        prompt.encounter_battle_flee("Saroian hoe",69, hero.getNAME(), hero.getHP(), hero.getMANA());
        cmdIndex = input.getInput(0);

        if(cmdIndex != -1){ /// just shows a prompt and should go to choose menu
            ///create a choose menu method
        }
    }




}