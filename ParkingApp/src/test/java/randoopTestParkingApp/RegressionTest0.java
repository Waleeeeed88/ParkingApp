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
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) (short) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            com.parkingapp.PaymentRates.RateCalculationStrategy rateCalculationStrategy1 = com.parkingapp.PaymentRates.getStrategy(userType0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) (short) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        java.lang.Class<?> wildcardClass1 = facultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) (byte) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        com.parkingapp.PaymentRates paymentRates0 = new com.parkingapp.PaymentRates();
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) ' ');
        java.lang.Class<?> wildcardClass11 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 160.0d + "'", double10 == 160.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        java.lang.Class<?> wildcardClass1 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        java.lang.Class<?> wildcardClass7 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, 1L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, 100L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, 0L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) (byte) 10);
        double double10 = studentRateStrategy0.calculateCost(250.0d);
        java.lang.Class<?> wildcardClass11 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1250.0d + "'", double10 == 1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        java.lang.Class<?> wildcardClass1 = visitorRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (short) -1);
        java.lang.Class<?> wildcardClass5 = visitorRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-15.0d) + "'", double4 == (-15.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) (-1));
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) 'a');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 1);
        double double6 = facultyRateStrategy0.calculateCost(10.0d);
        double double8 = facultyRateStrategy0.calculateCost((double) 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 80.0d + "'", double6 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 80.0d + "'", double8 == 80.0d);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        java.lang.Class<?> wildcardClass9 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((double) ' ');
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 320.0d + "'", double8 == 320.0d);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double8 = nonFacultyRateStrategy0.calculateCost((double) (short) 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 37500.0d + "'", double4 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 970.0d + "'", double6 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 100.0d + "'", double8 == 100.0d);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(320.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1600.0d + "'", double6 == 1600.0d);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost((double) 1L);
        java.lang.Class<?> wildcardClass3 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 5.0d + "'", double2 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost((double) 0.0f);
        double double4 = facultyRateStrategy0.calculateCost((double) 100L);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 800.0d + "'", double4 == 800.0d);
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 800.0d + "'", double4 == 800.0d);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 1);
        double double6 = facultyRateStrategy0.calculateCost(10.0d);
        java.lang.Class<?> wildcardClass7 = facultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 80.0d + "'", double6 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost(175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 875.0d + "'", double10 == 875.0d);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        java.lang.Class<?> wildcardClass7 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 37500.0d + "'", double4 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 970.0d + "'", double6 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost((double) (short) 10);
        double double6 = nonFacultyRateStrategy0.calculateCost(120.0d);
        java.lang.Class<?> wildcardClass7 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 100.0d + "'", double4 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1200.0d + "'", double6 == 1200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost((double) (-1));
        double double6 = visitorRateStrategy0.calculateCost(10000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-15.0d) + "'", double4 == (-15.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 150000.0d + "'", double6 == 150000.0d);
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, 10L);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) (byte) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) (byte) 10);
        double double10 = studentRateStrategy0.calculateCost(250.0d);
        double double12 = studentRateStrategy0.calculateCost(150000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1250.0d + "'", double10 == 1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 750000.0d + "'", double12 == 750000.0d);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) (short) 1);
        java.lang.Class<?> wildcardClass11 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 5.0d + "'", double10 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (byte) 10);
        double double6 = visitorRateStrategy0.calculateCost((double) (short) 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 150.0d + "'", double4 == 150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1500.0d + "'", double6 == 1500.0d);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(8.0d);
        java.lang.Class<?> wildcardClass5 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 80.0d + "'", double4 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 1750.0d + "'", double4 == 1750.0d);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) ' ');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost((double) (short) 10);
        double double6 = nonFacultyRateStrategy0.calculateCost(120.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost(0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 100.0d + "'", double4 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1200.0d + "'", double6 == 1200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 0.0d + "'", double8 == 0.0d);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) 100);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-8.0d) + "'", double4 == (-8.0d));
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((double) 0L);
        double double10 = nonFacultyRateStrategy0.calculateCost(15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 0.0d + "'", double8 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 150.0d + "'", double10 == 150.0d);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((-10.0d));
        double double6 = facultyRateStrategy0.calculateCost(600.0d);
        java.lang.Class<?> wildcardClass7 = facultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-80.0d) + "'", double4 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 4800.0d + "'", double6 == 4800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) '#');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (byte) 10);
        double double6 = visitorRateStrategy0.calculateCost((double) ' ');
        double double8 = visitorRateStrategy0.calculateCost((double) 1L);
        double double10 = visitorRateStrategy0.calculateCost(1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 150.0d + "'", double4 == 150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 480.0d + "'", double6 == 480.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 15.0d + "'", double8 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 18750.0d + "'", double10 == 18750.0d);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (short) -1);
        double double6 = visitorRateStrategy0.calculateCost(5.0d);
        double double8 = visitorRateStrategy0.calculateCost((double) 0L);
        double double10 = visitorRateStrategy0.calculateCost((double) ' ');
        java.lang.Class<?> wildcardClass11 = visitorRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-15.0d) + "'", double4 == (-15.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 75.0d + "'", double6 == 75.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 0.0d + "'", double8 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 480.0d + "'", double10 == 480.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 800.0d + "'", double4 == 800.0d);
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) (byte) 10);
        double double10 = studentRateStrategy0.calculateCost(250.0d);
        double double12 = studentRateStrategy0.calculateCost(3750.0d);
        double double14 = studentRateStrategy0.calculateCost(0.0d);
        double double16 = studentRateStrategy0.calculateCost(10.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1250.0d + "'", double10 == 1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 18750.0d + "'", double12 == 18750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 0.0d + "'", double14 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 50.0d + "'", double16 == 50.0d);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost((double) 0.0f);
        java.lang.Class<?> wildcardClass5 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        java.lang.Class<?> wildcardClass5 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) 0);
        double double8 = studentRateStrategy0.calculateCost(50.0d);
        double double10 = studentRateStrategy0.calculateCost((double) (short) 0);
        double double12 = studentRateStrategy0.calculateCost(6240.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 250.0d + "'", double8 == 250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 31200.0d + "'", double12 == 31200.0d);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((-10.0d));
        double double6 = facultyRateStrategy0.calculateCost((double) '4');
        double double8 = facultyRateStrategy0.calculateCost(500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-80.0d) + "'", double4 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 416.0d + "'", double6 == 416.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 4000.0d + "'", double8 == 4000.0d);
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 10);
        double double10 = studentRateStrategy0.calculateCost((double) (short) -1);
        double double12 = studentRateStrategy0.calculateCost(75.0d);
        double double14 = studentRateStrategy0.calculateCost(1500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-5.0d) + "'", double10 == (-5.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 375.0d + "'", double12 == 375.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 7500.0d + "'", double14 == 7500.0d);
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) (byte) 10);
        double double10 = studentRateStrategy0.calculateCost(250.0d);
        double double12 = studentRateStrategy0.calculateCost(3750.0d);
        double double14 = studentRateStrategy0.calculateCost((-1.0d));
        double double16 = studentRateStrategy0.calculateCost(175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1250.0d + "'", double10 == 1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 18750.0d + "'", double12 == 18750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + (-5.0d) + "'", double14 == (-5.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 875.0d + "'", double16 == 875.0d);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (short) -1);
        double double6 = visitorRateStrategy0.calculateCost(1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-15.0d) + "'", double4 == (-15.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 18750.0d + "'", double6 == 18750.0d);
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(8.0d);
        double double6 = visitorRateStrategy0.calculateCost(0.0d);
        double double8 = visitorRateStrategy0.calculateCost((-15.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 120.0d + "'", double4 == 120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-225.0d) + "'", double8 == (-225.0d));
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 10);
        double double10 = studentRateStrategy0.calculateCost((double) (short) -1);
        double double12 = studentRateStrategy0.calculateCost(75.0d);
        java.lang.Class<?> wildcardClass13 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-5.0d) + "'", double10 == (-5.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 375.0d + "'", double12 == 375.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (short) -1);
        double double6 = visitorRateStrategy0.calculateCost(5.0d);
        double double8 = visitorRateStrategy0.calculateCost((double) 10.0f);
        double double10 = visitorRateStrategy0.calculateCost((double) (-1L));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-15.0d) + "'", double4 == (-15.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 75.0d + "'", double6 == 75.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 150.0d + "'", double8 == 150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-15.0d) + "'", double10 == (-15.0d));
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost((double) 1);
        double double4 = facultyRateStrategy0.calculateCost(15.0d);
        double double6 = facultyRateStrategy0.calculateCost(1000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 8.0d + "'", double2 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 120.0d + "'", double4 == 120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 8000.0d + "'", double6 == 8000.0d);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost((double) (short) 0);
        double double6 = nonFacultyRateStrategy0.calculateCost(600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 6000.0d + "'", double6 == 6000.0d);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) 0);
        double double8 = studentRateStrategy0.calculateCost((double) 0);
        double double10 = studentRateStrategy0.calculateCost(1200.0d);
        double double12 = studentRateStrategy0.calculateCost((double) (byte) 100);
        java.lang.Class<?> wildcardClass13 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 0.0d + "'", double8 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 6000.0d + "'", double10 == 6000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 500.0d + "'", double12 == 500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(416.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 4160.0d + "'", double6 == 4160.0d);
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(8.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((double) (short) 0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 80.0d + "'", double4 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 0.0d + "'", double8 == 0.0d);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        java.lang.Class<?> wildcardClass9 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 970.0d + "'", double8 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (short) -1);
        double double6 = visitorRateStrategy0.calculateCost(5.0d);
        double double8 = visitorRateStrategy0.calculateCost((double) 0L);
        double double10 = visitorRateStrategy0.calculateCost((double) 0);
        double double12 = visitorRateStrategy0.calculateCost(6240.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-15.0d) + "'", double4 == (-15.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 75.0d + "'", double6 == 75.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 0.0d + "'", double8 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 93600.0d + "'", double12 == 93600.0d);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost((double) (short) 10);
        double double6 = nonFacultyRateStrategy0.calculateCost(120.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double10 = nonFacultyRateStrategy0.calculateCost(10.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 100.0d + "'", double4 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1200.0d + "'", double6 == 1200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-10.0d) + "'", double8 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 100.0d + "'", double10 == 100.0d);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost((double) (short) 10);
        double double6 = nonFacultyRateStrategy0.calculateCost(120.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost(120.0d);
        double double10 = nonFacultyRateStrategy0.calculateCost((double) '#');
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 100.0d + "'", double4 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1200.0d + "'", double6 == 1200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 1200.0d + "'", double8 == 1200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 350.0d + "'", double10 == 350.0d);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (byte) 10);
        double double6 = visitorRateStrategy0.calculateCost((double) ' ');
        double double8 = visitorRateStrategy0.calculateCost((double) 1L);
        java.lang.Class<?> wildcardClass9 = visitorRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 150.0d + "'", double4 == 150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 480.0d + "'", double6 == 480.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 15.0d + "'", double8 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 1);
        java.lang.Class<?> wildcardClass5 = facultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost(600.0d);
        java.lang.Class<?> wildcardClass9 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 6000.0d + "'", double8 == 6000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost((double) 0.0f);
        double double4 = facultyRateStrategy0.calculateCost(3750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 30000.0d + "'", double4 == 30000.0d);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) 1);
        java.lang.Class<?> wildcardClass11 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 5.0d + "'", double10 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((-10.0d));
        double double6 = facultyRateStrategy0.calculateCost(600.0d);
        double double8 = facultyRateStrategy0.calculateCost(1600.0d);
        double double10 = facultyRateStrategy0.calculateCost(6208.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-80.0d) + "'", double4 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 4800.0d + "'", double6 == 4800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 12800.0d + "'", double8 == 12800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 49664.0d + "'", double10 == 49664.0d);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost((double) (short) 10);
        double double6 = nonFacultyRateStrategy0.calculateCost(120.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost(485.0d);
        double double10 = nonFacultyRateStrategy0.calculateCost((-8.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 100.0d + "'", double4 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1200.0d + "'", double6 == 1200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 4850.0d + "'", double8 == 4850.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-80.0d) + "'", double10 == (-80.0d));
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (short) -1);
        double double6 = visitorRateStrategy0.calculateCost(5.0d);
        double double8 = visitorRateStrategy0.calculateCost((double) 0L);
        double double10 = visitorRateStrategy0.calculateCost((double) ' ');
        double double12 = visitorRateStrategy0.calculateCost(120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-15.0d) + "'", double4 == (-15.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 75.0d + "'", double6 == 75.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 0.0d + "'", double8 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 480.0d + "'", double10 == 480.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 1800.0d + "'", double12 == 1800.0d);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 1);
        double double6 = facultyRateStrategy0.calculateCost((double) (short) 0);
        double double8 = facultyRateStrategy0.calculateCost(1250.0d);
        double double10 = facultyRateStrategy0.calculateCost(0.0d);
        java.lang.Class<?> wildcardClass11 = facultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 10000.0d + "'", double8 == 10000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(75.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost(6000000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 7500.0d + "'", double4 == 7500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 750.0d + "'", double6 == 750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 6.0E7d + "'", double8 == 6.0E7d);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double10 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double12 = nonFacultyRateStrategy0.calculateCost((double) 100);
        double double14 = nonFacultyRateStrategy0.calculateCost(485.0d);
        java.lang.Class<?> wildcardClass15 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 970.0d + "'", double8 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 1000.0d + "'", double12 == 1000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 4850.0d + "'", double14 == 4850.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) (byte) 10);
        double double10 = studentRateStrategy0.calculateCost(250.0d);
        double double12 = studentRateStrategy0.calculateCost(3750.0d);
        double double14 = studentRateStrategy0.calculateCost((-1.0d));
        double double16 = studentRateStrategy0.calculateCost((double) (byte) 1);
        java.lang.Class<?> wildcardClass17 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1250.0d + "'", double10 == 1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 18750.0d + "'", double12 == 18750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + (-5.0d) + "'", double14 == (-5.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 5.0d + "'", double16 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass17);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost((-1.0d));
        double double8 = nonFacultyRateStrategy0.calculateCost(15.0d);
        double double10 = nonFacultyRateStrategy0.calculateCost(800000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 7500.0d + "'", double4 == 7500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + (-10.0d) + "'", double6 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 150.0d + "'", double8 == 150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 8000000.0d + "'", double10 == 8000000.0d);
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(1.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 5.0d + "'", double6 == 5.0d);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(1.0d);
        java.lang.Class<?> wildcardClass3 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 10.0d + "'", double2 == 10.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(1.0d);
        double double6 = visitorRateStrategy0.calculateCost((double) (byte) 100);
        double double8 = visitorRateStrategy0.calculateCost((double) 10);
        double double10 = visitorRateStrategy0.calculateCost(48500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 15.0d + "'", double4 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1500.0d + "'", double6 == 1500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 150.0d + "'", double8 == 150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 727500.0d + "'", double10 == 727500.0d);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) 0);
        double double8 = studentRateStrategy0.calculateCost(50.0d);
        double double10 = studentRateStrategy0.calculateCost(100.0d);
        double double12 = studentRateStrategy0.calculateCost((double) 100L);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 250.0d + "'", double8 == 250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 500.0d + "'", double10 == 500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 500.0d + "'", double12 == 500.0d);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (byte) 10);
        double double6 = visitorRateStrategy0.calculateCost(1.0d);
        double double8 = visitorRateStrategy0.calculateCost((-5.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 150.0d + "'", double4 == 150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 15.0d + "'", double6 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-75.0d) + "'", double8 == (-75.0d));
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((-10.0d));
        double double6 = facultyRateStrategy0.calculateCost((double) '4');
        double double8 = facultyRateStrategy0.calculateCost((double) (byte) -1);
        double double10 = facultyRateStrategy0.calculateCost(0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-80.0d) + "'", double4 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 416.0d + "'", double6 == 416.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-8.0d) + "'", double8 == (-8.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(8.0d);
        double double6 = visitorRateStrategy0.calculateCost(250.0d);
        double double8 = visitorRateStrategy0.calculateCost(40.0d);
        double double10 = visitorRateStrategy0.calculateCost(500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 120.0d + "'", double4 == 120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 3750.0d + "'", double6 == 3750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 600.0d + "'", double8 == 600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 7500.0d + "'", double10 == 7500.0d);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (short) -1);
        double double6 = visitorRateStrategy0.calculateCost((double) ' ');
        double double8 = visitorRateStrategy0.calculateCost(72750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-15.0d) + "'", double4 == (-15.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 480.0d + "'", double6 == 480.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 1091250.0d + "'", double8 == 1091250.0d);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost((double) 1);
        double double4 = facultyRateStrategy0.calculateCost(0.0d);
        double double6 = facultyRateStrategy0.calculateCost(0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 8.0d + "'", double2 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost((double) (short) 10);
        double double6 = nonFacultyRateStrategy0.calculateCost(120.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost(485.0d);
        double double10 = nonFacultyRateStrategy0.calculateCost(49664.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 100.0d + "'", double4 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1200.0d + "'", double6 == 1200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 4850.0d + "'", double8 == 4850.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 496640.0d + "'", double10 == 496640.0d);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((-10.0d));
        double double6 = facultyRateStrategy0.calculateCost(600.0d);
        double double8 = facultyRateStrategy0.calculateCost(2625.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-80.0d) + "'", double4 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 4800.0d + "'", double6 == 4800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 21000.0d + "'", double8 == 21000.0d);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(970.0d);
        java.lang.Class<?> wildcardClass5 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 9700.0d + "'", double4 == 9700.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(1.0d);
        java.lang.Class<?> wildcardClass5 = visitorRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 15.0d + "'", double4 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 1);
        double double6 = facultyRateStrategy0.calculateCost(100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 800.0d + "'", double6 == 800.0d);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost((double) 1L);
        double double4 = facultyRateStrategy0.calculateCost((-400.0d));
        double double6 = facultyRateStrategy0.calculateCost((-400.0d));
        double double8 = facultyRateStrategy0.calculateCost(750000.0d);
        double double10 = facultyRateStrategy0.calculateCost(1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 8.0d + "'", double2 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-3200.0d) + "'", double4 == (-3200.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + (-3200.0d) + "'", double6 == (-3200.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 6000000.0d + "'", double8 == 6000000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 10000.0d + "'", double10 == 10000.0d);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost((double) ' ');
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 37500.0d + "'", double4 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 320.0d + "'", double6 == 320.0d);
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 1500.0d + "'", double4 == 1500.0d);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(8.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 80.0d + "'", double4 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) 1);
        double double12 = studentRateStrategy0.calculateCost(100000.0d);
        double double14 = studentRateStrategy0.calculateCost(375.0d);
        double double16 = studentRateStrategy0.calculateCost(12800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 5.0d + "'", double10 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 500000.0d + "'", double12 == 500000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 1875.0d + "'", double14 == 1875.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 64000.0d + "'", double16 == 64000.0d);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(1.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 10.0d + "'", double2 == 10.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 50.0d + "'", double4 == 50.0d);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) (short) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(8.0d);
        double double6 = visitorRateStrategy0.calculateCost(250.0d);
        double double8 = visitorRateStrategy0.calculateCost(40.0d);
        double double10 = visitorRateStrategy0.calculateCost(970.0d);
        double double12 = visitorRateStrategy0.calculateCost(875.0d);
        double double14 = visitorRateStrategy0.calculateCost((double) 0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 120.0d + "'", double4 == 120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 3750.0d + "'", double6 == 3750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 600.0d + "'", double8 == 600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 14550.0d + "'", double10 == 14550.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 13125.0d + "'", double12 == 13125.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 0.0d + "'", double14 == 0.0d);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(8.0d);
        double double6 = visitorRateStrategy0.calculateCost(0.0d);
        double double8 = visitorRateStrategy0.calculateCost((-225.0d));
        java.lang.Class<?> wildcardClass9 = visitorRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 120.0d + "'", double4 == 120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-3375.0d) + "'", double8 == (-3375.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double10 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double12 = nonFacultyRateStrategy0.calculateCost((double) 100);
        double double14 = nonFacultyRateStrategy0.calculateCost(485.0d);
        double double16 = nonFacultyRateStrategy0.calculateCost(0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 970.0d + "'", double8 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 1000.0d + "'", double12 == 1000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 4850.0d + "'", double14 == 4850.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 0.0d + "'", double16 == 0.0d);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(49664.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 496640.0d + "'", double4 == 496640.0d);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((-10.0d));
        double double6 = facultyRateStrategy0.calculateCost((double) '4');
        double double8 = facultyRateStrategy0.calculateCost((double) 'a');
        double double10 = facultyRateStrategy0.calculateCost((double) '#');
        double double12 = facultyRateStrategy0.calculateCost(3750000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-80.0d) + "'", double4 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 416.0d + "'", double6 == 416.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 776.0d + "'", double8 == 776.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 280.0d + "'", double10 == 280.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 3.0E7d + "'", double12 == 3.0E7d);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = studentRateStrategy0.calculateCost((double) (byte) -1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-5.0d) + "'", double4 == (-5.0d));
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(8.0d);
        double double6 = visitorRateStrategy0.calculateCost(250.0d);
        double double8 = visitorRateStrategy0.calculateCost(40.0d);
        double double10 = visitorRateStrategy0.calculateCost(970.0d);
        double double12 = visitorRateStrategy0.calculateCost(875.0d);
        double double14 = visitorRateStrategy0.calculateCost(320.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 120.0d + "'", double4 == 120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 3750.0d + "'", double6 == 3750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 600.0d + "'", double8 == 600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 14550.0d + "'", double10 == 14550.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 13125.0d + "'", double12 == 13125.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 4800.0d + "'", double14 == 4800.0d);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 1);
        double double6 = facultyRateStrategy0.calculateCost((double) (short) 0);
        double double8 = facultyRateStrategy0.calculateCost(1250.0d);
        double double10 = facultyRateStrategy0.calculateCost(0.0d);
        double double12 = facultyRateStrategy0.calculateCost((double) (short) 100);
        java.lang.Class<?> wildcardClass13 = facultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 10000.0d + "'", double8 == 10000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 800.0d + "'", double12 == 800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost((double) 1L);
        double double4 = facultyRateStrategy0.calculateCost((-400.0d));
        java.lang.Class<?> wildcardClass5 = facultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 8.0d + "'", double2 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-3200.0d) + "'", double4 == (-3200.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) 1);
        double double12 = studentRateStrategy0.calculateCost(100000.0d);
        double double14 = studentRateStrategy0.calculateCost(375.0d);
        double double16 = studentRateStrategy0.calculateCost(5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 5.0d + "'", double10 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 500000.0d + "'", double12 == 500000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 1875.0d + "'", double14 == 1875.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 25.0d + "'", double16 == 25.0d);
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) 1);
        double double12 = studentRateStrategy0.calculateCost(9700.0d);
        double double14 = studentRateStrategy0.calculateCost((double) (short) 0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 5.0d + "'", double10 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 48500.0d + "'", double12 == 48500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 0.0d + "'", double14 == 0.0d);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) 0);
        double double8 = studentRateStrategy0.calculateCost(50.0d);
        double double10 = studentRateStrategy0.calculateCost(120.0d);
        double double12 = studentRateStrategy0.calculateCost((double) 100.0f);
        double double14 = studentRateStrategy0.calculateCost(2250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 250.0d + "'", double8 == 250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 600.0d + "'", double10 == 600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 500.0d + "'", double12 == 500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 11250.0d + "'", double14 == 11250.0d);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 1);
        double double6 = facultyRateStrategy0.calculateCost(0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) 0);
        double double8 = studentRateStrategy0.calculateCost(50.0d);
        double double10 = studentRateStrategy0.calculateCost(100.0d);
        double double12 = studentRateStrategy0.calculateCost(1.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 250.0d + "'", double8 == 250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 500.0d + "'", double10 == 500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 5.0d + "'", double12 == 5.0d);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost((double) 1);
        java.lang.Class<?> wildcardClass3 = facultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 8.0d + "'", double2 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 1);
        double double6 = facultyRateStrategy0.calculateCost((double) (short) 0);
        double double8 = facultyRateStrategy0.calculateCost(1250.0d);
        double double10 = facultyRateStrategy0.calculateCost(0.0d);
        double double12 = facultyRateStrategy0.calculateCost((double) (short) 100);
        double double14 = facultyRateStrategy0.calculateCost((-400.0d));
        java.lang.Class<?> wildcardClass15 = facultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 10000.0d + "'", double8 == 10000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 800.0d + "'", double12 == 800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + (-3200.0d) + "'", double14 == (-3200.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) (byte) 10);
        double double10 = studentRateStrategy0.calculateCost(150000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 750000.0d + "'", double10 == 750000.0d);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(1.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(3.0E7d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 10.0d + "'", double2 == 10.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 3.0E8d + "'", double4 == 3.0E8d);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(2625.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost(75.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 26250.0d + "'", double6 == 26250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 750.0d + "'", double8 == 750.0d);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost((double) 1L);
        double double4 = studentRateStrategy0.calculateCost(160.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 5.0d + "'", double2 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 800.0d + "'", double4 == 800.0d);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 10);
        double double10 = studentRateStrategy0.calculateCost((double) (byte) 1);
        java.lang.Class<?> wildcardClass11 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 5.0d + "'", double10 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(8.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost(7200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 80.0d + "'", double4 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 72000.0d + "'", double8 == 72000.0d);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost((double) 1L);
        double double4 = facultyRateStrategy0.calculateCost((-400.0d));
        double double6 = facultyRateStrategy0.calculateCost((-400.0d));
        double double8 = facultyRateStrategy0.calculateCost(750000.0d);
        double double10 = facultyRateStrategy0.calculateCost(18750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 8.0d + "'", double2 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-3200.0d) + "'", double4 == (-3200.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + (-3200.0d) + "'", double6 == (-3200.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 6000000.0d + "'", double8 == 6000000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 150000.0d + "'", double10 == 150000.0d);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(8.0d);
        java.lang.Class<?> wildcardClass5 = visitorRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 120.0d + "'", double4 == 120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        com.parkingapp.UserLogin.UserType userType0 = null;
        // The following exception was thrown during execution in test generation
        try {
            double double2 = com.parkingapp.PaymentRates.calculateCost(userType0, (long) '4');
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"com.parkingapp.UserLogin$UserType.ordinal()\" because \"userType\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) (byte) 10);
        double double10 = studentRateStrategy0.calculateCost(7500.0d);
        double double12 = studentRateStrategy0.calculateCost(62080.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 37500.0d + "'", double10 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 310400.0d + "'", double12 == 310400.0d);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost(100.0d);
        double double6 = facultyRateStrategy0.calculateCost(100000.0d);
        double double8 = facultyRateStrategy0.calculateCost(1.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 800.0d + "'", double4 == 800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 800000.0d + "'", double6 == 800000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 8.0d + "'", double8 == 8.0d);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 1);
        double double6 = facultyRateStrategy0.calculateCost((double) (short) 0);
        double double8 = facultyRateStrategy0.calculateCost(1250.0d);
        double double10 = facultyRateStrategy0.calculateCost((-400.0d));
        double double12 = facultyRateStrategy0.calculateCost(2625.0d);
        double double14 = facultyRateStrategy0.calculateCost(93600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 10000.0d + "'", double8 == 10000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-3200.0d) + "'", double10 == (-3200.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 21000.0d + "'", double12 == 21000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 748800.0d + "'", double14 == 748800.0d);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(100.0d);
        double double6 = visitorRateStrategy0.calculateCost(0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 1500.0d + "'", double4 == 1500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (byte) 10);
        double double6 = visitorRateStrategy0.calculateCost((double) ' ');
        double double8 = visitorRateStrategy0.calculateCost((double) 1L);
        double double10 = visitorRateStrategy0.calculateCost(150.0d);
        double double12 = visitorRateStrategy0.calculateCost((double) 1);
        double double14 = visitorRateStrategy0.calculateCost(320.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 150.0d + "'", double4 == 150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 480.0d + "'", double6 == 480.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 15.0d + "'", double8 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 2250.0d + "'", double10 == 2250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 15.0d + "'", double12 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 4800.0d + "'", double14 == 4800.0d);
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(18750.0d);
        java.lang.Class<?> wildcardClass5 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 187500.0d + "'", double4 == 187500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost(100.0d);
        double double6 = facultyRateStrategy0.calculateCost(100000.0d);
        double double8 = facultyRateStrategy0.calculateCost(970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 800.0d + "'", double4 == 800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 800000.0d + "'", double6 == 800000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 7760.0d + "'", double8 == 7760.0d);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) 0);
        double double8 = studentRateStrategy0.calculateCost((double) 0);
        double double10 = studentRateStrategy0.calculateCost(1200.0d);
        double double12 = studentRateStrategy0.calculateCost(480.0d);
        double double14 = studentRateStrategy0.calculateCost(40.0d);
        double double16 = studentRateStrategy0.calculateCost(970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 0.0d + "'", double8 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 6000.0d + "'", double10 == 6000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 2400.0d + "'", double12 == 2400.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 200.0d + "'", double14 == 200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 4850.0d + "'", double16 == 4850.0d);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) '4');
        double double6 = facultyRateStrategy0.calculateCost(13125.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 416.0d + "'", double4 == 416.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 105000.0d + "'", double6 == 105000.0d);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) 1);
        double double12 = studentRateStrategy0.calculateCost(4800.0d);
        double double14 = studentRateStrategy0.calculateCost((double) 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 5.0d + "'", double10 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 24000.0d + "'", double12 == 24000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 50.0d + "'", double14 == 50.0d);
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(1.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost((-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 10.0d + "'", double2 == 10.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-100.0d) + "'", double4 == (-100.0d));
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost((double) 0.0f);
        double double6 = nonFacultyRateStrategy0.calculateCost((double) (short) -1);
        java.lang.Class<?> wildcardClass7 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + (-10.0d) + "'", double6 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(64000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 320000.0d + "'", double6 == 320000.0d);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) 0);
        double double8 = studentRateStrategy0.calculateCost((double) 0);
        double double10 = studentRateStrategy0.calculateCost(100.0d);
        double double12 = studentRateStrategy0.calculateCost((-400.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 0.0d + "'", double8 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 500.0d + "'", double10 == 500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + (-2000.0d) + "'", double12 == (-2000.0d));
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(1.0d);
        double double6 = visitorRateStrategy0.calculateCost((double) (byte) 100);
        double double8 = visitorRateStrategy0.calculateCost((double) 10);
        double double10 = visitorRateStrategy0.calculateCost(93600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 15.0d + "'", double4 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1500.0d + "'", double6 == 1500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 150.0d + "'", double8 == 150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1404000.0d + "'", double10 == 1404000.0d);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((-10.0d));
        double double6 = facultyRateStrategy0.calculateCost(600.0d);
        double double8 = facultyRateStrategy0.calculateCost((double) 0);
        java.lang.Class<?> wildcardClass9 = facultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-80.0d) + "'", double4 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 4800.0d + "'", double6 == 4800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 0.0d + "'", double8 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) 0);
        double double8 = studentRateStrategy0.calculateCost(50.0d);
        double double10 = studentRateStrategy0.calculateCost((double) (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 250.0d + "'", double8 == 250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-5.0d) + "'", double10 == (-5.0d));
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(8.0d);
        double double6 = visitorRateStrategy0.calculateCost(250.0d);
        double double8 = visitorRateStrategy0.calculateCost(40.0d);
        double double10 = visitorRateStrategy0.calculateCost(970.0d);
        double double12 = visitorRateStrategy0.calculateCost(5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 120.0d + "'", double4 == 120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 3750.0d + "'", double6 == 3750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 600.0d + "'", double8 == 600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 14550.0d + "'", double10 == 14550.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 75.0d + "'", double12 == 75.0d);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) (byte) 10);
        double double8 = studentRateStrategy0.calculateCost(187500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 937500.0d + "'", double8 == 937500.0d);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double8 = nonFacultyRateStrategy0.calculateCost((double) 10L);
        double double10 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double12 = nonFacultyRateStrategy0.calculateCost(7200.0d);
        double double14 = nonFacultyRateStrategy0.calculateCost((double) (short) -1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 37500.0d + "'", double4 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 970.0d + "'", double6 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 100.0d + "'", double8 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 72000.0d + "'", double12 == 72000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + (-10.0d) + "'", double14 == (-10.0d));
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) (byte) 10);
        double double10 = studentRateStrategy0.calculateCost(250.0d);
        double double12 = studentRateStrategy0.calculateCost(3750.0d);
        double double14 = studentRateStrategy0.calculateCost(0.0d);
        double double16 = studentRateStrategy0.calculateCost(150.0d);
        double double18 = studentRateStrategy0.calculateCost(485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1250.0d + "'", double10 == 1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 18750.0d + "'", double12 == 18750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 0.0d + "'", double14 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 750.0d + "'", double16 == 750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double18 + "' != '" + 2425.0d + "'", double18 == 2425.0d);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (short) -1);
        double double6 = visitorRateStrategy0.calculateCost(5.0d);
        double double8 = visitorRateStrategy0.calculateCost((double) 0L);
        double double10 = visitorRateStrategy0.calculateCost((double) 0);
        java.lang.Class<?> wildcardClass11 = visitorRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-15.0d) + "'", double4 == (-15.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 75.0d + "'", double6 == 75.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 0.0d + "'", double8 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((-10.0d));
        double double6 = facultyRateStrategy0.calculateCost((double) '4');
        double double8 = facultyRateStrategy0.calculateCost((double) (byte) -1);
        double double10 = facultyRateStrategy0.calculateCost(1024000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-80.0d) + "'", double4 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 416.0d + "'", double6 == 416.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-8.0d) + "'", double8 == (-8.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 8192000.0d + "'", double10 == 8192000.0d);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (short) -1);
        double double6 = visitorRateStrategy0.calculateCost(5.0d);
        double double8 = visitorRateStrategy0.calculateCost((double) 10.0f);
        double double10 = visitorRateStrategy0.calculateCost((-225.0d));
        java.lang.Class<?> wildcardClass11 = visitorRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-15.0d) + "'", double4 == (-15.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 75.0d + "'", double6 == 75.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 150.0d + "'", double8 == 150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-3375.0d) + "'", double10 == (-3375.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 0);
        double double6 = facultyRateStrategy0.calculateCost((double) (byte) 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 800.0d + "'", double6 == 800.0d);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 0);
        double double6 = facultyRateStrategy0.calculateCost(750.0d);
        double double8 = facultyRateStrategy0.calculateCost(187500.0d);
        double double10 = facultyRateStrategy0.calculateCost(9.0E8d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 6000.0d + "'", double6 == 6000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 1500000.0d + "'", double8 == 1500000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 7.2E9d + "'", double10 == 7.2E9d);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((double) 1L);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 10.0d + "'", double8 == 10.0d);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) (short) 1);
        double double12 = studentRateStrategy0.calculateCost(120.0d);
        double double14 = studentRateStrategy0.calculateCost((double) 0L);
        java.lang.Class<?> wildcardClass15 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 5.0d + "'", double10 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 600.0d + "'", double12 == 600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 0.0d + "'", double14 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost(100.0d);
        double double6 = facultyRateStrategy0.calculateCost(100000.0d);
        double double8 = facultyRateStrategy0.calculateCost((double) (byte) -1);
        double double10 = facultyRateStrategy0.calculateCost((double) 1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 800.0d + "'", double4 == 800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 800000.0d + "'", double6 == 800000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-8.0d) + "'", double8 == (-8.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 8.0d + "'", double10 == 8.0d);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 1);
        double double6 = facultyRateStrategy0.calculateCost((double) (short) 0);
        double double8 = facultyRateStrategy0.calculateCost(1250.0d);
        double double10 = facultyRateStrategy0.calculateCost((-400.0d));
        java.lang.Class<?> wildcardClass11 = facultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 10000.0d + "'", double8 == 10000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-3200.0d) + "'", double10 == (-3200.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost((-1.0d));
        double double8 = nonFacultyRateStrategy0.calculateCost(10000.0d);
        java.lang.Class<?> wildcardClass9 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 7500.0d + "'", double4 == 7500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + (-10.0d) + "'", double6 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 100000.0d + "'", double8 == 100000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) 1);
        double double12 = studentRateStrategy0.calculateCost(100000.0d);
        double double14 = studentRateStrategy0.calculateCost(375.0d);
        double double16 = studentRateStrategy0.calculateCost(105000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 5.0d + "'", double10 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 500000.0d + "'", double12 == 500000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 1875.0d + "'", double14 == 1875.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 525000.0d + "'", double16 == 525000.0d);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double8 = nonFacultyRateStrategy0.calculateCost((double) (short) 100);
        double double10 = nonFacultyRateStrategy0.calculateCost(160.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 37500.0d + "'", double4 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 970.0d + "'", double6 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 1000.0d + "'", double8 == 1000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1600.0d + "'", double10 == 1600.0d);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 1);
        double double6 = facultyRateStrategy0.calculateCost((double) (short) 0);
        double double8 = facultyRateStrategy0.calculateCost(1250.0d);
        double double10 = facultyRateStrategy0.calculateCost(0.0d);
        double double12 = facultyRateStrategy0.calculateCost(75.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 10000.0d + "'", double8 == 10000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 600.0d + "'", double12 == 600.0d);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) (byte) 10);
        double double10 = studentRateStrategy0.calculateCost(250.0d);
        double double12 = studentRateStrategy0.calculateCost(3750.0d);
        double double14 = studentRateStrategy0.calculateCost(0.0d);
        double double16 = studentRateStrategy0.calculateCost(100000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1250.0d + "'", double10 == 1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 18750.0d + "'", double12 == 18750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 0.0d + "'", double14 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 500000.0d + "'", double16 == 500000.0d);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) 0);
        double double8 = studentRateStrategy0.calculateCost(50.0d);
        double double10 = studentRateStrategy0.calculateCost(100.0d);
        double double12 = studentRateStrategy0.calculateCost(3.0E8d);
        double double14 = studentRateStrategy0.calculateCost((double) (short) 0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 250.0d + "'", double8 == 250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 500.0d + "'", double10 == 500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 1.5E9d + "'", double12 == 1.5E9d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 0.0d + "'", double14 == 0.0d);
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double10 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double12 = nonFacultyRateStrategy0.calculateCost((double) 100);
        double double14 = nonFacultyRateStrategy0.calculateCost((double) 10.0f);
        double double16 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double18 = nonFacultyRateStrategy0.calculateCost(150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 970.0d + "'", double8 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 1000.0d + "'", double12 == 1000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 100.0d + "'", double14 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + (-10.0d) + "'", double16 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double18 + "' != '" + 1500.0d + "'", double18 == 1500.0d);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) (-1));
        double double12 = studentRateStrategy0.calculateCost(150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-5.0d) + "'", double10 == (-5.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 750.0d + "'", double12 == 750.0d);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) 1);
        double double12 = studentRateStrategy0.calculateCost(9700.0d);
        double double14 = studentRateStrategy0.calculateCost(1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 5.0d + "'", double10 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 48500.0d + "'", double12 == 48500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 6250.0d + "'", double14 == 6250.0d);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 10);
        double double10 = studentRateStrategy0.calculateCost(77600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 388000.0d + "'", double10 == 388000.0d);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost(150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 750.0d + "'", double4 == 750.0d);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost((-8.0d));
        double double8 = nonFacultyRateStrategy0.calculateCost((double) 10);
        double double10 = nonFacultyRateStrategy0.calculateCost(250.0d);
        double double12 = nonFacultyRateStrategy0.calculateCost(93600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + (-80.0d) + "'", double6 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 100.0d + "'", double8 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 2500.0d + "'", double10 == 2500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 936000.0d + "'", double12 == 936000.0d);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(1.0d);
        double double6 = visitorRateStrategy0.calculateCost((double) (byte) 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 15.0d + "'", double4 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1500.0d + "'", double6 == 1500.0d);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) (short) 1);
        double double12 = studentRateStrategy0.calculateCost(120.0d);
        double double14 = studentRateStrategy0.calculateCost((-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 5.0d + "'", double10 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 600.0d + "'", double12 == 600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + (-400.0d) + "'", double14 == (-400.0d));
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost(500.0d);
        double double4 = visitorRateStrategy0.calculateCost(1000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 7500.0d + "'", double2 == 7500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 15000.0d + "'", double4 == 15000.0d);
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost(9700.0d);
        double double6 = facultyRateStrategy0.calculateCost((double) (byte) 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 77600.0d + "'", double4 == 77600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 800.0d + "'", double6 == 800.0d);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost((double) (-1));
        java.lang.Class<?> wildcardClass3 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-5.0d) + "'", double2 == (-5.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((-10.0d));
        double double6 = facultyRateStrategy0.calculateCost((double) ' ');
        java.lang.Class<?> wildcardClass7 = facultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-80.0d) + "'", double4 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 256.0d + "'", double6 == 256.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((-8.0d));
        java.lang.Class<?> wildcardClass5 = facultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-64.0d) + "'", double4 == (-64.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(8.0d);
        double double6 = visitorRateStrategy0.calculateCost((double) 1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 120.0d + "'", double4 == 120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 15.0d + "'", double6 == 15.0d);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost(100.0d);
        double double6 = facultyRateStrategy0.calculateCost(100000.0d);
        double double8 = facultyRateStrategy0.calculateCost((double) (byte) -1);
        double double10 = facultyRateStrategy0.calculateCost(2500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 800.0d + "'", double4 == 800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 800000.0d + "'", double6 == 800000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-8.0d) + "'", double8 == (-8.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 20000.0d + "'", double10 == 20000.0d);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) (short) 1);
        double double12 = studentRateStrategy0.calculateCost(120.0d);
        java.lang.Class<?> wildcardClass13 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 5.0d + "'", double10 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 600.0d + "'", double12 == 600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass13);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(1.0d);
        double double6 = visitorRateStrategy0.calculateCost(75.0d);
        double double8 = visitorRateStrategy0.calculateCost(4200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 15.0d + "'", double4 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1125.0d + "'", double6 == 1125.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 63000.0d + "'", double8 == 63000.0d);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) (byte) 10);
        double double10 = studentRateStrategy0.calculateCost(250.0d);
        double double12 = studentRateStrategy0.calculateCost(3750.0d);
        double double14 = studentRateStrategy0.calculateCost(0.0d);
        double double16 = studentRateStrategy0.calculateCost(8000000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1250.0d + "'", double10 == 1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 18750.0d + "'", double12 == 18750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 0.0d + "'", double14 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 4.0E7d + "'", double16 == 4.0E7d);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost((double) 100);
        java.lang.Class<?> wildcardClass5 = visitorRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 1500.0d + "'", double4 == 1500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) (byte) 10);
        double double10 = studentRateStrategy0.calculateCost(250.0d);
        double double12 = studentRateStrategy0.calculateCost(3750.0d);
        double double14 = studentRateStrategy0.calculateCost(14550.0d);
        double double16 = studentRateStrategy0.calculateCost((double) (short) 1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1250.0d + "'", double10 == 1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 18750.0d + "'", double12 == 18750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 72750.0d + "'", double14 == 72750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 5.0d + "'", double16 == 5.0d);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(8.0d);
        double double6 = visitorRateStrategy0.calculateCost(0.0d);
        double double8 = visitorRateStrategy0.calculateCost((-225.0d));
        double double10 = visitorRateStrategy0.calculateCost(480.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 120.0d + "'", double4 == 120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-3375.0d) + "'", double8 == (-3375.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 7200.0d + "'", double10 == 7200.0d);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (short) -1);
        double double6 = visitorRateStrategy0.calculateCost((double) ' ');
        double double8 = visitorRateStrategy0.calculateCost(416.0d);
        double double10 = visitorRateStrategy0.calculateCost(485.0d);
        java.lang.Class<?> wildcardClass11 = visitorRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-15.0d) + "'", double4 == (-15.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 480.0d + "'", double6 == 480.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 6240.0d + "'", double8 == 6240.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 7275.0d + "'", double10 == 7275.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((-8.0d));
        double double6 = facultyRateStrategy0.calculateCost(1024000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-64.0d) + "'", double4 == (-64.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 8192000.0d + "'", double6 == 8192000.0d);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) 0);
        double double8 = studentRateStrategy0.calculateCost(50.0d);
        double double10 = studentRateStrategy0.calculateCost(100000.0d);
        double double12 = studentRateStrategy0.calculateCost(13125.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 250.0d + "'", double8 == 250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 500000.0d + "'", double10 == 500000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 65625.0d + "'", double12 == 65625.0d);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 0);
        double double6 = facultyRateStrategy0.calculateCost(750.0d);
        double double8 = facultyRateStrategy0.calculateCost(776.0d);
        double double10 = facultyRateStrategy0.calculateCost(0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 6000.0d + "'", double6 == 6000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 6208.0d + "'", double8 == 6208.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) 0);
        double double8 = studentRateStrategy0.calculateCost((double) 0);
        double double10 = studentRateStrategy0.calculateCost(1200.0d);
        double double12 = studentRateStrategy0.calculateCost((double) (byte) 100);
        double double14 = studentRateStrategy0.calculateCost(6.0E7d);
        java.lang.Class<?> wildcardClass15 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 0.0d + "'", double8 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 6000.0d + "'", double10 == 6000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 500.0d + "'", double12 == 500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 3.0E8d + "'", double14 == 3.0E8d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(8.0d);
        double double6 = visitorRateStrategy0.calculateCost(250.0d);
        java.lang.Class<?> wildcardClass7 = visitorRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 120.0d + "'", double4 == 120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 3750.0d + "'", double6 == 3750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost(500.0d);
        double double4 = visitorRateStrategy0.calculateCost(26250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 7500.0d + "'", double2 == 7500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 393750.0d + "'", double4 == 393750.0d);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost((double) (short) 10);
        double double6 = nonFacultyRateStrategy0.calculateCost(120.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost(875.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 100.0d + "'", double4 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1200.0d + "'", double6 == 1200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 8750.0d + "'", double8 == 8750.0d);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((-10.0d));
        double double6 = facultyRateStrategy0.calculateCost((double) '4');
        double double8 = facultyRateStrategy0.calculateCost((double) 'a');
        double double10 = facultyRateStrategy0.calculateCost(12800.0d);
        double double12 = facultyRateStrategy0.calculateCost(250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-80.0d) + "'", double4 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 416.0d + "'", double6 == 416.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 776.0d + "'", double8 == 776.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 102400.0d + "'", double10 == 102400.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 2000.0d + "'", double12 == 2000.0d);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) (byte) 10);
        double double10 = studentRateStrategy0.calculateCost(250.0d);
        double double12 = studentRateStrategy0.calculateCost((double) 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1250.0d + "'", double10 == 1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 50.0d + "'", double12 == 50.0d);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(30000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 37500.0d + "'", double4 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 300000.0d + "'", double6 == 300000.0d);
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost((double) 100);
        double double6 = visitorRateStrategy0.calculateCost(50.0d);
        double double8 = visitorRateStrategy0.calculateCost((double) (byte) -1);
        double double10 = visitorRateStrategy0.calculateCost((double) 10L);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 1500.0d + "'", double4 == 1500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 750.0d + "'", double6 == 750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-15.0d) + "'", double8 == (-15.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 150.0d + "'", double10 == 150.0d);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) 0);
        double double8 = studentRateStrategy0.calculateCost((double) 0);
        double double10 = studentRateStrategy0.calculateCost(1200.0d);
        double double12 = studentRateStrategy0.calculateCost((double) (byte) 100);
        double double14 = studentRateStrategy0.calculateCost(6.0E7d);
        double double16 = studentRateStrategy0.calculateCost((double) (byte) 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 0.0d + "'", double8 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 6000.0d + "'", double10 == 6000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 500.0d + "'", double12 == 500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 3.0E8d + "'", double14 == 3.0E8d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 50.0d + "'", double16 == 50.0d);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(8.0d);
        double double6 = visitorRateStrategy0.calculateCost(875.0d);
        double double8 = visitorRateStrategy0.calculateCost(72000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 120.0d + "'", double4 == 120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 13125.0d + "'", double6 == 13125.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 1080000.0d + "'", double8 == 1080000.0d);
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double10 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double12 = nonFacultyRateStrategy0.calculateCost((double) 100);
        double double14 = nonFacultyRateStrategy0.calculateCost(6208.0d);
        double double16 = nonFacultyRateStrategy0.calculateCost((double) 1L);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 970.0d + "'", double8 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 1000.0d + "'", double12 == 1000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 62080.0d + "'", double14 == 62080.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 10.0d + "'", double16 == 10.0d);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) 0);
        double double8 = studentRateStrategy0.calculateCost(50.0d);
        double double10 = studentRateStrategy0.calculateCost(120.0d);
        double double12 = studentRateStrategy0.calculateCost(1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 250.0d + "'", double8 == 250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 600.0d + "'", double10 == 600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 6250.0d + "'", double12 == 6250.0d);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((-10.0d));
        double double6 = facultyRateStrategy0.calculateCost((double) '4');
        double double8 = facultyRateStrategy0.calculateCost((double) 'a');
        double double10 = facultyRateStrategy0.calculateCost(4800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-80.0d) + "'", double4 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 416.0d + "'", double6 == 416.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 776.0d + "'", double8 == 776.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 38400.0d + "'", double10 == 38400.0d);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((-10.0d));
        double double6 = facultyRateStrategy0.calculateCost((double) '4');
        double double8 = facultyRateStrategy0.calculateCost((double) (byte) -1);
        double double10 = facultyRateStrategy0.calculateCost(24000.0d);
        double double12 = facultyRateStrategy0.calculateCost(2400.0d);
        double double14 = facultyRateStrategy0.calculateCost(105000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-80.0d) + "'", double4 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 416.0d + "'", double6 == 416.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-8.0d) + "'", double8 == (-8.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 192000.0d + "'", double10 == 192000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 19200.0d + "'", double12 == 19200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 840000.0d + "'", double14 == 840000.0d);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) 1L);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 1);
        double double6 = facultyRateStrategy0.calculateCost((double) (short) 0);
        double double8 = facultyRateStrategy0.calculateCost(1250.0d);
        double double10 = facultyRateStrategy0.calculateCost(15000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 10000.0d + "'", double8 == 10000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 120000.0d + "'", double10 == 120000.0d);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) 0);
        double double8 = studentRateStrategy0.calculateCost(50.0d);
        java.lang.Class<?> wildcardClass9 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 250.0d + "'", double8 == 250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost(100.0d);
        double double6 = facultyRateStrategy0.calculateCost((double) 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 800.0d + "'", double4 == 800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 80.0d + "'", double6 == 80.0d);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (short) -1);
        double double6 = visitorRateStrategy0.calculateCost(5.0d);
        double double8 = visitorRateStrategy0.calculateCost((double) 10.0f);
        double double10 = visitorRateStrategy0.calculateCost(120.0d);
        double double12 = visitorRateStrategy0.calculateCost((double) 10.0f);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-15.0d) + "'", double4 == (-15.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 75.0d + "'", double6 == 75.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 150.0d + "'", double8 == 150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1800.0d + "'", double10 == 1800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 150.0d + "'", double12 == 150.0d);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 10);
        double double10 = studentRateStrategy0.calculateCost(936000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 4680000.0d + "'", double10 == 4680000.0d);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 1);
        double double6 = facultyRateStrategy0.calculateCost(10.0d);
        double double8 = facultyRateStrategy0.calculateCost((double) 10);
        double double10 = facultyRateStrategy0.calculateCost((double) (-1));
        double double12 = facultyRateStrategy0.calculateCost(727500.0d);
        double double14 = facultyRateStrategy0.calculateCost(93120.0d);
        java.lang.Class<?> wildcardClass15 = facultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 80.0d + "'", double6 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 80.0d + "'", double8 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-8.0d) + "'", double10 == (-8.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 5820000.0d + "'", double12 == 5820000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 744960.0d + "'", double14 == 744960.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (byte) 10);
        double double6 = visitorRateStrategy0.calculateCost((double) ' ');
        double double8 = visitorRateStrategy0.calculateCost(416.0d);
        double double10 = visitorRateStrategy0.calculateCost(75.0d);
        double double12 = visitorRateStrategy0.calculateCost(31200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 150.0d + "'", double4 == 150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 480.0d + "'", double6 == 480.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 6240.0d + "'", double8 == 6240.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1125.0d + "'", double10 == 1125.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 468000.0d + "'", double12 == 468000.0d);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(2625.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((-1.0d));
        double double10 = nonFacultyRateStrategy0.calculateCost(0.0d);
        java.lang.Class<?> wildcardClass11 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 26250.0d + "'", double6 == 26250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-10.0d) + "'", double8 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) 1);
        double double12 = studentRateStrategy0.calculateCost((-3375.0d));
        double double14 = studentRateStrategy0.calculateCost(24000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 5.0d + "'", double10 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + (-16875.0d) + "'", double12 == (-16875.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 120000.0d + "'", double14 == 120000.0d);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 1);
        double double6 = facultyRateStrategy0.calculateCost((double) (short) 0);
        double double8 = facultyRateStrategy0.calculateCost((double) 10);
        double double10 = facultyRateStrategy0.calculateCost(48500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 80.0d + "'", double8 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 388000.0d + "'", double10 == 388000.0d);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost((double) 1L);
        double double4 = facultyRateStrategy0.calculateCost((-8.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 8.0d + "'", double2 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-64.0d) + "'", double4 == (-64.0d));
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost(100.0d);
        double double6 = facultyRateStrategy0.calculateCost(100000.0d);
        double double8 = facultyRateStrategy0.calculateCost((double) (byte) -1);
        double double10 = facultyRateStrategy0.calculateCost(0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 800.0d + "'", double4 == 800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 800000.0d + "'", double6 == 800000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-8.0d) + "'", double8 == (-8.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost(800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 4000.0d + "'", double4 == 4000.0d);
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) 1);
        double double12 = studentRateStrategy0.calculateCost(9700.0d);
        double double14 = studentRateStrategy0.calculateCost(727500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 5.0d + "'", double10 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 48500.0d + "'", double12 == 48500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 3637500.0d + "'", double14 == 3637500.0d);
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(1.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(25.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 10.0d + "'", double2 == 10.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 250.0d + "'", double4 == 250.0d);
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(8.0d);
        double double6 = visitorRateStrategy0.calculateCost(250.0d);
        double double8 = visitorRateStrategy0.calculateCost((double) 1L);
        double double10 = visitorRateStrategy0.calculateCost(1200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 120.0d + "'", double4 == 120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 3750.0d + "'", double6 == 3750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 15.0d + "'", double8 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 18000.0d + "'", double10 == 18000.0d);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((-80.0d));
        double double8 = studentRateStrategy0.calculateCost(8000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + (-400.0d) + "'", double6 == (-400.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 40000.0d + "'", double8 == 40000.0d);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(1.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(93600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 10.0d + "'", double2 == 10.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 936000.0d + "'", double4 == 936000.0d);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) 1);
        double double12 = studentRateStrategy0.calculateCost((-3375.0d));
        double double14 = studentRateStrategy0.calculateCost(416.0d);
        double double16 = studentRateStrategy0.calculateCost(9700.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 5.0d + "'", double10 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + (-16875.0d) + "'", double12 == (-16875.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 2080.0d + "'", double14 == 2080.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 48500.0d + "'", double16 == 48500.0d);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 1);
        double double6 = facultyRateStrategy0.calculateCost((double) (short) 0);
        double double8 = facultyRateStrategy0.calculateCost(1250.0d);
        double double10 = facultyRateStrategy0.calculateCost(0.0d);
        double double12 = facultyRateStrategy0.calculateCost((double) (short) 100);
        double double14 = facultyRateStrategy0.calculateCost((-3375.0d));
        double double16 = facultyRateStrategy0.calculateCost(8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 10000.0d + "'", double8 == 10000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 800.0d + "'", double12 == 800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + (-27000.0d) + "'", double14 == (-27000.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 64.0d + "'", double16 == 64.0d);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost(12800.0d);
        double double10 = nonFacultyRateStrategy0.calculateCost(1091250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 128000.0d + "'", double8 == 128000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1.09125E7d + "'", double10 == 1.09125E7d);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost(12800.0d);
        double double10 = nonFacultyRateStrategy0.calculateCost(102400.0d);
        double double12 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double14 = nonFacultyRateStrategy0.calculateCost((-5.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 128000.0d + "'", double8 == 128000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1024000.0d + "'", double10 == 1024000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 37500.0d + "'", double12 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + (-50.0d) + "'", double14 == (-50.0d));
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double10 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double12 = nonFacultyRateStrategy0.calculateCost((double) 100);
        double double14 = nonFacultyRateStrategy0.calculateCost(6208.0d);
        double double16 = nonFacultyRateStrategy0.calculateCost(776.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 970.0d + "'", double8 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 1000.0d + "'", double12 == 1000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 62080.0d + "'", double14 == 62080.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 7760.0d + "'", double16 == 7760.0d);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double8 = nonFacultyRateStrategy0.calculateCost((double) 10L);
        double double10 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double12 = nonFacultyRateStrategy0.calculateCost(7200.0d);
        double double14 = nonFacultyRateStrategy0.calculateCost(500000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 37500.0d + "'", double4 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 970.0d + "'", double6 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 100.0d + "'", double8 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 72000.0d + "'", double12 == 72000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 5000000.0d + "'", double14 == 5000000.0d);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double10 = nonFacultyRateStrategy0.calculateCost(10.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 970.0d + "'", double8 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 100.0d + "'", double10 == 100.0d);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost(100.0d);
        double double6 = facultyRateStrategy0.calculateCost(100000.0d);
        double double8 = facultyRateStrategy0.calculateCost(4200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 800.0d + "'", double4 == 800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 800000.0d + "'", double6 == 800000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 33600.0d + "'", double8 == 33600.0d);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(1.0d);
        double double6 = visitorRateStrategy0.calculateCost((double) (byte) 100);
        double double8 = visitorRateStrategy0.calculateCost((double) 0L);
        double double10 = visitorRateStrategy0.calculateCost(6.0E7d);
        double double12 = visitorRateStrategy0.calculateCost(4000.0d);
        double double14 = visitorRateStrategy0.calculateCost(1404000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 15.0d + "'", double4 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1500.0d + "'", double6 == 1500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 0.0d + "'", double8 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 9.0E8d + "'", double10 == 9.0E8d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 60000.0d + "'", double12 == 60000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 2.106E7d + "'", double14 == 2.106E7d);
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) (byte) 10);
        double double10 = studentRateStrategy0.calculateCost((double) ' ');
        double double12 = studentRateStrategy0.calculateCost((double) (byte) 0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 160.0d + "'", double10 == 160.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 0.0d + "'", double12 == 0.0d);
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(750000.0d);
        double double8 = studentRateStrategy0.calculateCost((double) ' ');
        java.lang.Class<?> wildcardClass9 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 3750000.0d + "'", double6 == 3750000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 160.0d + "'", double8 == 160.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(10.0d);
        double double4 = facultyRateStrategy0.calculateCost((double) (short) 1);
        double double6 = facultyRateStrategy0.calculateCost((double) (short) 0);
        double double8 = facultyRateStrategy0.calculateCost(1250.0d);
        double double10 = facultyRateStrategy0.calculateCost((-400.0d));
        double double12 = facultyRateStrategy0.calculateCost(2625.0d);
        double double14 = facultyRateStrategy0.calculateCost(8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 80.0d + "'", double2 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 8.0d + "'", double4 == 8.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 10000.0d + "'", double8 == 10000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-3200.0d) + "'", double10 == (-3200.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 21000.0d + "'", double12 == 21000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 64.0d + "'", double14 == 64.0d);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double8 = nonFacultyRateStrategy0.calculateCost(100.0d);
        double double10 = nonFacultyRateStrategy0.calculateCost((double) (-1L));
        double double12 = nonFacultyRateStrategy0.calculateCost(18750.0d);
        double double14 = nonFacultyRateStrategy0.calculateCost((-1.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 37500.0d + "'", double4 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 970.0d + "'", double6 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 1000.0d + "'", double8 == 1000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-10.0d) + "'", double10 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 187500.0d + "'", double12 == 187500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + (-10.0d) + "'", double14 == (-10.0d));
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(1.0d);
        double double6 = visitorRateStrategy0.calculateCost(75.0d);
        java.lang.Class<?> wildcardClass7 = visitorRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 15.0d + "'", double4 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1125.0d + "'", double6 == 1125.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(8.0d);
        double double6 = visitorRateStrategy0.calculateCost(250.0d);
        double double8 = visitorRateStrategy0.calculateCost(40.0d);
        double double10 = visitorRateStrategy0.calculateCost(970.0d);
        double double12 = visitorRateStrategy0.calculateCost(875.0d);
        double double14 = visitorRateStrategy0.calculateCost(0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 120.0d + "'", double4 == 120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 3750.0d + "'", double6 == 3750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 600.0d + "'", double8 == 600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 14550.0d + "'", double10 == 14550.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 13125.0d + "'", double12 == 13125.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 0.0d + "'", double14 == 0.0d);
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (byte) 10);
        double double6 = visitorRateStrategy0.calculateCost((double) ' ');
        double double8 = visitorRateStrategy0.calculateCost((double) 1L);
        double double10 = visitorRateStrategy0.calculateCost(150.0d);
        double double12 = visitorRateStrategy0.calculateCost((double) 1);
        double double14 = visitorRateStrategy0.calculateCost(175.0d);
        double double16 = visitorRateStrategy0.calculateCost(468000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 150.0d + "'", double4 == 150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 480.0d + "'", double6 == 480.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 15.0d + "'", double8 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 2250.0d + "'", double10 == 2250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 15.0d + "'", double12 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 2625.0d + "'", double14 == 2625.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 7020000.0d + "'", double16 == 7020000.0d);
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(8.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(15.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((-400.0d));
        double double10 = nonFacultyRateStrategy0.calculateCost((-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 80.0d + "'", double4 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 150.0d + "'", double6 == 150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-4000.0d) + "'", double8 == (-4000.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + (-500.0d) + "'", double10 == (-500.0d));
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test246");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) 0);
        double double8 = studentRateStrategy0.calculateCost(50.0d);
        double double10 = studentRateStrategy0.calculateCost(100.0d);
        double double12 = studentRateStrategy0.calculateCost(3.0E8d);
        double double14 = studentRateStrategy0.calculateCost(500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 250.0d + "'", double8 == 250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 500.0d + "'", double10 == 500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 1.5E9d + "'", double12 == 1.5E9d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 2500.0d + "'", double14 == 2500.0d);
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test247");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost((-8.0d));
        double double8 = nonFacultyRateStrategy0.calculateCost(4850.0d);
        double double10 = nonFacultyRateStrategy0.calculateCost(485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + (-80.0d) + "'", double6 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 48500.0d + "'", double8 == 48500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 4850.0d + "'", double10 == 4850.0d);
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test248");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (short) -1);
        double double6 = visitorRateStrategy0.calculateCost(5.0d);
        double double8 = visitorRateStrategy0.calculateCost((double) 100L);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-15.0d) + "'", double4 == (-15.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 75.0d + "'", double6 == 75.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 1500.0d + "'", double8 == 1500.0d);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test249");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(8.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(15.0d);
        java.lang.Class<?> wildcardClass7 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 80.0d + "'", double4 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 150.0d + "'", double6 == 150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test250");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(2400.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((double) 1.0f);
        double double10 = nonFacultyRateStrategy0.calculateCost((double) 10.0f);
        java.lang.Class<?> wildcardClass11 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 7500.0d + "'", double4 == 7500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 24000.0d + "'", double6 == 24000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 10.0d + "'", double8 == 10.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 100.0d + "'", double10 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test251");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double8 = nonFacultyRateStrategy0.calculateCost(31200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 37500.0d + "'", double4 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 970.0d + "'", double6 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 312000.0d + "'", double8 == 312000.0d);
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test252");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost((double) 100);
        double double6 = visitorRateStrategy0.calculateCost(50.0d);
        double double8 = visitorRateStrategy0.calculateCost((double) 100);
        double double10 = visitorRateStrategy0.calculateCost(6208.0d);
        double double12 = visitorRateStrategy0.calculateCost(727500.0d);
        double double14 = visitorRateStrategy0.calculateCost(13125.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 1500.0d + "'", double4 == 1500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 750.0d + "'", double6 == 750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 1500.0d + "'", double8 == 1500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 93120.0d + "'", double10 == 93120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 1.09125E7d + "'", double12 == 1.09125E7d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 196875.0d + "'", double14 == 196875.0d);
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test253");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double8 = nonFacultyRateStrategy0.calculateCost((double) 10L);
        double double10 = nonFacultyRateStrategy0.calculateCost(8.0d);
        java.lang.Class<?> wildcardClass11 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 37500.0d + "'", double4 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 970.0d + "'", double6 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 100.0d + "'", double8 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 80.0d + "'", double10 == 80.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass11);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test254");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(1.0d);
        double double6 = visitorRateStrategy0.calculateCost(26250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 15.0d + "'", double4 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 393750.0d + "'", double6 == 393750.0d);
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test255");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double8 = nonFacultyRateStrategy0.calculateCost((double) 10L);
        double double10 = nonFacultyRateStrategy0.calculateCost(1024000.0d);
        double double12 = nonFacultyRateStrategy0.calculateCost(26250.0d);
        double double14 = nonFacultyRateStrategy0.calculateCost(64.0d);
        double double16 = nonFacultyRateStrategy0.calculateCost(1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 37500.0d + "'", double4 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 970.0d + "'", double6 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 100.0d + "'", double8 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1.024E7d + "'", double10 == 1.024E7d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 262500.0d + "'", double12 == 262500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 640.0d + "'", double14 == 640.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 12500.0d + "'", double16 == 12500.0d);
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test256");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) 'a');
        double double10 = studentRateStrategy0.calculateCost((double) 1);
        double double12 = studentRateStrategy0.calculateCost(9700.0d);
        double double14 = studentRateStrategy0.calculateCost(0.0d);
        java.lang.Class<?> wildcardClass15 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 485.0d + "'", double8 == 485.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 5.0d + "'", double10 == 5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 48500.0d + "'", double12 == 48500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 0.0d + "'", double14 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass15);
    }

    @Test
    public void test257() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test257");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((-10.0d));
        double double6 = facultyRateStrategy0.calculateCost((double) (short) 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-80.0d) + "'", double4 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 80.0d + "'", double6 == 80.0d);
    }

    @Test
    public void test258() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test258");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost((double) (short) 10);
        double double6 = nonFacultyRateStrategy0.calculateCost(120.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost(485.0d);
        double double10 = nonFacultyRateStrategy0.calculateCost(1125.0d);
        double double12 = nonFacultyRateStrategy0.calculateCost(10.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 100.0d + "'", double4 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1200.0d + "'", double6 == 1200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 4850.0d + "'", double8 == 4850.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 11250.0d + "'", double10 == 11250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 100.0d + "'", double12 == 100.0d);
    }

    @Test
    public void test259() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test259");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double8 = nonFacultyRateStrategy0.calculateCost(10.0d);
        double double10 = nonFacultyRateStrategy0.calculateCost(100000.0d);
        double double12 = nonFacultyRateStrategy0.calculateCost(33600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 37500.0d + "'", double4 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 970.0d + "'", double6 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 100.0d + "'", double8 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1000000.0d + "'", double10 == 1000000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 336000.0d + "'", double12 == 336000.0d);
    }

    @Test
    public void test260() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test260");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double8 = nonFacultyRateStrategy0.calculateCost(970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 37500.0d + "'", double4 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 970.0d + "'", double6 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 9700.0d + "'", double8 == 9700.0d);
    }

    @Test
    public void test261() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test261");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(8.0d);
        double double6 = visitorRateStrategy0.calculateCost(250.0d);
        double double8 = visitorRateStrategy0.calculateCost(40.0d);
        double double10 = visitorRateStrategy0.calculateCost(970.0d);
        double double12 = visitorRateStrategy0.calculateCost((double) 'a');
        double double14 = visitorRateStrategy0.calculateCost(4.0E7d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 120.0d + "'", double4 == 120.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 3750.0d + "'", double6 == 3750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 600.0d + "'", double8 == 600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 14550.0d + "'", double10 == 14550.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 1455.0d + "'", double12 == 1455.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 6.0E8d + "'", double14 == 6.0E8d);
    }

    @Test
    public void test262() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test262");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost((double) 100);
        double double6 = visitorRateStrategy0.calculateCost(50.0d);
        double double8 = visitorRateStrategy0.calculateCost((double) (byte) -1);
        double double10 = visitorRateStrategy0.calculateCost(4.0E7d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 1500.0d + "'", double4 == 1500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 750.0d + "'", double6 == 750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-15.0d) + "'", double8 == (-15.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 6.0E8d + "'", double10 == 6.0E8d);
    }

    @Test
    public void test263() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test263");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = studentRateStrategy0.calculateCost(496640.0d);
        java.lang.Class<?> wildcardClass5 = studentRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 2483200.0d + "'", double4 == 2483200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test264() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test264");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost((double) (short) 100);
        double double6 = visitorRateStrategy0.calculateCost(480.0d);
        double double8 = visitorRateStrategy0.calculateCost(280.0d);
        double double10 = visitorRateStrategy0.calculateCost(72000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 1500.0d + "'", double4 == 1500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 7200.0d + "'", double6 == 7200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 4200.0d + "'", double8 == 4200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1080000.0d + "'", double10 == 1080000.0d);
    }

    @Test
    public void test265() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test265");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(1.0d);
        double double6 = visitorRateStrategy0.calculateCost((double) (byte) 100);
        java.lang.Class<?> wildcardClass7 = visitorRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 15.0d + "'", double4 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1500.0d + "'", double6 == 1500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test266() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test266");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost(12800.0d);
        double double10 = nonFacultyRateStrategy0.calculateCost(102400.0d);
        double double12 = nonFacultyRateStrategy0.calculateCost(5.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 128000.0d + "'", double8 == 128000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1024000.0d + "'", double10 == 1024000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 50.0d + "'", double12 == 50.0d);
    }

    @Test
    public void test267() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test267");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((-10.0d));
        double double6 = facultyRateStrategy0.calculateCost(600.0d);
        double double8 = facultyRateStrategy0.calculateCost(1600.0d);
        java.lang.Class<?> wildcardClass9 = facultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-80.0d) + "'", double4 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 4800.0d + "'", double6 == 4800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 12800.0d + "'", double8 == 12800.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test268() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test268");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost((double) (short) 10);
        double double6 = nonFacultyRateStrategy0.calculateCost(120.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        java.lang.Class<?> wildcardClass9 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 100.0d + "'", double4 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 1200.0d + "'", double6 == 1200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-10.0d) + "'", double8 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test269() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test269");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost((double) 0);
        double double8 = studentRateStrategy0.calculateCost(50.0d);
        double double10 = studentRateStrategy0.calculateCost(100.0d);
        double double12 = studentRateStrategy0.calculateCost(3.0E8d);
        double double14 = studentRateStrategy0.calculateCost(64.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 250.0d + "'", double8 == 250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 500.0d + "'", double10 == 500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 1.5E9d + "'", double12 == 1.5E9d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 320.0d + "'", double14 == 320.0d);
    }

    @Test
    public void test270() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test270");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost(3750.0d);
        double double4 = nonFacultyRateStrategy0.calculateCost(750.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(75.0d);
        java.lang.Class<?> wildcardClass7 = nonFacultyRateStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 37500.0d + "'", double2 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 7500.0d + "'", double4 == 7500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 750.0d + "'", double6 == 750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test271() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test271");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) (byte) 10);
        double double10 = studentRateStrategy0.calculateCost(250.0d);
        double double12 = studentRateStrategy0.calculateCost(3750.0d);
        double double14 = studentRateStrategy0.calculateCost(14550.0d);
        double double16 = studentRateStrategy0.calculateCost(4850.0d);
        double double18 = studentRateStrategy0.calculateCost(320.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1250.0d + "'", double10 == 1250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 18750.0d + "'", double12 == 18750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 72750.0d + "'", double14 == 72750.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 24250.0d + "'", double16 == 24250.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double18 + "' != '" + 1600.0d + "'", double18 == 1600.0d);
    }

    @Test
    public void test272() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test272");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (byte) 0);
        double double4 = visitorRateStrategy0.calculateCost(1.0d);
        double double6 = visitorRateStrategy0.calculateCost((double) 1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 15.0d + "'", double4 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 15.0d + "'", double6 == 15.0d);
    }

    @Test
    public void test273() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test273");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost((double) (short) 10);
        double double6 = nonFacultyRateStrategy0.calculateCost(310400.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 100.0d + "'", double4 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 3104000.0d + "'", double6 == 3104000.0d);
    }

    @Test
    public void test274() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test274");
        com.parkingapp.PaymentRates.NonFacultyRateStrategy nonFacultyRateStrategy0 = new com.parkingapp.PaymentRates.NonFacultyRateStrategy();
        double double2 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double4 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double6 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double8 = nonFacultyRateStrategy0.calculateCost((double) 'a');
        double double10 = nonFacultyRateStrategy0.calculateCost(0.0d);
        double double12 = nonFacultyRateStrategy0.calculateCost((double) 100);
        double double14 = nonFacultyRateStrategy0.calculateCost((double) 10.0f);
        double double16 = nonFacultyRateStrategy0.calculateCost((double) (-1));
        double double18 = nonFacultyRateStrategy0.calculateCost(525000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + (-10.0d) + "'", double2 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 0.0d + "'", double4 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 0.0d + "'", double6 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 970.0d + "'", double8 == 970.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 0.0d + "'", double10 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 1000.0d + "'", double12 == 1000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 100.0d + "'", double14 == 100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + (-10.0d) + "'", double16 == (-10.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double18 + "' != '" + 5250000.0d + "'", double18 == 5250000.0d);
    }

    @Test
    public void test275() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test275");
        com.parkingapp.PaymentRates.VisitorRateStrategy visitorRateStrategy0 = new com.parkingapp.PaymentRates.VisitorRateStrategy();
        double double2 = visitorRateStrategy0.calculateCost((double) (short) 1);
        double double4 = visitorRateStrategy0.calculateCost((double) (byte) 10);
        double double6 = visitorRateStrategy0.calculateCost(1.0d);
        double double8 = visitorRateStrategy0.calculateCost(65625.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 150.0d + "'", double4 == 150.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 15.0d + "'", double6 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 984375.0d + "'", double8 == 984375.0d);
    }

    @Test
    public void test276() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test276");
        com.parkingapp.PaymentRates.FacultyRateStrategy facultyRateStrategy0 = new com.parkingapp.PaymentRates.FacultyRateStrategy();
        double double2 = facultyRateStrategy0.calculateCost(5.0d);
        double double4 = facultyRateStrategy0.calculateCost((-10.0d));
        double double6 = facultyRateStrategy0.calculateCost((double) ' ');
        double double8 = facultyRateStrategy0.calculateCost((-400.0d));
        double double10 = facultyRateStrategy0.calculateCost(160.0d);
        double double12 = facultyRateStrategy0.calculateCost(31200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 40.0d + "'", double2 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + (-80.0d) + "'", double4 == (-80.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 256.0d + "'", double6 == 256.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + (-3200.0d) + "'", double8 == (-3200.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 1280.0d + "'", double10 == 1280.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 249600.0d + "'", double12 == 249600.0d);
    }

    @Test
    public void test277() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test277");
        com.parkingapp.PaymentRates.StudentRateStrategy studentRateStrategy0 = new com.parkingapp.PaymentRates.StudentRateStrategy();
        double double2 = studentRateStrategy0.calculateCost(0.0d);
        double double4 = studentRateStrategy0.calculateCost((double) '#');
        double double6 = studentRateStrategy0.calculateCost(10.0d);
        double double8 = studentRateStrategy0.calculateCost((double) (byte) 10);
        double double10 = studentRateStrategy0.calculateCost(7500.0d);
        double double12 = studentRateStrategy0.calculateCost(970.0d);
        double double14 = studentRateStrategy0.calculateCost(4200.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 0.0d + "'", double2 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 175.0d + "'", double4 == 175.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 50.0d + "'", double6 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 50.0d + "'", double8 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 37500.0d + "'", double10 == 37500.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 4850.0d + "'", double12 == 4850.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 21000.0d + "'", double14 == 21000.0d);
    }
}

