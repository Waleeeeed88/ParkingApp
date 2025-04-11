package com.parkingapp.GUI;

import com.parkingapp.GUI.BookingPage; // Need reference to logic class

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

public class BookingPageGUI extends JFrame {

    // --- UI Components ---
    private JComboBox<String> lotSelector;
    private JComboBox<String> spaceSelector;
    private JTextField startTimeField;
    private JTextField endTimeField;
    private JComboBox<String> vehicleTypeSelector;
    private JTextField carBrandField;
    private JTextArea bookingDetailsArea;
    private JButton bookButton, cancelButton, editButton, extendButton, returnButton, viewBookingsButton, loadFundsButton;
    private JLabel userTypeLabel;
    private JLabel balanceLabel;
    private JTextField licensePlateField;
    private JLabel realTimeLabel;
    private JTable bookingsTable; // For the 'My Bookings' window
    private DefaultTableModel bookingsTableModel; // Model for the table

    // Reference to the logic handler class
    private BookingPage bookingLogicHandler;

    // Store the original book button action listener to swap during edit mode
    private ActionListener originalBookButtonActionListener;
    private String bookingIdBeingEdited = null; // Track if in edit mode

    // --- Constructor ---
    public BookingPageGUI(BookingPage logicHandler) {
        this.bookingLogicHandler = logicHandler;
        initializeFrame();
        initializeUI();
        startDateTimeUpdater();
        // Trigger initial data load via logic handler AFTER GUI is built
        if (bookingLogicHandler != null) {
            bookingLogicHandler.loadInitialUIData();
        }
        setVisible(true);
    }

    // --- Frame Initialization ---
    private void initializeFrame() {
        setTitle("Parking Space Booking");
        // Use DISPOSE_ON_CLOSE for secondary windows like this
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(850, 650);
        setLocationRelativeTo(null);
    }

