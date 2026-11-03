
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

@WebServlet("/searchEmployeeByName")
public class SearchEmployeeByNameServlet extends HttpServlet {

    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String employeeName = request.getParameter("employeeName");

        List<Employee> employees =
                employeeService.searchEmployeesByName(employeeName);

        request.setAttribute("employees", employees);

        if (employees.isEmpty()) {
            request.setAttribute("message", "No employees found!");
        }

        request.getRequestDispatcher("searchByName.jsp")
               .forward(request, response);
    }
}
