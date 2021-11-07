/**
 * Joshua Catoe
 * 
 * Models tally counter.
 * 
 *
 */
public class Counter 
{
	private int value;
	
	
	/**
	 * Constructs a Counter object whose value is 
	 * initialized to 0.
	 */
	public Counter()
	{
		reset();
	}
	
	public Counter(int n)
	{
		value=n;
	}
	
	
	/**
	 * Gets the current value of this counter.
	 * @return the current value
	 */
	public int getValue()
	{
		return value;
	}
	
	
	/**
	 * Advances the value of this counter by 1.
	 */
	public void count()
	{
		value = value + 1;
	}
	
	
	/**
	 * Resets the value of this counter to 0.
	 */
	public void reset()
	{
		value=0;
	}
	
	public void undo()
	{
		if(value > 0)
		{
			value--;
		}
	}
	
} //End class.
