package project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project1.connection.ConnectionService;
import project1.menu.CreateProject;
import project1.menu.Employee;

public class RepoDBService {

	Statement statement;
	PreparedStatement prepStatement;
	ConnectionService objConnection = new ConnectionService();
	Connection connection = objConnection.getConnection();
	ResultSet result;

	public boolean checkLogin(String uname, String pass) {

		try {
			prepStatement = objConnection.getConnection()
					.prepareStatement("SELECT * FROM login WHERE uname= (?) and pass=(?)");
			prepStatement.setString(1, uname);
			prepStatement.setString(2, pass);
			result = prepStatement.executeQuery();
			if (result.next()) {
				System.out.println(uname + " logged in");
				return true;
			}

			objConnection.finalize();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public void viewProject() {
		try {

			String query = "select * from projects";
			statement = connection.createStatement();
			result = statement.executeQuery(query);

			while (result.next()) {

				System.out.println("Project name: (" + result.getString(1) + ") Project duration: ("
						+ result.getString(2) + " month) Project cost: (" + result.getString(3) + "$)");
				System.out.println("--------------------------------------------------------------------");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewTeam() {
		try {

			String query = "select * from teams";
			statement = connection.createStatement();
			result = statement.executeQuery(query);

			while (result.next()) {
				System.out.println("Team name: (" + result.getString(1) + ") Team size: (" + result.getString(2) + ")");
				System.out.println("--------------------------------------------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewEmployee() {
		try {

			String query = "select * from employees";
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);

			while (result.next()) {
				System.out.println("Employee name:" + result.getString(1) + " email:" + result.getString(2));
				System.out.println("--------------------------------------------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewTask() {
		try {

			String query = "select * from tasks";
			statement = connection.createStatement();
			result = statement.executeQuery(query);

			while (result.next()) {
				System.out.println("Task name: (" + result.getString(1) + ") Task due date: (" + result.getString(2)
						+ ") Task assigned to ID: (" + result.getString(3) + ")");
				System.out.println("--------------------------------------------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addProject(String name, int month, int cost) {

		try {
			prepStatement = objConnection.getConnection().prepareStatement("INSERT INTO Projects VALUES (?, ?, ?)");
			prepStatement.setString(1, name);
			prepStatement.setInt(2, month);
			prepStatement.setInt(3, cost);
			prepStatement.executeUpdate();
			System.out.println("New project created!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addTeam(String name, int teamSize, String[] members, String[] emails) {

		try {

			prepStatement = objConnection.getConnection().prepareStatement("INSERT INTO Teams VALUES (?, ?)");
			prepStatement.setString(1, name);
			prepStatement.setInt(2, teamSize);
			prepStatement.executeUpdate();

			for (int i = 0; i < teamSize; i++) {
				statement = objConnection.getConnection().createStatement();
				statement.executeUpdate("INSERT INTO Employees (employee_name, employee_email) VALUES ('" + members[i]
						+ "', '" + emails[i] + "');");
				System.out.println(teamSize + " employees added!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addTask(String taskName, String dueDate, int employeeID) {

		try {

			PreparedStatement taskStatement = objConnection.getConnection()
					.prepareStatement("INSERT INTO tasks VALUES (?, ?, ?)");
			taskStatement.setString(1, taskName);
			taskStatement.setString(2, dueDate);
			taskStatement.setInt(3, employeeID);
			taskStatement.executeUpdate();

			System.out.println("New task added!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateTask(int id, String name, String due_date) {

		try {

			PreparedStatement taskStatement = objConnection.getConnection()
					.prepareStatement("UPDATE  tasks set task_name=?, due_date=? where assigned_to_id=?");
			taskStatement.setString(1, name);
			taskStatement.setString(2, due_date);
			taskStatement.setInt(3, id);
			taskStatement.executeUpdate();
			System.out.println("Task updated!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteTask(int id) {

		try {

			PreparedStatement taskStatement = objConnection.getConnection()
					.prepareStatement("DELETE FROM tasks WHERE assigned_to_id=?");
			taskStatement.setInt(1, id);
			taskStatement.executeUpdate();
			System.out.println("Task deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteProject(String name) {

		try {

			PreparedStatement taskStatement = objConnection.getConnection()
					.prepareStatement("DELETE FROM projects WHERE project_name=?");
			taskStatement.setString(1, name);
			taskStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteTeam(String name) {

		try {

			PreparedStatement taskStatement = objConnection.getConnection()
					.prepareStatement("DELETE FROM teams WHERE team_name=?");
			taskStatement.setString(1, name);
			taskStatement.executeUpdate();
			System.out.println("Deleted!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
