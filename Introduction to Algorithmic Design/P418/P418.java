import java.util.Scanner;
public class P418 
{

	public static void main(String[] args) 
	{
		Scanner in= new Scanner(System.in);
		
		System.out.println("Enter Integer:");
		
		int num = in.nextInt();
		int counter = 2;
		
		while(counter<num);
		{			
			int x = num;
			int y = counter;
			
			Boolean prime=true;
			
			while (prime)
			{
				while(y<x)
				{
					y++;
				
					if(x%y==0)
					{
						prime=false;
					}
						if(prime)
						{
							System.out.println(x);
							prime=false;
							
						}
				}
			counter++;
			}
			
					
			    
						
		 }

	}

}
