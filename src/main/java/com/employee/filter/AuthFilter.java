
package com.employee.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/dashboard.jsp", "/employeeDashboard.jsp", "/addEmployee.jsp", "/addEmployee",
		"/viewEmployees", "/viewEmployees.jsp", "/searchEmployee", "/searchEmployee.jsp", "/updateEmployee",
		"/updateEmployee.jsp", "/deleteEmployee.jsp", "/deleteEmployee", "/searchEmployeeByName", "/searchByName.jsp",
		"/filterByDepartment", "/filterByDepartment.jsp" })
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		res.setHeader("Pragma", "no-cache");
		res.setDateHeader("Expires", 0);

		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("username") == null) {
			res.sendRedirect(req.getContextPath() + "/login.jsp");
			return;
		}

		String role = (String) session.getAttribute("role");
		String path = req.getServletPath();

		boolean employeeAllowed = path.equals("/employeeDashboard.jsp") || path.equals("/viewEmployees")
				|| path.equals("/viewEmployees.jsp") || path.equals("/searchEmployee")
				|| path.equals("/searchEmployee.jsp") || path.equals("/searchEmployeeByName")
				|| path.equals("/searchByName.jsp") || path.equals("/filterByDepartment")
				|| path.equals("/filterByDepartment.jsp");

		if ("ADMIN".equals(role)) {
			chain.doFilter(request, response);

		} else if ("EMPLOYEE".equals(role) && employeeAllowed) {
			chain.doFilter(request, response);

		} else {
			res.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied! You do not have permission.");
		}
	}
}
