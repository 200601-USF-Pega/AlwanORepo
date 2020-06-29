package project1.menu;


public class CreateProject {
	
	private String name;
	private int duration;
	private int cost;

	public CreateProject()
	{
		super();

	}

	public CreateProject(String name, int date, int Cost)
	{
		this.name = name;
		this.duration = date;
		this.cost = Cost;

	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getCost()
	{
		return cost;
	}

	public void setCost(int cost)
	{
		this.cost = cost;
	}

	
}


