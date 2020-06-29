package project1.dao;

import java.util.List;

import project1.menu.Employee;


public interface EmployeeRepo {
	public Employee addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(String employeeID);
}
