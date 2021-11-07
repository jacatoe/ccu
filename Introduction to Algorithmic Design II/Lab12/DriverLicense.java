/**
 * Joshua Catoe
 * CSCI 150-02
 * DriverLicense(Lab 12)
 * (Last Updated)February 29, 2016
 */

import java.util.Calendar;

public class DriverLicense extends Card 
{
	private int expireyear;
	
	public DriverLicense(String n, int expyear)
	{
		super(n);
		expireyear = expyear;
	}
	
	public boolean isExpired()
	{
		boolean expired = false;
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		
		if(currentYear < expireyear)
		{
			expired = true;
		}
		
		return expired;
	}
	
	public String format()
	{
		return super.format() + "\n" + "Expiration year: " + expireyear;
	}
}
