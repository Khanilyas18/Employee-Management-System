
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String username = (String) session.getAttribute("username");
    String role = (String) session.getAttribute("role");

    if (username != null) {

        if ("ADMIN".equals(role)) {
            response.sendRedirect("dashboard.jsp");
            return;

        } else if ("EMPLOYEE".equals(role)) {
            response.sendRedirect("employeeDashboard.jsp");
            return;
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management - Login</title>
<link rel="stylesheet" href="css/style.css">


<style>
    body {
        min-height: 100vh;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        background: linear-gradient(135deg, #141e30, #243b55, #514a9d);
        font-family: Arial, sans-serif;
    }

    .login-container {
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 20px;
    }

    .login-card {
        width: 100%;
        max-width: 400px;
        padding: 35px;
        background: white;
        border-radius: 15px;
        box-shadow: 0 10px 35px rgba(0,0,0,0.25);
        text-align: center;
    }

    .login-card h2 {
        color: #243b55;
        margin-bottom: 10px;
    }

    .subtitle {
        color: #777;
        margin-bottom: 30px;
    }

    .login-card form {
        max-width: none;
        padding: 0;
        margin: 0;
        box-shadow: none;
        text-align: left;
    }

    .login-card label {
        display: block;
        margin-bottom: 7px;
        font-weight: bold;
    }

    .login-card input {
        width: 100%;
        padding: 12px;
        margin-bottom: 20px;
        border: 1px solid #ccc;
        border-radius: 6px;
    }

    .login-card button {
        width: 100%;
        padding: 13px;
        background: #243b55;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
    }

    .login-card button:hover {
        background: #514a9d;
    }

    .error-message {
        color: red;
        text-align: center;
        margin-top: 12px;
    }

    .back-link {
        display: inline-block;
        margin-top: 20px;
        text-decoration: none;
        color: #243b55;
    }
</style>

</head>

<body>

    <div class="login-container">

        <div class="login-card">

            <h2>Welcome Back!</h2>
            <p class="subtitle">Employee Management System</p>

            <form action="login" method="post">

                <label>Username</label>
                <input type="text" name="username"
                       placeholder="Enter your username" required>

                <label>Password</label>
                <input type="password" name="password"
                       placeholder="Enter your password" required>

                <button type="submit">Login</button>

                <p class="error-message">${message}</p>

            </form>

            <a href="index.jsp" class="back-link">← Back to Home</a>

        </div>

    </div>

</body>

</html>
