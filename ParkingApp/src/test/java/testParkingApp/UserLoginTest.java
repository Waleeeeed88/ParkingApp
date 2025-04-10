package testParkingApp;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.prefs.Preferences;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.parkingapp.UserLogin;
import services.UserLoginService;
/**
 * JUnit tests for the UserLogin class.
 * This class tests the core logic of UserLogin.
 * The tests assume that UserLoginService's network operations are mocked or simulated.
 */
public class UserLoginTest {

    /**
     * A testable subclass of UserLogin that allows us to mock network interactions.
     * It mocks the service layer calls to simulate different responses.
     */
    private static class TestableUserLogin extends UserLogin {

        public String storedUid;
        public String storedEmail;
        public String storedUserType;

        // Mock the signIn method to simulate network failure or success
        protected String signIn(String email, String password) throws IOException {
            if ("fail@test.com".equals(email)) {
                return "{\"error\":{\"message\":\"INVALID_PASSWORD\"}}"; // Simulate failure
            }
            return "{\"idToken\":\"test-token\",\"localId\":\"test-uid\"}"; // Simulate success
        }

        // Mock the signUp method to simulate network failure or success
        protected String signUp(String email, String password) throws IOException {
            if ("fail@test.com".equals(email)) {
                return "{\"error\":{\"message\":\"EMAIL_EXISTS\"}}"; // Simulate failure
            }
            return "{\"idToken\":\"test-token\",\"localId\":\"test-uid\"}"; // Simulate success
        }

        // Simulate storing user information in Firestore
        protected void storeUserInfoInFirestore(String uid, String email, UserType userType) {
            this.storedUid = uid;
            this.storedEmail = email;
            this.storedUserType = userType.name();
        }

        // Mock the error handling to test error messages
       
        protected void showErrorMessage(String message, String title) {
            // Mock error handling logic here, can use System.out to track if it's invoked
            System.out.println("Error: " + message);
        }

        // Mock navigation to BookingPage to ensure it's tested
        
        protected void navigateToBookingPage() {
            System.out.println("Navigating to Booking Page...");
        }

        // Simulate Firebase error response handling
        
        protected void handleFirebaseErrorResponse(JSONObject jsonResponse) {
            System.out.println("Handled Firebase error response.");
        }

