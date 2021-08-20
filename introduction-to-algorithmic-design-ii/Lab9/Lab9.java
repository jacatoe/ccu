/**
 * Joshua Catoe
 * CSCI 150-02
 * Lab 9
 * (Last Updated)March 20, 2016
 * This program is designed to simulate sending and receiving an e-mail message. 
 */

import java.util.Scanner;

public class Lab9 
{

	public static void main(String[] args) 
	{
		String s; //Sender 
		String r; //Recipient
		String b; //Message body
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Sender:");
		s = in.nextLine();
		
		System.out.print("Recipient:");
		r = in.nextLine();
		
		Message m = new Message(s,r);
		
		System.out.print("Message(*** to quit):");
		b = in.nextLine();
			
		while (!b.equals("***"))
		{
			m.append(b);
			b = in.nextLine();	
		}

		System.out.print(m.toString());
		
		in.close();
	}

}
