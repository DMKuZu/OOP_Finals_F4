package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input_Processor implements List_of_Commands{
    private String input;
    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    protected String getInput(String from) {
        while (true) {
            try {
                System.out.print("\r|| >>> ");
                input = in.readLine().toLowerCase();

                switch (from){
                    case "start menu":
                        if(STARTMENU.containsKey(input)){
                            System.out.println("||--------------------------------------------------------------------------||");
                            System.out.flush();
                            return STARTMENU.get(input);
                        }
                        break;
                    case "choose hero":
                        if(CHOOSEHERO.containsKey(input)){
                            System.out.println("||--------------------------------------------------------------------------||");
                            System.out.flush();
                            return CHOOSEHERO.get(input);
                        }
                        break;
                    case "press to continue":
                        if(PRESS.containsKey(input)){
                            System.out.println("||--------------------------------------------------------------------------||");
                            System.out.flush();
                            return PRESS.get(input);
                        }
                        break;
                    case "trance":
                        if(TRANCE.containsKey(input)){
                            System.out.println("||--------------------------------------------------------------------------||");
                            System.out.flush();
                            return TRANCE.get(input);
                        }
                        break;
                    case "battle":
                        if(BATTLE.containsKey(input)){
                            System.out.println("||--------------------------------------------------------------------------||");
                            System.out.flush();
                            return BATTLE.get(input);
                        }
                        break;
                    case "choose skill":
                        if(CHOOSESKILL.containsKey(input)){
                            System.out.println("||--------------------------------------------------------------------------||");
                            System.out.flush();
                            return CHOOSESKILL.get(input);
                        }
                        break;
                    case "choose favor":
                        if(CHOOSEFAVOR.containsKey(input)){
                            System.out.println("||--------------------------------------------------------------------------||");
                            System.out.flush();
                            return CHOOSEFAVOR.get(input);
                        }
                        break;
                }
            }
            catch (IOException e) {
                System.out.println("An error occurred while reading input. Please try again.");
            }
        }
    }
}

