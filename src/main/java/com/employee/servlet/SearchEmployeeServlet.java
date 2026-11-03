package com.employee.servlet;

import java.io.IOException;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import com.employee.service.EmployeeServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/searchEmployee")
public class SearchEmployeeServlet extends HttpServlet {

    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String idValue = request.getParameter("employeeId");

        try {
            int employeeId = Integer.parseInt(idValue);

            Employee employee =
                    employeeService.getEmployeeById(employeeId);

            if (employee != null) {
                request.setAttribute("employee", employee);
            } else {
                request.setAttribute(
                        "message", "Employee not found!");
            }

        } catch (NumberFormatException e) {
            request.setAttribute(
                    "message", "Please enter a valid Employee ID!");
        }

        request.getRequestDispatcher("/searchEmployee.jsp")
               .forward(request, response);
    }
}