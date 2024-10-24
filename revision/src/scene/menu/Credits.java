package scene.menu;

import game.Game;
import scene.Scene;

import static game.WhichScene.MENU;

public class Credits extends Scene {

    public Credits(Game GAME){
        super(GAME);
    }

    @Override
    protected String displayText_Display() {
        return "The Entity\n" +
                "\n" +
                "Developed by:\n" +
                "> John Winston W. Tabada\n" +
                "> Aaron Rey A. Jacalan\n" +
                "> Lovely Shane P. Ong\n" +
                "> Ruhmer Jairus Espina\n" +
                "\n" +
                "> BACK";
    }

    protected String displayText_Choice() {
        return "Press ENTER or type the command.";
    }


    public void onInputReceived(String input) {
        switch (input.toLowerCase()) {
            case "back":
            case "":
                System.out.println("Going back to menu...");
                GAME.nextScene(MENU);
                break;
            default:
                System.out.println("Invalid input: " + input);
                break;
        }
    }
}
