package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.employee.model.Employee;
import com.employee.util.DBConnection;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public boolean addEmployee(Employee employee) {

		String sql = "INSERT INTO employees " + "(employee_name, email, department, salary, joining_date) "
				+ "VALUES (?, ?, ?, ?, ?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, employee.getEmployeeName());
			ps.setString(2, employee.getEmail());
			ps.setString(3, employee.getDepartment());
			ps.setDouble(4, employee.getSalary());
			ps.setDate(5, employee.getJoiningDate());

			int rows = ps.executeUpdate();

			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isEmailExists(String email) {

		String sql = "SELECT COUNT(*) FROM employees WHERE email = ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, email);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {
					return rs.getInt(1) > 0;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> employees = new ArrayList<>();

		String sql = "SELECT * FROM employees";

		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				Employee employee = new Employee();

				employee.setEmployeeId(rs.getInt("employee_id"));
				employee.setEmployeeName(rs.getString("employee_name"));
				employee.setEmail(rs.getString("email"));
				employee.setDepartment(rs.getString("department"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setJoiningDate(rs.getDate("joining_date"));

				employees.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {

		Employee employee = null;

		String sql = "SELECT * FROM employees WHERE employee_id = ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, employeeId);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {

					employee = new Employee();

					employee.setEmployeeId(rs.getInt("employee_id"));
					employee.setEmployeeName(rs.getString("employee_name"));
					employee.setEmail(rs.getString("email"));
					employee.setDepartment(rs.getString("department"));
					employee.setSalary(rs.getDouble("salary"));
					employee.setJoiningDate(rs.getDate("joining_date"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employee;
	}

	@Override
	public boolean updateEmployee(Employee employee) {

		String sql = "UPDATE employees SET employee_name = ?, "
				+ "email = ?, department = ?, salary = ?, joining_date = ? " + "WHERE employee_id = ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, employee.getEmployeeName());
			ps.setString(2, employee.getEmail());
			ps.setString(3, employee.getDepartment());
			ps.setDouble(4, employee.getSalary());
			ps.setDate(5, employee.getJoiningDate());
			ps.setInt(6, employee.getEmployeeId());

			int rows = ps.executeUpdate();

			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteEmployee(int employeeId) {

		String sql = "DELETE FROM employees WHERE employee_id = ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, employeeId);

			int rows = ps.executeUpdate();

			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isEmailExistsForOtherEmployee(String email, int employeeId) {

		String sql = "SELECT COUNT(*) FROM employees WHERE email = ? AND employee_id != ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, email);
			ps.setInt(2, employeeId);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt(1) > 0;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Employee> searchEmployeesByName(String employeeName) {

		List<Employee> employees = new ArrayList<>();

		String sql = "SELECT * FROM employees WHERE employee_name LIKE ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, "%" + employeeName + "%");

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					Employee employee = new Employee();

					employee.setEmployeeId(rs.getInt("employee_id"));
					employee.setEmployeeName(rs.getString("employee_name"));
					employee.setEmail(rs.getString("email"));
					employee.setDepartment(rs.getString("department"));
					employee.setSalary(rs.getDouble("salary"));
					employee.setJoiningDate(rs.getDate("joining_date"));

					employees.add(employee);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public List<Employee> getEmployeesByDepartment(String department) {

		List<Employee> employees = new ArrayList<>();

		String sql = "SELECT * FROM employees WHERE department = ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, department);

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					Employee employee = new Employee();

					employee.setEmployeeId(rs.getInt("employee_id"));
					employee.setEmployeeName(rs.getString("employee_name"));
					employee.setEmail(rs.getString("email"));
					employee.setDepartment(rs.getString("department"));
					employee.setSalary(rs.getDouble("salary"));
					employee.setJoiningDate(rs.getDate("joining_date"));

					employees.add(employee);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public List<Employee> getEmployeesByPage(int offset, int pageSize) {

		List<Employee> employees = new ArrayList<>();

		String sql = "SELECT * FROM employees LIMIT ? OFFSET ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, pageSize);
			ps.setInt(2, offset);

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					Employee employee = new Employee();

					employee.setEmployeeId(rs.getInt("employee_id"));
					employee.setEmployeeName(rs.getString("employee_name"));
					employee.setEmail(rs.getString("email"));
					employee.setDepartment(rs.getString("department"));
					employee.setSalary(rs.getDouble("salary"));
					employee.setJoiningDate(rs.getDate("joining_date"));

					employees.add(employee);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public int getTotalEmployeeCount() {

		String sql = "SELECT COUNT(*) FROM employees";

		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			if (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

}
