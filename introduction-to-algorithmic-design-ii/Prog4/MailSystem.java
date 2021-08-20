/**
 * Joshua Catoe
 * CSCI 150-02
 * MailSystem (Program 4)
 * (Last Updated)February 29, 2016
 */

import java.util.ArrayList;

public class MailSystem 
{
	private ArrayList<Mailbox> mbList; //ArrayList of Mailbox objects 
	
	/**
	 * Constructs MailSystem object.
	 */
	public MailSystem()
	{
		mbList = new ArrayList<Mailbox>();
	}
	
	/**
	 * Delivers Message to the recipient(owner of the Mailbox).
	 * Creates new Mailbox if recipient does not have one.
	 * 
	 * @param m //Message to be delivered. 
	 */
	public void deliver(Message m)
	{
		if(getIndex(m.getRecipient()) >= 0)
		{
			mbList.get(getIndex(m.getRecipient())).addMessage(m);
		}
		else if(getIndex(m.getRecipient()) == -1)
		{
			Mailbox mb = new Mailbox(m.getRecipient()); //New Mailbox for new recipient
			mb.addMessage(m);
			mbList.add(mb);
		}
	}
	
	/**
	 * Prints Messages in owner's Mailbox unless they do not own one. 
	 * 
	 * @param owner //Owner of Mailbox
	 */
	public void printMessages(String owner)
	{
		if(getIndex(owner) >= 0)
		{
			for(int i=0;i<mbList.size()-1;i++)
			{
				System.out.println(mbList.get(getIndex(owner)).getMessage(i));
			}
		}
		else
		{
			System.out.println("No messages.");
		}
	}
	
	/**
	 * Retrieves the index of the owner of a Mailbox. 
	 * 
	 * @param owner //Owner of Mailbox
	 * @return //Returns position(index) of Mailbox if it exists, and -1 if not
	 */
	private int getIndex(String owner)
	{
		String searchedOwner = owner; //Owner being searched for
		int pos = 0; //Position(index) of Mailbox 
		boolean found = false; //Mailbox has been found or not
		
		while(pos<mbList.size() && !found)
		{
			if(mbList.get(pos).getOwner().equals(searchedOwner))
			{
				found=true;
			}
			else
			{
				pos++;
			}
		}
		
		if(found)
		{
			return pos;
		}
		else
		{
			return -1;
		}
	}
}
