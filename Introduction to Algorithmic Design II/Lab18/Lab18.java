/**
 * Joshua Catoe
 * CSCI 150-02
 * Lab 18
 * (Last Updated) April 8, 2016
 * 
 * This program creates a LinkedList of strings, prints them out, and then removes all strings beginning with a vowel. It then prints the remaining strings. 
 *  * 
 */

import java.util.LinkedList;
import java.util.ListIterator;

public class Lab18
{

	public static void main(String[] args) 
	{
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("aaa");
		list.addLast("bbb");
		list.addLast("ccc");
		list.addLast("ddd");
		list.addLast("eee");
		list.addLast("fff");
		list.addLast("ggg");
		list.addLast("hhh");
		list.addLast("iii");
		
		ListIterator<String> iter = list.listIterator();
		
		while(iter.hasNext())
		{
			String str = iter.next();
			
			System.out.println(str);
		}
		
		System.out.println("");
		
		while(iter.hasPrevious())
		{
			String str = iter.previous();
			
			if(str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u')
			{
				iter.remove();
			}
			
		}
		
		while(iter.hasNext())
		{
			String str = iter.next();
			
			System.out.println(str);
		}

	}

}
