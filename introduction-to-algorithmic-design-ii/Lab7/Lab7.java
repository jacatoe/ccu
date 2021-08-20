/**
 * Joshua Catoe	
 * CSCI 150-02
 * Lab 7
 * (Last Updated)February 1, 2016
 * This program creates an array of vending machines and allows the user to pick which 
 * machine receives cans and tokens. 
 */
import java.util.Scanner;

public class Lab7 
{

	public static void main(String[] args)
	{
		int i;
		
		VendingMachine[] m = new VendingMachine[12];
		
		for(i=0;i<12;i++)
		{
			m[i] = new VendingMachine(20);
		}
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter machine number: ");		
		
		i = in.nextInt();
		
		m[i].fillUp(10);
		m[i].insertToken();
		m[i].insertToken();
		
		System.out.printf("%12s %12s %12s\n","Machine","Can Count","Token Count");
		
		for(i=0;i<12;i++)
		{
			System.out.printf("%10d %10d %10d\n",i,m[i].getCanCount(),m[i].getTokenCount());
		}
		
		
		in.close();
	}

}
