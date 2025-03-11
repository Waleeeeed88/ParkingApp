package InterfaceGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// public class UserLogin {

//     public static void main(String[] args) {
//         // Create JFrame
//         JFrame frame = new JFrame("Login Page");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setSize(300, 200);
//         frame.setLayout(new GridLayout(3, 2));

//         // Username Label and Field
//         JLabel userLabel = new JLabel("Username:");
//         JTextField userField = new JTextField();
        
//         // Password Label and Field
//         JLabel passLabel = new JLabel("Password:");
//         JPasswordField passField = new JPasswordField();
        
//         // Login Button
//         JButton loginButton = new JButton("Login");

//         // Action Listener for Login
//         loginButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 String username = userField.getText();
//                 String password = new String(passField.getPassword());

//                 if (username.equals("admin") && password.equals("password")) {
//                     JOptionPane.showMessageDialog(frame, "Login Successful!");
//                 } else {
//                     JOptionPane.showMessageDialog(frame, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
//                 }
//             }
//         });

//         // Add Components to Frame
//         frame.add(userLabel);
//         frame.add(userField);
//         frame.add(passLabel);
//         frame.add(passField);
//         frame.add(new JLabel()); // Empty space for layout
//         frame.add(loginButton);

//         // Set Frame Visibility
//         frame.setVisible(true);
//     }
    
// }

public class UserLogin {

    public UserLogin() {
        JFrame frame = new JFrame("Admin Login Selection");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200); // Increased size for the extra button
        frame.setLayout(new GridLayout(2, 2)); // Using GridLayout for button arrangement

        JButton managerButton = new JButton("Manager");
        JButton superManagerButton = new JButton("Super Manager");
        JButton notAdminButton = new JButton("Not an Admin");

        managerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminLogin("Manager");
                frame.dispose();
            }
        });

        superManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminLogin("Super Manager");
                frame.dispose();
            }
        });

        notAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showUserTypeSelection(frame); // Show user type selection
            }
        });

        frame.add(managerButton);
        frame.add(superManagerButton);
        frame.add(new JLabel()); // Empty label for spacing
        frame.add(notAdminButton);

        frame.setVisible(true);
    }

    // Method to show user type selection
    private void showUserTypeSelection(JFrame previousFrame) {
        previousFrame.dispose(); // Close the previous frame

        JFrame frame = new JFrame("User Type Selection");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(2, 2));

        JButton facultyButton = new JButton("Faculty");
        JButton nonFacultyButton = new JButton("Non-Faculty");
        JButton studentButton = new JButton("Student");
        JButton visitorButton = new JButton("Visitor");

        facultyButton.addActionListener(e -> showRegistrationLogin(frame, "Faculty"));
        nonFacultyButton.addActionListener(e -> showRegistrationLogin(frame, "Non-Faculty"));
        studentButton.addActionListener(e -> showRegistrationLogin(frame, "Student"));
        visitorButton.addActionListener(e -> showRegistrationLogin(frame, "Visitor"));

        frame.add(facultyButton);
        frame.add(nonFacultyButton);
        frame.add(studentButton);
        frame.add(visitorButton);

        frame.setVisible(true);
    }

    private void showRegistrationLogin(JFrame previousFrame, String userType) {
        previousFrame.dispose();

        JFrame frame = new JFrame(userType + " - Registration/Login");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");

        // Action Listener for Login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                // We have to replace this with our actual login logic using a db!!! THIS LOGIC BELOW IS JUST A TEST PLACEHOLDER FOR FRONTEND
                //We actually have to implement user authentication and whether login is successful or not here using a database
                /* To be implemented below:
                    1) Retrieving the stored username and password for the entered username from your database or wherever you store user data.
                    2) Comparing the entered password with the stored password.
                    3) If the credentials match, you might need to perform additional checks (e.g. if the account active?).
                    4) Finally, you need to provide feedback to the user (e.g. "Login successful" or "Invalid credentials").
                */
                if (username.equals("TESTUSERNAME") && password.equals("PASSWORD")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action Listener for Registration
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                //We have to replace this with our actual login logic using a db!!! THIS LOGIC BELOW IS JUST A TEST PLACEHOLDER FOR the FRONTEND
                //We actually have to perform user registration into the database here 

                /*To be implemented below: 
                    1) Validating the entered data (e.g. checking for valid email format, password complexity).
                    2) Creating a new user account in your database or user storage system.
                    3) Possibly sending a confirmation email or performing other account activation steps.
                    4) Providing feedback to the user (e.g., "Registration successful" or "Registration failed").
                */
                JOptionPane.showMessageDialog(frame, userType + " registration logic goes here.");
            }
        });

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(registerButton);
        frame.add(loginButton);

        frame.setVisible(true);
    }
}