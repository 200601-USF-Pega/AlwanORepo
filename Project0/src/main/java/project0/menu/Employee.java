
package project0.menu;

import java.util.Arrays;

import project0.models.ProjectModel;

public class Employee extends ProjectModel
{
	
	String[] member;
	
	public Employee()
	{
		super();
	}

	public Employee(String name, int teamSize, String[] member)
	{
		super(name, teamSize);
		this.member = member; 
	}
	public String[] getMember()
	{
		return member;
	}

	public void setMember(String[] members)
	{
		this.member = members;
	}


	@Override
	public String toString()
	{
		return "Team name: " + getName() + " Members of team: (" + getNumber()
		+ ") Members of the team: " + Arrays.toString(getMember())+ "]";
	}

}

