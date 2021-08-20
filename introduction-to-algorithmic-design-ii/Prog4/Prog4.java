/**
 * Joshua Catoe
 * CSCI 150-02
 * Program 4
 * (Last Updated)March 22, 2016
 * 
 * This program creates a menu-driven mail system (or tries to). One user may be logged in 
 * at a time, and users can send messages to each other and read their own
 * messages. 
 */

import java.util.Scanner;

public class Prog4 
{
	public static void main(String[] args) 
	{
		//Print menu selections
		
		System.out.println("Log I)n S)end message R)ead messages Log O)ut Q)uit");
		
		//Create related objects
		
		Message m; //Message object
		MailSystem ms = new MailSystem(); //MailSystem object
		
		//Create scanner 
		
		Scanner menuScan = new Scanner(System.in);
		
		//Process user choice 
		
		String user = ""; //Current user of e-mail system
		String recip; //Recipient of message
		String mbody;
		
		char choice; //User input 
		
		do
		{	
			choice = menuScan.next().charAt(0);

				switch(choice)
				{
					// If a user is logged in, case 'I' is not allowed
				
					case 'I':
					case 'i':
						if(user.equals(""))
						{
							System.out.println("Username: ");
							user = menuScan.next();
							System.out.println("Logged in.");
						}
						else 
						{
							System.out.println("Log out first.");
						}
						break;
						
					//If a user is not logged in, cases 'S','R','O' are not allowed
					
					case 'S':
					case 's':
						if(user.equals(""))
						{
							System.out.println("No user logged in.");
						}
						else
						{
							System.out.println("Recipient: ");
							recip = menuScan.nextLine();
							
							m = new Message(user,recip);
							
							System.out.println("Enter message. Blank line to quit.");
							mbody = menuScan.nextLine();
							
							while(!mbody.equals(""))
							{
								m.append(mbody);
								mbody = menuScan.nextLine();								
							}
							
							ms.deliver(m);
							
							System.out.println("Message sent.");
							
						}
						break;
					
					case 'R':
					case 'r':
						if(user.equals(""))
						{
							System.out.println("No user logged in.");
						}
						else
						{
							ms.printMessages(user);
						}						
						break;
					
					case 'O':
					case 'o':
						if(user.equals(""))
						{
							System.out.println("No user logged in.");
						}
						else
						{
							user = "";
							System.out.println("Logged out.");
						}
						break;
						
					case 'Q':
					case 'q':
						break;
						
					default:
						System.out.println("Invalid selection.");
						break;
				}	
		}
		while(choice != 'Q' && choice !='q');
		
		//Close scanner
		
		menuScan.close();
		
	} //End of main

}//End of class
