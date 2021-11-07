/**
 * Joshua Catoe
 * CSCI 150-02
 * Course (Program 5)
 * (Last Updated) April 10, 2016
 * 
 * This class represents a college course. 
 */

import java.util.ArrayList;
import java.util.Collections;

public class Course implements Comparable<Course>
{
	private String name; //Course name
	private int sectnum; //Section number of course
	private int enrollnum; //Number of students enrolled 
	private ArrayList<Student> studlist; //List of students in course
	
	/**
	 * Constructs course object.
	 * 
	 * @param name //Name of course
	 * @param sectnum //Section number of course
	 */
	public Course(String name, int sectnum)
	{
		this.name = name; //Course name
		this.sectnum = sectnum; //Section number
		studlist = new ArrayList<Student>(); //Initializes student list
		enrollnum = 0; //Enrollment number starts at 0, as there are no students
	}
	
	/**
	 * Retrieves name of course.
	 * 
	 * @return //Course name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Retrieves section number of course.
	 * 
	 * @return //Section number
	 */
	public int getSection()
	{
		return sectnum;
	}
	
	/**
	 * Retrieves number of students enrolled in course.
	 * 
	 * @return //Number of students enrolled
	 */
	public int getEnrolled()
	{
		return enrollnum;
	}
	
	/**
	 * Prints all information about a course.
	 */
	public void getInfo()
	{
		System.out.println(name + " " + sectnum + " " + enrollnum);
	}
	
	/**
	 * Adds student to course.
	 * 
	 * @param stud //Student being added
	 */
	public void addStudent(Student stud)
	{
		studlist.add(stud);
		
		enrollnum = studlist.size(); //Enrollment increases when student is added
	}
	
	/**
	 * Sets the grade of a specific student in a course.
	 * 
	 * @param lastname //Last name of student
	 * @param firstname  //First name of student
	 * @param grade //Letter grade of student
	 */
	public void enterGrades(String lastname, String firstname, String grade)
	{
		if(getIndex(lastname, firstname) >= 0)
		{
			studlist.get(getIndex(lastname, firstname)).setGrade(grade);
		}
		else if(getIndex(lastname, firstname) == -1)
		{
			System.out.println("Student not on roll.");
		}
	}
	
	/**
	 * Prints names and grades of all students in a course
	 */
	public void displayRoll()
	{
		if(studlist.size() > 0)
		{
			Collections.sort(studlist);
			
			for(int i=0; i<studlist.size(); i++)
			{
				studlist.get(i).getInfo();
			}
		}
		else if(studlist.size() == 0)
		{
			System.out.println("No students enrolled.");
		}
	}
	
	/**
	 * Lexicographically compares courses by name and then numerically by section 
	 */
	public int compareTo(Course others)
	{
		if(name.compareTo(others.name) < 0)
		{
			return -1;
		}
		else if(name.compareTo(others.name) > 0)
		{
			return 1;
		}
		else if(name.compareTo(others.name) == 0)
		{
			if(sectnum < others.sectnum)
			{
				return -1;
			}
			else if(sectnum > others.sectnum)
			{
				return 1;
			}
			return 0;
		}
		return 0;
	}
	
	/**
	 * Retrieves the index of a student object in the list of students.
	 * 
	 * @param lastname //Last name of student
	 * @param firstname //First name of student
	 * @return //Index if found, -1 if not found
	 */
	public int getIndex(String lastname, String firstname)
	{
		String searchedlastname = lastname; //Last name being searched for
		String searchedfirstname = firstname; //First name being searched for
		
		for(int i=0; i<studlist.size(); i++)
		{
			if(studlist.get(i).getLast().equals(searchedlastname) && studlist.get(i).getFirst().equals(searchedfirstname))
			{
				return i;
			}
		}
		return -1;
	}
}
