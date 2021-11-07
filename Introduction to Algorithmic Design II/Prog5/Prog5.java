/**
 * Joshua Catoe
 * CSCI 150-02
 * Program 5
 * (Last Updated) April 10, 2016
 * 
 *  This program creates a database of courses from a text file. It then gives the user a menu of options which allows them
 *  to list all courses, enroll a student in courses, sort the courses, enter a student's grades, display a class roll, or
 *  to quit.  
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Prog5
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//Create file object and file scanner
		
		File courses = new File("prog5.txt"); //File object to be scanned
		Scanner fileScan = new Scanner(courses); //Scanner object to scan file
		
		//Create CourseDatabase object
		
		CourseDatabase cdb = new CourseDatabase(); //CourseDB object 
		
		String coursename; //Name of course object
		int section; //Section number of course object
		
		//Read in contents of file
		
		while(fileScan.hasNextLine())
		{
			String line = fileScan.nextLine(); //Line of text file
			
			Scanner lineScan = new Scanner(line); //Scanner for line
			
			coursename = lineScan.next() + " " + lineScan.next(); //Name of course from file			
			section = lineScan.nextInt(); //Section number of course from file
			
			//Create course objects based on file 
			
			Course course = new Course(coursename, section); //Course object 
			
			//Add courses to the database
			
			cdb.addCourse(course);
			
			//Close line scanner
			
			lineScan.close();
		}
		
		//Print menu prompts
		
		System.out.println("1)List Courses 2)Enroll Student 3)Sort Courses 4)Enter Grades 5)Display Roll 6)Quit");
		
		//Create scanner to read user input
		
		Scanner inputScan = new Scanner(System.in);
		
		int choice; //User menu choice
		
		String lastname; //Last name of students
		String firstname; //First name of students
		String grade; //Letter grade of students
		
		//Read in and process user choice
		
		do
		{
			choice = inputScan.nextInt();
			
			switch(choice)
			{
				case 1:		
					
					//Display courses in database
					
					cdb.displayCourses();
					
					break;
					
				case 2:
					
					//Prompt for and read in last and first names 
					
					inputScan.nextLine(); //Clear input	
					System.out.println("Last name: ");
					lastname = inputScan.next();
				
					
					System.out.println("First name: ");
					firstname = inputScan.next();
									
					//Create new student object from inputs
					
					Student stud = new Student(lastname, firstname);
					
					//Prompt for and read in course name and section number
					
					inputScan.nextLine(); //Clear input
					System.out.println("Course name: ");
					coursename = inputScan.nextLine();
					
					
					System.out.println("Section number: ");
					section = inputScan.nextInt();
					
					//Add student to specified course
					
					cdb.enrollStudent(coursename, section, stud);
					
					System.out.println("Student enrolled.");
					
					break;
				
				case 3:
					
					//Sort courses by name and section number
					
					cdb.courseSort();
					
					System.out.println("Courses sorted.");
					
					break;
					
				case 4:
					
					//Prompt for and read in course name and section
					
					System.out.println("Course name:");
					inputScan.nextLine(); //Clear input
					coursename = inputScan.nextLine();
					
					System.out.println("Section number:");
					section = inputScan.nextInt();
					inputScan.nextLine();
					
					
					//Prompt for and read in student last name, first name, and grade
					
					System.out.println("Last name:");
					lastname = inputScan.nextLine();
					
					System.out.println("First name:");
					firstname = inputScan.nextLine();
					
					System.out.println("Letter grade:");
					grade = inputScan.nextLine();
					
					//Set grade for specified student in specified class
					
					cdb.enterGrades(coursename, section, lastname, firstname, grade);
					
					break;
					
				case 5:
					
					//Prompt for and read in course name and section number
					
					inputScan.nextLine();
					System.out.println("Course name: ");
					coursename = inputScan.nextLine();
					
					
					System.out.println("Section number: ");
					section = inputScan.nextInt();
					
					//Display the roll for the specified course
					
					cdb.displayRoll(coursename, section);
					
					break;
					
				case 6:
					
					//Terminate program
					
					break;
					
				default:
					System.out.println("Invalid selection.");			
			}
			
		}while(choice != 6);
		
		//Close scanners
		
		inputScan.close();
		fileScan.close();
		
	} //End of main
	
} //End of class
