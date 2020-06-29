package project0.driver;

import project0.connection.ConnectionService;
import project0.menu.Menu;
import project0.menu.TextMenu;

public class Driver {

	public static void main(String[] args) {
		
//		ConnectionService connection =  new ConnectionService();
//		connection.getConnection();
		Menu m = new TextMenu();
		
		m.createProject();

	}

}
