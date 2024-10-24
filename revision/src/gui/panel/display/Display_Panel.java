package gui.panel.display;

import javax.swing.*;
import java.awt.*;

public class Display_Panel extends Display {
    private JScrollPane scroll;

    public Display_Panel(GridBagConstraints gbc){
        super();

        scroll = new JScrollPane(display);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        gbc.gridx = 1; // Column 0
        gbc.gridy = 0; // Row 0
        gbc.gridwidth = 1; // Span 1 column
        gbc.gridheight = 1; // Span 1 row
        gbc.weightx = 0.7; // Take more horizontal space
        gbc.weighty = 1; // Take equal vertical space
        gbc.fill = GridBagConstraints.BOTH; // Fill both horizontal and vertical space
        gbc.insets = new Insets(10,10,10,10);

        display.setFont(new Font("MV Boli", Font.PLAIN, 30));
        display.setForeground(new Color(0xEBC300));
        setPreferredSize(new Dimension(500,0));
        setLayout(new GridBagLayout());
        add(scroll, gbc);
    }

    // Method to append text to the display
    public void displayText(String text) {
        display.setText(text);
        display.setCaretPosition(0);
    }

}
