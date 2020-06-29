package myTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import project1.connection.ConnectionService;
import project1.dao.EmployeeRepoDB;
import project1.dao.ProjectRepoDB;
import project1.menu.CreateProject;
import project1.menu.Employee;
import servlets.loginServlet;


public class junitTests {

	private boolean equals;

	@Test
    public void testShouldReturnTrue() {
		
        assertTrue(true);
    }
	
	@Test
	public void tesEmployeeID() {
		Employee employee = new Employee();
		employee.setId(10);
        assertTrue(employee.getId() == 10);
    }
	
	@Test
	public void tesEmployeeName() {
		Employee employee = new Employee();
		employee.setName("employee");
        assertTrue(employee.getName() == "employee");
    }
	@Test
	public void tesEmployeeEmail() {
		Employee employee = new Employee();
		employee.setEmail("test@email.com");
        assertTrue(employee.getEmail() == "test@email.com");
    }
	
	@Test
	public void tesProjectName() {
		CreateProject project = new CreateProject();
		project.setName("pro name");
        assertTrue(project.getName() == "pro name");
    }
	
	@Test
	public void tesProjectDuration() {
		CreateProject duration = new CreateProject();
		duration.setDuration(5);
        assertTrue(duration.getDuration() == 5);
    }
	@Test
	public void tesProjectCost() {
		CreateProject cost = new CreateProject();
		cost.setCost(2000);
        assertTrue(cost.getCost() == 2000);
    }
	
	
	
	@Test
    public void ShouldReturnTrue() {
		
        assertTrue(true);
    }
	
	@Test
	public void myTest()
	{
		System.err.println(" ");
	}

	@Test
	public void ViewProjects()
	{
		ProjectRepoDB repo = new ProjectRepoDB();
		repo.viewProjects();
	}

	@Test
	public void ViewEmployees()
	{
		EmployeeRepoDB repo = new EmployeeRepoDB();
		repo.getAllEmployees();
	}

}
