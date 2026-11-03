<!DOCTYPE html>
<html>
<head>
<title>Add Employee</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<h2>Add New Employee</h2>
	<p>${message}</p>
	<form action="addEmployee" method="post">

		<label>Employee Name:</label> <input type="text" name="employeeName"
			required> <br>
		<br> <label>Email:</label> <input type="email" name="email"
			required> <br>
		<br> <label>Department:</label> <input type="text"
			name="department" required> <br>
		<br> <label>Salary:</label> <input type="number" name="salary"
			step="0.01" min="0.01" required> <br>
		<br> <label>Joining Date:</label> <input type="date"
			name="joiningDate" required> <br>
		<br>

		<button type="submit">Add Employee</button>

	</form>

</body>
</html>