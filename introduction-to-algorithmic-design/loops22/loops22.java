import java.util.Scanner;
public class loops22 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		
		int number = in.nextInt();
		int sum = 0;
	
		
		for (sum =0; sum<=100; sum=sum+number)
		{
			System.out.println("Enter Numbers:");
			
			System.out.println ("Sum:" +sum);
			
		}
		
		System.out.print(number);

	}

}
