import javax.swing.*;
import java.awt.*;

public class successForm extends JFrame {
    private JPanel mainPanel;
    private JLabel successLabel;
    private JButton closeButton;
    private JButton backButton;

    public successForm(JFrame previousFrame) {
        // Initialize components
        mainPanel = new JPanel(new BorderLayout(10, 10));
        successLabel = new JLabel("Enrollment Successful!", SwingConstants.CENTER);
        closeButton = new JButton("Close Application");
        backButton = new JButton("Back to Courses");

        // Set up the UI
        setTitle("Enrollment Successful");
        setSize(400, 300);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        successLabel.setFont(new Font("Arial", Font.BOLD, 18));


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(backButton);
        buttonPanel.add(closeButton);


        mainPanel.add(successLabel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        closeButton.addActionListener(e -> System.exit(0));

        backButton.addActionListener(e -> {
            previousFrame.setVisible(true);
            this.dispose();
        });
    }
}