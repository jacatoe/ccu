/**
 * Joshua Catoe
 * CSCI 150-02
 * Lab 11
 * (Last Updated)February 22, 2016
 * 
 * This program simulates a mailbox receiving several messages. 
 */

public class Lab11 
{

	public static void main(String[] args) 
	{
		Mailbox inbox = new Mailbox("Joshua");
		
		Message m = new Message("Sam","Joshua");		
		m.append("How are you?");		
		inbox.addMessage(m);
		
		m = new Message("Bob","Joshua");
		m.append("This is Bob.");
		inbox.addMessage(m);
		
		m = new Message("Serge","Joshua");
		m.append("Have a steak.");
		inbox.addMessage(m);
		
		for(int i=0;i<inbox.getSize();i++)
		{
			System.out.println(inbox.getMessage(i));
		}
		
		inbox.removeMessage(1);
		
		for(int i=0;i<inbox.getSize();i++)
		{
			System.out.println(inbox.getMessage(i));
		}

	}

}
