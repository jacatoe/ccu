import javax.swing.JOptionPane;

public class posnegzero {

	public static void main(String[] args) 
	{
		String integer = JOptionPane.showInputDialog("Integer:");
		int x = Integer.parseInt(integer);
		
		if (x<0)
		{
			JOptionPane.showMessageDialog(null, "Negative (-)");
		}
		else if (x==0)
		{
			JOptionPane.showMessageDialog(null, "Zero (0)");
		}
		else if (x>0)
		{
			JOptionPane.showMessageDialog(null,"Positive (+)");
		}
			

	}

}
