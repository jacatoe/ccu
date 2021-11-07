/**
 * Joshua Catoe
 * CSCI 150-02
 * Rectangle (Lab 10)
 * (Last Updated)February 19, 2016
 */

public class Rectangle 
{
	private int length;
	private int width;
	
	public Rectangle(int lenght, int width)
	{
		this.length = lenght;
		this.width = width;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int area()
	{
		return length*width;
	}
}
