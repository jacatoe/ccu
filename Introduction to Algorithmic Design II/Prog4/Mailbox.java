/**
 * Joshua Catoe
 * CSCI 150-02
 * Mailbox (Program 4)
 * (Last Updated)February 29, 2016 
 */

import java.util.ArrayList;

public class Mailbox 
{
	private ArrayList<Message> list; //ArrayList of Message objects
	private String owner; //Owner of the Mailbox
	
	/**
	 * Constructs Mailbox object.
	 * 
	 * @param owner //Owner of the Mailbox
	 */
	public Mailbox(String owner)
	{
		list = new ArrayList<Message>(); 
		
		this.owner = owner; //Name of owner being passed in 
	}
	
	/**
	 * Retrieves owner of Mailbox.
	 * 
	 * @return //Returns owner of Mailbox
	 */
	public String getOwner()
	{
		return owner;
	}
	
	/**
	 * Adds Message object to Mailbox.
	 *  
	 * @param m //Message to be added to Mailbox
	 */
	public void addMessage(Message m)
	{
		list.add(m);
	}
	
	/**
	 * Retrieves Message from Mailbox.
	 * 
	 * @param i //Element of Mailbox object
	 * @return //Returns Message from Mailbox 
	 */
	public Message getMessage(int i)
	{
		return list.get(i);
	}
	
	/**
	 * Removes Message from Mailbox.
	 * 
	 * @param i //Element to be removed from Mailbox
	 */
	public void removeMessage(int i)
	{
		list.remove(i);
	}
	
	/**
	 * Retrieves the size of Mailbox(list). 
	 * 
	 * @return //Returns size of list
	 */
	public int getSize()
	{
		return list.size();
	}
}
