import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class lab1 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
	 System.out.println("Enter file name:");
	 System.out.println("");
	 
	 boolean done = false;
	 
	 while(!done)
	 {
		 try
		 {
			 Scanner input = new Scanner(System.in);		
			 File inputFile = new File(input.next());
		     Scanner in = new Scanner(inputFile);
		     
		     PrintWriter out = new PrintWriter("lab1out.txt");
		     
		     double sum = 0;
		     double num = 0;
		     
		     
		     while(in.hasNextLine())
		     {    	
		    	String line = in.nextLine();
		    	Scanner lineScanner = new Scanner(line);
		    	   	
		    	while(lineScanner.hasNextDouble())
		    	{
		    		num = lineScanner.nextDouble();
		    		sum = num+sum;    		
		    	}
		    	
		    	lineScanner.close();
		    	
		     }
		     
		     System.out.println("Line 1: Sum=" +sum);
			 System.out.println("Line 2: Sum=" +sum);
			 System.out.println("Line 3: Sum=" +sum);
			 	
			 out.println("Line 1: sum=" +sum);
			 out.println("Line 2: sum=" +sum);
			 out.println("Line 3: sum=" +sum);
		     
		    
			input.close();
		 	in.close();
		 	out.close();
			 
			done = true;
		 }
		 catch(FileNotFoundException exc)
		 {
			 System.out.println("File not found. Enter valid file name:");
		 } 
	     
	 } 	
 	
	}
	

}
