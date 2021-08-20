/*
 * Joshua Catoe
 * David Ramsaroop
 * Noah Reidinger
 */

import java.util.Scanner;

public class HashTable 
{
	
	int size = 0;
	int[] hash;
	Scanner scan = new Scanner(System.in);
	
	public HashTable(int s){
		
		size = s;
		hash = new int[size];
		/*
		 * Makes the array contents -1 to simulate null values
		 */
		for(int i = 0; i < size; i++){
			hash[i] = -1;
		}
	
	}
	
	public void delete(int value){
		//search and replace the selected value with -1 (our null value)
		boolean found = false;
		for(int i = 0; i < size; i++){
			if(hash[i] == value){
				hash[i] = -1;
				found = true;
				i = size;
				System.out.println("The value was removed.");
			}
		}
		if(!found)
			System.out.println("The value could not be found and removed!");
	}
	
	public void insert(int value){
		int index = -1;
		//Linear Probing
		for(int i = 0; i < size; i++){
			index = (value + i) % size; //Algorithm
			if(isEmpty(index)){
				hash[index] = value;
				i = size;
			}
		}
	}
	
	public void search(int value){
		boolean found = false;
		
		for(int i = 0; i < size; i++){
			if(hash[i] == value){
				System.out.println("The value " + value + " is at index: " + i);
				found = true;
				i = size;
			}
		}
		if(!found)
			System.out.println("The value " + value + " was not found!");
	}
	
	/*
	 * Prints contents of the hash table
	 */
	public void print(){
		for(int i = 0; i < size; i++){
			System.out.println("Key: " + i + " Value: " + hash[i]);
		}
	}
	/*
	 * Checks to see if specified index is filled already
	 */
	public boolean isEmpty(int index){
		int contents = hash[index];
		if(contents == -1)
			return true;
		else
			return false;
	}
	
	public static void main(String[]args){
		int input;
		boolean proceed = true;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter array size: ");
		input = scan.nextInt();
		HashTable table = new HashTable(input);
		System.out.println();
		table.print();
		System.out.println();
		
		while(proceed){
			System.out.println("Enter 1 to Insert a new value.");
			System.out.println("Enter 2 to Delete a value.");
			System.out.println("Enter 3 to Search for a value.");
			
			input = scan.nextInt();
			System.out.println();
			
			if(input == 1){
				System.out.println("Please enter the value you would like to insert: ");
				input = scan.nextInt();
				table.insert(input);
			}
			else if(input == 2){
				System.out.println("Please enter the value you would like to delete: ");
				input = scan.nextInt();
				table.delete(input);
			}
			else if(input == 3){
				System.out.println("Please enter the value you would like to search for: ");
				input = scan.nextInt();
				table.search(input);
			}
			else
				System.out.println("Unknown command entered!");
			
			System.out.println();
			
			table.print();
			
			System.out.println();
			System.out.println("Would you like to continue? (true/false)");
			proceed = scan.nextBoolean();
			System.out.println();
		}
		
		scan.close();
		
	}

}
