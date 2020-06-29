package project0.menu;

import java.util.Scanner;

import project0.dao.RepoDBService;

public class TextMenu implements Menu
{

//	@Override
	public void createProject()
	{
		Scanner scan = new Scanner(System.in);
		Services service = new Services();
		RepoDBService DBService = new RepoDBService();
		String input;
		do {
		
			System.out.println("Welcome to your project management app\n"
					+ "==================================\n"
					+ "What would you like to do?\n"
					+ "Press (1) to create a project\n"
					+ "Press (2) to create a team\n"
					+ "Press (3) to create and view tasks\n"
					+ "Press (4) to view Projects\n"
					+ "Press (5) to view teams\n"
					+ "Press (6) to view employees\n"
					+ "Press (7) to delete project\n"
					+ "Press (8) to delete team\n"
					+ "Press (9) to exit");
			
			input = scan.nextLine();
			
			switch(input)
			{
			case "1":
				service.createProject();
				break;
			case "2":
				service.createTeam();
				break;
			case "3":
				service.assignTask();
				break;
			case "4":
				DBService.viewProject();
				break;
			case "5":
				DBService.viewTeam();
				break;
			case "6":
				DBService.viewEmployee();
				break;
				
			case "7":
					System.out.println("Enter project name:");
					String proName = scan.nextLine();					
					DBService.deleteProject(proName);
				break;
			
			case "8":
				System.out.println("Enter team name:");
				String teamName = scan.nextLine();					
				DBService.deleteTeam(teamName);
			break;
			
			case "9":
				System.out.println("Goodbye.");
				break;
			default:
				System.out.println("Invalid input please try again!");
			}
		}while(!input.equals("9"));
	}

//	@Override
	public void printReceipt()
	{
		
		
	}

}