    // --- UI Initialization ---
    private void initializeUI() {
        JPanel mainPanel = createMainPanel();
        JPanel headerPanel = createHeaderPanel();
        JPanel inputPanel = createInputPanel();
        JPanel buttonPanel = createButtonPanel();

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    // --- Panel Creation Methods ---
    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        return mainPanel;
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Booking Page");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        userTypeLabel = new JLabel("Type: Loading...");
        userTypeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        rightPanel.add(userTypeLabel);

        balanceLabel = new JLabel("Balance: Loading...");
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        rightPanel.add(balanceLabel);

        loadFundsButton = new JButton("Load Funds");
        loadFundsButton.setFont(new Font("Arial", Font.BOLD, 14));
        // Add listener inside addButtonListeners or here
        loadFundsButton.addActionListener(e -> showLoadFundsDialog());
        rightPanel.add(loadFundsButton);

        headerPanel.add(rightPanel, BorderLayout.EAST);
        return headerPanel;
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = createGridBagConstraints();

        lotSelector = new JComboBox<>();
        spaceSelector = new JComboBox<>();
        vehicleTypeSelector = createVehicleTypeSelector();
        startTimeField = new JTextField(5);
        endTimeField = new JTextField(5);
        carBrandField = new JTextField(10);
        licensePlateField = new JTextField(10);
        realTimeLabel = new JLabel("Loading time...");
        bookingDetailsArea = new JTextArea(10, 30);

        addLabelAndComponent(inputPanel, "Select Lot:", lotSelector, gbc, 0);
        addLabelAndComponent(inputPanel, "Select Space:", spaceSelector, gbc, 1);
        addLabelAndComponent(inputPanel, "Current Time:", realTimeLabel, gbc, 2);
        addLabelAndComponent(inputPanel, "Start Time (HH:MM):", startTimeField, gbc, 3);
        addLabelAndComponent(inputPanel, "End Time (HH:MM):", endTimeField, gbc, 4);

        // Timeline Button
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JButton timelineSelectButton = new JButton("Select Time via Timeline");
        timelineSelectButton.setFont(new Font("Arial", Font.BOLD, 14));
        timelineSelectButton.addActionListener(e -> openTimelineDialog());
        inputPanel.add(timelineSelectButton, gbc);
        gbc.gridwidth = 1; gbc.weightx = 0; // Reset

        addLabelAndComponent(inputPanel, "Vehicle Type:", vehicleTypeSelector, gbc, 6);
        addLabelAndComponent(inputPanel, "Car Brand:", carBrandField, gbc, 7);
        addLabelAndComponent(inputPanel, "License Plate:", licensePlateField, gbc, 8);

        // Booking Details Area
        bookingDetailsArea.setEditable(false);
        bookingDetailsArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(bookingDetailsArea);
        gbc.gridx = 0; gbc.gridy = 9; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.BOTH; gbc.weighty = 1.0;
        inputPanel.add(scrollPane, gbc);

        // Add ActionListeners for selectors here or in a separate method
        lotSelector.addActionListener(e -> {
            String selectedLot = (String) lotSelector.getSelectedItem();
            if (selectedLot != null && bookingLogicHandler != null) {
                bookingLogicHandler.loadSpacesForLot(selectedLot);
            }
            updateBookingDetailsArea("Select a space to see details."); // Clear details
        });
        spaceSelector.addActionListener(e -> {
            String selectedLot = (String) lotSelector.getSelectedItem();
            String selectedSpace = (String) spaceSelector.getSelectedItem();
            if (selectedLot != null && selectedSpace != null && bookingLogicHandler != null) {
                bookingLogicHandler.fetchAndDisplayBookingDetails(selectedLot, selectedSpace);
            } else {
                updateBookingDetailsArea("Select a space to see details.");
            }
        });

        return inputPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bookButton = new JButton("Book Space");
        cancelButton = new JButton("Cancel Booking");
        editButton = new JButton("Edit Booking");
        extendButton = new JButton("Extend Booking");
        viewBookingsButton = new JButton("View My Bookings");
        returnButton = new JButton("Logout"); // Changed label

        setButtonFonts(bookButton, cancelButton, editButton, extendButton, viewBookingsButton, returnButton);
        // Add listeners after buttons are created
        addButtonListeners();

        buttonPanel.add(bookButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(editButton);
        buttonPanel.add(extendButton);
        buttonPanel.add(viewBookingsButton);
        buttonPanel.add(returnButton);

        return buttonPanel;
    }

    // --- UI Helper Methods ---
    private GridBagConstraints createGridBagConstraints() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        return gbc;
    }

    private void addLabelAndComponent(JPanel panel, String labelText, JComponent component, GridBagConstraints gbc, int row) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0; gbc.gridwidth = 1;
        panel.add(label, gbc);

