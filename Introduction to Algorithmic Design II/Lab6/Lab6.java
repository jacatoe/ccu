/**
 * Joshua Catoe
 * CSCI 150-02
 * Lab 6
 * (Last Updated)January 29, 2016
 * This program simulates a vending machine. 
 *
 */
public class Lab6 
{
	public static void main(String[] args) 
	{
		VendingMachine machine1 = new VendingMachine();
		VendingMachine machine2 = new VendingMachine(20);
		machine1.fillUp(5); //Fill up with 5 cans
		machine1.insertToken();
		machine1.insertToken();
		System.out.print("Token count for machine1: ");
		System.out.println(machine1.getTokenCount());
		System.out.println("Expected token count: 2");
		System.out.print("Can count for machine1: ");
		System.out.println(machine1.getCanCount());
		System.out.println("Expected can count: 13");
		machine2.insertToken();
		System.out.print("Can count for machine2: ");
		System.out.println(machine2.getCanCount());
		System.out.println("Expected can count: 19");
		

	}

}
