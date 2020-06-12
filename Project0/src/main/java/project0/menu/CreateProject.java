package project0.menu;


import project0.models.ProjectModel;

public class CreateProject extends ProjectModel
{
	
	private int id;
	private int cost;

	public CreateProject()
	{
		super();

	}

	public CreateProject(int ID, String name, int date, int Cost)
	{
		super(name, date);
		this.id = ID;
		this.cost = Cost;

	}

	public int getID()
	{
		return id;
	}

	public void setID(int id)
	{
		this.id = id;
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
		return "Project ID: " + id + " Project name: " + getName() + " Project Duration: "
				+ getNumber()+" Month " + " Project estimated cost: " + getCost() + " $";
	}
	
}


