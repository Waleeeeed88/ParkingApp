package com.parkingapp;

/**
 * PaymentRates encapsulates the cost calculation logic
 * for different user types using the Strategy Pattern.
 */
public class PaymentRates {

    /**
     * Strategy interface for calculating parking cost.
     */
    public interface RateCalculationStrategy {
        /**
         * Calculates the cost for the given number of hours.
         *
         * @param hoursParked the number of hours parked
         * @return the calculated cost
         */
        double calculateCost(double hoursParked);
    }

    /**
     * Concrete strategy for Student rate.
     */
    public static class StudentRateStrategy implements RateCalculationStrategy {
        private static final double STUDENT_RATE = 5.0; // $5 per hour

        @Override
        public double calculateCost(double hoursParked) {
            return STUDENT_RATE * hoursParked;
        }
    }

    /**
     * Concrete strategy for Faculty rate.
     */
    public static class FacultyRateStrategy implements RateCalculationStrategy {
        private static final double FACULTY_RATE = 8.0; // $8 per hour

        @Override
        public double calculateCost(double hoursParked) {
            return FACULTY_RATE * hoursParked;
        }
    }

    /**
     * Concrete strategy for Non-Faculty rate.
     */
    public static class NonFacultyRateStrategy implements RateCalculationStrategy {
        private static final double NON_FACULTY_RATE = 10.0; // $10 per hour

        @Override
        public double calculateCost(double hoursParked) {
            return NON_FACULTY_RATE * hoursParked;
        }
    }

    /**
     * Concrete strategy for Visitor rate.
     */
    public static class VisitorRateStrategy implements RateCalculationStrategy {
        private static final double VISITOR_RATE = 15.0; // $15 per hour

        @Override
        public double calculateCost(double hoursParked) {
            return VISITOR_RATE * hoursParked;
        }
    }

    /**
     * Factory method to return the correct RateCalculationStrategy
     * based on the given user type.
     *
     * @param userType the type of the user (from UserLogin.UserType)
     * @return a RateCalculationStrategy instance for the user type
     * @throws IllegalArgumentException if the user type is not recognized
     */
    public static RateCalculationStrategy getStrategy(UserLogin.UserType userType) {
        switch (userType) {
            case STUDENT:
                return new StudentRateStrategy();
            case FACULTY:
                return new FacultyRateStrategy();
            case NON_FACULTY:
                return new NonFacultyRateStrategy();
            case VISITOR:
                return new VisitorRateStrategy();
            default:
                throw new IllegalArgumentException("Unknown user type: " + userType);
        }
    }

    /**
     * Helper method to calculate parking cost given a user type and a duration (in minutes).
     * The duration is rounded to the nearest 10 minutes (e.g., 76 becomes 80, 31 becomes 30),
     * then converted to hours (with the hour value rounded to 3 significant figures).
     *
     * @param userType the type of user (e.g., STUDENT, FACULTY, etc.)
     * @param durationInMinutes the duration of parking in minutes
     * @return the total calculated cost
     */
    public static double calculateCost(UserLogin.UserType userType, long durationInMinutes) {
        // Round the duration to the nearest 10 minutes.
        long roundedMinutes = ((durationInMinutes + 5) / 10) * 10;
        
        // Convert rounded minutes to hours.
        double hours = roundedMinutes / 60.0;
        
        // Round the hours to two decimal figures.
        double hoursRounded = Math.round(hours * 100) / 100.0;

        // Calculate cost using the appropriate strategy.
        RateCalculationStrategy strategy = getStrategy(userType);
        return strategy.calculateCost(hoursRounded);
    }
    
}
