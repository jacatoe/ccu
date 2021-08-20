/**
 * Joshua Catoe
 * CSCI 150-02
 * Lab 5
 * (Last Updated)January 27, 2016
 * This program calls the Circle class to give the area of one circle and the circumference of another. 
 */

public class Lab5 {

	public static void main(String[] args) 
	{		
		Circle circle1 = new Circle();
		
		System.out.println("Circle 1 Initial Radius: " +circle1.getRadius());
		
		circle1.setRadius(2.0);
		
		System.out.println("Circle 1 Area: " +circle1.getArea());
		
		Circle circle2 = new Circle(10.0);
		
		System.out.println("Circle 2 Circumference: " +circle2.getCircumference());
	}

}
