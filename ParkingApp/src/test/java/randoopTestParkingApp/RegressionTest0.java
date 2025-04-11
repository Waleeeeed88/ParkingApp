package randoopTestParkingApp;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test001");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.prepareEditing("hi!", "hi!");
        java.lang.Class<?> wildcardClass7 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        java.lang.Class<?> wildcardClass6 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.prepareEditing("hi!", "hi!");
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        java.lang.Class<?> wildcardClass4 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass4);
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        java.lang.String str12 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        bookingPage0.attemptBooking("", "hi!", "", "", "hi!", "", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptUpdateBooking("", "hi!", "", "", "", "hi!", "", "");
        bookingPage0.processLoadFunds(1.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.loadUserBalance();
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        java.lang.Class<?> wildcardClass7 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.performCheckIn("hi!", "hi!", "", "hi!", "");
        java.lang.Class<?> wildcardClass15 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptExtendBooking("", "", "");
        bookingPage0.loadSpacesForLot("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.prepareEditing("hi!", "hi!");
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "hi!", "", "hi!", "hi!");
        java.lang.Class<?> wildcardClass16 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass16);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptBooking("", "", "", "", "", "", "hi!");
        java.lang.String str18 = bookingPage0.getCurrentEndTimeForBooking("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str18);
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.loadUserBalance();
        java.lang.Class<?> wildcardClass11 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "", "hi!", "hi!", "hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.loadInitialUIData();
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.performCheckIn("hi!", "", "", "", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        java.lang.Class<?> wildcardClass17 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass17);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptBooking("", "", "", "", "", "", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        java.lang.String str19 = bookingPage0.getCurrentEndTimeForBooking("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str19);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("", "", "hi!", "", "", "hi!", "hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        bookingPage0.loadInitialUIData();
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.attemptUpdateBooking("", "hi!", "", "", "", "hi!", "", "");
        java.lang.Class<?> wildcardClass17 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass17);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.loadParkingLots();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        bookingPage0.loadUserBookings();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        java.lang.String str12 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.loadUserBalance();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.performCheckIn("", "hi!", "", "", "");
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        java.lang.String str8 = bookingPage0.prepareEditing("hi!", "");
        java.lang.Class<?> wildcardClass9 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "hi!", "");
        java.lang.String str31 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.loadUserTypeForDisplay();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str31);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        bookingPage0.loadSpacesForLot("");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.handleLogoutOrReturn();
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        java.lang.String str8 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.attemptExtendBooking("", "hi!", "");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        java.lang.Class<?> wildcardClass16 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass16);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        java.lang.String str10 = bookingPage0.prepareEditing("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str10);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "hi!", "");
        java.lang.String str31 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str31);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        bookingPage0.loadInitialUIData();
        bookingPage0.attemptBooking("hi!", "hi!", "hi!", "", "hi!", "hi!", "");
        bookingPage0.loadInitialUIData();
        java.lang.String str24 = bookingPage0.prepareEditing("hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str24);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.processLoadFunds((double) (byte) 10);
        bookingPage0.cancelBookingForSelectedSpace("hi!", "hi!");
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "hi!", "");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.attemptBooking("", "hi!", "", "hi!", "hi!", "hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.processLoadFunds((double) 1);
        bookingPage0.attemptBooking("hi!", "", "hi!", "hi!", "", "hi!", "");
        bookingPage0.loadParkingLots();
        bookingPage0.loadInitialUIData();
        bookingPage0.attemptBooking("", "", "", "hi!", "", "", "hi!");
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        bookingPage0.loadSpacesForLot("");
        bookingPage0.handleLogoutOrReturn();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.performCheckIn("", "hi!", "hi!", "hi!", "hi!");
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.cancelBookingForSelectedSpace("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        java.lang.String str12 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        java.lang.String str12 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        bookingPage0.loadUserBookings();
        bookingPage0.loadUserBalance();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "", "hi!", "hi!", "hi!", "hi!");
        bookingPage0.attemptBooking("", "", "hi!", "", "", "hi!", "hi!");
        java.lang.String str28 = bookingPage0.prepareEditing("hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str28);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "hi!");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.performCheckIn("hi!", "hi!", "", "", "hi!");
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.loadUserBookings();
        bookingPage0.loadUserTypeForDisplay();
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "", "hi!", "hi!", "hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.loadParkingLots();
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.processLoadFunds((double) 0);
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.performCheckIn("", "hi!", "hi!", "hi!", "hi!");
        java.lang.String str12 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI4 = null;
        bookingPage0.setGUIReference(bookingPageGUI4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.attemptBooking("", "", "", "hi!", "", "", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "");
        bookingPage0.handleLogoutOrReturn();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.handleLogoutOrReturn();
        java.lang.Class<?> wildcardClass9 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        java.lang.String str12 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.processLoadFunds((double) (byte) 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.performCheckIn("hi!", "hi!", "", "hi!", "");
        bookingPage0.loadParkingLots();
        bookingPage0.performCheckIn("", "hi!", "", "", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "hi!", "", "", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.loadUserBalance();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptBooking("", "", "", "", "", "", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.fetchAndDisplayBookingDetails("", "hi!");
        java.lang.String str22 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.loadParkingLots();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str22);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptBooking("", "", "", "", "", "", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        java.lang.Class<?> wildcardClass17 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass17);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        bookingPage0.loadInitialUIData();
        java.lang.String str8 = bookingPage0.getCurrentEndTimeForBooking("hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.loadInitialUIData();
        bookingPage0.loadSpacesForLot("");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.loadUserTypeForDisplay();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.loadParkingLots();
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "");
        bookingPage0.loadUserTypeForDisplay();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        bookingPage0.loadSpacesForLot("");
        bookingPage0.attemptExtendBooking("hi!", "hi!", "");
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "hi!", "hi!", "", "");
        bookingPage0.attemptExtendBooking("hi!", "hi!", "");
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.prepareEditing("hi!", "hi!");
        bookingPage0.processLoadFunds((double) (byte) 0);
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "", "hi!", "hi!", "hi!", "", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        java.lang.String str7 = bookingPage0.prepareEditing("", "hi!");
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "", "", "", "", "hi!", "");
        bookingPage0.attemptBooking("", "", "hi!", "hi!", "hi!", "hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        bookingPage0.processLoadFunds((double) '4');
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.performCheckIn("hi!", "hi!", "", "hi!", "");
        bookingPage0.loadParkingLots();
        bookingPage0.performCheckIn("", "hi!", "", "", "hi!");
        bookingPage0.loadUserBookings();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.loadInitialUIData();
        bookingPage0.loadUserBookings();
        bookingPage0.loadUserBalance();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.loadUserBalance();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        bookingPage0.loadInitialUIData();
        bookingPage0.attemptBooking("hi!", "hi!", "hi!", "", "hi!", "hi!", "");
        bookingPage0.loadUserBookings();
        bookingPage0.loadUserBookings();
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.performCheckIn("hi!", "hi!", "", "hi!", "");
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.attemptUpdateBooking("", "", "", "", "hi!", "", "", "hi!");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI29 = null;
        bookingPage0.setGUIReference(bookingPageGUI29);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI8 = null;
        bookingPage0.setGUIReference(bookingPageGUI8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.loadUserBookings();
        bookingPage0.loadParkingLots();
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.loadUserTypeForDisplay();
        java.lang.String str15 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str15);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.processLoadFunds((double) 100L);
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.processLoadFunds((double) (byte) 10);
        bookingPage0.performCheckIn("", "", "hi!", "hi!", "");
        java.lang.String str11 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str11);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.performCheckIn("", "hi!", "", "hi!", "hi!");
        bookingPage0.performCheckIn("", "hi!", "", "", "hi!");
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "", "hi!", "hi!", "hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.loadParkingLots();
        java.lang.String str22 = bookingPage0.prepareEditing("hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str22);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptBooking("", "", "", "", "", "", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.fetchAndDisplayBookingDetails("", "hi!");
        java.lang.String str22 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.attemptUpdateBooking("", "", "hi!", "", "", "hi!", "", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str22);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "hi!", "");
        bookingPage0.loadParkingLots();
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.loadParkingLots();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "hi!", "");
        bookingPage0.loadParkingLots();
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.handleLogoutOrReturn();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        java.lang.String str12 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptBooking("", "", "", "", "hi!", "hi!", "");
        java.lang.String str27 = bookingPage0.getCurrentEndTimeForBooking("hi!", "");
        bookingPage0.loadParkingLots();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str27);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.loadParkingLots();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptBooking("", "", "", "", "", "", "hi!");
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "hi!", "hi!", "", "", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        bookingPage0.loadUserBalance();
        bookingPage0.cancelBookingForSelectedSpace("hi!", "hi!");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptExtendBooking("hi!", "hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.processLoadFunds((double) 0);
        bookingPage0.attemptBooking("", "", "hi!", "", "", "hi!", "");
        bookingPage0.loadInitialUIData();
        java.lang.Class<?> wildcardClass19 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass19);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.performCheckIn("", "hi!", "hi!", "hi!", "hi!");
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.loadUserBookings();
        bookingPage0.loadUserBalance();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.processLoadFunds((double) 1);
        java.lang.String str12 = bookingPage0.getCurrentEndTimeForBooking("hi!", "");
        bookingPage0.loadUserTypeForDisplay();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        java.lang.String str12 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.prepareEditing("hi!", "hi!");
        bookingPage0.processLoadFunds((double) (byte) 0);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI9 = null;
        bookingPage0.setGUIReference(bookingPageGUI9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.prepareEditing("hi!", "hi!");
        bookingPage0.processLoadFunds((double) (byte) 0);
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "", "hi!", "hi!", "hi!", "", "hi!");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "hi!", "");
        bookingPage0.loadParkingLots();
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.performCheckIn("", "hi!", "hi!", "", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        bookingPage0.loadInitialUIData();
        bookingPage0.loadParkingLots();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.loadSpacesForLot("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "", "hi!", "hi!", "hi!", "hi!");
        java.lang.String str20 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.attemptUpdateBooking("", "hi!", "", "hi!", "hi!", "", "", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str20);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "", "hi!", "hi!", "hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        java.lang.String str21 = bookingPage0.getCurrentEndTimeForBooking("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str21);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        java.lang.String str7 = bookingPage0.prepareEditing("", "hi!");
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "", "", "", "", "hi!", "");
        bookingPage0.handleLogoutOrReturn();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        java.lang.String str8 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        java.lang.String str8 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.handleLogoutOrReturn();
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI10 = null;
        bookingPage0.setGUIReference(bookingPageGUI10);
        bookingPage0.loadSpacesForLot("");
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.prepareEditing("hi!", "hi!");
        bookingPage0.loadParkingLots();
        bookingPage0.processLoadFunds((double) '4');
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        java.lang.String str12 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "hi!", "", "", "", "");
        bookingPage0.attemptBooking("", "hi!", "hi!", "hi!", "", "hi!", "hi!");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.loadInitialUIData();
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI15 = null;
        bookingPage0.setGUIReference(bookingPageGUI15);
        bookingPage0.attemptBooking("", "", "hi!", "", "", "hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "hi!", "");
        bookingPage0.loadUserBalance();
        bookingPage0.attemptBooking("hi!", "hi!", "", "hi!", "hi!", "", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.performCheckIn("hi!", "", "", "", "hi!");
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.processLoadFunds((double) 1);
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "hi!");
        java.lang.Class<?> wildcardClass23 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass23);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.loadInitialUIData();
        bookingPage0.loadSpacesForLot("");
        bookingPage0.processLoadFunds((double) (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.attemptUpdateBooking("", "hi!", "", "hi!", "", "hi!", "hi!", "");
        java.lang.String str28 = bookingPage0.prepareEditing("hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str28);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "hi!", "");
        bookingPage0.loadParkingLots();
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.loadSpacesForLot("hi!");
        java.lang.Class<?> wildcardClass33 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass33);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.loadSpacesForLot("");
        bookingPage0.processLoadFunds((double) (byte) -1);
        bookingPage0.attemptUpdateBooking("", "", "", "hi!", "hi!", "hi!", "", "hi!");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI20 = null;
        bookingPage0.setGUIReference(bookingPageGUI20);
        java.lang.String str24 = bookingPage0.prepareEditing("", "");
        bookingPage0.loadParkingLots();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str24);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.loadSpacesForLot("");
        bookingPage0.processLoadFunds((double) (byte) -1);
        bookingPage0.attemptUpdateBooking("", "", "", "hi!", "hi!", "hi!", "", "hi!");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI20 = null;
        bookingPage0.setGUIReference(bookingPageGUI20);
        bookingPage0.handleLogoutOrReturn();
        java.lang.Class<?> wildcardClass23 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass23);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptExtendBooking("", "", "");
        bookingPage0.loadParkingLots();
        bookingPage0.performCheckIn("", "", "", "", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        java.lang.String str12 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "hi!", "", "", "", "");
        bookingPage0.loadSpacesForLot("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.processLoadFunds((double) 10L);
        bookingPage0.cancelBookingForSelectedSpace("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        java.lang.String str12 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.loadUserBookings();
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "", "", "hi!", "hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        java.lang.String str12 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "hi!");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI16 = null;
        bookingPage0.setGUIReference(bookingPageGUI16);
        java.lang.String str20 = bookingPage0.prepareEditing("", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str20);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.prepareEditing("hi!", "hi!");
        bookingPage0.processLoadFunds((double) (byte) 0);
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "", "hi!", "hi!", "hi!", "hi!");
        bookingPage0.attemptBooking("hi!", "", "", "", "hi!", "", "hi!");
        java.lang.Class<?> wildcardClass26 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass26);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "hi!", "");
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "", "", "hi!", "", "hi!");
        bookingPage0.loadInitialUIData();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        java.lang.String str8 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.attemptExtendBooking("", "hi!", "");
        bookingPage0.attemptUpdateBooking("", "hi!", "", "hi!", "hi!", "", "", "");
        bookingPage0.loadParkingLots();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "hi!", "hi!", "", "");
        java.lang.Class<?> wildcardClass32 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass32);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptBooking("", "", "", "", "", "", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.performCheckIn("", "", "hi!", "", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        java.lang.String str8 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.attemptExtendBooking("", "hi!", "");
        bookingPage0.attemptUpdateBooking("", "hi!", "", "hi!", "hi!", "", "", "");
        bookingPage0.loadParkingLots();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "hi!", "hi!", "", "");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "", "", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.performCheckIn("hi!", "", "", "", "hi!");
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.processLoadFunds((double) 1L);
        bookingPage0.attemptExtendBooking("", "", "");
        bookingPage0.loadUserTypeForDisplay();
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        bookingPage0.loadUserBalance();
        bookingPage0.cancelBookingForSelectedSpace("hi!", "hi!");
        java.lang.String str11 = bookingPage0.prepareEditing("", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        java.lang.String str16 = bookingPage0.prepareEditing("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str16);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.loadSpacesForLot("");
        bookingPage0.processLoadFunds((double) (byte) -1);
        bookingPage0.attemptUpdateBooking("", "", "", "hi!", "hi!", "hi!", "", "hi!");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI20 = null;
        bookingPage0.setGUIReference(bookingPageGUI20);
        bookingPage0.loadUserTypeForDisplay();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.loadUserBalance();
        bookingPage0.handleLogoutOrReturn();
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.processLoadFunds((double) 0);
        bookingPage0.attemptBooking("", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.processLoadFunds((double) (short) 0);
        java.lang.String str22 = bookingPage0.prepareEditing("hi!", "hi!");
        bookingPage0.loadUserBookings();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str22);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.performCheckIn("", "hi!", "", "hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.performCheckIn("", "hi!", "hi!", "hi!", "hi!");
        java.lang.String str12 = bookingPage0.prepareEditing("hi!", "hi!");
        bookingPage0.attemptBooking("hi!", "hi!", "hi!", "", "", "hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        java.lang.String str8 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.handleLogoutOrReturn();
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI10 = null;
        bookingPage0.setGUIReference(bookingPageGUI10);
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "hi!");
        bookingPage0.loadUserBalance();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.processLoadFunds((double) '#');
        java.lang.Class<?> wildcardClass11 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        java.lang.String str9 = bookingPage0.prepareEditing("hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str9);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        java.lang.String str9 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.loadUserBalance();
        bookingPage0.fetchAndDisplayBookingDetails("", "hi!");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI14 = null;
        bookingPage0.setGUIReference(bookingPageGUI14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str9);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.processLoadFunds((double) 0);
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.loadUserBookings();
        bookingPage0.performCheckIn("", "hi!", "", "", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        java.lang.String str9 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.loadUserBookings();
        bookingPage0.handleLogoutOrReturn();
        java.lang.String str14 = bookingPage0.prepareEditing("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str14);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.performCheckIn("", "", "", "hi!", "hi!");
        bookingPage0.performCheckIn("hi!", "hi!", "", "hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        java.lang.String str7 = bookingPage0.prepareEditing("", "hi!");
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "", "", "", "", "hi!", "");
        java.lang.String str19 = bookingPage0.getCurrentEndTimeForBooking("hi!", "");
        java.lang.String str22 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str22);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.performCheckIn("hi!", "hi!", "", "hi!", "");
        bookingPage0.attemptBooking("", "", "", "", "", "hi!", "hi!");
        bookingPage0.loadSpacesForLot("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.processLoadFunds((double) 0);
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        java.lang.Class<?> wildcardClass19 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass19);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        bookingPage0.loadInitialUIData();
        bookingPage0.attemptBooking("hi!", "hi!", "hi!", "", "hi!", "hi!", "");
        bookingPage0.loadUserBookings();
        bookingPage0.loadUserBookings();
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.loadInitialUIData();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        java.lang.String str7 = bookingPage0.prepareEditing("", "hi!");
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "", "", "", "", "hi!", "");
        bookingPage0.loadUserBalance();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "");
        bookingPage0.processLoadFunds((double) '4');
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.processLoadFunds((double) 0);
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.loadInitialUIData();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        java.lang.String str12 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptBooking("", "", "", "", "hi!", "hi!", "");
        java.lang.String str27 = bookingPage0.getCurrentEndTimeForBooking("hi!", "");
        bookingPage0.loadInitialUIData();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str27);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "hi!", "");
        bookingPage0.handleLogoutOrReturn();
        java.lang.String str11 = bookingPage0.prepareEditing("", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str11);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "hi!", "");
        bookingPage0.loadUserBalance();
        bookingPage0.attemptUpdateBooking("hi!", "", "", "", "hi!", "hi!", "hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.loadInitialUIData();
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI15 = null;
        bookingPage0.setGUIReference(bookingPageGUI15);
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "", "", "", "hi!", "hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.loadUserBalance();
        bookingPage0.loadInitialUIData();
        java.lang.Class<?> wildcardClass16 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass16);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.loadInitialUIData();
        bookingPage0.loadUserBalance();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "hi!", "");
        bookingPage0.loadUserBalance();
        bookingPage0.attemptBooking("", "hi!", "", "hi!", "hi!", "hi!", "hi!");
        bookingPage0.loadSpacesForLot("hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        bookingPage0.loadInitialUIData();
        java.lang.String str8 = bookingPage0.getCurrentEndTimeForBooking("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "", "hi!", "hi!", "hi!", "hi!");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI18 = null;
        bookingPage0.setGUIReference(bookingPageGUI18);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "hi!", "");
        bookingPage0.attemptBooking("", "", "hi!", "", "", "hi!", "hi!");
        bookingPage0.processLoadFunds((double) (byte) 10);
        bookingPage0.loadUserBookings();
        bookingPage0.performCheckIn("", "hi!", "hi!", "", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.loadParkingLots();
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "");
        java.lang.String str20 = bookingPage0.prepareEditing("", "hi!");
        bookingPage0.attemptBooking("", "", "", "", "", "", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str20);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.processLoadFunds((double) (short) 10);
        java.lang.String str8 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str11 = bookingPage0.prepareEditing("", "");
        java.lang.String str14 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str14);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        bookingPage0.loadInitialUIData();
        bookingPage0.loadSpacesForLot("hi!");
        java.lang.String str10 = bookingPage0.getCurrentEndTimeForBooking("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str10);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        java.lang.String str7 = bookingPage0.prepareEditing("", "hi!");
        bookingPage0.processLoadFunds((double) 0L);
        bookingPage0.loadUserBalance();
        bookingPage0.loadUserBalance();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptBooking("", "", "", "", "", "", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.fetchAndDisplayBookingDetails("", "hi!");
        bookingPage0.processLoadFunds((-1.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        java.lang.String str8 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.attemptExtendBooking("", "hi!", "");
        bookingPage0.processLoadFunds((double) '4');
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "hi!", "");
        bookingPage0.attemptBooking("", "", "hi!", "", "", "hi!", "hi!");
        bookingPage0.processLoadFunds((double) (byte) 10);
        bookingPage0.loadUserBookings();
        bookingPage0.processLoadFunds((double) 10);
        bookingPage0.loadSpacesForLot("hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        java.lang.String str12 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptBooking("", "", "", "", "hi!", "hi!", "");
        java.lang.String str27 = bookingPage0.getCurrentEndTimeForBooking("hi!", "");
        bookingPage0.performCheckIn("hi!", "", "hi!", "hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str27);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.loadInitialUIData();
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI15 = null;
        bookingPage0.setGUIReference(bookingPageGUI15);
        bookingPage0.handleLogoutOrReturn();
        java.lang.Class<?> wildcardClass18 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass18);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.loadInitialUIData();
        bookingPage0.loadSpacesForLot("");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.handleLogoutOrReturn();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.loadUserBalance();
        bookingPage0.attemptUpdateBooking("", "", "hi!", "hi!", "", "hi!", "hi!", "");
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        java.lang.String str7 = bookingPage0.prepareEditing("", "hi!");
        bookingPage0.processLoadFunds((double) 0L);
        bookingPage0.processLoadFunds(0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        bookingPage0.loadUserBalance();
        bookingPage0.cancelBookingForSelectedSpace("hi!", "hi!");
        bookingPage0.fetchAndDisplayBookingDetails("", "hi!");
        bookingPage0.cancelBookingForSelectedSpace("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptBooking("", "", "", "", "", "", "hi!");
        bookingPage0.performCheckIn("hi!", "hi!", "hi!", "hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        bookingPage0.loadSpacesForLot("");
        bookingPage0.attemptExtendBooking("hi!", "hi!", "");
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "hi!", "hi!", "", "");
        bookingPage0.performCheckIn("hi!", "hi!", "hi!", "", "hi!");
        bookingPage0.handleLogoutOrReturn();
        java.lang.String str34 = bookingPage0.prepareEditing("", "hi!");
        java.lang.Class<?> wildcardClass35 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str34);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass35);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        bookingPage0.loadUserBalance();
        bookingPage0.loadUserBookings();
        bookingPage0.performCheckIn("hi!", "", "", "hi!", "");
        bookingPage0.cancelBookingForSelectedSpace("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        java.lang.String str7 = bookingPage0.prepareEditing("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.processLoadFunds((double) 0);
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.loadUserBalance();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.loadUserBalance();
        java.lang.Class<?> wildcardClass15 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        java.lang.String str12 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "hi!");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI16 = null;
        bookingPage0.setGUIReference(bookingPageGUI16);
        bookingPage0.attemptExtendBooking("hi!", "hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.processLoadFunds((double) 1);
        java.lang.String str12 = bookingPage0.getCurrentEndTimeForBooking("hi!", "");
        java.lang.Class<?> wildcardClass13 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        java.lang.String str8 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.attemptExtendBooking("", "hi!", "");
        bookingPage0.loadParkingLots();
        java.lang.String str16 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str16);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.attemptExtendBooking("hi!", "hi!", "");
        bookingPage0.loadUserBookings();
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.processLoadFunds((double) 0);
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.loadUserBookings();
        bookingPage0.processLoadFunds(0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        bookingPage0.loadInitialUIData();
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.attemptUpdateBooking("", "hi!", "", "", "", "hi!", "", "");
        bookingPage0.performCheckIn("", "", "hi!", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.loadSpacesForLot("hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.performCheckIn("hi!", "", "", "", "hi!");
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.processLoadFunds((double) 1);
        bookingPage0.loadSpacesForLot("");
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.loadSpacesForLot("");
        bookingPage0.processLoadFunds((double) (byte) -1);
        bookingPage0.attemptUpdateBooking("", "", "", "hi!", "hi!", "hi!", "", "hi!");
        bookingPage0.handleLogoutOrReturn();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "hi!", "");
        java.lang.String str31 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.loadSpacesForLot("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str31);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.attemptUpdateBooking("", "", "hi!", "hi!", "", "hi!", "", "");
        bookingPage0.loadUserBookings();
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.handleLogoutOrReturn();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.processLoadFunds((double) 0);
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        bookingPage0.attemptBooking("", "", "", "", "hi!", "", "hi!");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.loadUserBalance();
        bookingPage0.loadSpacesForLot("");
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.fetchAndDisplayBookingDetails("", "hi!");
        bookingPage0.loadUserBalance();
        bookingPage0.performCheckIn("hi!", "", "hi!", "hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.fetchAndDisplayBookingDetails("", "hi!");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        bookingPage0.attemptUpdateBooking("hi!", "", "", "hi!", "hi!", "hi!", "hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.loadInitialUIData();
        bookingPage0.performCheckIn("", "", "", "hi!", "hi!");
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        bookingPage0.loadInitialUIData();
        bookingPage0.attemptBooking("hi!", "hi!", "hi!", "", "hi!", "hi!", "");
        bookingPage0.loadUserBookings();
        bookingPage0.loadUserTypeForDisplay();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        bookingPage0.loadInitialUIData();
        bookingPage0.attemptBooking("hi!", "hi!", "hi!", "", "hi!", "hi!", "");
        bookingPage0.attemptUpdateBooking("", "", "hi!", "hi!", "hi!", "", "hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.performCheckIn("hi!", "hi!", "", "hi!", "");
        bookingPage0.loadParkingLots();
        bookingPage0.performCheckIn("", "hi!", "", "", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.processLoadFunds((double) (byte) 10);
        bookingPage0.loadUserBalance();
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.performCheckIn("hi!", "", "", "", "hi!");
        bookingPage0.attemptBooking("", "", "", "", "", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.attemptBooking("hi!", "hi!", "", "", "", "", "");
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.processLoadFunds((double) 0);
        bookingPage0.attemptBooking("", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.processLoadFunds((double) (short) 0);
        bookingPage0.loadSpacesForLot("hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.loadSpacesForLot("");
        bookingPage0.processLoadFunds((double) (byte) -1);
        bookingPage0.attemptUpdateBooking("", "", "", "hi!", "hi!", "hi!", "", "hi!");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI20 = null;
        bookingPage0.setGUIReference(bookingPageGUI20);
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "hi!", "hi!", "", "hi!", "hi!");
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        bookingPage0.loadInitialUIData();
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.attemptUpdateBooking("", "hi!", "", "", "", "hi!", "", "");
        bookingPage0.performCheckIn("", "", "hi!", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.loadInitialUIData();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.performCheckIn("hi!", "hi!", "", "hi!", "");
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.attemptExtendBooking("", "", "hi!");
        bookingPage0.attemptBooking("hi!", "hi!", "", "hi!", "hi!", "hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.performCheckIn("", "hi!", "hi!", "hi!", "hi!");
        bookingPage0.loadSpacesForLot("hi!");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptUpdateBooking("", "", "hi!", "hi!", "hi!", "", "", "hi!");
        bookingPage0.performCheckIn("hi!", "", "", "", "hi!");
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.prepareEditing("hi!", "hi!");
        bookingPage0.processLoadFunds((double) (byte) 0);
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "", "hi!", "hi!", "hi!", "", "hi!");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        java.lang.String str12 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "hi!", "", "", "", "");
        bookingPage0.loadParkingLots();
        bookingPage0.performCheckIn("", "hi!", "hi!", "hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.loadSpacesForLot("");
        bookingPage0.processLoadFunds((double) (byte) -1);
        bookingPage0.loadUserBookings();
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "", "hi!", "hi!", "hi!", "hi!");
        java.lang.String str20 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.attemptUpdateBooking("hi!", "", "", "hi!", "", "", "", "hi!");
        bookingPage0.loadUserBalance();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str20);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        java.lang.String str8 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.handleLogoutOrReturn();
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI10 = null;
        bookingPage0.setGUIReference(bookingPageGUI10);
        java.lang.Class<?> wildcardClass12 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass12);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.loadInitialUIData();
        bookingPage0.loadUserBookings();
        bookingPage0.loadParkingLots();
        bookingPage0.loadSpacesForLot("hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.attemptBooking("", "", "hi!", "hi!", "", "", "");
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.processLoadFunds((double) 0);
        bookingPage0.attemptBooking("", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.processLoadFunds((double) (short) 0);
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        java.lang.String str7 = bookingPage0.prepareEditing("", "hi!");
        bookingPage0.processLoadFunds((double) 0L);
        bookingPage0.loadUserBalance();
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        java.lang.String str9 = bookingPage0.getCurrentEndTimeForBooking("hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str9);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        java.lang.String str7 = bookingPage0.prepareEditing("", "hi!");
        bookingPage0.handleLogoutOrReturn();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.loadUserTypeForDisplay();
        java.lang.String str15 = bookingPage0.prepareEditing("", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str15);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptUpdateBooking("", "hi!", "", "", "", "hi!", "", "");
        bookingPage0.loadUserBalance();
        bookingPage0.loadUserTypeForDisplay();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        java.lang.String str9 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.loadUserBookings();
        java.lang.String str13 = bookingPage0.prepareEditing("hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str13);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.attemptExtendBooking("hi!", "", "");
        bookingPage0.loadUserBookings();
        bookingPage0.attemptExtendBooking("", "hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "hi!", "");
        bookingPage0.attemptBooking("", "", "hi!", "", "", "hi!", "hi!");
        bookingPage0.processLoadFunds((double) (byte) 10);
        bookingPage0.loadUserBookings();
        bookingPage0.loadUserBookings();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptExtendBooking("", "", "");
        bookingPage0.loadParkingLots();
        bookingPage0.loadUserBalance();
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI15 = null;
        bookingPage0.setGUIReference(bookingPageGUI15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.performCheckIn("hi!", "", "", "", "hi!");
        bookingPage0.attemptBooking("", "", "", "", "", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.handleLogoutOrReturn();
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.performCheckIn("", "hi!", "", "hi!", "hi!");
        bookingPage0.loadUserBookings();
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "hi!");
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.processLoadFunds((double) (short) 10);
        java.lang.String str8 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.attemptExtendBooking("", "", "");
        bookingPage0.loadUserBalance();
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        bookingPage0.processLoadFunds((double) (short) -1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str8);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "hi!");
        java.lang.String str12 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str12);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.attemptExtendBooking("hi!", "", "");
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        java.lang.String str8 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.attemptExtendBooking("", "hi!", "");
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        java.lang.String str18 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str18);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.loadParkingLots();
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "");
        java.lang.String str20 = bookingPage0.prepareEditing("", "hi!");
        bookingPage0.loadUserBalance();
        java.lang.Class<?> wildcardClass22 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass22);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.attemptBooking("", "hi!", "hi!", "", "", "", "hi!");
        java.lang.String str17 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str17);
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.loadParkingLots();
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "");
        java.lang.String str20 = bookingPage0.prepareEditing("", "hi!");
        bookingPage0.loadUserBalance();
        bookingPage0.attemptBooking("hi!", "", "", "", "", "", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str20);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.prepareEditing("hi!", "hi!");
        bookingPage0.loadInitialUIData();
        bookingPage0.loadUserBalance();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.loadUserBalance();
        bookingPage0.loadUserBookings();
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.performCheckIn("", "hi!", "", "hi!", "hi!");
        java.lang.String str9 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str9);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.attemptExtendBooking("hi!", "", "");
        bookingPage0.loadUserBookings();
        bookingPage0.attemptExtendBooking("hi!", "", "");
        bookingPage0.performCheckIn("", "", "hi!", "hi!", "");
        bookingPage0.fetchAndDisplayBookingDetails("", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        java.lang.String str7 = bookingPage0.prepareEditing("", "hi!");
        bookingPage0.cancelBookingForSelectedSpace("", "hi!");
        bookingPage0.loadInitialUIData();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str7);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        java.lang.String str8 = bookingPage0.prepareEditing("hi!", "");
        bookingPage0.attemptExtendBooking("", "hi!", "");
        bookingPage0.attemptUpdateBooking("", "hi!", "", "hi!", "hi!", "", "", "");
        bookingPage0.loadParkingLots();
        bookingPage0.loadSpacesForLot("");
        bookingPage0.loadParkingLots();
        java.lang.String str28 = bookingPage0.prepareEditing("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str28);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.processLoadFunds((double) 0);
        bookingPage0.cancelBookingForSelectedSpace("hi!", "");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.attemptBooking("", "", "", "", "", "", "hi!");
        bookingPage0.handleLogoutOrReturn();
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI23 = null;
        bookingPage0.setGUIReference(bookingPageGUI23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "", "hi!", "hi!", "hi!", "hi!");
        bookingPage0.performCheckIn("", "hi!", "hi!", "", "hi!");
        java.lang.Class<?> wildcardClass24 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass24);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        bookingPage0.loadSpacesForLot("");
        bookingPage0.attemptExtendBooking("hi!", "hi!", "");
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "hi!", "hi!", "", "");
        bookingPage0.attemptUpdateBooking("hi!", "", "", "hi!", "hi!", "", "", "");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.loadParkingLots();
        bookingPage0.processLoadFunds((double) 'a');
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptBooking("", "", "", "", "", "", "hi!");
        java.lang.String str18 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.fetchAndDisplayBookingDetails("hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str18);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.processLoadFunds((double) 0);
        bookingPage0.attemptBooking("", "", "hi!", "", "", "hi!", "");
        bookingPage0.loadInitialUIData();
        bookingPage0.loadUserBookings();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.attemptUpdateBooking("hi!", "hi!", "hi!", "hi!", "", "hi!", "", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "hi!", "");
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "", "", "hi!", "", "hi!");
        bookingPage0.loadParkingLots();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.prepareEditing("hi!", "hi!");
        bookingPage0.loadParkingLots();
        bookingPage0.loadInitialUIData();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.loadInitialUIData();
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI15 = null;
        bookingPage0.setGUIReference(bookingPageGUI15);
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.loadParkingLots();
        bookingPage0.loadUserBookings();
        java.lang.String str22 = bookingPage0.prepareEditing("", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str22);
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.loadUserBalance();
        java.lang.String str17 = bookingPage0.prepareEditing("", "hi!");
        bookingPage0.loadInitialUIData();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str17);
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.cancelBookingForSelectedSpace("", "");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.attemptUpdateBooking("", "hi!", "hi!", "", "hi!", "hi!", "hi!", "hi!");
        bookingPage0.attemptBooking("hi!", "", "", "", "hi!", "", "hi!");
        java.lang.String str28 = bookingPage0.getCurrentEndTimeForBooking("hi!", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str28);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptExtendBooking("hi!", "hi!", "");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.loadUserTypeForDisplay();
        bookingPage0.loadParkingLots();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.processLoadFunds(10.0d);
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI6 = null;
        bookingPage0.setGUIReference(bookingPageGUI6);
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.loadSpacesForLot("hi!");
        bookingPage0.attemptExtendBooking("", "hi!", "hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "", "", "hi!", "");
        bookingPage0.loadSpacesForLot("");
        bookingPage0.attemptExtendBooking("hi!", "hi!", "");
        bookingPage0.attemptUpdateBooking("hi!", "", "hi!", "", "hi!", "hi!", "", "");
        bookingPage0.attemptUpdateBooking("hi!", "", "", "hi!", "hi!", "", "", "");
        bookingPage0.loadUserBalance();
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.loadParkingLots();
        bookingPage0.loadUserBalance();
        bookingPage0.cancelBookingForSelectedSpace("hi!", "hi!");
        bookingPage0.loadInitialUIData();
        bookingPage0.loadUserBalance();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        java.lang.String str6 = bookingPage0.getCurrentEndTimeForBooking("hi!", "hi!");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.fetchAndDisplayBookingDetails("", "");
        bookingPage0.handleLogoutOrReturn();
        bookingPage0.loadUserBookings();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str6);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        com.parkingapp.GUI.BookingPage bookingPage0 = new com.parkingapp.GUI.BookingPage();
        java.lang.String str3 = bookingPage0.getCurrentEndTimeForBooking("", "hi!");
        bookingPage0.attemptBooking("hi!", "", "hi!", "", "hi!", "", "");
        com.parkingapp.GUI.BookingPageGUI bookingPageGUI12 = null;
        bookingPage0.setGUIReference(bookingPageGUI12);
        bookingPage0.attemptExtendBooking("hi!", "", "");
        java.lang.Class<?> wildcardClass18 = bookingPage0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(str3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass18);
    }
}

