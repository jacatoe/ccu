/**
 * Joshua Catoe
 * CSCI 150-02
 * Lab 8
 * (Last Updated)February 8, 2016
 * This program is designed to test the CashRegiter class. 
 *
 */

public class Lab8 
{

	public static void main(String[] args) 
	{
		CashRegister c1 = new CashRegister();
		c1.addItem(1.25);
		c1.addItem(3.00);
		System.out.printf("Total: %.2f\n", c1.getTotal());
		System.out.println("\n\nList:");
		c1.displayList();
		System.out.printf("\nCount=%d\n", c1.getCount());
		c1.clear();
		System.out.printf("\n\nNew Total: %.2f\n", c1.getTotal());
		System.out.println("\n\nList:");
		c1.displayList();
		System.out.println("End of test");

	}

}
