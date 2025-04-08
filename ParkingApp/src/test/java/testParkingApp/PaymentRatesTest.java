package testParkingApp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.parkingapp.UserLogin;
import com.parkingapp.PaymentRates;

class PaymentRatesTest {

    @Test
    @DisplayName("1) StudentRate - one hour => $5.0")
    void testStudentRate_OneHour() {
        double cost = PaymentRates.calculateCost(UserLogin.UserType.STUDENT, 60);
        assertEquals(5.0, cost, 0.0001);
    }

    @Test
    @DisplayName("2) StudentRate - multiple hours => 3 hours => $15.0")
    void testStudentRate_MultipleHours() {
        double cost = PaymentRates.calculateCost(UserLogin.UserType.STUDENT, 180);
        assertEquals(15.0, cost, 0.0001);
    }

    @Test
    @DisplayName("3) StudentRate - 0 minutes => $0.0")
    void testStudentRate_ZeroMinutes() {
        double cost = PaymentRates.calculateCost(UserLogin.UserType.STUDENT, 0);
        assertEquals(0.0, cost, 0.0001);
    }

    @Test
    @DisplayName("4) FacultyRate - one hour => $8.0")
    void testFacultyRate_OneHour() {
        double cost = PaymentRates.calculateCost(UserLogin.UserType.FACULTY, 60);
        assertEquals(8.0, cost, 0.0001);
    }

    @Test
    @DisplayName("5) FacultyRate - rounding minutes => 65 => 70 => ~1.17 hrs => 1.17 * 8 => ~9.36")
    void testFacultyRate_RoundingMinutes() {
        // 65 min becomes 70 min => 1.17 hours (approx).
        // 1.17 * 8 = 9.36
        double cost = PaymentRates.calculateCost(UserLogin.UserType.FACULTY, 65);
        assertEquals(9.36, cost, 0.01);
    }

    @Test
    @DisplayName("6) NonFacultyRate - one hour => $10.0")
    void testNonFacultyRate_OneHour() {
        double cost = PaymentRates.calculateCost(UserLogin.UserType.NON_FACULTY, 60);
        assertEquals(10.0, cost, 0.0001);
    }

    @Test
    @DisplayName("7) NonFacultyRate - multiple hours => 4 hours => $40.0")
    void testNonFacultyRate_MultipleHours() {
        double cost = PaymentRates.calculateCost(UserLogin.UserType.NON_FACULTY, 240);
        assertEquals(40.0, cost, 0.0001);
    }

    @Test
    @DisplayName("8) VisitorRate - half hour => 30 => $15 * 0.5 => $7.5")
    void testVisitorRate_30Minutes() {
        double cost = PaymentRates.calculateCost(UserLogin.UserType.VISITOR, 30);
        assertEquals(7.5, cost, 0.0001);
    }

    @Test
    @DisplayName("9) VisitorRate - multiple hours => 2.5 hrs => 150 min => $37.5")
    void testVisitorRate_150Minutes() {
        double cost = PaymentRates.calculateCost(UserLogin.UserType.VISITOR, 150);
        // 150 => rounds to 150 => 2.50 hours => 2.50 * 15 = 37.50
        assertEquals(37.5, cost, 0.0001);
    }

    @Test
    @DisplayName("10) getStrategy() throws IllegalArgumentException with unknown user type")
    void testGetStrategy_UnknownUserType() {
        assertThrows(IllegalArgumentException.class, () -> {
            PaymentRates.getStrategy(null); // or pass an invalid type
        });
    }
}