package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Input_Processor implements List_of_Commands{
    private String input;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public int getInput(int listIndex) {             ////should return the index of the command from the given index pointing to a list in the master
        while (true) {
            try {
                System.out.print("\r|| >>> ");
                input = in.readLine().toLowerCase();

                List<String> currList = master.get(listIndex);
                for(int i = 0; i < currList.size(); i++){
                    if(currList.get(i).equals(input)){
                        System.out.println("||--------------------------------------------------------------------------||");
                        return i;       ////mureturn ni sa index sa currlist para sa command_runner ra ka maglihok
                    }
                }

                System.out.flush();     ////will reset the input and keep asking for the input until sakto ang command
            }
            catch (IOException e) {
                System.out.println("An error occurred while reading input. Please try again.");
            }
        }
    }
}

