# Code Analyzer

This is a **Spring Boot + MySQL + HTML (frontend)** project to analyze Java code submissions, score them, and store results in a database.  
Users can register, submit their Java code, and get an analysis score with feedback.

## 📋 Features
- User registration with email & username
- Java code submission & analysis
- Analysis score & issues detected
- Results saved in MySQL database
- Simple HTML/CSS frontend

## 🖥️ Tech Stack
- Java 17
- Spring Boot 3.x
- Maven
- MySQL
- HTML / CSS

## 🚀 How to Run
1. Clone this repository:
```bash
git clone <https://github.com/arinash143/codeanalyzer.git>

Navigate into the folder:
cd codeanalyzer

2.Run Maven build:
mvn clean install

3.Start the application:
mvn spring-boot:run

4.Open your browser and visit:
http://localhost:8080

5.MySQL setup:
Create a database: codeanalyzerdb
Update your MySQL username/password in src/main/resources/application.properties
