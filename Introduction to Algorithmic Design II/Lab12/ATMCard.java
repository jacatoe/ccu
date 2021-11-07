/**
 * Joshua Catoe
 * CSCI 150-02
 * ATMCard(Lab 12)
 * (Last Updated)February 29, 2016
 */

public class ATMCard extends Card
{
	private String accountnum;
	private String pin;
	
	public ATMCard(String n, String acctnum, String pnum)
	{
		super(n);
		accountnum = acctnum;
		pin = pnum;
	}
	
	public String format()
	{
		return super.format() + "\n" + "Account number: " + accountnum + "\n" + "PIN: " + pin;
	}
}
