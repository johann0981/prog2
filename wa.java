import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class wa extends JFrame {
    private JTextField p1;
    private JTextField p2;
    private JTextField p3;
    private JButton submitButton;
    private JButton backButton;
    private JPanel main;
    private Course registrationForm;

    public wa(Course registrationForm) {
        this.registrationForm = registrationForm;

        setTitle("Available Courses");
        setContentPane(main);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        main.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        // Add title
        JLabel titleLabel = new JLabel("Select Your Course Preferences");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        main.add(titleLabel);

        main.add(Box.createRigidArea(new Dimension(10, 10)));

        // Add course list
        String[] courses = {
                "1. Computer Science",
                "2. Electrical Engineering",
                "3. Mechanical Engineering",
                "4. Business Administration",
                "5. Medicine"
        };

        for (String course : courses) {
            JLabel courseLabel = new JLabel(course);
            courseLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            main.add(courseLabel);
        }

        // Add preference fields
        main.add(Box.createRigidArea(new Dimension(20, 20)));
        addPreferenceField("First Preference (Enter course number):", p1);
        addPreferenceField("Second Preference (Enter course number):", p2);
        addPreferenceField("Third Preference (Enter course number):", p3);

        // Add back button
        backButton = new JButton("Back to Registration");
        backButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        backButton.addActionListener(e -> {
            registrationForm.setVisible(true);
            dispose();
        });
        main.add(Box.createRigidArea(new Dimension(20, 20)));
        main.add(backButton);

        // Submit button
        main.add(Box.createRigidArea(new Dimension(20, 20)));
        submitButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                successForm SuccessForm  = new successForm(wa.this);
                SuccessForm.setVisible(true);
                setVisible(false);
                String text1 = p1.getText().trim();
                String text2 = p2.getText().trim();
                String text3 = p3.getText().trim();

                if (text1.isEmpty() || text2.isEmpty() || text3.isEmpty()) {
                    JOptionPane.showMessageDialog(wa.this,
                            "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!text1.matches("[1-5]") || !text2.matches("[1-5]") || !text3.matches("[1-5]")) {
                    JOptionPane.showMessageDialog(wa.this,
                            "Please enter valid course numbers (1-5).", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    successForm successForm = new successForm(wa.this);
                    successForm.setVisible(true);
                    setVisible(false);
                }
            }
        });
    }

    private void addPreferenceField(String labelText, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        main.add(label);

        textField.setAlignmentX(Component.LEFT_ALIGNMENT);
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height));
        main.add(textField);
        main.add(Box.createRigidArea(new Dimension(10, 10)));
    }
}