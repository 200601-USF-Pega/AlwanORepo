package project0.menu;


import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import project0.models.ProjectModel;

public class Services
{
	
	private ArrayList<ProjectModel> projectList = new ArrayList<ProjectModel>();
	private final Scanner scan = new Scanner(System.in);
	
		String taskName; 
		String dueDate; 
		int employeeID; 
		boolean loop = true;
	public void createProject()
	{
		System.out.print("What is the project ID: ");
		int projectId = scan.nextInt();
		System.out.print("Enter project name: ");
		String projectName  = scan.nextLine();
		scan.nextLine();
		System.out.println("Time needed to complete the project (in month):");
		int date = scan.nextInt();
		System.out.println("Project estimated cost:");
		int cost = scan.nextInt();
		
		CreateProject project = new CreateProject(projectId, projectName, date, cost);
		projectList.add(project);

	}
	
	public void createTeam()
	{
		
		System.out.print("Please enter team name: \n");
		String name = scan.nextLine();
		System.out.println("Enter number of people in the team:\n");
		int teamSize = scan.nextInt();
		String[] members = new String[teamSize];
		
		for (int i = 0; i < members.length; i++) {
			System.out.print("Team member " +"["+(i+1)+"] ");
			members[i] = scan.nextLine();
			scan.nextLine();
		}
		
		System.out.print("$$$ Team has been created successfully $$$ \n");
		System.out.print(" \n");
		ProjectModel team = new Employee(name, teamSize, members);
		projectList.add(team);
		
	}
	
	public void assignTask()
	{
		System.out.print("[1] Assign task to existing employee \n");
		System.out.print("[2] Assign task to new employee \n");
		System.out.print("[3] Main menu \n");
		System.out.print("[4] Exit \n");
		int input = 0;
		try
		{
			input = scan.nextInt();
		}
		catch(InputMismatchException ime)
		{
			System.out.println("Invalid option.");
			input = 0;
		}
		
		
		scan.nextLine();
		
		switch(input)
		{
		case 1:
			System.out.println("Enter task name here \n");
			taskName = scan.nextLine();
			System.out.println("Assign task to (enter employee ID) \n");
			employeeID = scan.nextInt();
			System.out.println("Task due date \n");
			dueDate = scan.nextLine();
			break;
		
		case 2:
			System.out.println("Enter task name here \n");
			taskName = scan.nextLine();
			System.out.println("Assign task to (enter employee ID) \n");
			employeeID = scan.nextInt();
			System.out.println("Task due date \n");
			dueDate = scan.nextLine();
			break;
			
		case 3:
			Menu m = new TextMenu();
			m.createProject();
			break;
		case 4:
			loop = false;
			System.out.println("Goodbye.");
			break;
		}
		
		
		scan.nextLine();
		
		ProjectModel task = new Task(taskName, employeeID, dueDate);
		projectList.add(task);
		
	}
	
	
	
	public void projectProgress()
	{	
		try
		{
			FileWriter fw = new FileWriter("projects.txt");
			for(ProjectModel f : projectList)
			{
				fw.write(f.toString());
			}
			fw.flush();
			fw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	
	public void projectCompleted()
	{
		try {
			FileReader fr = new FileReader("projects.txt");
			BufferedReader br = new BufferedReader(fr);
			
			int i;
	        while((i=br.read())!=-1){
	        	System.out.print((char)i);
	        }
	        br.close();   
	        fr.close();
	        System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}

