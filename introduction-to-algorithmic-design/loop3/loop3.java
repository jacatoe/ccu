import java.util.Scanner;
import javax.swing.JOptionPane;
public class loop3 {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner (System.in);
		
	    int number = in.nextInt();
	    if (number>=1 && number<=100)
	    {
	    	boolean found = false;
	 	    
	 	    int guess = in.nextInt();
	 	    JOptionPane.showInputDialog("Guess?");	 	    
	 	    
	 	    while(!found && guess<=10)
	 	    {
	 	       JOptionPane.showInputDialog("Guess Again:"); 	    	
	 	    	
	 	    }
	    
	    }
	    
	    
	   
	    
	    
	    
		

	}

}