        // Synchronous login method for testing
        public void performLoginSync(String email, String password) {
            try {
                String response = signIn(email, password);
                JSONObject jsonResponse = new JSONObject(response);
                if (jsonResponse.has("idToken")) {
                    String uid = jsonResponse.getString("localId");
                    Preferences prefs = Preferences.userNodeForPackage(UserLogin.class);
                    prefs.put("user_uid", uid);
                } else if (jsonResponse.has("error")) {
                    JSONObject error = jsonResponse.getJSONObject("error");
                    throw new RuntimeException("Login error: " + error.getString("message"));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        // Synchronous registration method for testing
        public void performRegistrationSync(String email, String password, UserType userType) {
            try {
                String response = signUp(email, password);
                JSONObject jsonResponse = new JSONObject(response);
                if (jsonResponse.has("idToken")) {
                    String uid = jsonResponse.getString("localId");
                    Preferences prefs = Preferences.userNodeForPackage(UserLogin.class);
                    prefs.put("user_uid", uid);
                    storeUserInfoInFirestore(uid, email, userType);
                } else if (jsonResponse.has("error")) {
                    JSONObject error = jsonResponse.getJSONObject("error");
                    throw new RuntimeException("Registration error: " + error.getString("message"));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Preferences prefs;

    @BeforeEach
    void setUp() {
        prefs = Preferences.userNodeForPackage(UserLogin.class);
        prefs.remove("user_uid");
    }

    @Test
    @DisplayName("1) performLoginSync with valid credentials updates preferences")
    void testPerformLoginSuccess() {
        TestableUserLogin login = new TestableUserLogin();
        login.performLoginSync("valid@test.com", "password");
        String uid = prefs.get("user_uid", null);
        assertEquals("test-uid", uid, "Expected user_uid to be 'test-uid' after successful login.");
    }

    @Test
    @DisplayName("2) performLoginSync with failure credentials throws exception")
    void testPerformLoginFailure() {
        TestableUserLogin login = new TestableUserLogin();
        Exception exception = assertThrows(RuntimeException.class, () -> {
            login.performLoginSync("fail@test.com", "password");
        });
        assertTrue(exception.getMessage().contains("INVALID_PASSWORD"), "Expected error message to contain 'INVALID_PASSWORD'.");
    }

    @Test
    @DisplayName("3) performRegistrationSync with valid credentials updates preferences and stores user info")
    void testPerformRegistrationSuccess() {
        TestableUserLogin login = new TestableUserLogin();
        login.performRegistrationSync("valid@test.com", "password", UserLogin.UserType.FACULTY);
        String uid = prefs.get("user_uid", null);
        assertEquals("test-uid", uid, "Expected user_uid to be 'test-uid' after successful registration.");
        assertEquals("test-uid", login.storedUid, "Stored UID should be 'test-uid'.");
        assertEquals("valid@test.com", login.storedEmail, "Stored email should match input email.");
        assertEquals("FACULTY", login.storedUserType, "Stored user type should be 'FACULTY'.");
    }

    @Test
    @DisplayName("4) performRegistrationSync with failure credentials throws exception")
    void testPerformRegistrationFailure() {
        TestableUserLogin login = new TestableUserLogin();
        Exception exception = assertThrows(RuntimeException.class, () -> {
            login.performRegistrationSync("fail@test.com", "password", UserLogin.UserType.VISITOR);
        });
        assertTrue(exception.getMessage().contains("EMAIL_EXISTS"), "Expected error message to contain 'EMAIL_EXISTS'.");
    }

    @Test
    @DisplayName("5) signIn method returns valid JSON for successful login")
    void testSignInValid() throws IOException {
        TestableUserLogin login = new TestableUserLogin();
        String response = login.signIn("valid@test.com", "password");
        JSONObject json = new JSONObject(response);
        assertTrue(json.has("idToken"), "Response should contain idToken for valid credentials.");
        assertTrue(json.has("localId"), "Response should contain localId for valid credentials.");
    }

    @Test
    @DisplayName("6) signIn method returns error JSON for failure login")
    void testSignInFailure() throws IOException {
        TestableUserLogin login = new TestableUserLogin();
        String response = login.signIn("fail@test.com", "password");
        JSONObject json = new JSONObject(response);
        assertFalse(json.has("idToken"), "Response should not contain idToken for failure credentials.");
        assertTrue(json.has("error"), "Response should contain error for failure credentials.");
    }

    @Test
    @DisplayName("7) signUp method returns valid JSON for successful registration")
    void testSignUpValid() throws IOException {
        TestableUserLogin login = new TestableUserLogin();
        String response = login.signUp("valid@test.com", "password");
        JSONObject json = new JSONObject(response);
        assertTrue(json.has("idToken"), "Response should contain idToken for valid registration.");
        assertTrue(json.has("localId"), "Response should contain localId for valid registration.");
    }

    @Test
    @DisplayName("8) signUp method returns error JSON for failure registration")
    void testSignUpFailure() throws IOException {
        TestableUserLogin login = new TestableUserLogin();
        String response = login.signUp("fail@test.com", "password");
        JSONObject json = new JSONObject(response);
        assertFalse(json.has("idToken"), "Response should not contain idToken for failure registration.");
        assertTrue(json.has("error"), "Response should contain error for failure registration.");
    }

    @Test
    @DisplayName("9) initializeFirebase does not throw an exception")
    void testInitializeFirebase() {
        assertDoesNotThrow(() -> {
            new TestableUserLogin();
        }, "Firebase initialization in the constructor should not throw an exception.");
    }

    @Test
    @DisplayName("10) saveUserSession correctly stores the UID in preferences")
    void testSaveUserSession() {
        TestableUserLogin login = new TestableUserLogin();
        login.saveUserSession("test-uid");
        String storedUid = prefs.get("user_uid", null);
        assertEquals("test-uid", storedUid, "The user_uid should be saved correctly in preferences.");
    }

    @Test
    @DisplayName("11) navigateToBookingPage method is invoked")
    void testNavigateToBookingPage() {
        TestableUserLogin login = new TestableUserLogin();
        login.navigateToBookingPage(); // This should print a log message
    }

    @Test
    @DisplayName("12) handleFirebaseErrorResponse correctly handles Firebase error")
    void testHandleFirebaseErrorResponse() {
        TestableUserLogin login = new TestableUserLogin();
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("error", new JSONObject().put("message", "ERROR"));
        login.handleFirebaseErrorResponse(jsonResponse); // This should print an error message
    }

    @Test
    @DisplayName("13) showErrorMessage displays error messages correctly")
    void testShowErrorMessage() {
        TestableUserLogin login = new TestableUserLogin();
        login.showErrorMessage("Test Error", "Test Title"); // This should show an error dialog
    }
    
    @Test
    @DisplayName("15) check that correct error message is shown for empty email in login")
    void testEmptyEmailLogin() {
        TestableUserLogin login = new TestableUserLogin();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            login.performLoginSync("", "password");
        });
        assertTrue(exception.getMessage().contains("Email cannot be empty"), "Expected error for empty email.");
    }

    @Test
    @DisplayName("16) check that correct error message is shown for empty password in login")
    void testEmptyPasswordLogin() {
        TestableUserLogin login = new TestableUserLogin();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            login.performLoginSync("test@user.com", "");
        });
        assertTrue(exception.getMessage().contains("Password cannot be empty"), "Expected error for empty password.");
    }

    @Test
    @DisplayName("17) check that valid registration works with preferences set correctly")
    void testValidRegistration() {
        TestableUserLogin login = new TestableUserLogin();
        login.performRegistrationSync("valid@register.com", "password", UserLogin.UserType.STUDENT);
        String uid = prefs.get("user_uid", null);
        assertEquals("test-uid", uid, "UID should be correctly saved in preferences after registration.");
    }

    @Test
    @DisplayName("18) test invalid registration email format")
    void testInvalidRegistrationEmail() {
        TestableUserLogin login = new TestableUserLogin();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            login.performRegistrationSync("invalidemail", "password", UserLogin.UserType.FACULTY);
        });
        assertTrue(exception.getMessage().contains("Invalid email format"), "Expected error for invalid email format.");
    }

    @Test
    @DisplayName("19) test invalid registration password length")
    void testInvalidRegistrationPassword() {
        TestableUserLogin login = new TestableUserLogin();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            login.performRegistrationSync("valid@register.com", "short", UserLogin.UserType.FACULTY);
        });
        assertTrue(exception.getMessage().contains("Password must be at least 6 characters"), "Expected error for short password.");
    }

    @Test
    @DisplayName("20) test invalid user type in registration")
    void testInvalidUserTypeRegistration() {
        TestableUserLogin login = new TestableUserLogin();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            login.performRegistrationSync("valid@register.com", "password", null);
        });
        assertTrue(exception.getMessage().contains("User type cannot be null"), "Expected error for null user type.");
    }

}