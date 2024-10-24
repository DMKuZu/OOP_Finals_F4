package gui;

import gui.panel.display.Choice_Panel;
import gui.panel.display.Display;
import gui.panel.display.Display_Panel;
import gui.panel.input.Input_Panel;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Frame extends JFrame {
    private Display DISPLAY;
    private Display CHOICE;
    private Input_Panel INPUT;

    public Frame(){
        this.setTitle("The Entity");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setMinimumSize(new Dimension(2000,1000));
        this.setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();

        DISPLAY = new Display_Panel(gbc);
        this.add(DISPLAY,gbc);

        CHOICE = new Choice_Panel(gbc);
        this.add(CHOICE,gbc);

        INPUT = new Input_Panel(gbc);
        this.add(INPUT,gbc);

        this.getContentPane().setBackground(new Color(0x511C88));
        this.setVisible(true);
    }

    public Display getDISPLAY() {
        return DISPLAY;
    }
    public Display getCHOICE() {
        return CHOICE;
    }
    public Input_Panel getINPUT() {
        return INPUT;
    }
}
