/**
 * Joshua Catoe
 * CSCI 150-02
 * Box (Lab 10)
 * (Last Updated)February 19, 2016
 */

public class Box extends Rectangle
{
	private int height;
	
	public Box(int length,int width,int height)
	{
		super(length,width);
		this.height=height;
	}
	
	public int height()
	{
		return height;
	}
	
	public int volume()
	{
		return getLength()*getWidth()*height;
	}
	
	public int area()
	{
		return getLength()*height + getLength()*height + getWidth()*height + getWidth()*height + getLength()*getWidth() + getLength()*getWidth();
	}	
}