package testParkingApp;

import static org.junit.jupiter.api.Assertions.*;
import com.parkingapp.SuperAdminDashboard;

import org.junit.jupiter.api.Test;

public class SuperAdminDashboardTest {

    // --------------------------------------------------------------------
    // Tests for generateSecurePassword()
    // --------------------------------------------------------------------

    // Verify that a password of the desired length is generated, and that each character is allowed.
    @Test
    public void testGenerateSecurePassword() {
        SuperAdminDashboard dashboard = new SuperAdminDashboard();
        int desiredLength = 12;
        String password = dashboard.generateSecurePassword(desiredLength);

        assertNotNull(password, "Generated password should not be null");
        assertEquals(desiredLength, password.length(), "Password length should be " + desiredLength);

        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*()-_?.";
        for (char c : password.toCharArray()) {
            assertTrue(allowedChars.indexOf(c) >= 0, "Character '" + c + "' is not allowed.");
        }
    }

    // Verify that a zero-length password returns an empty string.
    @Test
    public void testGenerateSecurePasswordWithZeroLength() {
        SuperAdminDashboard dashboard = new SuperAdminDashboard();
        String password = dashboard.generateSecurePassword(0);
        assertNotNull(password, "Password should not be null even if length is 0");
        assertEquals(0, password.length(), "Password length should be zero when 0 is requested");
    }

    // Verify that consecutive calls produce different values (i.e. randomness).
    @Test
    public void testGenerateSecurePasswordRandomness() {
        SuperAdminDashboard dashboard = new SuperAdminDashboard();
        String password1 = dashboard.generateSecurePassword(10);
        String password2 = dashboard.generateSecurePassword(10);
        // Although there is a very small chance they could match, we assume different calls yield different passwords.
        assertNotEquals(password1, password2, "Consecutive generated passwords should likely be different");
    }

    // --------------------------------------------------------------------
    // Tests for generateAdminAccount()
    // --------------------------------------------------------------------

    // Verify that a valid prefix produces an admin account with the expected userId (prefix in lowercase + "yups") and a 10-character password.
    @Test
    public void testGenerateAdminAccount_ValidPrefix() {
        SuperAdminDashboard dashboard = new SuperAdminDashboard();
        String prefix = "admin";

        // Use a simple prototype instance (using the inner AdminAccount class).
        SuperAdminDashboard.AdminAccountPrototype prototype =
                new SuperAdminDashboard.AdminAccount("dummy", "dummy");
        SuperAdminDashboard.AdminAccount account =
                (SuperAdminDashboard.AdminAccount) dashboard.generateAdminAccount(prefix, prototype);

        assertNotNull(account, "Generated admin account should not be null");
        // The method converts the prefix to lowercase and appends "yups"
        assertEquals(prefix.toLowerCase() + "yups", account.getUserId(),
                "UserId should be the prefix in lowercase concatenated with 'yups'");
        assertNotNull(account.getPassword(), "Password should not be null");
        assertEquals(10, account.getPassword().length(),
                "Generated password length should be 10");
    }

    // Verify that an empty (whitespace-only) prefix causes an exception.
    @Test
    public void testGenerateAdminAccount_EmptyPrefixThrowsException() {
        SuperAdminDashboard dashboard = new SuperAdminDashboard();
        SuperAdminDashboard.AdminAccountPrototype prototype = new SuperAdminDashboard.AdminAccount("dummy", "dummy");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            dashboard.generateAdminAccount("   ", prototype);
        });
        assertEquals("Prefix cannot be empty.", exception.getMessage(),
                "Expected exception message for empty prefix does not match");
    }

    // Verify that the prefix is converted to lowercase even if mixed-case is provided.
    @Test
    public void testGenerateAdminAccountLowercaseConversion() {
        SuperAdminDashboard dashboard = new SuperAdminDashboard();
        String prefix = "AdMiN";

        SuperAdminDashboard.AdminAccountPrototype prototype =
                new SuperAdminDashboard.AdminAccount("dummy", "dummy");
        SuperAdminDashboard.AdminAccount account =
                (SuperAdminDashboard.AdminAccount) dashboard.generateAdminAccount(prefix, prototype);

        assertEquals("adminyups", account.getUserId(),
                "UserId should convert the prefix to lowercase and append 'yups'");
    }

    // Verify that the provided prototype is not modified by generateAdminAccount.
    @Test
    public void testPrototypeNotModified() {
        SuperAdminDashboard.AdminAccount prototypeInstance = new SuperAdminDashboard.AdminAccount("original", "original");
        SuperAdminDashboard.AdminAccountPrototype prototype = prototypeInstance;
        SuperAdminDashboard dashboard = new SuperAdminDashboard();

        dashboard.generateAdminAccount("test", prototype);

        // The prototype instance must remain unchanged.
        assertEquals("original", prototypeInstance.getUserId(), "Prototype userId should remain unchanged");
        assertEquals("original", prototypeInstance.getPassword(), "Prototype password should remain unchanged");
    }

    // --------------------------------------------------------------------
    // Tests for AdminAccount clone() method
    // --------------------------------------------------------------------

    // Verify that cloning an AdminAccount produces a different instance with the same data.
    @Test
    public void testAdminAccountClone() {
        SuperAdminDashboard.AdminAccount original = new SuperAdminDashboard.AdminAccount("user", "pass");
        SuperAdminDashboard.AdminAccount clone = original.clone();

        assertNotSame(original, clone, "Clone should be a distinct instance");
        assertEquals(original.getUserId(), clone.getUserId(), "User IDs should be equal after cloning");
        assertEquals(original.getPassword(), clone.getPassword(), "Passwords should be equal after cloning");

        // Change original values and verify clone remains unchanged.
        original.setUserId("modified");
        original.setPassword("modified");
        assertNotEquals(original.getUserId(), clone.getUserId(), "Clone userId should not change if original is modified");
        assertNotEquals(original.getPassword(), clone.getPassword(), "Clone password should not change if original is modified");
    }

    // --------------------------------------------------------------------
    // Tests for AdminAccountData Getters
    // --------------------------------------------------------------------

    // Verify that AdminAccountData getters return the expected values.
    @Test
    public void testAdminAccountDataGetters() {
        String expectedUser = "testuser";
        String expectedPassword = "testpass";
        SuperAdminDashboard.AdminAccountData data =
                new SuperAdminDashboard.AdminAccountData(expectedUser, expectedPassword);

        assertEquals(expectedUser, data.getAdmin_user(), "getAdmin_user() should return the correct user");
        assertEquals(expectedPassword, data.getAdmin_password(), "getAdmin_password() should return the correct password");
    }
}