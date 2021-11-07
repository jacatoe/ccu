import javax.swing.JOptionPane;

/* This program accomplishes the task of allowing a user to input a radius of a circle and, in return,
	be given the computaion of the diameter, circumference, and area of the circle based on said radius. 
	Joshua Catoe
	CSCI 140-01
	9/30/2015 */
	
	
public class circle 

{

	public static void main(String[] args) 
	
	{
		String rad = JOptionPane.showInputDialog("Radius of Circle");
		double radius = Double.parseDouble(rad);
		
		final double diameter = (radius*2);
		JOptionPane.showMessageDialog(null, "Diameter of Circle=" +diameter);
		
		final double circumference = (2*3.14*radius);
		JOptionPane.showMessageDialog(null, "Circumference of Circle=" +circumference);
		
		final double area = (3.14*(Math.pow(radius, 2)));
		JOptionPane.showMessageDialog(null, "Area of Circle=" +area);
	}

}
