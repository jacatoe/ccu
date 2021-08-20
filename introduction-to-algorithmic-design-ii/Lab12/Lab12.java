/**
 * Joshua Catoe
 * CSCI 150-02
 * Lab 12
 * (Last Updated)February 29, 2016
 * 
 * This program tests the Card class and several sub-classes (IDCard, ATMCard, and DriverLicense).
 */

public class Lab12 
{

	public static void main(String[] args) 
	{
		Card card = new Card("John Doe");
		System.out.println(card.format());
		
		IDCard id = new IDCard("Sam Smith", "99999");
		System.out.println(id.format());
		
		ATMCard atm = new ATMCard("Sue Jones", "1111", "123");
		System.out.println(atm.format());
		
		DriverLicense license = new DriverLicense("Jane Smith", 2014);
		System.out.println(license.format());
		System.out.println("Driver License expired:" + license.isExpired());
	}

}
