/**
 * Joshua Catoe
 * CSCI 150-02
 * Lab 15
 * (Last Updated)March 29, 2016
 * 
 * This program reads in a large amount of last names, sorts them, then tries to guess the user's last name based on the list.
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.net.URL;
import java.io.File; //Not needed?
import java.io.PrintWriter; //Not needed?

public class Lab15 
{

	public static void main(String[] args) throws IOException, MalformedURLException
	{
		ArrayList<String> lastNames = new ArrayList<String>();
		
		URL url = new URL("http://www2.census.gov/topics/genealogy/1990surnames/dist.all.last");
		
		Scanner in = new Scanner(url.openStream());
		
		while(in.hasNext())
		{
			String lname = in.next();
			in.nextLine();
			
			lastNames.add(lname);
		}
		
		Collections.sort(lastNames);
		
		guessName(lastNames);
		
		in.close();
	}
	
	public static void guessName(ArrayList<String> arraylist)
	{
		boolean found = false;
		int low = 0;
		int high = arraylist.size()-1;
		int mid = 0;
		char answer;
		
		Scanner inputScan = new Scanner(System.in);
		
		while(low <= high && !found)
		{
			mid = (low+high)/2;
			
			System.out.println("Is your name " + arraylist.get(mid) + "? (Y/N)");
			answer = inputScan.next().charAt(0);
			
			if(answer == 'Y' || answer == 'y')
			{
				found = true;
			}
			else if(answer == 'N' || answer == 'n')
			{
				System.out.println("Does your name come before " + arraylist.get(mid) + " in the dictionary? (Y/N)");
				answer = inputScan.next().charAt(0);
				
				if(answer == 'Y' || answer == 'y')
				{
					high = mid - 1;
				}
				else if(answer == 'N' || answer == 'n')
				{
					low = mid + 1;
				}
			}
		}

		if(found)
		{
			System.out.println("I guessed your name!");
		}
		else
		{
			System.out.println("Sorry, I cannot guess your name.");
		}
		
		inputScan.close();
	}

}
