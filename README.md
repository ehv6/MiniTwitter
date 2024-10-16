# MiniTwitter

A Twitter-like application built with Spring Boot that allows users to register, log in, and create posts.

## Features
- User Registration and Authentication: Users can register and log in with encrypted passwords.
- Post Management: Users can create, view, and manage their posts.
- Secure Password Handling: Passwords are securely encrypted using Spring Security.

## Requirements
- Java Development Kit (JDK) 8 or later
- Dependencies managed by Maven
- MySQL Database

## Installation
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd MiniTwitter
2. Build the project: If you're using Maven, you can build the project by running:
   ```bash
   mvn clean install
3. Run the application: You can run the application using:
   ```bash
   mvn spring-boot:run

##Usage
- Once the project has begun running, head over to http://localhost:8080/login for the user interface.
- From here, you can create an account and log in.
- After logging in, you are able to create and view posts.
- You can log off after finishing.

## Technologies Used
Backend Framework: Spring Boot
Security: Spring Security
Database: MySQL
View Templates: Thymeleaf
Version Control: Git/GitHub

## Contributing
Contributions are welcome! Please feel free to submit a pull request or open an issue for any suggestions or improvements.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgements
Thanks to the Spring Boot community and all contributors for their support in making this project possible.
