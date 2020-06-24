package project1.menu;

import project1.models.ProjectModel;

public class Task extends ProjectModel
{
	
	private String task;

	public Task()
	{
		super();
	}

	public Task(String name,  int dueDate, String task )
	{
		super(name, dueDate);
		this.task = task;
	}

	public String getTask()
	{
		return task;
	}

	public void setTask(String task)
	{
		this.task = task;
	}

	@Override
	public String toString()
	{
		return "Task name: " + getName() + ", Task assigned to employee with ID number: " + getTask () 
		+ ", Task due date: " + getNumber();
	}
	
}
