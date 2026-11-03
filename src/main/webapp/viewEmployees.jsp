
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Employees | Employee Management</title>
<link rel="stylesheet" href="css/style.css">

<style>
* {
    box-sizing: border-box;
}

body {
    margin: 0;
    padding: 30px;
    background: #f4f7fb;
    font-family: 'Segoe UI', Arial, sans-serif;
    color: #263247;
}

.container {
    max-width: 1250px;
    margin: auto;
}

.top-section {
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    gap: 15px;
    margin-bottom: 25px;
}

.heading h2 {
    margin: 0;
    font-size: 27px;
    color: #172554;
}

.heading p {
    color: #718096;
    margin-top: 7px;
}

.actions {
    display: flex;
    gap: 10px;
    flex-wrap: wrap;
}

.btn {
    display: inline-block;
    padding: 11px 18px;
    border-radius: 8px;
    text-decoration: none;
    font-weight: 600;
    font-size: 14px;
    transition: 0.2s;
}

.btn-primary {
    background: #2563eb;
    color: white;
}

.btn-primary:hover {
    background: #1d4ed8;
}

.btn-secondary {
    background: #e2e8f0;
    color: #334155;
}

.btn-secondary:hover {
    background: #cbd5e1;
}

.summary-card {
    background: white;
    padding: 22px;
    border-radius: 12px;
    margin-bottom: 25px;
    box-shadow: 0 3px 15px rgba(0,0,0,0.05);
    border-left: 5px solid #2563eb;
}

.summary-card span {
    color: #718096;
    font-size: 14px;
}

.summary-card h3 {
    font-size: 28px;
    margin: 8px 0 0;
    color: #172554;
}

.table-card {
    background: white;
    border-radius: 12px;
    padding: 22px;
    box-shadow: 0 3px 15px rgba(0,0,0,0.05);
    overflow-x: auto;
}

.table-heading {
    margin: 0 0 20px;
    color: #172554;
    font-size: 19px;
}

table {
    width: 100%;
    border-collapse: collapse;
    min-width: 750px;
}

thead {
    background: #eff4ff;
}

th {
    padding: 15px 12px;
    text-align: left;
    color: #334155;
    font-size: 13px;
    text-transform: uppercase;
    letter-spacing: 0.4px;
}

td {
    padding: 15px 12px;
    border-bottom: 1px solid #edf0f5;
    font-size: 14px;
    color: #475569;
}

tbody tr:hover {
    background: #f8faff;
}

.employee-id {
    font-weight: 700;
    color: #2563eb;
}

.department {
    display: inline-block;
    background: #e8efff;
    color: #1d4ed8;
    padding: 5px 10px;
    border-radius: 20px;
    font-size: 12px;
    font-weight: 600;
}

.salary {
    font-weight: 600;
    color: #15803d;
}

.pagination {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 15px;
    margin-top: 25px;
    flex-wrap: wrap;
}

.page-btn {
    text-decoration: none;
    background: #2563eb;
    color: white;
    padding: 9px 17px;
    border-radius: 7px;
    font-size: 14px;
    font-weight: 600;
}

.page-btn:hover {
    background: #1d4ed8;
}

.page-info {
    color: #475569;
    font-size: 14px;
    font-weight: 600;
}

.empty-state {
    text-align: center;
    padding: 35px;
    color: #718096;
}

@media(max-width: 600px) {
    body {
        padding: 15px;
    }

    .heading h2 {
        font-size: 22px;
    }
}
</style>
</head>

<body>

<div class="container">

    <div class="top-section">

        <div class="heading">
            <h2>Employee Management</h2>
            <p>View and manage all registered employees.</p>
        </div>

        <div class="actions">

            <!-- Role-based Dashboard Navigation -->
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

            <!-- Only Admin can add employees -->
            <c:if test="${sessionScope.role == 'ADMIN'}">
                <a href="addEmployee.jsp" class="btn btn-primary">
                    + Add Employee
                </a>
            </c:if>

        </div>
    </div>

    <div class="summary-card">
        <span>Employees on this page</span>
        <h3>${employees.size()}</h3>
    </div>

    <div class="table-card">

        <h3 class="table-heading">All Employees</h3>

        <c:choose>
            <c:when test="${not empty employees}">

                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Department</th>
                            <th>Salary</th>
                            <th>Joining Date</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="emp" items="${employees}">
                            <tr>
                                <td class="employee-id">#${emp.employeeId}</td>
                                <td><strong>${emp.employeeName}</strong></td>
                                <td>${emp.email}</td>
                                <td>
                                    <span class="department">
                                        ${emp.department}
                                    </span>
                                </td>
                                <td class="salary">₹ ${emp.salary}</td>
                                <td>${emp.joiningDate}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:when>

            <c:otherwise>
                <div class="empty-state">
                    <h3>No Employees Found</h3>
                    <p>There are currently no employee records to display.</p>
                </div>
            </c:otherwise>
        </c:choose>

        <c:if test="${totalPages > 0}">
            <div class="pagination">

                <c:if test="${currentPage > 1}">
                    <a href="viewEmployees?page=${currentPage - 1}"
                       class="page-btn">← Previous</a>
                </c:if>

                <span class="page-info">
                    Page ${currentPage} of ${totalPages}
                </span>

                <c:if test="${currentPage < totalPages}">
                    <a href="viewEmployees?page=${currentPage + 1}"
                       class="page-btn">Next →</a>
                </c:if>

            </div>
        </c:if>

    </div>

</div>

</body>
</html>
