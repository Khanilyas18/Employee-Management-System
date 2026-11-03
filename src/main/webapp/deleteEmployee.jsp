
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Employee</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <h2>Delete Employee</h2>

    <p>${message}</p>

    <form action="deleteEmployee" method="post">

        <label>Enter Employee ID:</label>

        <input type="number"
               name="employeeId"
               min="1"
               required>

        <br><br>

        <button type="submit"
                onclick="return confirm('Are you sure you want to delete this employee?')">
            Delete Employee
        </button>

    </form>

    <br>

    <a href="viewEmployees">View All Employees</a>

</body>
</html>
