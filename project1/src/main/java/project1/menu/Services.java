package project1.menu;



import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import project1.connection.ConnectionService;
import project1.dao.RepoDBService;
import project1.models.ProjectModel;

public class Services{
	
		private ArrayList<ProjectModel> projectList = new ArrayList<ProjectModel>();
		private final Scanner scan = new Scanner(System.in);
		
		ConnectionService objConnection = new ConnectionService();
		Employee employee = new Employee();
		Connection connection = objConnection.getConnection();
		RepoDBService DBService = new RepoDBService();
		String taskName; 
		String dueDate; 
		int employeeID; 
		boolean loop = true;
		boolean isNumeric = false;
		
	public void createProject()
	{
		System.out.print("Enter project name: \n");
		while (!scan.hasNextLine()) { 
		System.out.println("Please enter valid name!"); 
		scan.nextLine();}
		String projectName  = scan.nextLine();
		System.out.println("Time needed to complete the project (in month):");
		while (!scan.hasNextInt()) { 
		System.out.println("Please enter valid number!"); 
		scan.nextLine();}
		int date = scan.nextInt();
		System.out.println("Project estimated cost:");
		while (!scan.hasNextInt()) { 
		System.out.println("Please enter valid amount!"); 
		scan.nextInt();}
		int cost = scan.nextInt();
		
		DBService.addProject(projectName, date, cost);

	}
	
	public void createTeam()
	{
		System.out.print("Please enter team name: \n");
		while (!scan.hasNext()) { 
		System.out.println("Please enter valid name!"); 
		scan.nextLine();}
		String name = scan.nextLine();
		System.out.println("Enter number of people in the team:\n");
		while (!scan.hasNextInt()) { 
		System.out.println("Please enter a valid number!"); 
		scan.next();}
		int teamSize = scan.nextInt();
		String[] members = new String[teamSize];
		String[] emails = new String[teamSize];
		scan.nextLine();
		for (int i = 0; i < members.length; i++) {
			System.out.print("Enter team member " +"["+(i+1)+"] first and last name:");
			while (!scan.hasNextLine()) { 
			System.out.println("Please enter valid name!"); 
			scan.next();}
			members[i] = scan.nextLine();
			System.out.print("Team member " +"["+(i+1)+"] email address: ");
			while (!scan.hasNextLine() ) { 
			System.out.println("Please enter valid email address!"); 
			scan.next();}
			emails[i] = scan.nextLine();
			
		}
		
		DBService.addTeam(name, teamSize, members, emails);

	}
	
	public void assignTask()
	{
		String input;
		do {
		System.out.print("Press [1] to assign task\n");
		System.out.print("Press [2] to view tasks\n");
		System.out.print("Press [3] for update menu \n");
		System.out.print("Press [4] for delete menu \n");
		System.out.print("Press [5] for main menu \n");
		System.out.print("Press [6] to exit \n");
		

		input = scan.nextLine();
		
		switch(input)
		{
		case "1":
			System.out.println("Enter task name here");
			while (!scan.hasNextLine() ) { 
				System.out.println("Please enter valid name!"); 
				scan.next();}
			taskName = scan.nextLine();
			System.out.println("Task due date (form: mm/dd/yyyy)");
			while (!scan.hasNextLine() ) { 
				System.out.println("Please enter valid date!"); 
				scan.next();}
			dueDate = scan.nextLine();
			System.out.println("Assign task to (enter employee ID)");
			while (!scan.hasNextInt() ) { 
				System.out.println("Please enter valid ID!"); 
				scan.next();}
			employeeID = scan.nextInt();
			
			DBService.addTask(taskName, dueDate, employeeID);
			break;
		
		case "2":
			DBService.viewTask();
			break;
		
		case "3":
			
			System.out.println("Enter new task name:");
			String name = scan.nextLine();
			System.out.println("Enter new due date:");
			String date = scan.nextLine();
			System.out.println("Enter ID:");
			int id = scan.nextInt();
			DBService.updateTask(id, name, date);
			
			break;
			
		case "4":
			System.out.println("Enter ID:");
			int ID = scan.nextInt();
			DBService.deleteTask(ID);
			scan.next();
			break;
			
		case "5":
			Menu m = new TextMenu();
			m.createProject();
			break;
			
		case "6":
			loop = false;
			System.out.println("Goodbye.");
			break;
		
		default:
			System.out.println("Invalid input please try again!");	
		}
		
		}while (!input.equals("6"));
		scan.next();
		
		scan.nextLine();
		
		ProjectModel task = new Task(taskName, employeeID, dueDate);
		projectList.add(task);
		
	}
	
}

