# Library Management System (JDBC Console Application)

## Description
A simple Java console application using **JDBC** and **MySQL** to manage library books.  
It demonstrates **CRUD operations** and **layered architecture**.

---

## Features
- Add book  
- View all books  
- Search by ID or Title  
- Update book  
- Delete book  

---

## Project Architecture

```
Main Layer
    ↓
Service Layer
    ↓
DAO Layer
    ↓
Database (MySQL)
```

---

## Layers

### 1. Main Layer
- Handles user input and menu  

### 2. Service Layer
- Handles validation and business logic  

### 3. DAO Layer
- Executes SQL queries using JDBC  

### 4. Model Layer
- Represents Book class  

### 5. Config Layer
- Manages database connection  

---

## Project Structure

```
src/
├── config/     (DBConnection.java)
├── model/      (Book.java)
├── dao/        (BookDAO.java)
├── service/    (BookService.java)
└── app/        (Main.java)
```

---

## Database Setup

### Create Database
```sql
CREATE DATABASE library_db;
```

### Create Table
```sql
CREATE TABLE books (
    id INT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(50),
    price DOUBLE,
    quantity INT
);
```

---

## Technologies
- Java  
- JDBC  
- MySQL  

---

## How to Run

### 1. Clone Repository
```bash
git clone https://github.com/RSujan123/libraryManagementSystem.git
```

### 2. Configure Database
Update in `DBConnection.java`:
```java
String url = "jdbc:mysql://localhost:3306/library_db";
String username = "your_username";
String password = "your_password";
```

### 3. Run Application
Run `Main.java`

---

## Menu

```
1 Add Book
2 View Books
3 Search by ID
4 Search by Title
5 Update Book
6 Delete Book
7 Exit
```

---

## Learning Outcomes
- JDBC basics  
- CRUD operations  
- DAO pattern  
- Layered architecture  

---

## Future Improvements
- Add GUI (JavaFX/Swing)  
- Use Spring Boot  
- Add logging and tests  

---

## Author
Built while learning Java Backend and JDBC.
