package com.parkingapp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingPage extends JFrame {

    private JComboBox<String> spaceSelector;
    private JTextField bookingDateField;
    private JTextField startTimeField;
    private JTextField endTimeField;
    private JTextArea bookingDetailsArea;
    private JButton bookButton, cancelButton, editButton, extendButton;

    private Map<String, Booking> bookings = new HashMap<>(); // Store bookings by space
    private List<String> availableSpaces = new ArrayList<>();


    public BookingPage() {
        setTitle("Parking Space Booking");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Important: Don't exit the whole app
        setSize(600, 450);
        setLocationRelativeTo(null); // Center the window

        // Initialize available spaces (replace with data loading from database/file)
        availableSpaces.add("Space A1");
        availableSpaces.add("Space A2");
        availableSpaces.add("Space B1");
        availableSpaces.add("Space B2");
        availableSpaces.add("Space C1");

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add padding

        // --- Input Panel (Top) ---
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Consistent spacing
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel spaceLabel = new JLabel("Select Space:");
        spaceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(spaceLabel, gbc);

        spaceSelector = new JComboBox<>(availableSpaces.toArray(new String[0]));
        spaceSelector.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Allow combo box to expand
        inputPanel.add(spaceSelector, gbc);

        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        dateLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;  // Reset weight
        inputPanel.add(dateLabel, gbc);

        bookingDateField = new JTextField(10);
        bookingDateField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        inputPanel.add(bookingDateField, gbc);

        JLabel startTimeLabel = new JLabel("Start Time (HH:MM):");
        startTimeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        inputPanel.add(startTimeLabel, gbc);

        startTimeField = new JTextField(5);
        startTimeField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        inputPanel.add(startTimeField, gbc);

        JLabel endTimeLabel = new JLabel("End Time (HH:MM):");
        endTimeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        inputPanel.add(endTimeLabel, gbc);

        endTimeField = new JTextField(5);
        endTimeField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        inputPanel.add(endTimeField, gbc);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // --- Booking Details Panel (Center) ---
        bookingDetailsArea = new JTextArea();
        bookingDetailsArea.setEditable(false); // Display-only
        bookingDetailsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(bookingDetailsArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // --- Button Panel (Bottom) ---
        JPanel buttonPanel = new JPanel(new FlowLayout());
        bookButton = new JButton("Book Space");
        bookButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelButton = new JButton("Cancel Booking");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        editButton = new JButton("Edit Booking");
        editButton.setFont(new Font("Arial", Font.BOLD, 14));
        extendButton = new JButton("Extend Booking");
        extendButton.setFont(new Font("Arial", Font.BOLD, 14));

        buttonPanel.add(bookButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(editButton);
        buttonPanel.add(extendButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // --- Action Listeners ---
        bookButton.addActionListener(e -> bookSpace());
        cancelButton.addActionListener(e -> cancelBooking());
        editButton.addActionListener(e -> editBooking());
        extendButton.addActionListener(e -> extendBooking());
        spaceSelector.addActionListener(e -> showBookingDetails()); //update booking details when space changes

        //Initial booking details update
        showBookingDetails();
        setVisible(true); // Make the frame visible
    }

    private void bookSpace() {
        String space = (String) spaceSelector.getSelectedItem();
        String date = bookingDateField.getText();
        String startTime = startTimeField.getText();
        String endTime = endTimeField.getText();

        // Input validation (basic checks)
        if (space == null || date.isEmpty() || startTime.isEmpty() || endTime.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate date and time formats (using a simple regex for demonstration)
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Use YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!startTime.matches("\\d{2}:\\d{2}") || !endTime.matches("\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Invalid time format. Use HH:MM.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check for booking conflicts
        if (bookings.containsKey(space)) {
            Booking existingBooking = bookings.get(space);
            if (existingBooking.getDate().equals(date)) { //same day
                //check times conflict.
                if (timeConflict(existingBooking.getStartTime(), existingBooking.getEndTime(), startTime, endTime)) {
                    JOptionPane.showMessageDialog(this, "Booking conflict. Space already booked for this time.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }

        // Create a new booking
        Booking newBooking = new Booking(space, date, startTime, endTime);
        bookings.put(space, newBooking);

        showBookingDetails();
        JOptionPane.showMessageDialog(this, "Booking successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        clearInputFields();
    }

    private boolean timeConflict(String start1, String end1, String start2, String end2) {
        // Convert times to minutes for easy comparison
        int start1Minutes = Integer.parseInt(start1.substring(0, 2)) * 60 + Integer.parseInt(start1.substring(3));
        int end1Minutes = Integer.parseInt(end1.substring(0, 2)) * 60 + Integer.parseInt(end1.substring(3));
        int start2Minutes = Integer.parseInt(start2.substring(0, 2)) * 60 + Integer.parseInt(start2.substring(3));
        int end2Minutes = Integer.parseInt(end2.substring(0, 2)) * 60 + Integer.parseInt(end2.substring(3));

        // Check for overlap
        return (start1Minutes < end2Minutes && end1Minutes > start2Minutes);

    }

    private void cancelBooking() {
        String selectedSpace = (String) spaceSelector.getSelectedItem();

        if (bookings.containsKey(selectedSpace)) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to cancel the booking for " + selectedSpace + "?",
                    "Confirm Cancellation",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                bookings.remove(selectedSpace);
                showBookingDetails();
                JOptionPane.showMessageDialog(this, "Booking cancelled!", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearInputFields();
            }
        } else {
            JOptionPane.showMessageDialog(this, "No booking found for the selected space.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editBooking() {
        String space = (String) spaceSelector.getSelectedItem();
        if (!bookings.containsKey(space)) {
            JOptionPane.showMessageDialog(this, "No booking to edit for " + space, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Booking currentBooking = bookings.get(space);

        // Pre-populate the input fields with the current booking details
        bookingDateField.setText(currentBooking.getDate());
        startTimeField.setText(currentBooking.getStartTime());
        endTimeField.setText(currentBooking.getEndTime());

        // Change the "Book Space" button to "Update Booking" temporarily
        bookButton.setText("Update Booking");
        bookButton.removeActionListener(bookButton.getActionListeners()[0]); // Remove the old listener
        bookButton.addActionListener(e -> updateBooking(space, currentBooking));  // Add an update listener

        //Disable other buttons
        cancelButton.setEnabled(false);
        editButton.setEnabled(false);
        extendButton.setEnabled(false);
        spaceSelector.setEnabled(false); // Don't allow changing the space during edit

    }

    private void updateBooking(String originalSpace, Booking oldBooking) {
        String space = (String) spaceSelector.getSelectedItem();
        String date = bookingDateField.getText();
        String startTime = startTimeField.getText();
        String endTime = endTimeField.getText();
        if (space == null || date.isEmpty() || startTime.isEmpty() || endTime.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Use YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!startTime.matches("\\d{2}:\\d{2}") || !endTime.matches("\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Invalid time format. Use HH:MM.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //check for conflict ONLY if date or time has changed
        if (!date.equals(oldBooking.getDate()) || !startTime.equals(oldBooking.getStartTime()) || !endTime.equals(oldBooking.getEndTime())) {

            if (bookings.containsKey(space)) {
                Booking existingBooking = bookings.get(space);
                if (!existingBooking.equals(oldBooking)) {//not conflicting with itself.

                    if (existingBooking.getDate().equals(date)) { //same day
                        //check times conflict.
                        if (timeConflict(existingBooking.getStartTime(), existingBooking.getEndTime(), startTime, endTime)) {
                            JOptionPane.showMessageDialog(this, "Booking conflict. Space already booked for this time.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                }

            }
        }

        // Update the booking
        oldBooking.setDate(date);
        oldBooking.setStartTime(startTime);
        oldBooking.setEndTime(endTime);
        bookings.put(space, oldBooking); //if the space has been changed, reflect this.

        showBookingDetails();
        JOptionPane.showMessageDialog(this, "Booking updated!", "Success", JOptionPane.INFORMATION_MESSAGE);


        // Restore the "Book Space" button and its original listener
        bookButton.setText("Book Space");
        bookButton.removeActionListener(bookButton.getActionListeners()[0]);
        bookButton.addActionListener(e -> bookSpace());
        // Re-enable buttons
        cancelButton.setEnabled(true);
        editButton.setEnabled(true);
        extendButton.setEnabled(true);
        spaceSelector.setEnabled(true);

        clearInputFields();

    }


    private void extendBooking() {
        String space = (String) spaceSelector.getSelectedItem();
        if (!bookings.containsKey(space)) {
            JOptionPane.showMessageDialog(this, "No booking to extend for " + space, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Booking currentBooking = bookings.get(space);

        // Prompt for the new end time
        String newEndTime = JOptionPane.showInputDialog(this, "Enter new end time (HH:MM):", currentBooking.getEndTime());

        if (newEndTime == null || newEndTime.isEmpty()) {
            return; // User cancelled or entered nothing
        }
        if (!newEndTime.matches("\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Invalid time format. Use HH:MM.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Check for time conflicts with the *extended* time.
        if (bookings.containsKey(space)) {
            Booking existingBooking = bookings.get(space); // Get the existing booking
            if (existingBooking.getDate().equals(currentBooking.getDate())) {  //same space and same day.
                if (timeConflict(existingBooking.getStartTime(), newEndTime, existingBooking.getStartTime(), existingBooking.getEndTime()) && !newEndTime.equals(currentBooking.getEndTime())) {
                    JOptionPane.showMessageDialog(this, "Booking conflict. Space already booked for this time.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        // Check if new end time is *before* the current start time
        if (timeConflict(newEndTime, newEndTime, currentBooking.getStartTime(), currentBooking.getStartTime())) {
            JOptionPane.showMessageDialog(this, "New end time cannot be before the start time.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        currentBooking.setEndTime(newEndTime);
        bookings.put(space, currentBooking); // Update the booking
        showBookingDetails();
        JOptionPane.showMessageDialog(this, "Booking extended!", "Success", JOptionPane.INFORMATION_MESSAGE);

    }


    private void showBookingDetails() {
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        if (selectedSpace != null) {
            if (bookings.containsKey(selectedSpace)) {
                Booking booking = bookings.get(selectedSpace);
                bookingDetailsArea.setText(booking.toString());
            } else {
                bookingDetailsArea.setText("No booking found for " + selectedSpace);
            }
        } else {
            bookingDetailsArea.setText(""); // Clear the area if no space is selected
        }
    }

    private void clearInputFields() {
        bookingDateField.setText("");
        startTimeField.setText("");
        endTimeField.setText("");
    }

    // Inner class to represent a booking
    private class Booking {
        private String space;
        private String date;
        private String startTime;
        private String endTime;

        public Booking(String space, String date, String startTime, String endTime) {
            this.space = space;
            this.date = date;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String getSpace() {
            return space;
        }

        public String getDate() {
            return date;
        }

        public String getStartTime() {
            return startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }


        @Override
        public String toString() {
            return "Booking Details:\n" +
                    "-------------------\n" +
                    "Space: " + space + "\n" +
                    "Date: " + date + "\n" +
                    "Start Time: " + startTime + "\n" +
                    "End Time: " + endTime + "\n";
        }
        // equals and hashCode are important for correct behavior of HashMap and other collections
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Booking booking = (Booking) o;

            if (!space.equals(booking.space)) return false;
            if (!date.equals(booking.date)) return false;
            if (!startTime.equals(booking.startTime)) return false;
            return endTime.equals(booking.endTime);
        }

        @Override
        public int hashCode() {
            int result = space.hashCode();
            result = 31 * result + date.hashCode();
            result = 31 * result + startTime.hashCode();
            result = 31 * result + endTime.hashCode();
            return result;
        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BookingPage());
    }
}
