
package com.employee.servlet;

import java.io.IOException;

import com.employee.model.User;
import com.employee.service.UserService;
import com.employee.service.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = userService.login(username, password);

		if (user != null) {

			HttpSession oldSession = request.getSession(false);

			if (oldSession != null) {
				oldSession.invalidate();
			}

			HttpSession session = request.getSession(true);

			// HttpSession session = request.getSession();

			session.setAttribute("username", user.getUsername());
			session.setAttribute("role", user.getRole());

			if ("ADMIN".equals(user.getRole())) {

			    response.sendRedirect("dashboard.jsp");

			} else if ("EMPLOYEE".equals(user.getRole())) {

			    response.sendRedirect("employeeDashboard.jsp");

			} else {

			    session.invalidate();
			    response.sendRedirect("login.jsp");
			}

		} else {

			request.setAttribute("message", "Invalid username or password!");

			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
