
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Employee Management System</title>

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
        color: #243b55;
    }

    .hero {
        min-height: 90vh;
        background: linear-gradient(135deg, #141e30, #243b55, #514a9d);
        color: white;
        display: flex;
        align-items: center;
        justify-content: center;
        text-align: center;
        padding: 50px 20px;
    }

    .hero-content {
        max-width: 850px;
    }

    .tagline {
        display: inline-block;
        background: rgba(255,255,255,0.15);
        padding: 10px 20px;
        border-radius: 30px;
        margin-bottom: 25px;
        font-size: 14px;
    }

    .hero h1 {
        color: white;
        font-size: 48px;
        margin-bottom: 20px;
    }

    .hero p {
        color: #e0e7ff;
        font-size: 18px;
        line-height: 1.7;
        margin-bottom: 30px;
    }

    .login-btn {
        display: inline-block;
        background: white;
        color: #243b55;
        padding: 14px 35px;
        border-radius: 30px;
        text-decoration: none;
        font-weight: bold;
        transition: 0.3s;
    }

    .login-btn:hover {
        background: #dbeafe;
        transform: translateY(-3px);
    }

    .features {
        padding: 65px 8%;
        text-align: center;
    }

    .features h2 {
        font-size: 32px;
        margin-bottom: 12px;
    }

    .subtitle {
        color: #64748b;
        margin-bottom: 40px;
    }

    .feature-container {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
        gap: 25px;
    }

    .feature-card {
        background: white;
        padding: 30px 22px;
        border-radius: 12px;
        box-shadow: 0 5px 20px rgba(0,0,0,0.07);
        transition: 0.3s;
    }

    .feature-card:hover {
        transform: translateY(-7px);
    }

    .feature-card h3 {
        margin-bottom: 12px;
        color: #243b55;
    }

    .feature-card p {
        color: #64748b;
        line-height: 1.6;
    }

    footer {
        background: #141e30;
        color: white;
        text-align: center;
        padding: 22px;
        font-size: 14px;
    }

    @media (max-width: 600px) {
        .hero h1 {
            font-size: 34px;
        }

        .hero p {
            font-size: 16px;
        }
    }
</style>

</head>

<body>

    <section class="hero">

        <div class="hero-content">

            <div class="tagline">
                Welcome to Employee Management System
            </div>

            <h1>Manage Your Workforce Smarter</h1>

            <p>
                A simple and secure platform to manage employee records,
                search employee information, and organize your workforce
                efficiently.
            </p>

            <a href="login.jsp" class="login-btn">
                Get Started &nbsp; →
            </a>

        </div>

    </section>

    <section class="features">

        <h2>What You Can Do</h2>

        <p class="subtitle">
            Everything you need to manage employee information.
        </p>

        <div class="feature-container">

            <div class="feature-card">
                <h3>Employee Records</h3>
                <p>
                    Add, view, update and delete employee information
                    with ease.
                </p>
            </div>

            <div class="feature-card">
                <h3>Smart Search</h3>
                <p>
                    Search employees by ID or name and find records quickly.
                </p>
            </div>

            <div class="feature-card">
                <h3>Department Filter</h3>
                <p>
                    Filter employee records according to their department.
                </p>
            </div>

            <div class="feature-card">
                <h3>Secure Access</h3>
                <p>
                    Role-based login system with separate ADMIN
                    and EMPLOYEE permissions.
                </p>
            </div>

        </div>

    </section>

    <footer>
        <p>Employee Management System | Java Servlet & MySQL Project</p>
    </footer>

</body>
</html>
