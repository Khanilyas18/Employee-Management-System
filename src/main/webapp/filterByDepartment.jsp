
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filter Employees By Department</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<h2>Filter Employees By Department</h2>

	<form action="filterByDepartment" method="post">

		<label>Select Department:</label> <select name="department" required>
			<option value="">-- Select Department --</option>
			<option value="IT">IT</option>
			<option value="HR">HR</option>
			<option value="Finance">Finance</option>
			<option value="Sales">Sales</option>
			<option value="Marketing">Marketing</option>
		</select>

		<button type="submit">Filter</button>

	</form>

	<p style="color: red;">${message}</p>

	<c:if test="${not empty employees}">
		<h3>Filtered Employees</h3>

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
			<a href="dashboard.jsp" class="btn btn-secondary"> ← Dashboard </a>
		</c:when>

		<c:otherwise>
			<a href="employeeDashboard.jsp" class="btn btn-secondary"> ←
				Dashboard </a>
		</c:otherwise>
	</c:choose>

</body>
</html>
