
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Employee By Name</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

    <h2>Search Employee By Name</h2>

    <form action="searchEmployeeByName" method="post">
        <label>Employee Name:</label>
        <input type="text" name="employeeName" required>
        <button type="submit">Search</button>
    </form>

    <p style="color:red;">${message}</p>

    <c:if test="${not empty employees}">
        <h3>Search Results</h3>

        <table border="1" cellpadding="8">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Department</th>
                <th>Salary</th>
                <th>Joining Date</th>
            </tr>

            <c:forEach var="emp" items="${employees}">
                <tr>
                    <td>${emp.employeeId}</td>
                    <td>${emp.employeeName}</td>
                    <td>${emp.email}</td>
                    <td>${emp.department}</td>
                    <td>${emp.salary}</td>
                    <td>${emp.joiningDate}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <br>
   <c:choose>
    <c:when test="${sessionScope.role == 'ADMIN'}">
        <a href="dashboard.jsp" class="btn btn-secondary">
            ← Dashboard
        </a>
    </c:when>

    <c:otherwise>
        <a href="employeeDashboard.jsp" class="btn btn-secondary">
            ← Dashboard
        </a>
    </c:otherwise>
</c:choose>

</body>
</html>
