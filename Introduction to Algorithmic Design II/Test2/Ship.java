/**
 * Joshua Catoe
 * CSCI 150-02
 * Ship (Test 2)
 * (Last Updated)March 2, 2016
 */

public class Ship 
{
	private String shipname;
	private int yearbuilt;
	
	public Ship()
	{
		shipname = " ";
		yearbuilt = 0;
	}
	
	public void setName(String name)
	{
		shipname = name;
	}
	
	public void setYear(int year)
	{
		yearbuilt = year;
	}
	
	public String getName()
	{
		return shipname;
	}
	
	public int getYear()
	{
		return yearbuilt;
	}
	
	public String toString()
	{
		return "Ship name: " + shipname + "\n" + "Year built: " + yearbuilt;
	}
}
