package project1.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import project1.connection.ConnectionService;
import project1.menu.CreateProject;


public class ProjectRepoDB implements IProjectRepo{
	
	ConnectionService objConnection = new ConnectionService();

	@Override
	public CreateProject addProject(CreateProject project) {
		
		try {
			
			PreparedStatement projectStatement = objConnection.getConnection().prepareStatement("INSERT INTO Projects (project_name, duration_inMonth, project_cost) VALUES (?, ?, ?)");
			projectStatement.setString(1, project.getName());
			projectStatement.setInt(2, project.getDuration());
			projectStatement.setInt(3, project.getCost());
			projectStatement.executeUpdate();			
			
			return project;
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<CreateProject> viewProjects() {
		
			
			List<CreateProject> result = new ArrayList<CreateProject>();
		
		try {
			
			
			
			Statement s = objConnection.getConnection().createStatement();
			s.executeQuery("SELECT * FROM projects;");
			
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				CreateProject tempProject = new CreateProject();
				tempProject.setName(rs.getString("project_name"));
				tempProject.setDuration(rs.getInt("duration_inMonth"));
				tempProject.setCost(rs.getInt("project_cost"));
				if (!result.contains(tempProject)) {
					result.add(tempProject);
				}
				
			}
			
			return result;
			
		} catch (SQLException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}

		
		return null;
	}

	@Override
	public void removeProject(String name) {
		try {
			Statement s = objConnection.getConnection().createStatement();
			s.execute("DELETE FROM Projects WHERE project_name = '" + name + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Project not found.");
		
	}

}
