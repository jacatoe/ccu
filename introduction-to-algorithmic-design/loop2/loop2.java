import java.util.Scanner;

public class loop2 {

	public static void main(String[] args) 
	
	{
		Scanner in = new Scanner(System.in);
		
				
		
		int sum = 0;
		
		while (sum < 100)
		{
			System.out.println("Enter Integers:");
			
			int integer = in.nextInt();			
			
			sum = sum + integer;			
			
			System.out.println("Sum:" +sum);
			
		}
		
	
		

	}

}
