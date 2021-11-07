import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class files1 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		int[] numbers = new int[20];
		
		File inputFile = new File("numbers.txt");
		
		Scanner in = new Scanner(inputFile); 
		
	    int i=0;
		
		while(in.hasNextInt())
		{
			numbers[i] = in.nextInt(); 
			i++;
		}
		
		for(i=0;i<20;i++)
		{
			BubbleSort(numbers);
			
			System.out.print(numbers[i]+" ");
		}
		
		in.close();
        
        //End of Main
        
		
	}

	
	public static int BubbleSort(int[]array)
	{		
		int temp = 0;
		
		for(int i=0;i<19;i++)
		{
			for(int j=0;j<19;j++)
			{				
				if(array[j]<array[j+1])
				{
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;					
					
				}
			}			
	    }
		return temp;
	}
	
}
