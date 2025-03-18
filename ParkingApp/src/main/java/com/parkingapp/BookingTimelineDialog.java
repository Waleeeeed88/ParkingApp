package com.parkingapp;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.*;

public class BookingTimelineDialog extends JDialog {
    private String selectedStartTime;
    private String selectedEndTime;

    public BookingTimelineDialog(Frame owner) {
        // The third argument (true) makes this dialog modal
        super(owner, "Select Booking Time", true);

        // Create a TimelinePanel from your BookingTimeline class
        BookingTimeline.TimelinePanel timelinePanel = new BookingTimeline.TimelinePanel();
        // Add a listener so we know when the user confirms a selection
        timelinePanel.setBookingTimeSelectionListener((start, end) -> {
            selectedStartTime = start;
            selectedEndTime = end;
            dispose(); // close the dialog
        });

        // Create Confirm/Reset buttons
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> timelinePanel.confirmSelection());

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> timelinePanel.resetSelection());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmButton);
        buttonPanel.add(resetButton);

        // Add everything to the dialog
        setLayout(new BorderLayout());
        add(timelinePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set the dialog size and position
        setSize(1100, 300);
        setLocationRelativeTo(owner);
    }

    public String getSelectedStartTime() {
        return selectedStartTime;
    }

    public String getSelectedEndTime() {
        return selectedEndTime;
    }
}