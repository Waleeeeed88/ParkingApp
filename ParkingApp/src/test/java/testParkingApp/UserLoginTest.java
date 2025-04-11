/*  src/test/java/com/parkingapp/UserLogin.java  */

package testParkingApp;

import java.lang.reflect.Field;
import java.util.prefs.Preferences;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.parkingapp.UserLogin;
import com.parkingapp.UserLogin.UserType;

class UserLoginTest {

    /* ------------------------------------------------------------------
     * Simple stub that fakes the REST calls performed by UserLoginService
     * ------------------------------------------------------------------ */
    static class StubUserLoginService extends services.UserLoginService {

        private final String cannedResponse;

        StubUserLoginService(String json) { this.cannedResponse = json; }

        @Override
        public String signInUser(String email, String password) {
            return cannedResponse;
        }

        @Override
        public String signUpUser(String email, String password) {
            return cannedResponse;
        }

        @Override
        public void storeNewUserInfo(String uid, String email, UserType type) {
            /* no-op for the test */
        }
    }

    /* ---------------------------------------------------------------
     * Helpers
     * --------------------------------------------------------------- */
    private static void injectService(UserLogin target,
                                      services.UserLoginService fake) throws Exception {
        Field f = UserLogin.class.getDeclaredField("userLoginService");
        f.setAccessible(true);
        f.set(target, fake);
    }

    private static final Preferences PREFS =
            Preferences.userNodeForPackage(UserLogin.class);

    @BeforeEach
    void clearPrefs() {
        PREFS.remove("user_uid");
    }

    /* ===============================================================
     * Test cases
     * =============================================================== */

    /** Verifies that saveUserSession really persists the UID. */
    @Test
    void saveUserSessionStoresUid() {
        UserLogin login = new UserLogin();
        login.saveUserSession("TEST123");
        Assertions.assertEquals("TEST123",
                PREFS.get("user_uid", null),
                "UID should be stored in java.util.prefs");
    }

    @Test
    void performLoginSuccessStoresUid() throws Exception {

        /* ---------- Arrange ---------- */
        String successJson =
                "{\"idToken\":\"abc\",\"localId\":\"UID_999\"}";
        UserLogin login = new UserLogin();
        injectService(login, new StubUserLoginService(successJson));

        /* ---------- Act ---------- */
        login.performLogin("foo@bar.com", "secret");

        /*  Give the SwingWorker time to finish.
         *  A robust production test would use a CountDownLatch or refactor
         *  the code to avoid sleeping, but here we keep it simple.         */
        Thread.sleep(300);

        /* ---------- Assert ---------- */
        Assertions.assertEquals("UID_999",
                PREFS.get("user_uid", null),
                "Successful login should write UID to preferences");
    }

    @Test
    void performLoginFailureDoesNotStoreUid() throws Exception {

        /* ---------- Arrange ---------- */
        String errorJson =
                "{\"error\":{\"message\":\"INVALID_PASSWORD\"}}";
        UserLogin login = new UserLogin();
        injectService(login, new StubUserLoginService(errorJson));

        /* ---------- Act ---------- */
        login.performLogin("foo@bar.com", "wrong‑pw");
        Thread.sleep(300);

        /* ---------- Assert ---------- */
        Assertions.assertNull(
                PREFS.get("user_uid", null),
                "UID should not be written when login fails");
    }

    @Test
    void performRegistrationSuccessStoresUid() throws Exception {

        /* ---------- Arrange ---------- */
        String successJson =
                "{\"idToken\":\"xyz\",\"localId\":\"NEW_UID\"}";
        UserLogin login = new UserLogin();
        injectService(login, new StubUserLoginService(successJson));

        /* ---------- Act ---------- */
        login.performRegistration("new@user.com",
                                  "password",
                                  UserType.VISITOR);
        Thread.sleep(300);

        /* ---------- Assert ---------- */
        Assertions.assertEquals("NEW_UID",
                PREFS.get("user_uid", null),
                "Successful registration should write UID to preferences");
    }
}