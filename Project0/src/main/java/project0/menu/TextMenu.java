package project0.menu;

import java.util.InputMismatchException;
import java.util.Scanner;
public class TextMenu implements Menu
{

//	@Override
	public void createProject()
	{
		Scanner scan = new Scanner(System.in);
		Services service = new Services();
		boolean loop = true;
		
		while(loop)
		{
		
			System.out.println("Welcome to your online project management software\n"
					+ "What would you like to do?\n"
					+ "(1) Create a project\n"
					+ "(2) Create a team\n"
					+ "(3) Assign a task\n"
					+ "(4) View Projects in progress\n"
					+ "(5) View completed projects\n"
					+ "(6) Exit");
			
			
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
				service.createProject();
				break;
			case 2:
				service.createTeam();
				break;
			case 3:
				service.assignTask();
				break;
			case 4:
				service.projectProgress();
				break;
			case 5:
				service.projectCompleted();
				break;
			case 6:
				loop = false;
				System.out.println("Goodbye.");
				break;
			}
		}
	}

//	@Override
	public void printReceipt()
	{
		
		
	}

}
