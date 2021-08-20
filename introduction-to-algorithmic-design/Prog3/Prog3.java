/*
  Joshua Catoe
  CSCI 140-01
  11/3/2015
 
  This program is designed to allow the user to input a list of test grades and receive as output 
  the average grade, lowest grade, highest grade, and the median grade. When the user inputs a 
  negative value the process is terminated, and they are asked if they would like to enter another
  list. If the user inputs 1, then the loop runs again; if the user inputs 0, then the process is 
  terminated. 
   
*/


import java.util.Scanner;
public class Prog3 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner (System.in);
		
		System.out.println("Enter Grades. Enter negative to quit.");
		
		int grade=0;
		double sum=0;
		int count=0;
		
		int largest=0;
		int smallest=100;
		
		int response;
		
		do
		{
			while(grade>=0)
			{	
				grade=in.nextInt();			
			
				if(grade>=0 && grade<=100)
				{
					sum=sum+grade;
					count++;       
				
					if(grade>largest)
					{
						largest=grade;
					}
				
					if(grade<smallest)
					{
						smallest=grade;
					}
				
				}
			
				else
				{
					System.out.printf("Average Grade:" +(("%.1f\n")),(sum/count));
					System.out.println("Lowest Grade:" +smallest);
					System.out.println("Highest Grade:" +largest);
					System.out.println("Median Grade: Grade #" +(count/2)); //Count is also used as a position counter. "Grade #" indicates the position in the list. 
					System.out.println("");
					System.out.println("Enter another list? (1-Yes/0-No)");
				}
			
			}
		}
		while(grade>=0);
		{
			response=in.nextInt();
			
			if(response==1)
			{
				System.out.println("Enter Grades. Enter negative to quit.");
				
				grade=0;
				sum=0;
				count=0;
				
				largest=0;
				smallest=100;
				
				while(response==1)
				{	
					grade=in.nextInt();			
				
					if(grade>=0 && grade<=100)
					{
						sum=sum+grade;
						count++;
					
						if(grade>largest)
						{
							largest=grade;
						}
					
						if(grade<smallest)
						{
							smallest=grade;
						}
					
					}
				
					else
					{
						System.out.println("Average Grade:" +(sum/count));
						System.out.println("Lowest Grade:" +smallest);
						System.out.println("Highest Grade:" +largest);
						System.out.println("Median Grade: Grade #" +(count/2));
						System.out.println("");
					}
				}
				
			}
			
			else if(response==0) 
			{
				
			}
		}
		
		
	}

}
