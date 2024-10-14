package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input_Taker {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private String input;

    public Input_Taker(String choice) throws IOException{
        if(choice.equals("start")){
            startChoice();
        }
    }
    private String startChoice() throws IOException {
        input = in.readLine();
        return input;
    }
}
