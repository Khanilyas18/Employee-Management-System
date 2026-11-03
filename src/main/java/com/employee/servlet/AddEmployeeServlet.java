package com.employee.servlet;

import java.io.IOException;
import java.sql.Date;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import com.employee.service.EmployeeServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

	private EmployeeService employeeService;

	@Override
	public void init() throws ServletException {
		employeeService = new EmployeeServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String name = request.getParameter("employeeName");
			String email = request.getParameter("email").trim();
			String department = request.getParameter("department");
			double salary = Double.parseDouble(request.getParameter("salary"));

			Date joiningDate = Date.valueOf(request.getParameter("joiningDate"));

			Employee employee = new Employee(name, email, department, salary, joiningDate);

			if (employeeService.isEmailExists(email)) {
				request.setAttribute("message", "Email already exists! Please use another email.");
				request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
				return;
			}

			boolean result = employeeService.addEmployee(employee);

			if (result) {
				request.setAttribute("message", "Employee added successfully!");
			} else {
				request.setAttribute("message", "Employee insertion failed!");
			}

		} catch (IllegalArgumentException e) {
			request.setAttribute("message", "Invalid employee input!");
		}

		request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
	}
}