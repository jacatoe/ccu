/**
 * Joshua Catoe
 * CSCI 150-02
 * Lab 17
 * (Last Updated) April 4, 2016
 * 
 * This program creates an array of 25 strings from a file and sorts the strings alphabetically. 
 * 
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lab17 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		File strings = new File("Lab17.txt");
		Scanner fileScan = new Scanner(strings);
		
		String [] s = new String[25];
		
		while(fileScan.hasNextLine())
		{
			
			for(int i=0; i<s.length; i++)
			{
				s[i] = fileScan.nextLine();
			}
		}
		
		MergeSorter.sort(s);
		
		for(int i=0; i<s.length; i++)
		{
			System.out.println(s[i] + "\n");
		}
		
		fileScan.close();
	}

}
