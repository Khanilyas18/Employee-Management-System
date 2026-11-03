
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.employee.model.Employee" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <h2>Update Employee Details</h2>

    <h3>Search Employee</h3>

    <form action="updateEmployee" method="get">

        <label>Employee ID:</label>

        <input type="number"
               name="employeeId"
               min="1"
               required>

        <button type="submit">Search</button>

    </form>

    <p>${message}</p>

    <%
        Employee emp =
            (Employee) request.getAttribute("employee");

        if (emp != null) {
    %>

        <h3>Edit Employee Details</h3>

        <form action="updateEmployee" method="post">

            <input type="hidden"
                   name="employeeId"
                   value="<%= emp.getEmployeeId() %>">

            <label>Employee Name:</label>

            <input type="text"
                   name="employeeName"
                   value="<%= emp.getEmployeeName() %>"
                   required>

            <br><br>

            <label>Email:</label>

            <input type="email"
                   name="email"
                   value="<%= emp.getEmail() %>"
                   required>

            <br><br>

            <label>Department:</label>

            <input type="text"
                   name="department"
                   value="<%= emp.getDepartment() %>"
                   required>

            <br><br>

            <label>Salary:</label>

            <input type="number"
                   name="salary"
                   value="<%= emp.getSalary() %>"
                   step="0.01"
                   min="0.01"
                   required>

            <br><br>

            <label>Joining Date:</label>

            <input type="date"
                   name="joiningDate"
                   value="<%= emp.getJoiningDate() %>"
                   required>

            <br><br>

            <button type="submit">Update Employee</button>

        </form>

    <%
        }
    %>

    <br>

    <a href="viewEmployees">View All Employees</a>

</body>
</html>
