/**
 * Joshua Catoe
 * CSCI 150-02
 * Program 3
 * (Last Updated)February 29, 2016
 * 
 * This program is designed to test the Message, Mailbox, and MailSystem classes. 
 */
import java.util.Scanner;
public class Prog3 
{
	public static void main(String[] args) 
	{
		//Create MailSystem object
		
		MailSystem ms = new MailSystem();
		
		//Create Message object for multiple uses
		
		Message m; //Message being sent
		
		//Create and deliver messages
		
		Scanner menuScan = new Scanner(System.in);
		
		String user = null;
		String recip;
		String mbody;
		
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
}
