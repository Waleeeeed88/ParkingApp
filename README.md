# 🚗 YorkU Parking Management System (ParkingApp)

The **YorkU Parking Management System** is a Java-based parking booking system application designed to streamline the process of reserving parking spaces on campus for students, faculty, staff, and visitors. The system offers secure user authentication, efficient parking space management, and a seamless payment process.​ 

---

## 🔑 Features

- **User Authentication**: Secure registration and login for different user categories (students, faculty, staff, visitors).
- **Automated Account Generation**: Administrative accounts are automatically generated for the management team.
- **Parking Space Booking**: Users can reserve available parking spaces, with hourly rates varying based on user category.
- **Deposit System**: A one-hour deposit is required at booking, deducted upon checkout or forfeited in case of a no-show.
- **Sensor Integration**: Each parking space is equipped with a sensor to detect occupancy status.

---

## 🛠️ Technologies Used

- **Programming Language**: Java
- **Development Environment**: Eclipse IDE
- **Build Automation Tool**: Apache Maven
- **Testing Frameworks**: JUnit 5, Randoop
- **Mutation Testing**: PIT (Pitest) via Pitclipse
- **Database**: Firebase - Firestore Cloud Storage Database
- **GUI Framework**: Swing (Java)
- **Version Control**: Git & GitHub

---

## 📁 Project Structure
```
ParkingApp/
├── src/
│   ├── main/
│   │   └── java/          # Application source code
│   └── test/
│       └── java/          # Unit and integration tests
├── Documentation/         # Project documentation and related resources
├── ParkingAppClass.drawio.pdf  # Class diagram
├── pom.xml                # Maven configuration
└── README.md              # Project overview
```

---

## 🚀 Getting Started

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Waleeeeed88/ParkingApp.git
   ```

2. **Import into Eclipse**:
   - File > Import > Existing Maven Projects
   - Select the cloned repo folder

3. **Build the Project**:
   ```bash
   mvn clean install
   ```

4. **Run the Application**:
   - Locate the `ParkingApp` main class
   - Right-click → Run As → Java Application

---

## ✅ Testing

### Unit Testing with JUnit 5

JUnit Tests are located in `src/test/java/testParkingApp`.
Randoop Auto-Generated Regression Tests are located in `src/test/java/randoopTestParkingApp`.

Run tests with:
```bash
mvn test
```

### Automated Test Generation with Randoop

Randoop generates random test cases for non-GUI Java Classes under test. It utilizes the imported randoop-lib folder, which contains the randoop-all-4.2.1 jar file used for testing.

1. Example: Randoop Test Run for `UserLogin.java` class.
2. Opened Project Directory in the command prompt and run the following command: 
3. Generate tests:
   ```bash
    python randoop_automation.py --project-dir=. --test-class=com.parkingapp.UserLogin
   ```

### Randoop Automation Script (Python)

We use a `randoop_automation.py` script to:
- Compile the project
- Generate tests using Randoop
- Insert package declarations
- Move test files to the correct directories

Ensure `randoop_automation.py` is run from the root directory.

Reports are generated in:
```
target/site/index.html
```

### Mutation Testing with PIT (Pitest)

Mutation testing evaluates test effectiveness.

1. Ensure PITclipse is installed via github link: https://github.com/pitest/pitclipse
2. Ensure PIT is configured in `pom.xml`.
3. Run mutation tests on JUnit Test Classes

---

Prerequisites

    Java Development Kit (Preferably JDK 17)
    IDE with Java support (Examples: IntelliJ IDEA, Eclipse IDE)
    Set up Firebase Firestore Cloud Storage

🙌 Contributors

    Mohammad Waliduddin @Waleeeeed88
    Nathan Binu Edappilly @NathanBinu
    Harmandeep Arneja @HarmandeepArneja
    Bhavneet Kaur @bhavneetk20
    Syed Ali Raza Rizvi @aliriz71
    
License

    This project is for educational purposes only and should not be shared publicly outside the course.
