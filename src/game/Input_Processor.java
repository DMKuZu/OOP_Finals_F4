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
                System.out.println("||--------------------------------------------------------------------------||");
                System.out.flush();

                switch (from){
                    case "start menu":
                        if(STARTMENU.containsKey(input)) return STARTMENU.get(input);
                        else continue;
                    case "choose hero":
                        if(CHOOSEHERO.containsKey(input)) return CHOOSEHERO.get(input);
                        else continue;
                    case "press to continue":
                        if(PRESS.containsKey(input)) return PRESS.get(input);
                        else continue;
                    case "trance":
                        if(TRANCE.containsKey(input)) return TRANCE.get(input);
                        else continue;
                    case "battle":
                        if(BATTLE.containsKey(input)) return BATTLE.get(input);
                        else continue;
                    case "choose skill":
                        if(CHOOSESKILL.containsKey(input)) return CHOOSESKILL.get(input);
                        else continue;
                    case "choose favor":
                        if(CHOOSEFAVOR.containsKey(input)) return CHOOSEFAVOR.get(input);
                        else continue;
                    case "norm or elite":
                        if(FORK.containsKey(input)) return FORK.get(input);
                        else continue;
                }
            }
            catch (IOException e) {
                System.out.println("An error occurred while reading input. Please try again.");
            }
        }
    }
}

