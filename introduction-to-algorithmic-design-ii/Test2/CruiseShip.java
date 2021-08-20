/**
 * Joshua Catoe
 * CSCI 150-02
 * CruiseShip(Test 2)
 * (Last Updated)March 2, 2016
 */

public class CruiseShip extends Ship
{
	private int maxpass;
	
	public CruiseShip(String name, int year)
	{
		name = super.getName();
		year = super.getYear();
		maxpass = 0;
	}
	
	public void setMax(int max)
	{
		maxpass = max;
	}
	
	public int getMax()
	{
		return maxpass;
	}
	
	public String toString()
	{
		return "Ship name: " + super.getName() + "\n" + "Maximun passengers: " + maxpass;
	}
}
