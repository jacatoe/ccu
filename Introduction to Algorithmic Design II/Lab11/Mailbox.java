/**
 * Joshua Catoe
 * CSCI 150-02
 * Mailbox (Lab 11)
 * (Last Updated)February 22, 2016 
 */

import java.util.ArrayList;

public class Mailbox 
{
	private ArrayList<Message> list;
	private String owner;
	
	public Mailbox(String owner)
	{
		list = new ArrayList<Message>();
		
		this.owner = owner;
	}
	
	public String getOwner()
	{
		return owner;
	}
	
	public void addMessage(Message m)
	{
		list.add(m);
	}
	
	public Message getMessage(int i)
	{
		return list.get(i);
	}
	
	public void removeMessage(int i)
	{
		list.remove(i);
	}
	
	public int getSize()
	{
		return list.size();
	}
}
