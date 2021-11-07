import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial 
{
	private LinkedList<Term> termlist;
	
	public Polynomial()
	{
		termlist = new LinkedList<Term>();
	}
	
	public void addTerm(Term term)
	{
		ListIterator<Term> iter = termlist.listIterator();
		
		if(termlist.size() == 0)
		{
			termlist.add(term);
		}
		else if()
		{
			
		}
		else
		{
			if(term.getExp() > termlist.getFirst().getExp())
			{
				termlist.addFirst(term);
			}
			else if(term.getExp() < termlist.getFirst().getExp())
			{
				
			}
		}
	}
	
	public void input()
	{
		//Polynomial from console
	}
	
	public void addPolynomial(Polynomial poly)
	{
		//Add poly to current polynomial
	}
	
	public String toString()
	{
		
	}
}
