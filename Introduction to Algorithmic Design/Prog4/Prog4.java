/*
  Joshua Catoe
  CSCI 140-01
  12/9/2015
  
  This program is designed to read in an array, sort the array in ascending order by using the bubble sort algorithm, and then allow the user 
  to search for a value within the array using the binary search algorithm.
   
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prog4 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
        int[] numbers = new int[100];
		
		File inputFile = new File("readin.txt");		
		Scanner in = new Scanner(inputFile);   
		
        int i=0;
		
		while(in.hasNextInt())
		{
			numbers[i] = in.nextInt(); 
			i++;
		}
		
		for(i=0;i<99;i++)
		{
			BubbleSort(numbers);
			
			System.out.print(numbers[i]+" ");
		}
		
		System.out.println(" ");
		System.out.println(" ");
		
		BinarySearch(numbers);		
		
		in.close();
		
	}
	
	public static int BubbleSort(int[]array)
	{		
		int temp = 0;
		
		for(int i=0;i<99;i++)
		{
			for(int j=0;j<99;j++)
			{				
				if(array[j]>array[j+1])
				{
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;					
					
				}
			}			
	    }
		return temp;
	}
	
	public static void BinarySearch(int[]array)
	{
		boolean found=false;
		int low=0;
		int high=array.length -1;
		int pos=0;
		int searchedValue=250; //Change searchedValue to desired number.
		
		while(low<=high && !found)
		{			
			pos=(low+high)/2;
			
			if(array[pos]==searchedValue)
			{
				found=true;
			}
			else if(array[pos]<searchedValue)
			{
				low = pos+1;
			}
			else
			{
				high = pos-1;
			}
		}
		if(found)
		{
			System.out.println("Searched value found at position " +pos);
		}
		else
		{
			System.out.println("Searched value not found.");
		}
		
	}

}
