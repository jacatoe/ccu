/*
  Joshua Catoe
  CSCI 140-01
  10/14/2015
 
  This program is designed to allow the user to input a list of nonnegative integers and receive as output the number of integers that contain
  one, two, or three or more digits, and the sum of those integers. The user must input a negative integer to terminate the process and print the 
  results.
   
*/
 

import java.util.Scanner;
public class Prog2 {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Input integers. Input negative to quit.");
		
		int count = 0;
		int count2 = 0;
		int count3 = 0;
			
	    int sum = 0;
		int sum2 = 0;
		int sum3 = 0;
		
	    int integer = 0;
	    		
	    while (integer >=0)
	    {		    		
	    	integer = in.nextInt();
	    	
	    	if(integer>=0 && integer<=9)
	    	{
	    		sum = sum + integer;
	    		count++;
	    	}
	    	else if(integer>=10 && integer<=99)
	    	{
	    		sum2 = sum2 + integer;
	    		count2++;
	    	}
	    	else if(integer>=100)
	    	{
	    		sum3 = sum3 + integer;
	    		count3++;
	    	}
	    	else 
	    	{
	    		 System.out.println("");
	    		 System.out.println("Number of one digit integers:" +count);
	    		 System.out.println("Sum of one digit integers:" +sum);
	    		 System.out.println("");
	    		 System.out.println("Number of two digit integers:" +count2);
	    		 System.out.println("Sum of two digit integers:" +sum2);
	    		 System.out.println("");
	    		 System.out.println("Number of three or more digit integers:" +count3);
	    		 System.out.println("Sum of three or more digit integers:" +sum3);
	    	}
	    	
	    } 
	    		
	  
	}

}
