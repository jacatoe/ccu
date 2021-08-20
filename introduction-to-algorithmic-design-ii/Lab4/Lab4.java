/**
 * Joshua Catoe
 * CSCI 150-02
 * Lab 4
 * (Last Updated)January 25,2016
 * This program simulates a handheld tally counter. 
 * 
 *
 */
public class Lab4 
{

	public static void main(String[] args) 
	{
		Counter tally = new Counter();
		
		tally.count();
		tally.count();
		tally.count();
		tally.count();
		tally.count();
		
		tally.undo();
		tally.undo();
		
		System.out.println("Value: " + tally.getValue());
		
		Counter tally2 = new Counter(2);
		
		tally.count();
		tally.count();
		tally.count();
		
		System.out.println("Final Value: " + tally.getValue());

	}

}
