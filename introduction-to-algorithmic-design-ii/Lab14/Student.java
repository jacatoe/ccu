/**
 * Joshua Catoe
 * CSCI 150-02
 * Student(Lab 14)
 * (Last Updated)March 16, 2016
 */

public class Student 
{
	private String name;
	private int grade;
	
	public Student(String name,int grade)
	{
		this.name = name;
		this.grade = grade;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getGrade()
	{
		return grade;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setGrade(int grade)
	{
		this.grade = grade;
	}	
}
