# Employee Management System

A Java-based Employee Management System built using **Java Servlets, JSP, JDBC, MySQL, and Maven**. The application provides employee record management with role-based authentication for Admin and Employee users.

## Features

### Authentication & Security
- User login and logout
- BCrypt password hashing
- Session management
- Role-based access control using Servlet Filter
- Separate Admin and Employee dashboards

### Employee Management
- Add new employees
- View all employees
- Update employee details
- Delete employee records
- Search employees by ID
- Search employees by name
- Filter employees by department
- Pagination for employee records

### Validation
- Required field validation
- Duplicate email validation
- Input validation
- Access restrictions based on user roles

## Technologies Used

| Technology | Purpose |
|---|---|
| Java 21 | Backend programming |
| Jakarta Servlet 6.0 | Request handling |
| JSP | Frontend pages |
| JSTL 3.0 | Dynamic JSP content |
| JDBC | Database connectivity |
| MySQL 8 | Database |
| Maven | Dependency management |
| Apache Tomcat 10.1 | Application server |
| BCrypt | Password hashing |
| HTML & CSS | User interface |
| Eclipse IDE | Development environment |

## Project Architecture

The application follows a layered architecture:

- **Model:** Represents application entities.
- **DAO:** Handles database operations.
- **Service:** Contains business logic and validations.
- **Servlet:** Handles HTTP requests and responses.
- **Filter:** Controls authentication and authorization.
- **JSP:** Displays the user interface.

## Database Setup

1. Start your MySQL server.
2. Create the database:

```sql
CREATE DATABASE employee_management;
USE employee_management;
```

3. Create the employees table:

```sql
CREATE TABLE employees (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    department VARCHAR(50) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    joining_date DATE
);
```

4. Create the users table:

```sql
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) DEFAULT 'ADMIN'
);
```

5. Configure your MySQL connection in `DBConnection.java`.

**Important:** Use your own database username and password. Never commit actual database credentials or plain-text passwords to GitHub.

Create user accounts with BCrypt-hashed passwords and appropriate roles (`ADMIN` or `EMPLOYEE`).

## How to Run the Project

### Prerequisites

- JDK 21 or compatible Java version
- Eclipse IDE
- Apache Tomcat 10.1
- MySQL Server
- Maven

### Steps

1. Clone or download this repository.
2. Import the project into Eclipse as an Existing Maven Project.
3. Configure MySQL database credentials.
4. Make sure the required Maven dependencies are downloaded.
5. Configure Apache Tomcat 10.1 in Eclipse.
6. Add the project to the Tomcat server.
7. Start the server.
8. Open the application:

```text
http://localhost:8080/EmployeeManagementSystem/
```

## User Roles

| Role | Permissions |
|---|---|
| ADMIN | Add, view, update, delete, search and filter employees |
| EMPLOYEE | View, search and filter employee records |



## Future Enhancements

- Export employee records to PDF or Excel
- Advanced search and sorting
- Improved reporting dashboard
- Automated testing

## Author

**Ilyas Khan**

## License

This project is available for educational and portfolio purposes.
