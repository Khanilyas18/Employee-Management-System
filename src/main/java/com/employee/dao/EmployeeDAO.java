package com.employee.dao;

import com.employee.model.Employee;
import java.util.List;

public interface EmployeeDAO {

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