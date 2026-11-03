
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Employee</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<h2>Search Employee By ID</h2>

	<form action="searchEmployee" method="get">

		<label>Enter Employee ID:</label> <input type="number"
			name="employeeId" min="1" required>

		<button type="submit">Search</button>

	</form>

	<br>

	<p>${message}</p>

	<%-- Display employee details when found --%>

	<%
	com.employee.model.Employee emp = (com.employee.model.Employee) request.getAttribute("employee");

	if (emp != null) {
	%>

	<h3>Employee Details</h3>

	<table border="1" cellpadding="10" cellspacing="0">

		<tr>
			<th>Employee ID</th>
			<td><%=emp.getEmployeeId()%></td>
		</tr>

		<tr>
			<th>Name</th>
			<td><%=emp.getEmployeeName()%></td>
		</tr>

		<tr>
			<th>Email</th>
			<td><%=emp.getEmail()%></td>
		</tr>

		<tr>
			<th>Department</th>
			<td><%=emp.getDepartment()%></td>
		</tr>

		<tr>
			<th>Salary</th>
			<td><%=emp.getSalary()%></td>
		</tr>

		<tr>
			<th>Joining Date</th>
			<td><%=emp.getJoiningDate()%></td>
		</tr>

	</table>

	<%
	}
	%>

	<br>

	<a href="viewEmployees">View All Employees</a><br><br>
<c:choose>
    <c:when test="${sessionScope.role == 'ADMIN'}">
        <a href="dashboard.jsp" class="btn btn-secondary">
            ←Admin Dashboard
        </a>
    </c:when>

    <c:otherwise>
        <a href="employeeDashboard.jsp" class="btn btn-secondary">
            ←Employee Dashboard
        </a>
    </c:otherwise>
</c:choose>

</body>
</html>
