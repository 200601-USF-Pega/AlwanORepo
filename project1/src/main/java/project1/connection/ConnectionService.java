package project1.connection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionService {

	private Connection connection;
	
	public ConnectionService() {
		try  {
			
			Class.forName("org.postgresql.Driver");
			FileInputStream fis = new FileInputStream("connectionService.prop");
			Properties p = new Properties();
			p.load(fis);
			
			connection = DriverManager.getConnection("jdbc:postgresql://ruby.db.elephantsql.com:5432/rtqlcigm", "rtqlcigm", "z6b6Diu1TXmEVeYPoJxCa2CrXhrwdUUG");
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
