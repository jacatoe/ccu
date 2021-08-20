/**
 * Joshua Catoe
 * CSCI 150-02
 * Lab 10
 * (Last Updated)February 19, 2016
 * This program calculates the surface area and volume of a box.  
 *
 */

public class Lab10 
{
	public static void main(String[] args) 
	{		
		Box b = new Box(2,3,4);
		
		System.out.println("Volume = " + b.volume());
		
		System.out.println("Surface Area = " + b.area());
	}
}
