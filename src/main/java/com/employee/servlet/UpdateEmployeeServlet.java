
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

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {

	private EmployeeService employeeService;

	@Override
	public void init() throws ServletException {
		employeeService = new EmployeeServiceImpl();
	}

	// Fetch existing employee details
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int employeeId = Integer.parseInt(request.getParameter("employeeId"));

			Employee employee = employeeService.getEmployeeById(employeeId);

			if (employee != null) {
				request.setAttribute("employee", employee);
			} else {
				request.setAttribute("message", "Employee not found!");
			}

		} catch (NumberFormatException e) {
			request.setAttribute("message", "Invalid Employee ID!");
		}

		request.getRequestDispatcher("/updateEmployee.jsp").forward(request, response);
	}

	// Update employee details
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int employeeId = Integer.parseInt(request.getParameter("employeeId"));

			String name = request.getParameter("employeeName");
			String email = request.getParameter("email");
			String department = request.getParameter("department");

			double salary = Double.parseDouble(request.getParameter("salary"));

			Date joiningDate = Date.valueOf(request.getParameter("joiningDate"));

			// Create Employee object using default constructor
			Employee employee = new Employee();

			// Set all employee details
			employee.setEmployeeId(employeeId);
			employee.setEmployeeName(name);
			employee.setEmail(email);
			employee.setDepartment(department);
			employee.setSalary(salary);
			employee.setJoiningDate(joiningDate);

			if (employeeService.isEmailExistsForOtherEmployee(employee.getEmail(), employee.getEmployeeId())) {

				request.setAttribute("message", "Email already exists for another employee!");

				request.getRequestDispatcher("updateEmployee.jsp").forward(request, response);
				return;
			}

			boolean result = employeeService.updateEmployee(employee);

			if (result) {
				request.setAttribute("message", "Employee updated successfully!");
			} else {
				request.setAttribute("message", "Employee update failed!");
			}

		} catch (IllegalArgumentException e) {
			request.setAttribute("message", "Invalid employee input!");
		}

		request.getRequestDispatcher("/updateEmployee.jsp").forward(request, response);
	}
}
