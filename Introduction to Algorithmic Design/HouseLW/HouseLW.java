import javax.swing.JOptionPane;
public class HouseLW 
{

	public static void main(String[] args)
	{
		String lengthoflot;
		double lotlength = 0;
		
		while(lotlength<=0)		
		{
			lengthoflot = JOptionPane.showInputDialog("Lenght of Lot");
		    lotlength = Double.parseDouble(lengthoflot);
		}
		
		String widthoflot;
		double lotwidth = 0;
		
		while(lotwidth<=0)	
		{
			widthoflot = JOptionPane.showInputDialog("Width of Lot");		
			lotwidth = Double.parseDouble(widthoflot);
		}
		
	 final double lotarea = Area(lotlength,lotwidth);	 
	 JOptionPane.showMessageDialog(null,"Area of Lot:" + lotarea);
	 
	    String lengthofhouse;
	    double houselength = 0;
	    
	 	while (houselength<=0)
	 	{
	 		lengthofhouse = JOptionPane.showInputDialog("Length of House:");
	 		houselength = Double.parseDouble(lengthofhouse);
	 	}
	 	
	 	String widthofhouse;
	 	double housewidth = 0;
	 	
	 	while(housewidth<=0)
	 	{	
	 		widthofhouse = JOptionPane.showInputDialog("Width of House:");
	 		housewidth = Double.parseDouble(widthofhouse);
	 	}
	 	
	 final double housearea = Area(houselength,housewidth);
	 JOptionPane.showMessageDialog(null, "Area of House:" +housearea);	 
	 
	 final double grassarea= Area(lotarea,housearea);
	 JOptionPane.showMessageDialog(null,"Area of Grass:" + grassarea);
	 
	 if(housearea>grassarea)
	 {
		 JOptionPane.showMessageDialog(null,"ERROR: Please git gud and try again.");
	 }
	 else
	 {
		 JOptionPane.showMessageDialog(null,"Area of Lot:" +lotarea);
		 JOptionPane.showMessageDialog(null,"Area of House:" +housearea);
		 JOptionPane.showMessageDialog(null,"Area of Grass:" +grassarea);
		   
	 }
	 
	 
 
	} //End of Main
	
	public static double Area(double length, double width)
	{
		return length*width;
	}
	
	

}
