package project1.driver;

import project1.connection.ConnectionService;
import project1.menu.Menu;
import project1.menu.TextMenu;

public class Driver {

	public static void main(String[] args) {
		
//		ConnectionService connection =  new ConnectionService();
//		connection.getConnection();
		Menu m = new TextMenu();
		
		m.createProject();

	}

}
