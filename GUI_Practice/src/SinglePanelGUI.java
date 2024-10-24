import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class SinglePanelGUI extends JFrame {
    private JTextField inputField;
    private JLabel displayLabel;
    private JPanel mainPanel;

    public SinglePanelGUI() {
        // Initialize components
        inputField = new JTextField(20);
        displayLabel = new JLabel("Enter text below and press Enter", SwingConstants.CENTER);

        // Customize label appearance
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        displayLabel.setPreferredSize(new Dimension(400, 100));

        // Add a border to the label to make it look like a box
        Border boxBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
        displayLabel.setBorder(boxBorder);

        // Initialize panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Add components to panel
        mainPanel.add(displayLabel, BorderLayout.CENTER);
        mainPanel.add(inputField, BorderLayout.SOUTH);

        // Add action listener for the input field
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = inputField.getText(); // Get user input
                displayLabel.setText("You entered: " + userInput); // Update the display label
                inputField.setText(""); // Clear the input field
            }
        });

        // Add panel to frame
        add(mainPanel);

        // Set frame properties
        setTitle("Single Panel GUI");
        setSize(400, 200);
        setLocationRelativeTo(null); // Center the GUI on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SinglePanelGUI();
    }
}
