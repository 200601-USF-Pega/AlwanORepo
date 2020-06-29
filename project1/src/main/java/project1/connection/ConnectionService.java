package project1.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;

import project1.loggin.Logging;

public class ConnectionService {

	private static Connection connection;
	
	
	
	public static void initialize() {			
		
		try  {
			
			Class.forName("org.postgresql.Driver");
						
			connection = DriverManager.getConnection(MyProp.url, MyProp.username, MyProp.password);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
		
	
	public Connection getConnection() {
		if (connection == null)
			initialize();

		return connection;
	}
	
	@Override
	public void finalize() {
		try {
			connection.close();
		} catch(Exception e) {
			
		}
	}

	
}
