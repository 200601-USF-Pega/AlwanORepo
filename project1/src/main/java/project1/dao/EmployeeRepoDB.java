package project1.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project1.connection.ConnectionService;
import project1.menu.Employee;



public class EmployeeRepoDB implements EmployeeRepo {
	
	ConnectionService objConnection = new ConnectionService();

	@Override
	public Employee addEmployee(Employee employee) {
		try {

			PreparedStatement employeeStatement = objConnection.getConnection()
					.prepareStatement("INSERT INTO employees (employee_id, employee_name, employee_email) VALUES (?, ?, ?)");
			employeeStatement.setInt(1, employee.getId());
			employeeStatement.setString(2, employee.getName());
			employeeStatement.setString(3, employee.getEmail());
			
			employeeStatement.executeUpdate();

			return employee;

		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		

		return null;
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> result = new ArrayList<Employee>();

		try {
			Statement s = objConnection.getConnection().createStatement();
			s.executeQuery("SELECT * FROM employees;");

			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				Employee tempEmployee = new Employee(rs.getInt("employee_id"), rs.getString("employee_name"), rs.getString("employee_email"));
				if (!result.contains(tempEmployee)) {
					result.add(tempEmployee);
				}

			}

			return result;

		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void deleteEmployee(String employeeID) {
		try {
			Statement s = objConnection.getConnection().createStatement();
			s.execute("DELETE FROM employees WHERE employee_id = '" + employeeID + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Item not found.");
		
	}

}