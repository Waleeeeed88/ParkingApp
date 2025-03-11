YorkU Parking Management System (ParkingApp)

The YorkU Parking Management System is a Java-based parking booking system designed to provide students, faculty members, non-faculty staff, and visitors with a streamlined and user-friendly experience for reserving parking spaces on campus. The system ensures secure user authentication, efficient parking space management, and a seamless payment process.
Features

    User Authentication: Secure registration and login for different types of clients (students, faculty, staff, visitors).
    Automated Account Generation: Management team accounts are automatically generated for administrative access.
    Parking Space Booking: Users can book available parking spaces with different hourly rates based on their category.
    Deposit System: A one-hour deposit is required, which is deducted upon checkout or forfeited in case of a no-show.
    Sensor Integration: Each parking space is equipped with a sensor to detect occupancy and verify license plate details.
    Parking Lot Management: Administrators can add, enable, disable, and maintain parking lots and spaces.
    Navigation Assistance: Each parking space has a unique ID and location details for easy access.
    Booking Management: Users can edit, cancel, or extend their reservations before expiration.
    Multiple Payment Options: Payments can be made via debit cards, credit cards, or mobile payment methods.

Repository Structure

The project is structured as follows:

    src/: Contains the core source code for the system.
    InterfaceGui/: Houses the Java Swing-based graphical user interface components.
    database/: Includes CSV files that simulate a database for parking records, user information, and transactions.
    test/: Contains JUnit test cases for different modules of the project.
    docs/: Includes UML diagrams (use case, sequence, activity, class diagrams) and design documentation.

Getting Started
Prerequisites

    Java Development Kit (JDK 17 or later)
    IDE with Java support (e.g., IntelliJ IDEA, Eclipse)
    CSV file handling knowledge for database simulation

Installation

    Clone the repository:

    git clone https://github.com/Waleeeeed88/ParkingApp

    Open the project in your preferred IDE.
    Navigate to the database/ folder and ensure all CSV files are correctly formatted.
    Compile and run the application.

Usage

    Login/Register: Users must register and log in before booking a parking space.
    Book a Parking Spot: Select an available parking space, enter the license plate number, and confirm payment.
    Manage Reservations: Users can cancel, modify, or extend their bookings before the reservation time starts.
    Check-in and Check-out: The system detects the vehicle’s arrival and automatically updates the booking status.
    Admin Control: The parking management team can monitor parking space availability, modify settings, and handle maintenance.

Design Patterns Used

TBD

Documentation and Demo

    Detailed UML diagrams and technical documentation are available in the Documentation/ folder.
    A demo video showcasing the system’s functionality can be accessed here: 

Contributors

    Mohammad Waliduddin
    Nathan Binu
    Harmandeep Arneja
    Bhavneet Kaur
    Syed Rizvi
    

License

This project is for educational purposes only and should not be shared publicly outside the course.
