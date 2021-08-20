/**
 * Joshua Catoe
 * CSCI 150-02
 * CashRegister (Lab 8)
 * (Last Updated)February 8, 2016
 * 
 */

import java.util.ArrayList;

public class CashRegister 
{	
	private ArrayList<Double> list;
	
	public CashRegister()
	{
		list = new ArrayList<Double>();
	}
	
	public void addItem(double item)
	{
		list.add(item);
	}
	
	public double getTotal()
	{
		int i;
		double sum = 0;
		
		for(i=0;i<list.size();i++)
		{
			sum = sum + list.get(i);
		}
		
		return sum;
	}
	
	public int getCount()
	{
		return list.size();
	}
	
	public void displayList()
	{
		for(int i=0;i<list.size();i++)
		{
			System.out.printf("%10.2f\n", list.get(i));
		}
	}
	
	public void clear()
	{
		list.clear();
	}
}
