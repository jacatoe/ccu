/**
 * Joshua Catoe
 * CSCI 150-02
 * Program 2 
 * (Last Updated)February 11, 2016
 * This program is designed to simulate a simple cash register.
 */

import java.util.Scanner;

public class Prog2 
{

	public static void main(String[] args) 
	{
		//Create CashRegister object.
		
		CashRegister cr = new CashRegister();
		
		//Print out menu.
		
		System.out.println("A)dd");
		System.out.println("T)otal");
		System.out.println("C)lear");
		System.out.println("D)isplay");
		System.out.println("Q)uit");
		System.out.println("\nSelect action:");
		
		//Create input scanner.		
		
		Scanner menu = new Scanner(System.in);
		
		//Process user choice.
		
		char choice; //User input variable.
		
		do
		{			
			choice = menu.next().charAt(0); 
			
			switch(choice)
			{
				case 'A':
					System.out.println("\nEnter item price:");
					cr.addItem(menu.nextDouble());					
					break;
				
				case 'T':
					System.out.printf("Current total: " + "%.2f",cr.getTotal());
					break;
				
				case 'C':
					cr.clear();
					break;
				
				case 'D':
					cr.displayList();
					System.out.println("----------");
					System.out.printf("%10.2f %2s %19s",cr.getTotal(),"Total\n","Number items: " + cr.getCount());
					break;
				
				case 'Q':
					System.out.println("\nAdditional customer?(Y/N):");
					choice = menu.next().charAt(0);	//Resets choice for yes/no inquiry.					
					if(choice == 'Y')
					{
						System.out.println("\nSelect action:");
						cr.clear();
					}
					else if(choice == 'N')
					{
						System.out.printf("\nTotal sales: " + "%.2f",cr.getTotal());
					}		
					break;
					
				default:
					System.out.println("Invalid selection. Enter valid choice: ");
					break;
			}		
		
		}while(choice != 'N');
		
		//Close scanner.
		
		menu.close();
		
		//End of main.
	}
	
	//End of class.
}