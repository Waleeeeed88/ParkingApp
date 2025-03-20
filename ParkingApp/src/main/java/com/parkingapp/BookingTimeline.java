package com.parkingapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;

public class BookingTimeline extends JFrame {
    // (Keep your existing code here if you want to use the standalone frame elsewhere)

    // The TimelinePanel will be reused for the time selector.
	public static class TimelinePanel extends JPanel {
	    private final int segmentsPerRow = 48;
	    private final int totalSegments = 96;
	    private final int topMargin = 30;
	    private final int bottomMargin = 30;
	    enum SegmentState { GREEN, ORANGE, RED }
	    private final SegmentState[] segmentStates = new SegmentState[totalSegments];
	    private int selectedStartSegment = -1;
	    private int selectedEndSegment = -1;

	    public interface BookingTimeSelectionListener {
	        void timeSelected(String startTime, String endTime);
	    }
	    private BookingTimeSelectionListener selectionListener;

	    public void setBookingTimeSelectionListener(BookingTimeSelectionListener listener) {
	        this.selectionListener = listener;
	    }

	    public TimelinePanel() {
	        // Initialize all segments as GREEN initially.
	        for (int i = 0; i < totalSegments; i++) {
	            segmentStates[i] = SegmentState.GREEN;
	        }
	        // Immediately update past segments based on current time.
	        updatePastSegments();

	        addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                handleClick(e);
	            }
	        });
	        
	        // Start a timer to update the timeline every minute.
	        new Timer(60000, event -> repaint()).start();
	    }

	    private int getCurrentSegmentIndex() {
	        LocalTime now = LocalTime.now();
	        int minutesSinceMidnight = now.getHour() * 60 + now.getMinute();
	        return minutesSinceMidnight / 15;
	    }

	    // New method to update segment states based on current time.
	    private void updatePastSegments() {
	        int currentSegment = getCurrentSegmentIndex();
	        for (int i = 0; i < totalSegments; i++) {
	            if (i < currentSegment) {
	                segmentStates[i] = SegmentState.RED;
	            } else {
	                // Only revert segments to green if they are not currently selected (ORANGE).
	                if (segmentStates[i] == SegmentState.RED) {
	                    segmentStates[i] = SegmentState.GREEN;
	                }
	            }
	        }
	    }

	    private void handleClick(MouseEvent e) {
	        int panelWidth = getWidth();
	        int panelHeight = getHeight();
	        int usableHeight = panelHeight - topMargin - bottomMargin;
	        int rowHeight = usableHeight / 2;
	        int segWidth = panelWidth / segmentsPerRow;

	        int adjustedY = e.getY() - topMargin;
	        if (adjustedY < 0) return;
	        int clickedRow = adjustedY / rowHeight;
	        if (clickedRow < 0 || clickedRow > 1) return;
	        int clickedCol = e.getX() / segWidth;
	        if (clickedCol < 0 || clickedCol >= segmentsPerRow) return;

	        int clickedSegment = clickedRow * segmentsPerRow + clickedCol;

	        // Prevent selection of past segments.
	        if (clickedSegment < getCurrentSegmentIndex()) {
	            // Optionally notify the user (e.g., beep or message)
	            Toolkit.getDefaultToolkit().beep();
	            return;
	        }

	        // Proceed with selection logic.
	        if (selectedStartSegment == -1) {
	            selectedStartSegment = clickedSegment;
	            selectedEndSegment = Math.min(clickedSegment + 3, totalSegments - 1);
	            markRangeOrange(selectedStartSegment, selectedEndSegment);
	        } else {
	            if (clickedSegment < selectedStartSegment) {
	                clearOrangeSelection();
	                selectedStartSegment = clickedSegment;
	                selectedEndSegment = Math.min(clickedSegment + 3, totalSegments - 1);
	                markRangeOrange(selectedStartSegment, selectedEndSegment);
	            } else if (clickedSegment > selectedEndSegment) {
	                if (clickedSegment < selectedStartSegment + 3) {
	                    selectedEndSegment = Math.min(selectedStartSegment + 3, totalSegments - 1);
	                } else {
	                    selectedEndSegment = Math.min(clickedSegment, totalSegments - 1);
	                }
	                markRangeOrange(selectedStartSegment, selectedEndSegment);
	            }
	        }
	        repaint();
	    }

	    private void markRangeOrange(int start, int end) {
	        for (int i = start; i <= end; i++) {
	            if (segmentStates[i] == SegmentState.GREEN) {
	                segmentStates[i] = SegmentState.ORANGE;
	            }
	        }
	    }

	    private void clearOrangeSelection() {
	        for (int i = 0; i < totalSegments; i++) {
	            if (segmentStates[i] == SegmentState.ORANGE) {
	                segmentStates[i] = SegmentState.GREEN;
	            }
	        }
	        selectedStartSegment = -1;
	        selectedEndSegment = -1;
	    }

	    public void confirmSelection() {
	        if (selectedStartSegment < 0 || selectedEndSegment < 0) {
	            JOptionPane.showMessageDialog(this, "No valid selection!", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        int startMinutes = selectedStartSegment * 15;
	        int endMinutes = (selectedEndSegment + 1) * 15;
	        LocalTime start = LocalTime.MIDNIGHT.plusMinutes(startMinutes);
	        LocalTime end = LocalTime.MIDNIGHT.plusMinutes(endMinutes);
	        String startTimeStr = String.format("%02d:%02d", start.getHour(), start.getMinute());
	        String endTimeStr = String.format("%02d:%02d", end.getHour(), end.getMinute());

	        if (selectionListener != null) {
	            selectionListener.timeSelected(startTimeStr, endTimeStr);
	        }

	        selectedStartSegment = -1;
	        selectedEndSegment = -1;
	        repaint();
	    }

	    public void resetSelection() {
	        clearOrangeSelection();
	        repaint();
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        // Update segment states based on realtime before painting.
	        updatePastSegments();

	        int panelWidth = getWidth();
	        int panelHeight = getHeight();
	        int usableHeight = panelHeight - topMargin - bottomMargin;
	        int rowHeight = usableHeight / 2;
	        int segWidth = panelWidth / segmentsPerRow;

	        // Draw top row hour labels.
	        g.setColor(Color.BLACK);
	        FontMetrics fm = g.getFontMetrics();
	        int labelYTop = topMargin - 5;
	        for (int i = 0; i <= 12; i++) {
	            int x = i * 4 * segWidth;
	            String label = String.format("%02d:00", i % 24);
	            int labelWidth = fm.stringWidth(label);
	            g.drawString(label, x - labelWidth / 2, labelYTop);
	        }

	        // Draw each segment.
	        for (int i = 0; i < totalSegments; i++) {
	            int row = i / segmentsPerRow;
	            int col = i % segmentsPerRow;
	            int x = col * segWidth;
	            int y = topMargin + row * rowHeight;
	            switch (segmentStates[i]) {
	                case GREEN -> g.setColor(new Color(0, 175, 0));
	                case ORANGE -> g.setColor(Color.ORANGE);
	                case RED -> g.setColor(new Color(204, 0, 0));
	            }
	            g.fillRect(x, y, segWidth, rowHeight);
	        }

	        // Draw grid lines.
	        for (int row = 0; row < 2; row++) {
	            int yStart = topMargin + row * rowHeight;
	            int yEnd = yStart + rowHeight;
	            for (int c = 0; c <= segmentsPerRow; c++) {
	                int x = c * segWidth;
	                if (c % 4 == 0) {
	                    g.setColor(Color.BLACK);
	                } else {
	                    g.setColor(Color.WHITE);
	                }
	                g.drawLine(x, yStart, x, yEnd);
	            }
	        }
	        g.setColor(Color.BLACK);
	        g.drawLine(0, topMargin, panelWidth, topMargin);
	        g.drawLine(0, topMargin + rowHeight, panelWidth, topMargin + rowHeight);
	        g.drawLine(0, topMargin + 2 * rowHeight - 1, panelWidth, topMargin + 2 * rowHeight - 1);
	        int labelYBottom = topMargin + rowHeight * 2 + fm.getAscent();
	        for (int i = 0; i <= 12; i++) {
	            int x = i * 4 * segWidth;
	            int hour = (i + 12) % 24;
	            String label = String.format("%02d:00", hour);
	            int labelWidth = fm.stringWidth(label);
	            g.drawString(label, x - labelWidth / 2, labelYBottom);
	        }
	    }
	}

}