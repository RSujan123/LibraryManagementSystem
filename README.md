📚 Library Management System (JDBC Console Application)

A Java console-based Library Management System built using JDBC and MySQL.
This project demonstrates how to implement CRUD operations, layered architecture, and database connectivity in Java without using frameworks.

The application allows users to manage books in a library through a simple menu-driven console interface.

🚀 Features

Add new books

View all books

Search book by ID

Search book by Title

Update book details

Delete books

Input validation using service layer

Structured layered architecture

🏗️ Project Architecture

This project follows a layered architecture commonly used in enterprise Java applications.

Main (Application Layer)
        ↓
Service Layer (Business Logic)
        ↓
DAO Layer (Database Operations)
        ↓
Database (MySQL)
Layers Explanation

1️⃣ Main Layer

Handles user interaction

Displays menu

Collects input from user

2️⃣ Service Layer

Performs validation

Handles business logic

Calls DAO methods

3️⃣ DAO Layer

Contains SQL queries

Communicates with the database using JDBC

4️⃣ Model Layer

Represents database entities as Java classes

5️⃣ Config Layer

Handles database connection management

📂 Project Structure
src
 ├── config
 │     └── DBConnection.java
 │
 ├── model
 │     └── Book.java
 │
 ├── dao
 │     └── BookDAO.java
 │
 ├── service
 │     └── BookService.java
 │
 └── app
       └── Main.java
🗄️ Database Schema

Database Name:

library_db

Table:

CREATE TABLE books (
    id INT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(50),
    price DOUBLE,
    quantity INT
);
🛠️ Technologies Used

Java

JDBC

MySQL

IntelliJ IDEA

Git & GitHub

⚙️ How to Run the Project
1️⃣ Clone the repository
git clone https://github.com/yourusername/library-management-system-jdbc.git
2️⃣ Create Database

Open MySQL and run:

CREATE DATABASE library_db;

Then create the table:

CREATE TABLE books (
    id INT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(50),
    price DOUBLE,
    quantity INT
);
3️⃣ Configure Database Connection

Open:

config/DBConnection.java

Update credentials:

String url = "jdbc:mysql://localhost:3306/library_db";
String username = "your_username";
String password = "your_password";
4️⃣ Add MySQL Connector

Download MySQL JDBC Driver:

https://dev.mysql.com/downloads/connector/j/

Add the mysql-connector-j.jar to your project dependencies.

5️⃣ Run the Application

Run:

Main.java
📋 Example Menu
------ Library Management System ------

1 Add Book
2 View Books
3 Search Book by ID
4 Search Book by Title
5 Update Book
6 Delete Book
7 Exit
📖 Learning Outcomes

This project helped practice:

JDBC database connectivity

PreparedStatement usage

ResultSet processing

CRUD operations

DAO pattern implementation

Layered architecture design

Input validation and error handling

📌 Future Improvements

Possible enhancements:

Add SQL joins for advanced queries

Implement Spring Boot version

Add GUI using JavaFX or Swing

Add logging

Implement unit tests

👨‍💻 Author

Developed as part of learning Java Backend Development and JDBC.

⭐ If you found this project helpful, consider giving it a star on GitHub!
