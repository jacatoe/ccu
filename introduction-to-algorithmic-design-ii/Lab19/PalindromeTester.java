/**
 * Joshua Catoe
 * CSCI 150-02
 * PalindromeTester (Lab 19)
 * (Last Updated) April 15, 2016  
 */

import java.util.Stack;

public class PalindromeTester 
{
	private Stack<Character> stk;
	
	public PalindromeTester()
	{
		stk = new Stack<Character>();
	}
	
	public boolean isPalindrome(String s)
	{		
		for(int i=0; i<s.length(); i++)
		{
			stk.push(s.charAt(i));			
		}
		
		String s2 = "";
		
		while(!stk.isEmpty())
		{
			s2 = s2 + stk.pop().toString();
		}
		
		if(s2.equals(s))
		{
			return true;
		}
		return false;
		
	}
}
