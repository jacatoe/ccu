/**
 * Joshua Catoe
 * CSCI 150-02
 * Message (Lab 9)
 * (Last Updated)February 12, 2016 
 */

public class Message 
{
	private String rname; //Recipient name
	private String sname; //Sender name
	private String body;  //Message body
	
	public Message(String sender,String recipient)
	{
		rname = recipient;
		sname = sender;
		body = "";
	}
	
	public String getSender()
	{
		return sname;
	}
	
	public String getRecipient()
	{
		return rname;
	}
	
	public void append(String string)
	{
		body = body + string + "\n";
	}
	
	public String toString()
	{
		String str;
		str = "From: " + sname + "\n" + "To: " + rname + "\n \n" + body + "\n";
		return str;
	}
}
