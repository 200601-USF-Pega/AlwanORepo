
package project1.menu;

import java.util.Arrays;

import project1.models.ProjectModel;

public class Employee extends ProjectModel
{
	
	 String[] member;
	 String[] email;
	public Employee()
	{
		super();
	}

	public Employee(String name, int teamSize, String[] member, String[] email)
	{
		super(name, teamSize);
		this.member = member; 
		this.email = email;
	}
	public String[] getMember()
	{
		return member;
	}

	public void setMember(String[] members)
	{
		this.member = members;
	}
	
	public String[] getEmail()
	{
		return email;
	}

	public void setEmail(String[] emails)
	{
		this.email = emails;
	}

	@Override
	public String toString()
	{
		return "Team name: " + getName() + " Members of team: (" + getNumber()
		+ ") Members of the team: " + Arrays.toString(getMember())+ "]";
	}

}

