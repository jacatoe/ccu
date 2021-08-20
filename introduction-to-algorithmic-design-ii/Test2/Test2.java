/**
 * Joshua Catoe
 * CSCI 150-02
 * Test 2
 * (Last Updated)March 2, 2016
 */

public class Test2 
{
	public static void main(String[] args) 
	{
		Ship QueenSue = new Ship();		
		QueenSue.setName("Queen Sue");
		QueenSue.setYear(1999);
		System.out.println(QueenSue.toString());
		
		CruiseShip MaryII = new CruiseShip("Mary II",2010);
		MaryII.setName("Mary II");
		MaryII.setMax(300);
		MaryII.setYear(2010);
		System.out.println(MaryII.toString());
		System.out.println("Year built: " + MaryII.getYear());
		
	}

}
