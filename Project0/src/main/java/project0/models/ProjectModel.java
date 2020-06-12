package project0.models;
import java.io.Serializable;
import java.util.Arrays;

public abstract class ProjectModel implements Serializable {
	
	
	private String name;
	private int number;
	
	public ProjectModel()
	{
		
	}
	
	public ProjectModel(String name, int proInfo)
	{
		super();
		this.name = name;
		this.number = proInfo;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int proInfo)
	{
		this.number = proInfo;
	}

	@Override
	public String toString()
	{
		return  "Project name: " + name + ", Number " + number;
	}


}
