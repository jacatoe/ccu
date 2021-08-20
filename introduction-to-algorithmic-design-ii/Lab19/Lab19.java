/**
 * Joshua Catoe
 * CSCI 150-02
 * Lab 19
 * (Last Updated) April 15, 2016
 * 
 * This program test to see if a string is a palindrome. 
 * 
 */

public class Lab19 
{
	public static void main(String[] args) 
	{
		PalindromeTester pt = new PalindromeTester();
		
		if(pt.isPalindrome("bob"))
		{
			System.out.println("bob is a palindrome");
		}
		else
		{
			System.out.println("bob is not a palindrome");
		}
		
		if(pt.isPalindrome("amanaplanacanalpanama"))
		{
			System.out.println("amanaplanacanalpanama is a palindrome");
		}
		else
		{
			System.out.println("amanaplanacanalpanama is not a palindrome");
		}
		
		if(pt.isPalindrome("abcdefghijklmnopqrstuvwxyz"))
		{
			System.out.println("abcdefghijklmnopqrstuvwxyz is a palindrome");
		}
		else
		{
			System.out.println("abcdefghijklmnopqrstuvwxyz is not a palindrome");
		}
	}
}
