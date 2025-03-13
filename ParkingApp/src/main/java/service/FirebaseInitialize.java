package service;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.FileInputStream;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;

@Service
public class FirebaseInitialize {
	@PostConstruct
	public void initialize() {
		try {
		FileInputStream serviceAccount =
				new FileInputStream("./google-services.json");

				FirebaseOptions options = new FirebaseOptions.Builder()
				  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				  .build();
				FirebaseApp.initializeApp(options);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
