/**
 * Joshua Catoe
 * CSCI 150-02
 * Card(Lab 12)
 * (Last Updated)February 29, 2016
 */

public class Card 
{
	private String name;
	
	public Card()
	{
		name = " ";
	}
	
	public Card(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean isExpired()
	{
		return false;
	}
	
	public String format()
	{
		return "Card holder: " + name;
	}
}
