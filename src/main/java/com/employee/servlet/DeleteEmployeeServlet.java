
package com.employee.servlet;

import java.io.IOException;

import com.employee.service.EmployeeService;
import com.employee.service.EmployeeServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {

    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int employeeId = Integer.parseInt(
                    request.getParameter("employeeId"));

            boolean result =
                    employeeService.deleteEmployee(employeeId);

            if (result) {
                request.setAttribute(
                        "message", "Employee deleted successfully!");
            } else {
                request.setAttribute(
                        "message", "Employee not found or deletion failed!");
            }

        } catch (NumberFormatException e) {
            request.setAttribute(
                    "message", "Please enter a valid Employee ID!");
        }

        request.getRequestDispatcher("/deleteEmployee.jsp")
               .forward(request, response);
    }
}
