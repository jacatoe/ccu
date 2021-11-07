import javax.swing.JOptionPane;

public class grades {

	public static void main(String[] args) 
	
	{
		String doubl3 = JOptionPane.showInputDialog("Numeric Grade:");
		int grade = Integer.parseInt(doubl3);
		
		if (grade >= 90)
		{
			JOptionPane.showMessageDialog(null, "Letter Grade: A");
		}
			else if (grade >= 87 && grade <= 89)
			{
			JOptionPane.showMessageDialog(null, "Letter Grade B+");
			}
			else if (grade >= 80 && grade <= 86)
			{
			JOptionPane.showMessageDialog(null, "Letter Grade B");
			}
			else if (grade >= 77 && grade <= 79)
			{
			JOptionPane.showMessageDialog(null, "Letter Grade C+");
			}
			else if (grade >=70 && grade <=76)
			{
			JOptionPane.showMessageDialog(null, "Letter Grade C");
			}
			else if (grade >=67 && grade <= 69)
			{
			JOptionPane.showMessageDialog(null, "Letter Grade D+");
			}
			else if (grade >=60 && grade <= 66)
			{
			JOptionPane.showMessageDialog(null, "Letter Grade D");
			}
			else
		{
			JOptionPane.showMessageDialog(null, "Letter Grade F");
		}

	}

}
