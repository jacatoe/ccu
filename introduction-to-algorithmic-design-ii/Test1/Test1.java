/**
 * Joshua Catoe
 * CSCI 150-02
 * Test 1
 * (Last Updated)February 24, 2016
 * 
 * This program allows the user to enter a file name and have the contents of said file printed in reverse. 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Test1 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		System.out.println("Enter file name: ");
		
		boolean complete = false;
		
		while(!complete)
		{
			try
			{
				Scanner input = new Scanner(System.in);				
				File integers = new File(input.next());
				Scanner filescan = new Scanner(integers);
				
				ArrayList<Integer> a = new ArrayList<Integer>();
				
				while(filescan.hasNextLine())
				{
					String line = filescan.nextLine();
					Scanner linescan = new Scanner(line);
					
					while(linescan.hasNextInt())
					{
						int num = linescan.nextInt();
						
						a.add(num);						
					}	
					
					linescan.close();
				}			
				
				for(int i=a.size()-1;i>=0;i--)
				{
					System.out.println(a.get(i));
				}	
				
				input.close();
				filescan.close();
				
				complete=true;
			}
			catch(FileNotFoundException exception)
			{
				System.out.println("File not found. Enter valid file name: ");
			}
		}
	}

}
