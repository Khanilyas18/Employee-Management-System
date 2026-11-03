package com.employee.service;

import java.util.List;
import com.employee.model.Employee;

public interface EmployeeService {

    boolean addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int employeeId);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(int employeeId);
    
    boolean isEmailExists(String email);
    
    boolean isEmailExistsForOtherEmployee(String email, int employeeId);
    
    List<Employee> searchEmployeesByName(String employeeName);
    
    List<Employee> getEmployeesByDepartment(String department);
    
    List<Employee> getEmployeesByPage(int offset, int pageSize);

    int getTotalEmployeeCount();
}