package com.parkingapp;

import javax.swing.*;
import java.awt.*;

/*public class WelcomePage extends JFrame {
    public WelcomePage() {
        setTitle("Welcome");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        JLabel welcomeLabel = new JLabel("Welcome to YorkU Parking Booking System", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.RED);
        panel.add(welcomeLabel, BorderLayout.NORTH);

        ImageIcon icon = new ImageIcon("/Users/bhavneetkaur/Desktop/car_parking.jpeg");
        JLabel imageLabel = new JLabel(icon, SwingConstants.CENTER);
        panel.add(imageLabel, BorderLayout.CENTER);

        add(panel);
        setVisible(true);

        // Timer instead of Thread.sleep()
     // Set a timer to close the splash screen and open the login page
        Timer timer = new Timer(5000, e -> {
            dispose();  // Close the splash screen
            SwingUtilities.invokeLater(() -> new UserLogin());  // Open the login page on the Event Dispatch Thread
        });
        timer.setRepeats(false);  // Ensure it runs only once
        timer.start();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WelcomePage());
    }
}
*/import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JFrame {
    
    public WelcomePage() {
        setTitle("Welcome");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // Load Image
        ImageIcon imageIcon = new ImageIcon("/Users/bhavneetkaur/Desktop/c.png"); // Replace with the correct path
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(imageLabel, BorderLayout.CENTER);

        // Create Welcome Label
        JLabel welcomeLabel = new JLabel("Welcome to YorkU Parking Booking System", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.RED);
        panel.add(welcomeLabel, BorderLayout.NORTH);

        // Add "Get Started" Button
        JButton getStartedButton = new JButton("Get Started");
        getStartedButton.setBackground(new Color(30, 144, 255)); // Blue color
        getStartedButton.setForeground(Color.WHITE);
        getStartedButton.setFont(new Font("Arial", Font.BOLD, 16));
        getStartedButton.setOpaque(true);
        getStartedButton.setBorderPainted(false);
        getStartedButton.addActionListener(e -> {
            dispose(); // Close the splash screen
            new UserLogin().createAndShowGUI(); // Open the login screen // Open the login page
        });

        // Add button at the bottom
      //  panel.add(getStartedButton, BorderLayout.SOUTH);

       // add(panel);
      //  setVisible(true);
       //new UserLogin().createAndShowGUI(); // Open the login screen
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(getStartedButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WelcomePage::new);
    }
}

