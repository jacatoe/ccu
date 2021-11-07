/**
 * Joshua Catoe
 * CSCI 150-02
 * Vending Machine(Lab 6)
 * (Last Updated)January 29, 2016
 *
 */
public class VendingMachine 
{
	private int toks;
	private int can;
	
	public VendingMachine()
	{
		toks = 0;
		can = 10;
	}
	
	public VendingMachine(int cans)
	{
		toks = 0;
		can = cans;
	}
	
	public void insertToken()
	{
		if(can>0)
		{
			toks = toks+1;
			can = can-1;
		}		
		
	}
	
	public void fillUp(int cans)
	{
		can = can+cans;
	}
	
	public int getCanCount()
	{
		return can;
	}
	
	public int getTokenCount()
	{
		return toks;
	}
}
