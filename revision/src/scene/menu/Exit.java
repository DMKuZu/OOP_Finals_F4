package scene.menu;

import game.Game;
import scene.Scene;

import javax.swing.*;


public class Exit extends Scene {

    public Exit(Game GAME){
        super(GAME);
        int result = JOptionPane.showOptionDialog(
                null,
                "Are you sure you want to exit?",
                "The Entity",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                0
        );
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0); // Exit the program
        }
    }

}
