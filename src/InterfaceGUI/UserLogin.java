package InterfaceGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLogin {

    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("Login Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 2));

        // Username Label and Field
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        
        // Password Label and Field
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        
        // Login Button
        JButton loginButton = new JButton("Login");

        // Action Listener for Login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add Components to Frame
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(new JLabel()); // Empty space for layout
        frame.add(loginButton);

        // Set Frame Visibility
        frame.setVisible(true);
    }
    
}
