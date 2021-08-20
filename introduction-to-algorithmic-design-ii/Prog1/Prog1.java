/**
 * Joshua Catoe
 * CSCI 150-02
 * Program 1
 * (Last Updated)February 2, 2016
 * This program is designed to simulate a bug moving along a line, and allows the user to control its movement
 * including its direction(left and right only).
 */

import java.util.Scanner;

public class Prog1 
{

	public static void main(String[] args) 
	{			
		//Print menu and prompt.
		
		System.out.println("t turn"); 
		System.out.println("m move");
		System.out.println("g get position");
		System.out.println("q quit");
		System.out.println("");
		System.out.println("Enter selection: ");
		
		//Create bug object.
		
		Bug bug1 = new Bug(10);
		
		String choice; //User's choice of action. 
		
		//Read and process user input.
		
		do
		{				
			Scanner in = new Scanner(System.in); 
			
			choice = in.next(); 
			
			switch(choice)
			{
				case "t": //If user enters t, turn bug left or right.
					bug1.turn();
					break;
					
				case "m": //If user enters m, move bug one space, left or right. 
					bug1.move();
					break;
					
				case "g": //If user enters g, print position of bug.
					System.out.println("Position: " + bug1.getPosition());
					break;
					
				case "q": //If user enters q, terminate program.
					System.exit(0);
					break;
					
				default: //If user does not enter t,m,g,q, prompt for entry.
					System.out.println("Invalid selection. Enter selection:");
			}
			//Scanner in not closed to preserve loop.
			
		}while(choice != "q");
		
	} //End of main.

} //End of class.
