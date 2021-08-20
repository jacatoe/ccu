import java.util.Scanner;
public class methods 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter two positive integers, zero and integer to quit:");
		
		int num1 = in.nextInt();
		int num2 = in.nextInt();
		
		do
		{
			int sum = Add(num1,num2);
			System.out.println("Sum:" +sum);
			
			int dif = Subtract(num1,num2);
			System.out.println("Difference:" +dif);
			
			int pro = Multiply(num1,num2);
			System.out.println("Product:" +pro);
			
			int quo = Divide(num1,num2);
			System.out.println("Quotient:" +quo);
			
			num1 = in.nextInt();
			num2 = in.nextInt();			
		}
		while(num1!=0 && num2!=0);
		{
			
		}

	}
	
	//END MAIN
	
	public static int Add(int x,int y)
	{
		return x+y;
	}
	
	public static int Subtract(int x,int y)
	{
		return x-y;
	}
	
	public static int Multiply(int x,int y)
	{
		return x*y;
	}
	
	public static int Divide(int x,int y)
	{
		return x/y;
	}

}
