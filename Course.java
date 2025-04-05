import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Course extends JFrame {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField mobileField;
    private JTextField emailField;
    private JButton submitButton;
    private JTextField stateField;
    private JTextField dobField;
    private JPanel mainPanel;
    private JButton clearButton;

    public Course() {
        setTitle("Registration Form");
        setSize(500, 500);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateAndSubmit()) {
                    wa courseForm = new wa(Course.this);
                    courseForm.setVisible(true);
                    setVisible(false);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }

    private boolean validateAndSubmit() {
        String name = nameField.getText().trim();
        String age = ageField.getText().trim();
        String mobile = mobileField.getText().trim();
        String state = stateField.getText().trim();
        String email = emailField.getText().trim();
        String dob = dobField.getText().trim();

        if (name.isEmpty()) {
            showError("Please enter your name", nameField);
            return false;
        } else if (age.isEmpty() || !age.matches("\\d+")) {
            showError("Please enter a valid age", ageField);
            return false;
        } else if (mobile.isEmpty() || !mobile.matches("\\d{11}")) {
            showError("Please enter a valid 11-digit mobile number", mobileField);
            return false;
        } else if (email.isEmpty() || !email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            showError("Please enter a valid email address", emailField);
            return false;
        } else if (dob.isEmpty()) {
            showError("Please enter your date of birth", dobField);
            return false;
        }

        String message = String.format(
                "Registration Successful!\n\nName: %s\nAge: %s\nMobile: %s\nState: %s\nEmail: %s\nDOB: %s",
                name, age, mobile, state, email, dob
        );

        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    private void showError(String message, JTextField field) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        field.requestFocus();
        field.selectAll();
    }

    private void clearFields() {
        nameField.setText("");
        ageField.setText("");
        mobileField.setText("");
        stateField.setText("");
        emailField.setText("");
        dobField.setText("");
        nameField.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Course().setVisible(true);
            }
        });
    }
}