package myTests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import project1.menu.CreateProject;
import project1.menu.Task;
;

public class junitTests {

	@Test
    public void testShouldReturnTrue() {
		
        assertTrue(true);
    }
	
	
	@Test
	public void tesTask() {
		Task task = new Task();
		task.setTask("test");
        assertTrue(task.getTask() == "test");
    }
	
	@Test
	public void testEmployee() {
		CreateProject task = new CreateProject();
		task.setCost(4);
        assertTrue(task.getCost() == 4);
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
	

}
