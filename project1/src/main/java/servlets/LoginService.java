package servlets;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import project1.connection.ConnectionService;
import project1.dao.ProjectRepoDB;

public class LoginService {
	
	public boolean checkLogin(String uname, String pass) {
		
		PreparedStatement prepStatement;
		ConnectionService objConnection = new ConnectionService();
		ResultSet result;
		final Logger log = LogManager.getLogger(ProjectRepoDB.class.getName());

		try {
			
			log.info(uname + " logged in succesfully!");
			prepStatement = objConnection.getConnection()
					.prepareStatement("SELECT * FROM login WHERE uname= (?) and pass=(?)");
			prepStatement.setString(1, uname);
			prepStatement.setString(2, pass);
			result = prepStatement.executeQuery();
			if (result.next()) {
				System.out.println(uname + " logged in");
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
