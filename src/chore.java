
public class chore 
{
	private String choreName;
	private int price;
	
	public chore(String cn, int p)
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
}
