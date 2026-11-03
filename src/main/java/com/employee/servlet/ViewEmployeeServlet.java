package com.employee.servlet;

import java.io.IOException;
import java.util.List;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import com.employee.service.EmployeeServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewEmployees")
public class ViewEmployeeServlet extends HttpServlet {

	private EmployeeService employeeService;

	@Override
	public void init() throws ServletException {
		employeeService = new EmployeeServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int page = 1;
		int pageSize = 5;

		try {
			String pageParam = request.getParameter("page");

			if (pageParam != null) {
				page = Integer.parseInt(pageParam);
			}

			if (page < 1) {
				page = 1;
			}

		} catch (NumberFormatException e) {
			page = 1;
		}

		int offset = (page - 1) * pageSize;

		List<Employee> employees = employeeService.getEmployeesByPage(offset, pageSize);

		int totalEmployees = employeeService.getTotalEmployeeCount();

		int totalPages = (int) Math.ceil((double) totalEmployees / pageSize);

		request.setAttribute("employees", employees);
		request.setAttribute("currentPage", page);
		request.setAttribute("totalPages", totalPages);

		request.getRequestDispatcher("viewEmployees.jsp").forward(request, response);
	}

}