package com.parkingapp.GUI;

import com.parkingapp.GUI.BookingPage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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

/**
 * BookingPageGUI – a modern and human-friendly interface for booking parking spaces.
 * This version uses a modern look & feel, a custom gradient header, improved spacing,
 * custom tooltips, and intuitive UI messages.
 */
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
    private JTable bookingsTable;
    private DefaultTableModel bookingsTableModel;

    // Reference to the logic handler class
    private BookingPage bookingLogicHandler;

    // Store the original book button action listener to swap during edit mode
    private ActionListener originalBookButtonActionListener;
    private String bookingIdBeingEdited = null; // Track if in edit mode

    // --- Constructor ---
    public BookingPageGUI(BookingPage logicHandler) {
        // Apply Nimbus Look & Feel for a modern interface
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.err.println("Nimbus Look & Feel not available, continuing with default.");
        }

        this.bookingLogicHandler = logicHandler;
        initializeFrame();
        initializeUI();
        startDateTimeUpdater();

        // Trigger initial data load via logic handler after GUI is built
        if (bookingLogicHandler != null) {
            bookingLogicHandler.loadInitialUIData();
        }
        setVisible(true);
    }

    // --- Frame Initialization ---
    private void initializeFrame() {
        setTitle("Parking Space Booking");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
    }

    // --- UI Initialization ---
    private void initializeUI() {
        // Main panel using BorderLayout with generous margins
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        // Create a custom gradient header panel for a human-friendly touch
        JPanel headerPanel = new GradientHeaderPanel("Booking Page");
        headerPanel.setPreferredSize(new Dimension(0, 60));

        // Organize input fields and buttons in separate panels
        JPanel inputPanel = createInputPanel();
        JPanel buttonPanel = createButtonPanel();

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    // --- Custom Gradient Header Panel ---
    class GradientHeaderPanel extends JPanel {
        private String title;
        public GradientHeaderPanel(String title) {
            this.title = title;
            setLayout(new BorderLayout());
            setBorder(new EmptyBorder(10, 15, 10, 15));

            // Left side: Title label
            JLabel titleLabel = new JLabel(title);
            titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
            titleLabel.setForeground(Color.WHITE);
            add(titleLabel, BorderLayout.WEST);

            // Right side: User info panel
            JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 5));
            rightPanel.setOpaque(false);
            userTypeLabel = new JLabel("Type: Loading...");
            userTypeLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
            userTypeLabel.setForeground(Color.WHITE);
            rightPanel.add(userTypeLabel);

            balanceLabel = new JLabel("Balance: Loading...");
            balanceLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
            balanceLabel.setForeground(Color.WHITE);
            rightPanel.add(balanceLabel);

            loadFundsButton = new JButton("Load Funds");
            loadFundsButton.setFont(new Font("SansSerif", Font.BOLD, 14));
            loadFundsButton.setToolTipText("Click to add funds to your account");
            loadFundsButton.addActionListener(e -> showLoadFundsDialog());
            rightPanel.add(loadFundsButton);

            add(rightPanel, BorderLayout.EAST);
        }

        @Override
        protected void paintComponent(Graphics g) {
            // Draw a smooth gradient background
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            Color color1 = new Color(66, 133, 244); // Blue tone
            Color color2 = new Color(15, 157, 88);  // Green tone
            GradientPaint gp = new GradientPaint(0, 0, color1, width, height, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
            super.paintComponent(g);
        }
    }

    // --- Input Panel Creation ---
    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = createGridBagConstraints();

        lotSelector = new JComboBox<>();
        lotSelector.setToolTipText("Select a parking lot");
        spaceSelector = new JComboBox<>();
        spaceSelector.setToolTipText("Select a parking space");
        vehicleTypeSelector = createVehicleTypeSelector();
        vehicleTypeSelector.setToolTipText("Select vehicle type");
        startTimeField = new JTextField(5);
        startTimeField.setToolTipText("Enter start time (HH:MM)");
        endTimeField = new JTextField(5);
        endTimeField.setToolTipText("Enter end time (HH:MM)");
        carBrandField = new JTextField(10);
        carBrandField.setToolTipText("Enter your car brand");
        licensePlateField = new JTextField(10);
        licensePlateField.setToolTipText("Enter your license plate");
        realTimeLabel = new JLabel("Loading time...");
        realTimeLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
        bookingDetailsArea = new JTextArea(10, 30);
        bookingDetailsArea.setEditable(false);
        bookingDetailsArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        bookingDetailsArea.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));

        addLabelAndComponent(inputPanel, "Select Lot:", lotSelector, gbc, 0);
        addLabelAndComponent(inputPanel, "Select Space:", spaceSelector, gbc, 1);
        addLabelAndComponent(inputPanel, "Current Time:", realTimeLabel, gbc, 2);
        addLabelAndComponent(inputPanel, "Start Time (HH:MM):", startTimeField, gbc, 3);
        addLabelAndComponent(inputPanel, "End Time (HH:MM):", endTimeField, gbc, 4);

        // Timeline Button with bold styling
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        JButton timelineSelectButton = new JButton("Select Time via Timeline");
        timelineSelectButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        timelineSelectButton.setToolTipText("Use timeline view for time selection");
        timelineSelectButton.addActionListener(e -> openTimelineDialog());
        inputPanel.add(timelineSelectButton, gbc);
        gbc.gridwidth = 1; gbc.weightx = 0;

        addLabelAndComponent(inputPanel, "Vehicle Type:", vehicleTypeSelector, gbc, 6);
        addLabelAndComponent(inputPanel, "Car Brand:", carBrandField, gbc, 7);
        addLabelAndComponent(inputPanel, "License Plate:", licensePlateField, gbc, 8);

        // Add booking details text area inside a scroll pane with padding
        JScrollPane scrollPane = new JScrollPane(bookingDetailsArea);
        gbc.gridx = 0; gbc.gridy = 9; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH; gbc.weighty = 1.0;
        inputPanel.add(scrollPane, gbc);
        gbc.gridwidth = 1; gbc.weighty = 0; gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add listeners for lot and space selectors
        lotSelector.addActionListener(e -> {
            String selectedLot = (String) lotSelector.getSelectedItem();
            if (selectedLot != null && bookingLogicHandler != null) {
                bookingLogicHandler.loadSpacesForLot(selectedLot);
            }
            updateBookingDetailsArea("Select a space to see details.");
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

    // --- Button Panel Creation ---
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setBackground(Color.WHITE);
        bookButton = new JButton("Book Space");
        cancelButton = new JButton("Cancel Booking");
        editButton = new JButton("Edit Booking");
        extendButton = new JButton("Extend Booking");
        viewBookingsButton = new JButton("View My Bookings");
        returnButton = new JButton("Logout");

        setButtonFonts(bookButton, cancelButton, editButton, extendButton, viewBookingsButton, returnButton);
        addButtonListeners();

        // Optionally set tooltips for extra friendliness
        bookButton.setToolTipText("Click to confirm your booking.");
        cancelButton.setToolTipText("Cancel your current booking.");
        editButton.setToolTipText("Edit details of an existing booking.");
        extendButton.setToolTipText("Extend the duration of your booking.");
        viewBookingsButton.setToolTipText("View all your current bookings.");
        returnButton.setToolTipText("Logout and return to the main menu.");

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
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        return gbc;
    }

    private void addLabelAndComponent(JPanel panel, String labelText, JComponent component, GridBagConstraints gbc, int row) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0; gbc.gridwidth = 1;
        panel.add(label, gbc);

        component.setFont(new Font("SansSerif", Font.PLAIN, 14));
        gbc.gridx = 1; gbc.gridy = row; gbc.weightx = 1.0;
        panel.add(component, gbc);
    }

    private JComboBox<String> createVehicleTypeSelector() {
        String[] types = {"SUV", "Sedan", "Convertible", "Mini SUV", "Van", "Truck"};
        return new JComboBox<>(types);
    }

    private void setButtonFonts(JButton... buttons) {
        Font buttonFont = new Font("SansSerif", Font.BOLD, 14);
        for (JButton button : buttons) {
            button.setFont(buttonFont);
        }
    }

    // --- Event Listener Setup ---
    private void addButtonListeners() {
        // Store the default book action (booking new space)
        originalBookButtonActionListener = e -> handleBookOrUpdateAction(false);
        bookButton.addActionListener(originalBookButtonActionListener);

        cancelButton.addActionListener(e -> handleCancelAction());
        editButton.addActionListener(e -> handleEditAction());
        extendButton.addActionListener(e -> handleExtendAction());
        viewBookingsButton.addActionListener(e -> openMyBookingsWindow());
        returnButton.addActionListener(e -> handleLogoutAction());
    }

    // --- Action Handling Methods ---
    private void handleBookOrUpdateAction(boolean isUpdate) {
        // Gather input data
        String lot = (String) lotSelector.getSelectedItem();
        String space = (String) spaceSelector.getSelectedItem();
        String startTime = startTimeField.getText().trim();
        String endTime = endTimeField.getText().trim();
        String vehicleType = (String) vehicleTypeSelector.getSelectedItem();
        String carBrand = carBrandField.getText().trim();
        String licensePlate = licensePlateField.getText().trim();

        if (!validateInputFields(lot, space, startTime, endTime, vehicleType, carBrand, licensePlate)) {
            return;
        }

        if (bookingLogicHandler != null) {
            if (isUpdate) {
                if (bookingIdBeingEdited != null) {
                    bookingLogicHandler.attemptUpdateBooking(bookingIdBeingEdited, lot, space, startTime, endTime, vehicleType, carBrand, licensePlate);
                } else {
                    showErrorMessage("Cannot update: No booking selected for editing.");
                    resetToBookingMode();
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
            String bookingId = bookingLogicHandler.prepareEditing(lot, space);
            if (bookingId != null) {
                setEditMode(bookingId);
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
            this.dispose();
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
        if (!licensePlate.matches("^[A-Za-z0-9 -]+$")) {
            showErrorMessage("Invalid license plate format (letters, numbers, spaces, hyphens only).");
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
                updateSpaceSelector(new ArrayList<>());
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
    public void setEditMode(String bookingId) {
        this.bookingIdBeingEdited = bookingId;
        SwingUtilities.invokeLater(() -> {
            bookButton.setText("Update Booking");
            bookButton.removeActionListener(originalBookButtonActionListener);
            bookButton.addActionListener(e -> handleBookOrUpdateAction(true));
            editButton.setEnabled(false);
            cancelButton.setEnabled(false);
            extendButton.setEnabled(false);
        });
    }

    public void resetToBookingMode() {
        this.bookingIdBeingEdited = null;
        SwingUtilities.invokeLater(() -> {
            startTimeField.setText("");
            endTimeField.setText("");
            carBrandField.setText("");
            licensePlateField.setText("");
            bookingDetailsArea.setText("Select lot and space or enter details to book.");
            bookButton.setText("Book Space");
            for (ActionListener l : bookButton.getActionListeners()) {
                bookButton.removeActionListener(l);
            }
            bookButton.addActionListener(originalBookButtonActionListener);
            editButton.setEnabled(true);
            cancelButton.setEnabled(true);
            extendButton.setEnabled(true);
            lotSelector.setEnabled(true);
            spaceSelector.setEnabled(true);
        });
    }

    // --- Dialog and Window Openers ---
    private void openTimelineDialog() {
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
        confirmButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        confirmButton.addActionListener(e -> {
            double amount;
            try {
                amount = Double.parseDouble(amountField.getText().trim());
            } catch (NumberFormatException ex) {
                showErrorMessage("Invalid amount.", loadFundsDialog);
                return;
            }
            if (amount <= 0) {
                showErrorMessage("Enter a positive amount.", loadFundsDialog);
                return;
            }
            String method = (String) methodComboBox.getSelectedItem();
            if (!"Mobile Payment".equals(method)) {
                String card = cardNumberField.getText().trim().replaceAll("\\s+", "");
                String cvv = cvvField.getText().trim();
                if (!card.matches("\\d{16}") || !cvv.matches("\\d{3}")) {
                    showErrorMessage("Invalid card details (16-digit card, 3-digit CVV).", loadFundsDialog);
                    return;
                }
            }
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
        JDialog bookingsDialog = new JDialog(this, "My Bookings", true);
        bookingsDialog.setSize(750, 500);
        bookingsDialog.setLayout(new BorderLayout(10, 10));
        bookingsDialog.setLocationRelativeTo(this);
        bookingsTableModel = new DefaultTableModel(
                new Object[]{"Lot", "Space", "Start", "End", "Status", "License", "ID"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        bookingsTable = new JTable(bookingsTableModel);
        bookingsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        bookingsTable.setFont(new Font("SansSerif", Font.PLAIN, 14));
        bookingsTable.setRowHeight(25);
        bookingsTable.removeColumn(bookingsTable.getColumnModel().getColumn(6));
        JScrollPane scrollPane = new JScrollPane(bookingsTable);
        bookingsDialog.add(scrollPane, BorderLayout.CENTER);
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton checkInButton = new JButton("Check In");
        JButton exitButton = new JButton("Close");
        checkInButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        exitButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnPanel.add(checkInButton);
        btnPanel.add(exitButton);
        bookingsDialog.add(btnPanel, BorderLayout.SOUTH);

        checkInButton.addActionListener(e -> {
            int selectedRow = bookingsTable.getSelectedRow();
            if (selectedRow == -1) {
                showErrorMessage("Select booking to check in.", bookingsDialog);
                return;
            }
            String lot = (String) bookingsTableModel.getValueAt(selectedRow, 0);
            String space = (String) bookingsTableModel.getValueAt(selectedRow, 1);
            String status = (String) bookingsTableModel.getValueAt(selectedRow, 4);
            int modelRow = bookingsTable.convertRowIndexToModel(selectedRow);
            String bookingId = (String) bookingsTableModel.getValueAt(modelRow, 6);
            if (!"booked".equalsIgnoreCase(status)) {
                showErrorMessage("Only 'booked' status reservations can be checked in.", bookingsDialog);
                return;
            }
            String checkInTime = JOptionPane.showInputDialog(bookingsDialog, "Check-In Time (HH:MM):",
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
            if (checkInTime == null || !isValidTimeFormat(checkInTime)) {
                showErrorMessage("Invalid time.", bookingsDialog);
                return;
            }
            String enteredLicensePlate = JOptionPane.showInputDialog(bookingsDialog, "License Plate:");
            if (enteredLicensePlate == null || enteredLicensePlate.trim().isEmpty()) {
                showErrorMessage("License plate empty.", bookingsDialog);
                return;
            }
            if (bookingLogicHandler != null) {
                bookingLogicHandler.performCheckIn(bookingId, lot, space, checkInTime, enteredLicensePlate.trim());
            }
        });
        exitButton.addActionListener(e -> bookingsDialog.dispose());
        if (bookingLogicHandler != null) {
            bookingLogicHandler.loadUserBookings();
        }
        bookingsDialog.setVisible(true);
    }

    public void updateBookingsTable(List<Object[]> bookingData) {
        SwingUtilities.invokeLater(() -> {
            if (bookingsTableModel != null) {
                bookingsTableModel.setRowCount(0); // Clear previous rows
                if (bookingData != null) {
                    bookingData.forEach(bookingsTableModel::addRow);
                }
            }
        });
    }

    // --- DateTime Updater ---
    private void startDateTimeUpdater() {
        Timer timer = new Timer(1000, e -> {
            if (realTimeLabel != null) {
                realTimeLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
        });
        timer.setInitialDelay(0);
        timer.start();
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
    public void closeWindow() {
        dispose();
    }

    // Main method removed – this frame should be launched from a higher-level controller after login
}
