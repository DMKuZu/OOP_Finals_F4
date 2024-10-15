package game;

import java.util.List;

public class Command_Runner implements List_of_Commands{
    private Input_Processor input = new Input_Processor();
    private Prompt_Display prompt = new Prompt_Display();
    private int cmdIndex = -1;                                      ////mao ning index para sa list of commands
    /// 0 - start menu commands
    /// 1 - characters
    /// 2 - exit a choice command


    public void startMenu(){
        prompt.startMenu();
        cmdIndex = input.getInput(0);

        if(cmdIndex != -1){  //just to make sure that i am not accessing incorrectly
            callCommand(0);
        }
    }

    private void callCommand(int masterIndex){
        List<String> cmdList = master.get(masterIndex);
        String cmd = cmdList.get(cmdIndex);

        if (masterIndex == 0) {
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
    }

    private void start(){
        prompt.introPrompt();
        cmdIndex = input.getInput(1);

    }

    private void atlas(){
        prompt.atlas();
        cmdIndex = input.getInput(2);

        if(cmdIndex != -1){ //just to make sure that i am not accessing incorrectly
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
        cmdIndex = input.getInput(2);

        if(cmdIndex != -1){ //just to make sure that i am not accessing incorrectly
            startMenu();
        }
    }

    private void exit(){
        prompt.exit();
    }




}