import java.util.Scanner;
public class Name {

	public static void main(String[] args) 
	{Scanner in = new Scanner(System.in);
	
	System.out.print("Frist Name:");
	String fname = in.next();
	System.out.print("Middle Initial:");
	String mname = in.next();
	System.out.print("Last Name:");
	String lname = in.next();
	
	String name = fname+" "+mname+" "+lname;
	System.out.println();
	System.out.println(name);
	}
	

}
