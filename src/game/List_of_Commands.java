package game;

import java.util.Arrays;
import java.util.List;

public interface List_of_Commands {
    List<String> exit = Arrays.asList("","exit");
    List<String> start_commands = Arrays.asList("start", "atlas", "exit",/*"help",*/"credits","exit");
    List<String> characters = Arrays.asList("radea", "mazupe", "zipau","superidolsirkhai");
    List<String> battle_commands = Arrays.asList("skills","potions","flee");
    List<String> skills_commands = Arrays.asList("1","2","3","4","5","back");
    List<String> potions_commands = Arrays.asList("1","2","3","back");


    List<List<String>> master = Arrays.asList(exit,start_commands,characters,battle_commands,skills_commands,potions_commands);

    /* private volatile boolean skipDelay = false;
    private void introPrompt() {
        nextPrompt();
        startInputThread(); // Start thread to allow skipping the delay
        try {
            printWithDelay("|| Since the beginning of time, the land of Erotoma was created", 50);
            printWithDelay("|| by the grace of The Beings. The Beings created a land full of", 50);
            printWithDelay("|| diversity. Creatures were created in the likeness of The Beings.", 50);
            printWithDelay("|| As time passed, these creatures have evolved and had started");
            printWithDelay("|| naming themselves and creating factions based on which of The");
            printWithDelay("|| Beings had created them. Thus, Erotoma was split into 3.");
            printWithDelay("|| The Saroia, The Quacero, and The Azrue. Each having their own");
            printWithDelay("|| cultures but all share the same language.");
            printWithDelay("||");
            printWithDelay("|| As the factions grew, so did their ideals. The difference of");
            printWithDelay("|| their ideals were enough to cause a war amongst the 3 factions.");
            printWithDelay("|| What seemed to be a war that would last forever was abruptly");
            printWithDelay("|| ended due to the birth of The Entity. If it wasn't for the");
            printWithDelay("|| legends being passed down from generations, the existence of");
            printWithDelay("|| The Entity would be long forgotten. The Entity was a being of");
            printWithDelay("|| pure chaos. It had almost wiped out the 3 factions... until");
            printWithDelay("|| The Beings intervened. It was the first time and the last time");
            printWithDelay("|| that the factions ever saw The Beings. As right after The Beings");
            printWithDelay("|| fought The Entity, they all vanished to the far horizon where");
            printWithDelay("|| none of the Factions could see. After the disappearance of");
            printWithDelay("|| The Beings and The Entity, the 3 factions decided to make peace");
            printWithDelay("|| and unite to rebuild for a better civilization.");
            printWithDelay("||");
            printWithDelay("|| Fast forward to the current era. In the center of Erotoma lies");
            printWithDelay("|| the heart of the 3 factions. A city of diversity, Azsaroqua.");
            printWithDelay("|| A city where Saroians, Quaceron, and Azrueians gather to share");
            printWithDelay("|| their culture and traditions.");
            printWithDelay("||");
            printWithDelay("|| In this city, 3 friends with different cultures share the same");
            printWithDelay("|| outlook in life, to search for the whereabouts of The Beings.");
            printWithDelay("||");
            printWithDelay("|| The 3 embark on a quest after hearing about a rumour of a sudden");
            printWithDelay("|| appearance of a small island in the far outskirts of Erotoma");
            printWithDelay("|| containing what seems to be a temple.");
            printWithDelay("||");
            printWithDelay("|| Choose your character:", 50);
            printWithDelay("||", 50);
            printWithDelay("|| > Radea", 50);
            printWithDelay("|| > Mazupe", 50);
            printWithDelay("|| > Zipau", 50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        process.chooseCharacter();
    }

    private void printWithDelay(String message, int delay) throws InterruptedException {
        for (int i = 0; i < message.length(); i++) {
            if (skipDelay) {
                System.out.print(message.substring(i));
                break;
            }
            System.out.print(message.charAt(i));
            Thread.sleep(delay); // Introduce delay between characters
        }
        System.out.println(); // Move to the next line after printing the message
    }

    private void startInputThread() {
        Thread inputThread = new Thread(() -> {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                reader.readLine(); // Wait for the user to press Enter
                skipDelay = true;  // Set the flag to skip the delay
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        inputThread.start(); // Start the thread to listen for input
    }*/
}