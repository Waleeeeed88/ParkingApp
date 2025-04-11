package com.parkingapp;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.parkingapp.parkingObjects.ParkingServices;
import services.FirebaseInitialization;
import services.SuperAdminDashboardFirestore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SuperAdminDashboard {
    private static final String COLLECTION_NAME = "admin_accounts";

    private SuperAdminDashboardFirestore firestore;

	 // Initialize it in the constructor or as needed
	 public SuperAdminDashboard() {
	     this.firestore = new SuperAdminDashboardFirestore();
	 }
	 
    // Generates a secure random password of given length.
    public String generateSecurePassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*()-_?.";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }
        return password.toString();
    }

    // Creates a new admin account by applying the given prefix and the prototype instance.
    public AdminAccount generateAdminAccount(String prefix, AdminAccountPrototype adminPrototype) {
        prefix = prefix.trim().toLowerCase();
        if (prefix.isEmpty()) {
            throw new IllegalArgumentException("Prefix cannot be empty.");
        }
        // For demonstration, appending a static string to the prefix; adapt as needed.
        String uniqueUserId = prefix + "yups";
        String generatedPassword = generateSecurePassword(10);

        AdminAccount newAdmin = adminPrototype.clone();
        newAdmin.setUserId(uniqueUserId);
        newAdmin.setPassword(generatedPassword);
        return newAdmin;
    }
 
    // Saves the admin account to Firebase Firestore.
    public void saveAdminAccountToFirebase(AdminAccount adminAccount) throws InterruptedException, ExecutionException {
        firestore.saveAdminAccountToFirebase(adminAccount);
    }

    // Retrieves existing admin accounts from Firebase Firestore.
    public List<String> fetchAdminAccounts() throws InterruptedException, ExecutionException {
        return firestore.fetchAdminAccountsFromFirestore();
    }

    // --------------------------------------------------
    // Admin Account Prototype Interface and Implementation
    // --------------------------------------------------
    public interface AdminAccountPrototype extends Cloneable {
        AdminAccount clone();
        void setUserId(String userId);
        void setPassword(String password);
    }

    public static class AdminAccount implements AdminAccountPrototype {
        private String userId;
        private String password;

        public AdminAccount(String userId, String password) {
            this.userId = userId;
            this.password = password;
        }

        // Copy constructor used for cloning.
        public AdminAccount(AdminAccount source) {
            this.userId = source.userId;
            this.password = source.password;
        }

        @Override
        public AdminAccount clone() {
            return new AdminAccount(this);
        }

        @Override
        public void setUserId(String userId) {
            this.userId = userId;
        }

        @Override
        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserId() {
            return userId;
        }

        public String getPassword() {
            return password;
        }
    }

    // Data Transfer Object for Firestore.
    public static class AdminAccountData {
        private String admin_user;
        private String admin_password;

        public AdminAccountData(String admin_user, String admin_password) {
            this.admin_user = admin_user;
            this.admin_password = admin_password;
        }

        public String getAdmin_user() {
            return admin_user;
        }

        public String getAdmin_password() {
            return admin_password;
        }
    }
}

