
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee Dashboard</title>

<link rel="stylesheet" href="css/style.css">

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        font-family: Arial, sans-serif;
        background: #f4f6fb;
        display: flex;
        min-height: 100vh;
    }

    .sidebar {
        width: 250px;
        background: #141e30;
        color: white;
        padding: 30px 20px;
        min-height: 100vh;
        flex-shrink: 0;
    }

    .sidebar h2 {
        color: white;
        text-align: center;
        margin-bottom: 35px;
        font-size: 22px;
    }

    .sidebar a {
        display: block;
        color: #dbeafe;
        padding: 13px 15px;
        margin-bottom: 8px;
        border-radius: 7px;
        text-decoration: none;
        transition: 0.3s;
    }

    .sidebar a:hover {
        background: #514a9d;
        color: white;
    }

    .main-content {
        flex: 1;
        padding: 35px;
        min-width: 0;
    }

    .topbar {
        display: flex;
        justify-content: space-between;
        align-items: center;
        gap: 15px;
        margin-bottom: 35px;
        flex-wrap: wrap;
    }

    .topbar h1 {
        color: #243b55;
        font-size: 28px;
    }

    .welcome {
        color: #64748b;
        margin-top: 8px;
    }

    .logout-btn {
        background: #dc3545;
        color: white;
        padding: 11px 22px;
        border-radius: 7px;
        text-decoration: none;
    }

    .logout-btn:hover {
        background: #b02a37;
        color: white;
    }

    .summary-cards {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(190px, 1fr));
        gap: 20px;
        margin-bottom: 35px;
    }

    .summary-card {
        background: white;
        padding: 25px;
        border-radius: 12px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.06);
        border-left: 5px solid #514a9d;
    }

    .summary-card h3 {
        color: #64748b;
        font-size: 15px;
        margin-bottom: 12px;
    }

    .summary-card p {
        color: #243b55;
        font-size: 20px;
        font-weight: bold;
    }

    .section-title {
        margin-bottom: 20px;
        color: #243b55;
    }

    .operations {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(210px, 1fr));
        gap: 20px;
    }

    .operation-card {
        background: white;
        padding: 25px;
        border-radius: 12px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.06);
        transition: 0.3s;
    }

    .operation-card:hover {
        transform: translateY(-5px);
        box-shadow: 0 7px 20px rgba(0,0,0,0.12);
    }

    .operation-card h3 {
        color: #243b55;
        margin-bottom: 12px;
        font-size: 18px;
    }

    .operation-card p {
        color: #64748b;
        line-height: 1.5;
        margin-bottom: 18px;
        font-size: 14px;
    }

    .operation-card a {
        display: inline-block;
        background: #243b55;
        color: white;
        padding: 10px 17px;
        border-radius: 6px;
        text-decoration: none;
    }

    .operation-card a:hover {
        background: #514a9d;
    }

    @media(max-width: 700px) {
        body {
            display: block;
        }

        .sidebar {
            width: 100%;
            min-height: auto;
        }

        .main-content {
            padding: 22px;
        }
    }
</style>

</head>

<body>

    <aside class="sidebar">

        <h2>EMS Employee</h2>

        <a href="employeeDashboard.jsp">Dashboard</a>
        <a href="viewEmployees">View Employees</a>
        <a href="searchEmployee.jsp">Search By ID</a>
        <a href="searchByName.jsp">Search By Name</a>
        <a href="filterByDepartment.jsp">Department Filter</a>
        <a href="logout">Logout</a>

    </aside>

    <main class="main-content">

        <div class="topbar">

            <div>
                <h1>Employee Dashboard</h1>

                <p class="welcome">
                    Welcome back, ${sessionScope.username}!
                    Access employee information from one place.
                </p>
            </div>

            <a href="logout" class="logout-btn">Logout</a>

        </div>

        <div class="summary-cards">

            <div class="summary-card">
                <h3>Account</h3>
                <p>Employee</p>
            </div>

            <div class="summary-card">
                <h3>Your Role</h3>
                <p>${sessionScope.role}</p>
            </div>

            <div class="summary-card">
                <h3>Access</h3>
                <p>Read Only</p>
            </div>

        </div>

        <h2 class="section-title">Available Features</h2>

        <div class="operations">

            <div class="operation-card">
                <h3>View Employees</h3>
                <p>View employee records available in the system.</p>
                <a href="viewEmployees">View Records</a>
            </div>

            <div class="operation-card">
                <h3>Search By ID</h3>
                <p>Find employee information using employee ID.</p>
                <a href="searchEmployee.jsp">Search Now</a>
            </div>

            <div class="operation-card">
                <h3>Search By Name</h3>
                <p>Find employees using their names.</p>
                <a href="searchByName.jsp">Search Now</a>
            </div>

            <div class="operation-card">
                <h3>Department Filter</h3>
                <p>Find employee records according to department.</p>
                <a href="filterByDepartment.jsp">Filter Records</a>
            </div>

        </div>

    </main>

</body>
</html>
