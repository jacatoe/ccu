/**
 * Joshua Catoe
 * CSCI 150-02
 * Message (Program 4)
 * (Last Updated)February 29, 2016 
 */

public class Message 
{
	private String rname; //Recipient name
	private String sname; //Sender name
	private String body;  //Message body
	
	/**
	 * Constructs Message object.
	 * 
	 * @param sender //Sender of Message
	 * @param recipient //Recipient of Message
	 */
	public Message(String sender,String recipient)
	{
		rname = recipient; //Name of recipient
		sname = sender; //Name of sender
		body = ""; //Message body
	}
	
	/**
	 * Retrieves name of Message sender.
	 * 
	 * @return //Returns name of sender
	 */
	public String getSender()
	{
		return sname;
	}
	
	/**
	 * Retrieves name of Message recipient.
	 * 
	 * @return //Returns name of recipient
	 */
	public String getRecipient()
	{
		return rname;
	}
	
	/**
	 * Concatenates new string onto message body. 
	 * 
	 * @param string //String to be concatenated 
	 */
	public void append(String string)
	{
		body = body + string + "\n";
	}
	
	/**
	 * Gives format to message being printed.
	 */
	public String toString()
	{
		String str; //String being formated
		str = "From: " + sname + "\n" + "To: " + rname + "\n \n" + body + "\n";
		return str;
	}
}
