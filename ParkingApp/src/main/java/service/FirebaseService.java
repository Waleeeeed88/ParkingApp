package service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {

    private static final String API_KEY = "AIzaSyAeBBsBEyflDmEmfjwiX7rm0FuILDflss4"; 
    private static final String SIGN_IN_URL = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + API_KEY;
    private static final String SIGN_UP_URL = "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=" + API_KEY;

    // 🔹 **User Registration**
    public String registerUser(String email, String password) {
        try {
            String response = sendHttpRequest(SIGN_UP_URL, email, password);
            JSONObject jsonResponse = new JSONObject(response);
            if (jsonResponse.has("idToken")) {
                return "User registered successfully";
            } else {
                return handleFirebaseError(jsonResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Registration failed: " + e.getMessage();
        }
    }

    // 🔹 **User Login**
    public String loginUser(String email, String password) {
        try {
            String response = sendHttpRequest(SIGN_IN_URL, email, password);
            JSONObject jsonResponse = new JSONObject(response);
            if (jsonResponse.has("idToken")) {
                return jsonResponse.getString("idToken"); // ✅ Returns ID token for authentication
            } else {
                return handleFirebaseError(jsonResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Login failed: " + e.getMessage();
        }
    }

    // 🔹 **Helper Method to Handle HTTP Requests**
    private String sendHttpRequest(String urlString, String email, String password) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String jsonInputString = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"returnSecureToken\":true}";

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        return getResponse(conn);
    }

    // 🔹 **Handle Firebase API Response**
    private String getResponse(HttpURLConnection conn) throws IOException {
        int responseCode = conn.getResponseCode();
        BufferedReader br;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        } else {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"));
        }

        StringBuilder response = new StringBuilder();
        String responseLine;
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }
        return response.toString();
    }

    // 🔹 **Error Handling for Firebase API**
    private String handleFirebaseError(JSONObject jsonResponse) {
        if (jsonResponse.has("error")) {
            JSONObject error = jsonResponse.getJSONObject("error");
            String message = error.getString("message");
            return "Firebase Error: " + message;
        }
        return "Unknown Firebase error";
    }

    // 🔹 **Fetch Parking Spaces from Firestore**
    public Map<String, Object> fetchParkingSpaces() {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection("Parking_spaces").get();

        Map<String, Object> parkingData = new HashMap<>();
        try {
            for (var document : future.get().getDocuments()) {
                parkingData.put(document.getId(), document.getData());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parkingData;
    }

    // 🔹 **Add Parking Space to Firestore**
    public void addParkingSpace(Map<String, Object> parkingInfo) {
        Firestore db = FirestoreClient.getFirestore();
        db.collection("Parking_spaces").document((String) parkingInfo.get("id")).set(parkingInfo);
        System.out.println("Parking space added to Firestore.");
    }
}
