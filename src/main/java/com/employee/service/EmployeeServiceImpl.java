package com.employee.service;

import java.util.ArrayList;
import java.util.List;

import com.employee.dao.EmployeeDAO;
import com.employee.dao.EmployeeDAOImpl;
import com.employee.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	@Override
	public boolean addEmployee(Employee employee) {

		if (employee == null) {
			return false;
		}

		if (employee.getEmployeeName() == null || employee.getEmployeeName().isBlank()) {
			return false;
		}

		if (employee.getEmail() == null || employee.getEmail().isBlank()) {
			return false;
		}

		if (employee.getDepartment() == null || employee.getDepartment().isBlank()) {
			return false;
		}

		if (employee.getSalary() <= 0) {
			return false;
		}

		return employeeDAO.addEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int employeeId) {

		if (employeeId <= 0) {
			return null;
		}

		return employeeDAO.getEmployeeById(employeeId);
	}

	@Override
	public boolean updateEmployee(Employee employee) {

		if (employee == null || employee.getEmployeeId() <= 0) {
			return false;
		}

		if (employee.getEmployeeName() == null || employee.getEmployeeName().isBlank()) {
			return false;
		}

		if (employee.getSalary() <= 0) {
			return false;
		}

		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {

		if (employeeId <= 0) {
			return false;
		}

		return employeeDAO.deleteEmployee(employeeId);
	}

	@Override
	public boolean isEmailExists(String email) {

		if (email == null || email.trim().isEmpty()) {
			return false;
		}

		return employeeDAO.isEmailExists(email.trim());
	}

	@Override
	public boolean isEmailExistsForOtherEmployee(String email, int employeeId) {

		if (email == null || email.trim().isEmpty() || employeeId <= 0) {
			return false;
		}

		return employeeDAO.isEmailExistsForOtherEmployee(email.trim(), employeeId);
	}

	@Override
	public List<Employee> searchEmployeesByName(String employeeName) {

		if (employeeName == null || employeeName.trim().isEmpty()) {
			return new ArrayList<>();
		}

		return employeeDAO.searchEmployeesByName(employeeName.trim());
	}

	@Override
	public List<Employee> getEmployeesByDepartment(String department) {

		if (department == null || department.trim().isEmpty()) {
			return new ArrayList<>();
		}

		return employeeDAO.getEmployeesByDepartment(department.trim());
	}
	
	@Override
	public List<Employee> getEmployeesByPage(int offset, int pageSize) {

	    if (offset < 0 || pageSize <= 0) {
	        return new ArrayList<>();
	    }

	    return employeeDAO.getEmployeesByPage(offset, pageSize);
	}

	@Override
	public int getTotalEmployeeCount() {
	    return employeeDAO.getTotalEmployeeCount();
	}
}