        component.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1; gbc.gridy = row; gbc.weightx = 1.0;
        panel.add(component, gbc);
    }

    private JComboBox<String> createVehicleTypeSelector() {
        String[] types = {"SUV", "Sedan", "Convertible", "Mini SUV", "Van", "Truck"};
        return new JComboBox<>(types);
    }

    private void setButtonFonts(JButton... buttons) {
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        for (JButton button : buttons) {
            button.setFont(buttonFont);
        }
    }

    // --- Event Listener Setup ---
    private void addButtonListeners() {

        // Store the default book action
        originalBookButtonActionListener = e -> handleBookOrUpdateAction(false); // false = not updating
        bookButton.addActionListener(originalBookButtonActionListener);

        cancelButton.addActionListener(e -> handleCancelAction());
        editButton.addActionListener(e -> handleEditAction());
        extendButton.addActionListener(e -> handleExtendAction());
        viewBookingsButton.addActionListener(e -> openMyBookingsWindow());
        returnButton.addActionListener(e -> handleLogoutAction());
    }

    // --- Action Handling Methods (Called by Listeners) ---

    private void handleBookOrUpdateAction(boolean isUpdate) {
        // Gather data (common for book and update)
        String lot = (String) lotSelector.getSelectedItem();
        String space = (String) spaceSelector.getSelectedItem();
        String startTime = startTimeField.getText().trim();
        String endTime = endTimeField.getText().trim();
        String vehicleType = (String) vehicleTypeSelector.getSelectedItem();
        String carBrand = carBrandField.getText().trim();
        String licensePlate = licensePlateField.getText().trim();

        // Basic UI Validation
        if (!validateInputFields(lot, space, startTime, endTime, vehicleType, carBrand, licensePlate)) {
            return; // Validation method shows error message
        }

        // Call appropriate logic handler method
        if (bookingLogicHandler != null) {
            if (isUpdate) {
                // Ensure bookingIdBeingEdited is set correctly when edit mode starts
                if (bookingIdBeingEdited != null) {
                    bookingLogicHandler.attemptUpdateBooking(bookingIdBeingEdited, lot, space, startTime, endTime, vehicleType, carBrand, licensePlate);
                } else {
                    showErrorMessage("Cannot update: No booking selected for editing.");
                    resetToBookingMode(); // Reset UI state if something went wrong
                }
            } else {
                bookingLogicHandler.attemptBooking(lot, space, startTime, endTime, vehicleType, carBrand, licensePlate);
            }
        }
    }

    private void handleCancelAction() {
        String lot = (String) lotSelector.getSelectedItem();
        String space = (String) spaceSelector.getSelectedItem();
        if (lot == null || space == null) {
            showErrorMessage("Please select a lot and space to cancel.");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to cancel the booking for " + lot + " - " + space + "?",
                "Confirm Cancellation", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION && bookingLogicHandler != null) {
            bookingLogicHandler.cancelBookingForSelectedSpace(lot, space);
        }
    }

    private void handleEditAction() {
        String lot = (String) lotSelector.getSelectedItem();
        String space = (String) spaceSelector.getSelectedItem();
        if (lot == null || space == null) {
            showErrorMessage("Please select a booking to edit.");
            return;
        }
        if (bookingLogicHandler != null) {
            // Logic handler fetches data and calls populateFieldsForEditing() on this GUI instance
            // It should also return the bookingId if found
            String bookingId = bookingLogicHandler.prepareEditing(lot, space);
            if (bookingId != null) {
                setEditMode(bookingId); // Set GUI into edit mode
            } else {
                // Error message shown by logic handler if booking not found/editable
            }
        }
    }

    private void handleExtendAction() {
        String lot = (String) lotSelector.getSelectedItem();
        String space = (String) spaceSelector.getSelectedItem();
        if (lot == null || space == null) {
            showErrorMessage("Please select a booking to extend.");
            return;
        }

        // Get current end time from logic handler to prepopulate dialog
        String currentEndTime = (bookingLogicHandler != null) ? bookingLogicHandler.getCurrentEndTimeForBooking(lot, space) : null;
        if (currentEndTime == null) {
            showErrorMessage("Could not find current booking to extend.");
            return;
        }

        String newEndTime = JOptionPane.showInputDialog(this, "Enter new end time (HH:MM):", currentEndTime);
        if (newEndTime != null && !newEndTime.trim().isEmpty()) {
            if (!isValidTimeFormat(newEndTime)) {
                showErrorMessage("Invalid time format. Use HH:MM.");
                return;
            }
            if (bookingLogicHandler != null) {
                bookingLogicHandler.attemptExtendBooking(lot, space, newEndTime);
            }
        }
    }

    private void handleLogoutAction() {
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to logout?",
                "Confirm Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION && bookingLogicHandler != null) {
            bookingLogicHandler.handleLogoutOrReturn();
            this.dispose(); // Close the booking window
        }
    }

    // --- Input Validation ---
    private boolean validateInputFields(String lot, String space, String startTime, String endTime, String vehicleType, String carBrand, String licensePlate) {
        if (lot == null || space == null || startTime.isEmpty() || endTime.isEmpty() || licensePlate.isEmpty() || vehicleType == null || carBrand.isEmpty()) {
            showErrorMessage("Please fill in all booking fields.");
            return false;
        }
        if (!isValidTimeFormat(startTime) || !isValidTimeFormat(endTime)) {
            showErrorMessage("Invalid time format. Use HH:MM.");
            return false;
        }
        // Basic license plate format check
        if (!licensePlate.matches("^[A-Za-z0-9 -]+$")) {
            showErrorMessage("Invalid license plate format (use letters, numbers, spaces, hyphens).");
            return false;
        }
        return true;
    }

    private boolean isValidTimeFormat(String time) {
        if (time == null) return false;
        try {
            LocalTime.parse(time.trim(), DateTimeFormatter.ofPattern("HH:mm"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // --- Methods to Update GUI (Called by Logic Handler) ---

    public void updateUserTypeDisplay(String userType) {
        SwingUtilities.invokeLater(() -> userTypeLabel.setText("Type: " + userType));
    }

    public void updateUserBalanceDisplay(double balance) {
        SwingUtilities.invokeLater(() -> balanceLabel.setText(String.format("Balance: $%.2f", balance)));
    }

    public void updateLotSelector(List<String> lots) {
        SwingUtilities.invokeLater(() -> {
            lotSelector.removeAllItems();
            if (lots != null) {
                lots.forEach(lotSelector::addItem);
            }
            if (lotSelector.getItemCount() > 0) {
                lotSelector.setSelectedIndex(0);
            } else {
                updateSpaceSelector(new ArrayList<>()); // Clear spaces if no lots
            }
        });
    }

    public void updateSpaceSelector(List<String> spaces) {
        SwingUtilities.invokeLater(() -> {
            String currentSelection = (String) spaceSelector.getSelectedItem();
            spaceSelector.removeAllItems();
            if (spaces != null) {
                spaces.forEach(spaceSelector::addItem);
                if (currentSelection != null && spaces.contains(currentSelection)) {
                    spaceSelector.setSelectedItem(currentSelection);
                } else if (spaceSelector.getItemCount() > 0) {
                    spaceSelector.setSelectedIndex(0);
                }
            }
            // Trigger detail update if a space is selected
            if (spaceSelector.getSelectedIndex() != -1) {
                ActionListener[] listeners = spaceSelector.getActionListeners();
                if (listeners.length > 0) {
                    listeners[0].actionPerformed(new ActionEvent(spaceSelector, ActionEvent.ACTION_PERFORMED, null));
                }
            } else {
                updateBookingDetailsArea("Select a lot and space.");
            }
        });
    }

    public void updateBookingDetailsArea(String details) {
        SwingUtilities.invokeLater(() -> bookingDetailsArea.setText(details));
    }

    public void populateFieldsForEditing(String startTime, String endTime, String vehicleType, String carBrand, String licensePlate) {
        SwingUtilities.invokeLater(() -> {
            startTimeField.setText(startTime);
            endTimeField.setText(endTime);
            vehicleTypeSelector.setSelectedItem(vehicleType);
            carBrandField.setText(carBrand);
            licensePlateField.setText(licensePlate);
        });
    }

    // --- Edit Mode Handling ---

    /** Puts the GUI into editing mode */
    public void setEditMode(String bookingId) {
        this.bookingIdBeingEdited = bookingId;
        SwingUtilities.invokeLater(() -> {
            bookButton.setText("Update Booking");
            // Remove default listener, add update listener
            bookButton.removeActionListener(originalBookButtonActionListener);
            bookButton.addActionListener(e -> handleBookOrUpdateAction(true)); // true = isUpdate

            // Disable buttons not relevant during edit
            editButton.setEnabled(false);
            cancelButton.setEnabled(false);
            extendButton.setEnabled(false);
            // Optionally disable lot/space selection?
            // lotSelector.setEnabled(false);
            // spaceSelector.setEnabled(false);
        });
    }

    /** Resets GUI from editing mode back to booking mode */
    public void resetToBookingMode() {
        this.bookingIdBeingEdited = null;
        SwingUtilities.invokeLater(() -> {
            // Clear fields
            startTimeField.setText("");
            endTimeField.setText("");
            carBrandField.setText("");
            licensePlateField.setText("");
            bookingDetailsArea.setText("Select lot and space or enter details to book.");

            // Restore button text and listeners
            bookButton.setText("Book Space");
            // Remove potentially added update listener, restore original book listener
            ActionListener[] listeners = bookButton.getActionListeners();
            for (ActionListener l : listeners) {
                bookButton.removeActionListener(l);
            }
            bookButton.addActionListener(originalBookButtonActionListener);

            // Re-enable buttons
            editButton.setEnabled(true);
            cancelButton.setEnabled(true);
            extendButton.setEnabled(true);
            // Re-enable selectors if they were disabled
            lotSelector.setEnabled(true);
            spaceSelector.setEnabled(true);
        });
    }

    // --- Dialog/Window Openers (UI Responsibility) ---

    private void openTimelineDialog() {
        // This logic stays in GUI
        BookingTimelineDialog dialog = new BookingTimelineDialog(this);
        dialog.setVisible(true);
        String start = dialog.getSelectedStartTime();
        String end = dialog.getSelectedEndTime();
        if (start != null && end != null) {
            startTimeField.setText(start);
            endTimeField.setText(end);
        }
    }

    private void showLoadFundsDialog() {
        // This UI logic stays here, but the processing is delegated
        JDialog loadFundsDialog = new JDialog(this, "Load Funds", true);
        loadFundsDialog.setSize(400, 350);
        loadFundsDialog.setLocationRelativeTo(this);
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JTextField amountField = new JTextField();
        JComboBox<String> methodComboBox = new JComboBox<>(new String[]{"Credit Card", "Debit Card", "Mobile Payment"});
        JTextField cardNumberField = new JTextField();
        JTextField cvvField = new JTextField();

        panel.add(new JLabel("Amount to Load ($):")); panel.add(amountField);
        panel.add(new JLabel("Select Payment Method:")); panel.add(methodComboBox);
        panel.add(new JLabel("Card Number (16 digits):")); panel.add(cardNumberField);
        panel.add(new JLabel("CVV (3 digits):")); panel.add(cvvField);

        JButton confirmButton = new JButton("Confirm Payment");
        confirmButton.setFont(new Font("Arial", Font.BOLD, 14));
        confirmButton.addActionListener(e -> {
            // UI Validation
            double amount;
            try { amount = Double.parseDouble(amountField.getText().trim()); }
            catch (NumberFormatException ex) { showErrorMessage("Invalid amount.", loadFundsDialog); return; }
            if (amount <= 0) { showErrorMessage("Enter positive amount.", loadFundsDialog); return; }
            // Card validation... (similar to before)
            String method = (String) methodComboBox.getSelectedItem();
            if (!"Mobile Payment".equals(method)) { // Assuming card validation needed
                String card = cardNumberField.getText().trim().replaceAll("\\s+", "");
                String cvv = cvvField.getText().trim();
                if (!card.matches("\\d{16}") || !cvv.matches("\\d{3}")) {
                    showErrorMessage("Invalid card details (16-digit card, 3-digit CVV).", loadFundsDialog); return;
                }
            }

            // Delegate processing to logic handler
            if (bookingLogicHandler != null) {
                bookingLogicHandler.processLoadFunds(amount);
            }
            loadFundsDialog.dispose();
        });

        panel.add(new JLabel()); // Spacer
        panel.add(confirmButton);
        loadFundsDialog.add(panel);
        loadFundsDialog.setVisible(true);
    }

    private void openMyBookingsWindow() {
        // UI structure stays here
        JDialog bookingsDialog = new JDialog(this, "My Bookings", true);
        bookingsDialog.setSize(700, 450); // Slightly wider for license plate
        bookingsDialog.setLayout(new BorderLayout(10, 10));
        bookingsDialog.setLocationRelativeTo(this);

        bookingsTableModel = new DefaultTableModel(
                new Object[]{"Lot", "Space", "Start", "End", "Status", "License", "ID"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        bookingsTable = new JTable(bookingsTableModel);
        bookingsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        bookingsTable.setFont(new Font("Arial", Font.PLAIN, 14));
        bookingsTable.setRowHeight(25);
        // Hide ID column
        bookingsTable.removeColumn(bookingsTable.getColumnModel().getColumn(6));


        JScrollPane scrollPane = new JScrollPane(bookingsTable);
        bookingsDialog.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton checkInButton = new JButton("Check In");
        JButton exitButton = new JButton("Close");
        checkInButton.setFont(new Font("Arial", Font.BOLD, 14));
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));
        buttonPanel.add(checkInButton);
        buttonPanel.add(exitButton);
        bookingsDialog.add(buttonPanel, BorderLayout.SOUTH);

        checkInButton.addActionListener(e -> {
            // Get selected row data from UI table
            int selectedRow = bookingsTable.getSelectedRow();
            if (selectedRow == -1) { showErrorMessage("Select booking to check in.", bookingsDialog); return; }

            String lot = (String) bookingsTableModel.getValueAt(selectedRow, 0);
            String space = (String) bookingsTableModel.getValueAt(selectedRow, 1);
            String status = (String) bookingsTableModel.getValueAt(selectedRow, 4);
            // Retrieve hidden ID using convertRowIndexToModel if table sorting/filtering is ever added
            int modelRow = bookingsTable.convertRowIndexToModel(selectedRow);
            String bookingId = (String) bookingsTableModel.getValueAt(modelRow, 6); // Get ID from correct model row

            if (!"booked".equalsIgnoreCase(status)) {
                showErrorMessage("Only 'booked' status reservations can be checked in.", bookingsDialog); return;
            }
            // Get check-in time and license plate via dialogs (UI responsibility)
            String checkInTime = JOptionPane.showInputDialog(bookingsDialog, "Check-In Time (HH:MM):",
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
            if (checkInTime == null || !isValidTimeFormat(checkInTime)) {
                showErrorMessage("Invalid time.", bookingsDialog); return;
            }
            String enteredLicensePlate = JOptionPane.showInputDialog(bookingsDialog, "License Plate:");
            if (enteredLicensePlate == null || enteredLicensePlate.trim().isEmpty()) {
                showErrorMessage("License plate empty.", bookingsDialog); return;
            }

            // Delegate processing to logic handler
            if (bookingLogicHandler != null) {
                bookingLogicHandler.performCheckIn(bookingId, lot, space, checkInTime, enteredLicensePlate.trim());
                // Logic handler might call loadUserBookings again to refresh the table via updateBookingsTable
            }
        });
        exitButton.addActionListener(e -> bookingsDialog.dispose());

        // Initial load delegated to logic handler
        if (bookingLogicHandler != null) {
            bookingLogicHandler.loadUserBookings();
        }
        bookingsDialog.setVisible(true);
    }

    /** Updates the data displayed in the 'My Bookings' table. Called by logic handler. */
    public void updateBookingsTable(List<Object[]> bookingData) {
        SwingUtilities.invokeLater(() -> {
            if (bookingsTableModel != null) {
                bookingsTableModel.setRowCount(0); // Clear
                if (bookingData != null) {
                    bookingData.forEach(bookingsTableModel::addRow); // Add new rows
                }
            }
        });
    }

    // --- Utility Methods ---
    private void startDateTimeUpdater() {
        Timer timer = new Timer(1000, e -> {
            if (realTimeLabel != null) {
                realTimeLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
        });
        timer.setInitialDelay(0); timer.start();
    }

    // --- Message Dialogs ---
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void showErrorMessage(String message, Component parent) {
        JOptionPane.showMessageDialog(parent, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void showInfoMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    public void showInfoMessage(String message, Component parent) {
        JOptionPane.showMessageDialog(parent, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    /** Closes this Booking window */
    public void closeWindow() {
        dispose();
    }

    // Main method removed - should be launched from elsewhere after login
}