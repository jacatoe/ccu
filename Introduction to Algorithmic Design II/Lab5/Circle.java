/**
 * Joshua Catoe
 * CSCI 150-02
 * Circle Class (Lab 5)
 * (Last Updated)January 27,2016
 *
 */
public class Circle 
{
	private double radius;
	
	/**
	 * Accepts radius of a circle as an argument.
	 * @param r
	 */
	public Circle(double r)
	{
		radius=r;
	}
	
	/**
	 * Sets radius to 0.
	 * No parameters.
	 */
	public Circle()
	{
		radius = 0.0;
	}
	
	/**
	 * Allows user to set radius.
	 * @param n
	 */
	public void setRadius(double n)
	{
		radius = n;
	}
	
	/**
	 * Returns value of radius.
	 * @return
	 */
	public double getRadius()
	{
		return radius;
	}
	
	/**
	 * Calculates area of circle and returns the value.
	 * @return
	 */
	public double getArea()
	{
		double area = Math.PI*(Math.pow(radius, 2));
		return area;
	}
	
	/**
	 * Calculates circumference of circle and returns the value.
	 * @return
	 */
	public double getCircumference()
	{
		double cir = 2*Math.PI*radius;
		return cir;
	}
}
