package project1.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionService {

	private Connection connection;
	
	public ConnectionService() {
		try  {
			
			Class.forName("org.postgresql.Driver");
						
			connection = DriverManager.getConnection(MyProp.url, MyProp.username, MyProp.password);
					System.out.println("Connected Successfully");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
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
