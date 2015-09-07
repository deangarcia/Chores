
public class Chores 
{
	private Chores[] chores;
	private String choreName;
	private String choreDescription;
	private int price;
	
	
	public Chores(String cn, int p)
	{
		choreName = cn;
		price = p;
	}
	
	public String getChore()
	{
		return choreName;
	}
	
	public int getPrice()
	{
		return price;
	}
	public boolean getStatus()
	{
		return true;
	}
	public String getDescription()
	{
		return choreName;
	}
}
