import java.util.Scanner;

public class P45 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		double sum=0;
		int count =0;
		int values = 0;
		
		System.out.print("Enter values. Enter negative to quit.");
		
		while(values>=0);
		{			
			values = in.nextInt();
			
			sum = sum+values;
			count ++;
		}
		
		System.out.println("");
		System.out.println("Average:" +(sum/count));
		System.out.println("");
		System.out.println("Smallest Value:" +Math.min(values,values));
		System.out.println("");
		System.out.println("Largest Value:" +Math.max(values,values));
		System.out.println("");
		System.out.println("Range:" +(Math.min(values,values)-Math.max(values,values)));
		

	}

}
