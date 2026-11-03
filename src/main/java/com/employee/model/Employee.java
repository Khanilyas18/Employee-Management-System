package com.employee.model;

import java.sql.Date;

public class Employee {

	private int employeeId;
	private String employeeName;
	private String email;
	private String department;
	private double salary;
	private Date joiningDate;

	// Default Constructor
	public Employee() {
	}

	// Parameterized Constructor
	public Employee(String employeeName, String email, String department, double salary, Date joiningDate) {
		this.employeeName = employeeName;
		this.email = email;
		this.department = department;
		this.salary = salary;
		this.joiningDate = joiningDate;
	}

	// Getters and Setters
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
}