
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

@WebServlet("/filterByDepartment")
public class FilterEmployeeByDepartmentServlet extends HttpServlet {

    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String department = request.getParameter("department");

        List<Employee> employees =
                employeeService.getEmployeesByDepartment(department);

        request.setAttribute("employees", employees);

        if (employees.isEmpty()) {
            request.setAttribute("message", "No employees found in this department!");
        }

        request.getRequestDispatcher("filterByDepartment.jsp")
               .forward(request, response);
    }
}
