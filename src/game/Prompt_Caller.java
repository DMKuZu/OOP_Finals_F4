package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompt_Caller{
    private String input;
    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public void startMenu() throws IOException {
        System.out.println("|| The Entity");
        System.out.println("||");
        System.out.println("|| Type a command to continue...");
        System.out.println("||");
        System.out.println("|| > Start Game");
        System.out.println("|| > Encyclopedia");
        System.out.println("|| > Credits");
        System.out.println("|| > Exit");
        System.out.print("|| > ");
        input = in.readLine();
    }
}
