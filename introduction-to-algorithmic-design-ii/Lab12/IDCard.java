/**
 * Joshua Catoe
 * CSCI 150-02
 * IDCard(Lab 12)
 * (Last Updated)February 29, 2016
 */

public class IDCard extends Card 
{
	private String IDnum;
	
	public IDCard(String n, String id)
	{
		super(n);
		IDnum = id;
	}
	
	public String format()
	{
		return super.format() + "\n" + "ID number: " + IDnum;
	}
}
