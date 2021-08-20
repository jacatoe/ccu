public class MathCalc 
{
	public static void main(String[] args) 
	{int number1=69;
	 int number2=420;
	 System.out.println("Number 1: 69");
	 System.out.println("Number 2: 420");
	 System.out.print("Sum:");
	 System.out.printf("%15d",number1+number2);
	 System.out.println();
	 System.out.print("Difference:");
	 System.out.printf("%8d",number2-number1);
	 System.out.println();
	 System.out.print("Product:");
	 System.out.printf("%13d",number1*number2);
	 System.out.println();
	 System.out.print("Average:");

	 double num1=69;
	 double num2=420;
	 System.out.printf("%13.1f",(num1+num2)/2);
	 System.out.println();
	
	 System.out.print("Distance:");
	 System.out.printf("%10d",Math.abs(420-69));
	 System.out.println();
	 System.out.print("Maximum:");
	 System.out.printf("%11d",Math.max(69, 420));
	 System.out.println();
	 System.out.print("Minimum:");
	 System.out.printf("%10d",Math.min(69, 420));
	}

}
