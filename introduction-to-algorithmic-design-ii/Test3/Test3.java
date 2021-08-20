/**
 * Joshua Catoe
 * CSCI 150-02
 * Test 3
 * (Last Updated) April 25, 2016
 * 
 * This program takes a list of nonnegative integers inputed by the user and prints them in several orders.
 */
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Scanner;

public class Test3 
{

	public static void main(String[] args) 
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		System.out.println("Enter list of nonnegative integers. Negative to quit.");
		
		Scanner input = new Scanner(System.in);
		
		int num = 0;
		
		while(num >= 0)
		{
			num = input.nextInt();
			
			if(num >= 0)
			{
				list.add(num);
			}
			
		}
		
		ListIterator<Integer> iter = list.listIterator();
		
		System.out.println("List of integers.");
		System.out.println("----------------");
		
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
		System.out.println("");
		System.out.println("Reversed list");
		System.out.println("-------------");
		
		while(iter.hasPrevious())
		{
			System.out.println(iter.previous());
		}
		
		Stack<Integer> stk = new Stack<Integer>();
		
		iter = list.listIterator();
		
		while(iter.hasNext())
		{
			stk.push(iter.next());
		}
		
		System.out.println("");
		System.out.println("Stack elements");
		System.out.println("--------------");
		
		while(!stk.isEmpty())
		{
			System.out.println(stk.pop());
		}
		
		iter = list.listIterator();
		
		while(iter.hasNext())
		{
			for(int i=0; i<list.size(); i++)
			{
				if(iter.next() % 2 == 0)
				{
					list.remove(i);
				}
			}
			
		}
		
		System.out.println("");
		System.out.println("Non-even integers");
		System.out.println("-----------------");
		
		iter = list.listIterator();
		
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
		input.close();
	}

}
