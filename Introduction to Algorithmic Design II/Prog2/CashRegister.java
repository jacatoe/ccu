/**
 * Joshua Catoe
 * CSCI 150-02
 * CashRegister (Program 2)
 * (Last Updated)February 11, 2016
 * 
 */

import java.util.ArrayList;

public class CashRegister 
{	
	private ArrayList<Double> list; //List of items(prices).
	
	/**
	 * Constructs CashRegister object.
	 */
	public CashRegister()
	{
		list = new ArrayList<Double>();
	}
	
	/**
	 * Adds item to list of items.
	 * @param item //Item to be added to list.
	 */
	public void addItem(double item)
	{
		list.add(item);
	}
	
	/**
	 * Calculates total price of items in the list.
	 * @return //Returns sum of items.
	 */
	public double getTotal()
	{
		int i; //Counter variable & elements of list.
		double sum = 0; //Sum of list.
		
		for(i=0;i<list.size();i++)
		{
			sum = sum + list.get(i);
		}
		
		return sum;
	}
	
	/**
	 * Retrieves total number of items in the list. 
	 * @return //Returns number of items (size of list).
	 */
	public int getCount()
	{
		return list.size();
	}
	
	/**
	 * Displays each element of the list. 
	 */
	public void displayList()
	{
		for(int i=0;i<list.size();i++)
		{
			System.out.printf("%10.2f\n", list.get(i));
		}
	}
	
	/**
	 * Empties list of items. 
	 */
	public void clear()
	{
		list.clear();
	}
}
