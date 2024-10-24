package gui.panel.display;

import java.awt.*;

public class Choice_Panel extends Display{


    public Choice_Panel(GridBagConstraints gbc){
        super();

        gbc.gridx = 0; // Column 1
        gbc.gridy = 0; // Row 0
        gbc.gridwidth = 1; // Span 1 column
        gbc.gridheight = 2; // Span 2 row
        gbc.weightx = 0.3; // Take less horizontal space
        gbc.weighty = 1; // Take equal vertical space
        gbc.fill = GridBagConstraints.BOTH; // Fill both horizontal and vertical space
        gbc.insets = new Insets(10,10,10,10);

        setPreferredSize(new Dimension(250,0));
        display.setFont(new Font("MV Boli", Font.PLAIN, 20));
        display.setForeground(new Color(0x34FF59));
    }

    // Method to append text to the display
    public void displayText(String text) {
        display.setText(text);
    }

}
