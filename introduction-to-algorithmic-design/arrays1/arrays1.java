import java.util.Scanner;

import javax.swing.JOptionPane;
public class arrays1 
{

	public static void main(String[] args)
	{
		final int length=5;
		int[]values = new int [length];
		
		System.out.println("Enter 5 Integers:");
		
		Scanner in = new Scanner(System.in);
		
		for(int i=0;i<values.length;i++)
		{
			values[i]=in.nextInt();
			
			while(i>values.length)
			{
				JOptionPane.showMessageDialog(null,values[i]);
			}
			
		}
		
		

	}

}
