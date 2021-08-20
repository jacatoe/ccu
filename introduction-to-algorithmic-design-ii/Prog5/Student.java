/**
 * Joshua Catoe
 * CSCI 150-02
 * Student (Program 5)
 * (Last Updated) April 10, 2016 
 * 
 * This class represents a student. 
 */

public class Student implements Comparable<Student>
{
	private String lname; //Student's last name
	private String fname; //Student's first name
	private String lgrade; //Student's letter grade
	
	/**
	 * Constructs Student object. 
	 * 
	 * @param lname //Student's last name
	 * @param fname //Student's first name
	 */
	public Student(String lname, String fname)
	{
		this.lname = lname; //Student's last name
		this.fname = fname; //Student's first name
		this.lgrade = "No grade."; //Student starts with no grade
	}
	
	/**
	 * Retrieves last name of student.
	 * 
	 * @return //Last name
	 */
	public String getLast()
	{
		return lname;
	}
	
	/**
	 * Retrieves first name of student.
	 * 
	 * @return //First name
	 */
	public String getFirst()
	{
		return fname;
	}
	
	/**
	 * Retrieves letter grade of student.
	 * 
	 * @return //Letter grade
	 */
	public String getGrade()
	{
		return lgrade;
	}
	
	/**
	 * Prints all information about a student. 
	 */
	public void getInfo()
	{
		System.out.println(lname + ", " + fname + " - " + lgrade);
	}
	
	/**
	 * Sets student's letter grade to the parameter. 
	 * 
	 * @param lgrade //Letter grade
	 */
	public void setGrade(String lgrade)
	{
		this.lgrade=lgrade;
	}
	
	/**
	 * Lexicographically compares student last names and then first names. 
	 */
	public int compareTo(Student others)
	{
		if(lname.compareTo(others.lname) < 0)
		{
			return -1;
		}
		else if(lname.compareTo(others.lname) > 0)
		{
			return 1;
		}
		else if(lname.compareTo(others.lname) == 0)
		{
			if(fname.compareTo(others.fname) < 0)
			{
				return -1;
			}
			else if(fname.compareTo(others.fname) > 0)
			{
				return 1;
			}
			return 0;
		}
		return 0;
	}
}
