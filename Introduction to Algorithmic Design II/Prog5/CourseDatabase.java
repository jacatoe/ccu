/**
 * Joshua Catoe
 * CSCI 150-02
 * CourseDatabase (Program 5)
 * (Last Updated) April 10, 2016
 * 
 *  This class represents a database of course objects. 
 */

import java.util.ArrayList;
import java.util.Collections;

public class CourseDatabase 
{
	private ArrayList<Course> courselist; //List of course objects
	
	/**
	 * Constructs CourseDatabase object.
	 */
	public CourseDatabase()
	{
		courselist = new ArrayList<Course>(); //Initialize list of courses
	}
	
	/**
	 * Adds course to the database.
	 * 
	 * @param course //Course being added
	 */
	public void addCourse(Course course)
	{
		courselist.add(course);
	}
	
	/**
	 * Sorts courses in the course list by name and section.
	 */
	public void courseSort()
	{
		Collections.sort(courselist);
	}
	
	/**
	 * Prints the name, section, and enrollment number of all courses in the database.
	 */
	public void displayCourses()
	{
		for(int i=0; i<courselist.size(); i++)
		{
			courselist.get(i).getInfo();
		}
	}
	
	/**
	 * Adds a student to the specified class in the database. 
	 * 
	 * @param coursename //Name of course
	 * @param section //Course section number
	 * @param stud //Student object 
	 */
	public void enrollStudent(String coursename, int section, Student stud)
	{
		courselist.get(getIndex(coursename, section)).addStudent(stud);
	}
	
	/**
	 * Sets the grade for a student in a course in the database.
	 * 
	 * @param coursename //Name of course
	 * @param section //Course section number
	 * @param lastname //Last name of student
	 * @param firstname //First name of student
	 * @param grade //Letter grade of student
	 */
	public void enterGrades(String coursename, int section, String lastname, String firstname, String grade)
	{
		if(getIndex(coursename, section) >= 0)
		{
			if(courselist.get(getIndex(coursename, section)).getIndex(lastname, firstname) >= 0)
			{
				courselist.get(getIndex(coursename, section)).enterGrades(lastname, firstname, grade);
				
				System.out.println("Grade entered.");
			}
			else if(courselist.get(getIndex(coursename, section)).getIndex(lastname, firstname) == -1)
			{
				System.out.println("Student not on roll.");
			}
		}
		else if(getIndex(coursename, section) == -1)
		{
			System.out.println("Course not available.");
		}
	}
	
	/**
	 * Prints names and grades of all students in a specified course.
	 * 
	 * @param coursename //Name of course
	 * @param section //Course section number
	 */
	public void displayRoll(String coursename, int section)
	{
		if(getIndex(coursename, section) >= 0)
		{
			courselist.get(getIndex(coursename, section)).displayRoll();
		}
		else if(getIndex(coursename, section) == -1)
		{
			System.out.println("Course not available.");
		}
		
	}	
	
	/**
	 * Retrieves index of a specific course object in the course list. 
	 * 
	 * @param coursename //Name of course
	 * @param section //Course section number
	 * @return //Index of course if found, -1 if not found
	 */
	private int getIndex(String coursename, int section)
	{
		String searchedname = coursename; //Course name being searched for
		int searchedsection = section; //Course section being searched for
		
		for(int i=0; i<courselist.size(); i++)
		{
			if(courselist.get(i).getName().equals(searchedname) && courselist.get(i).getSection() ==  searchedsection)
			{
				return i;
			}
		}
		return -1;
	}
}
