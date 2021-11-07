import java.util.Scanner;

public class Lab16 
{

	public static void main(String[] args) 
	{
		Scanner inputScan = new Scanner(System.in);
		
		System.out.println("Input any string:");
		
		String input = inputScan.next();
		
		reverse(input);
		
		System.out.println(input);
		
		inputScan.close();

	}
	
	public static String reverse(String str)
	{
		if(str.length() <= 1)
		{
			return str;
		}
		else
		{
			return reverse((str.substring(1)) + (str.substring(0,1)));
		}
	
	}

}
