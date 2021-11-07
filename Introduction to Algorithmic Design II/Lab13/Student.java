/**
 * Joshua Catoe
 * CSCI 150-02
 * Student(Lab 13)
 * (Last Updated)March 14
 */

public class Student implements Comparable<Student>
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
	
	public int compareTo(Student otherStu)
	{
		if(name.compareTo(otherStu.getName())<0)
		{
			return -1;
		}
		if(name.compareTo(otherStu.getName())>0)
		{
			return 1;
		}
		if(name.compareTo(otherStu.getName())==0)
		{
			if(grade<otherStu.getGrade())
			{
				return -1;
			}
			if(grade>otherStu.getGrade())
			{
				return 1;
			}
			return 0;
		}
		return 0;
	}
}
