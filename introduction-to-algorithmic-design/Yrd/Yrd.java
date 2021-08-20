import java.util.Scanner;
public class Yrd {

	public static void main(String[] args) {

	Scanner in = new Scanner(System.in);
	System.out.print("Yards:");
	final double yard = in.nextDouble();
	System.out.println();
	System.out.print("Feet:");
	final double feets = 3;
	 double feet = (yard*feets);
	System.out.println(feet); 
	System.out.print("Inches:");
	final double inches1 = 36;
	 double inches = (yard*inches1);
	System.out.println(inches);
}}
