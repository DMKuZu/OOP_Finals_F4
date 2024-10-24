package gui.panel;


import javax.swing.*;
import java.awt.*;


public abstract class Panel extends JPanel {

    public Panel(){
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.white));
        this.setBackground(Color.black);
    }

}
