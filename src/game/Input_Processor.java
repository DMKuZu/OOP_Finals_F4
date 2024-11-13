package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input_Processor implements List_of_Commands{
    private String input;
    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    protected String getInput(String from) {
        String ret = "";

        while (true) {
            try {
                System.out.print("\r|| >>> ");
                input = in.readLine().toLowerCase();
                System.out.println("||--------------------------------------------------------------------------||");
                System.out.flush();

                switch (from){
                    case "start menu":
                        if(STARTMENU.containsKey(input)) ret = STARTMENU.get(input);
                        else continue;
                        break;
                    case "choose hero":
                        if(CHOOSEHERO.containsKey(input)) ret = CHOOSEHERO.get(input);
                        else continue;
                        break;
                    case "trance":
                        if(TRANCE.containsKey(input)) ret = TRANCE.get(input);
                        else continue;
                        break;
                    case "battle":
                        if(BATTLE.containsKey(input)) ret = BATTLE.get(input);
                        else continue;
                        break;
                    case "choose skill":
                        if(CHOOSESKILL.containsKey(input)) ret = CHOOSESKILL.get(input);
                        else continue;
                        break;
                    case "choose favor":
                        if(CHOOSEFAVOR.containsKey(input)) ret = CHOOSEFAVOR.get(input);
                        else continue;
                        break;
                    case "norm or elite":
                        if(FORK.containsKey(input)) ret = FORK.get(input);
                        else continue;
                        break;
                    case "press to continue":
                        ret = "";
                }

                return ret;
            }
            catch (IOException e) {
                System.out.println("|| An error occurred while reading input. Please try again.");
            }
        }
    }
}

