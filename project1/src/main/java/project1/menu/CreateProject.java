package project1.menu;


import project1.models.ProjectModel;

public class CreateProject extends ProjectModel
{
	
	private int cost;

	public CreateProject()
	{
		super();

	}

	public CreateProject(String name, int date, int Cost)
	{
		super(name, date);
		
		this.cost = Cost;

	}

	
	public int getCost()
	{
		return cost;
	}

	public void setCost(int cost)
	{
		this.cost = cost;
	}

	@Override
	public String toString()
	{
		return " Project name: " + getName() + " Project Duration: "
				+ getNumber()+" Month " + " Project estimated cost: " + getCost() + "$";
	}
	
}


