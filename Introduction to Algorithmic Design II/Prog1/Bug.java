/**
 * Joshua Catoe
 * CSCI 150-02
 * Bug (Program 1)
 * (Last Updated)February 2, 2016
 */

public class Bug 
{
	private int pos; //Position of bug.
	private char dir; //Direction bug is moving. 
	
	/**
	 * Creates initial position of bug. 
	 * Initial direction is to the right. 
	 * @param initialPosition
	 */
	public Bug(int initialPosition)
	{
		pos = initialPosition;
		dir = 'r';
	}
	
	/**
	 * Turns bug left or right.
	 */
	public void turn()
	{
		if(dir == 'r')
		{
			dir = 'l';
		}
		else if(dir == 'l')
		{
			dir = 'r';
		}
	}
	
	/**
	 * Moves bug one position to the right or left. 
	 */
	public void move()
	{
		if(dir == 'r')
		{
			pos = pos +1;
		}
		else if(dir == 'l')
		{
			pos = pos -1;
		}
	}
	
	/**
	 * Returns current position of bug. 
	 * @return
	 */
	public int getPosition()
	{
		return pos;
	}

} //End of class. 
