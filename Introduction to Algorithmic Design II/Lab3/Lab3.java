/**
 * Joshua Catoe
 * CSCI 150-02
 * Lab 3
 * (Last Updated)January 22, 2016
 * This program takes an array of integers and rotates the elements of the array so that the last takes the position of the first,
 * and all other elements move one position to the right.  
 * 
 *
 */
public class Lab3 
{

	public static void main(String[] args) 
	{
		int[] a={10,20,30,40};
		
		rotate(a);
		
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]);
		}	
		
	}
	
	/**
	 * Places last array element in first position and moves all other elements one position to the right. 
	 * @param array
	 */
	public static void rotate(int[]array)
	{
		for(int i=array.length-1;i<=array.length-1;i++)
		{
			int temp=array[i];
			array[i]=array[i-1];
			array[i-1]=array[i-2];
			array[i-2]=array[i-3];
			array[i-3]=temp;
		}
	}

}
