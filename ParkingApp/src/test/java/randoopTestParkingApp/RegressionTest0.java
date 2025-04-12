package randoopTestParkingApp;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test01");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getParentId();
        parkingSpace2.disable();
        parkingSpace2.carLeaves();
        boolean boolean6 = parkingSpace2.isOccupied();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test02");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("", "hi!");
        java.lang.String str3 = parkingSpace2.getParentId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test03");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("", "hi!");
        boolean boolean3 = parkingSpace2.isEnabled();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test04");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getId();
        boolean boolean4 = parkingSpace2.isEnabled();
        boolean boolean5 = parkingSpace2.isEnabled();
        boolean boolean6 = parkingSpace2.isOccupied();
        boolean boolean7 = parkingSpace2.isOccupied();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test05");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getParentId();
        parkingSpace2.disable();
        java.lang.String str5 = parkingSpace2.getParentId();
        boolean boolean6 = parkingSpace2.isEnabled();
        parkingSpace2.carLeaves();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "hi!" + "'", str5.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test06");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("", "hi!");
        java.time.LocalDateTime localDateTime4 = null;
        // The following exception was thrown during execution in test generation
        try {
            parkingSpace2.carEnters("hi!", localDateTime4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.plusHours(long)\" because \"bookingStartTime\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test07");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        parkingSpace2.carLeaves();
        boolean boolean4 = parkingSpace2.isOccupied();
        java.lang.Class<?> wildcardClass5 = parkingSpace2.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test08");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getId();
        boolean boolean4 = parkingSpace2.isEnabled();
        boolean boolean5 = parkingSpace2.isEnabled();
        boolean boolean6 = parkingSpace2.isOccupied();
        java.time.LocalDateTime localDateTime8 = null;
        // The following exception was thrown during execution in test generation
        try {
            parkingSpace2.carEnters("", localDateTime8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.plusHours(long)\" because \"bookingStartTime\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test09");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getParentId();
        boolean boolean4 = parkingSpace2.isEnabled();
        parkingSpace2.carLeaves();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test10");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getId();
        boolean boolean4 = parkingSpace2.isEnabled();
        boolean boolean5 = parkingSpace2.isEnabled();
        java.time.LocalDateTime localDateTime7 = null;
        // The following exception was thrown during execution in test generation
        try {
            parkingSpace2.carEnters("", localDateTime7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.plusHours(long)\" because \"bookingStartTime\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
    }

    @Test
    public void test11() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test11");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getId();
        boolean boolean4 = parkingSpace2.isEnabled();
        java.lang.String str5 = parkingSpace2.getId();
        java.time.LocalDateTime localDateTime7 = null;
        // The following exception was thrown during execution in test generation
        try {
            parkingSpace2.carEnters("hi!", localDateTime7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.plusHours(long)\" because \"bookingStartTime\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "hi!" + "'", str5.equals("hi!"));
    }

    @Test
    public void test12() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test12");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getId();
        boolean boolean4 = parkingSpace2.isEnabled();
        java.lang.String str5 = parkingSpace2.getId();
        java.time.LocalDateTime localDateTime7 = null;
        // The following exception was thrown during execution in test generation
        try {
            parkingSpace2.carEnters("", localDateTime7);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.plusHours(long)\" because \"bookingStartTime\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "hi!" + "'", str5.equals("hi!"));
    }

    @Test
    public void test13() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test13");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getParentId();
        java.lang.String str4 = parkingSpace2.getParentId();
        java.time.LocalDateTime localDateTime6 = null;
        // The following exception was thrown during execution in test generation
        try {
            parkingSpace2.carEnters("hi!", localDateTime6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.plusHours(long)\" because \"bookingStartTime\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "hi!" + "'", str4.equals("hi!"));
    }

    @Test
    public void test14() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test14");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getParentId();
        parkingSpace2.disable();
        java.lang.String str5 = parkingSpace2.getParentId();
        boolean boolean6 = parkingSpace2.isEnabled();
        parkingSpace2.enable();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "hi!" + "'", str5.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test15() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test15");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("", "hi!");
        java.time.LocalDateTime localDateTime4 = null;
        // The following exception was thrown during execution in test generation
        try {
            parkingSpace2.carEnters("", localDateTime4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"java.time.LocalDateTime.plusHours(long)\" because \"bookingStartTime\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test16() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test16");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getParentId();
        parkingSpace2.disable();
        java.lang.String str5 = parkingSpace2.getParentId();
        java.lang.String str6 = parkingSpace2.getId();
        java.time.LocalDateTime localDateTime8 = null;
        parkingSpace2.carEnters("", localDateTime8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "hi!" + "'", str5.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "hi!" + "'", str6.equals("hi!"));
    }

    @Test
    public void test17() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test17");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getId();
        boolean boolean4 = parkingSpace2.isEnabled();
        java.lang.String str5 = parkingSpace2.getId();
        java.lang.Class<?> wildcardClass6 = parkingSpace2.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "hi!" + "'", str5.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass6);
    }

    @Test
    public void test18() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test18");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "");
        parkingSpace2.enable();
    }

    @Test
    public void test19() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test19");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getParentId();
        parkingSpace2.disable();
        java.lang.String str5 = parkingSpace2.getParentId();
        boolean boolean6 = parkingSpace2.isEnabled();
        java.lang.Class<?> wildcardClass7 = parkingSpace2.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "hi!" + "'", str5.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test20() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test20");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        parkingSpace2.carLeaves();
        boolean boolean4 = parkingSpace2.isOccupied();
        parkingSpace2.disable();
        java.lang.String str6 = parkingSpace2.getId();
        boolean boolean7 = parkingSpace2.isOccupied();
        parkingSpace2.carLeaves();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "hi!" + "'", str6.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test21() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test21");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getParentId();
        java.lang.String str4 = parkingSpace2.getParentId();
        parkingSpace2.enable();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "hi!" + "'", str4.equals("hi!"));
    }

    @Test
    public void test22() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test22");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getParentId();
        java.lang.String str4 = parkingSpace2.getParentId();
        parkingSpace2.carLeaves();
        parkingSpace2.carLeaves();
        boolean boolean7 = parkingSpace2.isOccupied();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "hi!" + "'", str4.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
    }

    @Test
    public void test23() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test23");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getId();
        boolean boolean4 = parkingSpace2.isEnabled();
        java.lang.String str5 = parkingSpace2.getId();
        java.lang.String str6 = parkingSpace2.getParentId();
        parkingSpace2.carLeaves();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "hi!" + "'", str5.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "hi!" + "'", str6.equals("hi!"));
    }

    @Test
    public void test24() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test24");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("hi!", "hi!");
        java.lang.String str3 = parkingSpace2.getParentId();
        java.lang.String str4 = parkingSpace2.getParentId();
        boolean boolean5 = parkingSpace2.isEnabled();
        boolean boolean6 = parkingSpace2.isOccupied();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "hi!" + "'", str3.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "hi!" + "'", str4.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + true + "'", boolean5 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test25() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test25");
        com.parkingapp.parkingObjects.ParkingSpace parkingSpace2 = new com.parkingapp.parkingObjects.ParkingSpace("", "");
    }
}

