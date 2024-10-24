package gui.panel.display;

import gui.panel.Panel;

import javax.swing.*;
import java.awt.*;

public abstract class Display extends Panel {
    protected JTextArea display;
    
    public Display(){
        super();

        display = new JTextArea();
        display.setEditable(false);
        display.setBackground(Color.BLACK);
        display.setLineWrap(true);
        display.setWrapStyleWord(true);
        display.setMargin(new Insets(10, 10, 10, 10));

        add(display, BorderLayout.CENTER);
    }

    public abstract void displayText(String text);
}
