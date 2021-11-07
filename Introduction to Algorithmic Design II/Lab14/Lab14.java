/**
 * Joshua Catoe
 * CSCI 150-02
 * Lab 14
 * (Last Updated)March 16, 2016
 * 
 * This program sorts an array of students by name, grade and name+grade. 
 */

import java.util.Arrays;

public class Lab14 
{
	public static void main(String[] args) 
	{		
		Student[] stu = new Student[6];
		stu[0]= new Student("Sam", 100);
		stu[1]= new Student("John", 80);
		stu[2]= new Student("Sue", 95);
		stu[3]= new Student("Sam", 65);
		stu[4]= new Student("Sam", 85);
		stu[5]= new Student("Sue", 70);
		
		System.out.println("Sorting the Students by Grade\n");
		Arrays.sort(stu, new GradeComparator());
		for(int i = 0; i < stu.length; i++)
		{
			System.out.println(stu[i].getName() + " " + stu[i].getGrade());
		}
		
		System.out.println("\nSorting the Students by Name\n");
		Arrays.sort(stu, new NameComparator());
		for(int i = 0; i < stu.length; i++)
		{
			System.out.println(stu[i].getName() + " " + stu[i].getGrade());
		}
		
		System.out.println("\nSorting the Students by Name and Grade\n");
		Arrays.sort(stu, new NameGradeComparator());
		for(int i = 0; i < stu.length; i++)
		{
			System.out.println(stu[i].getName() + " " + stu[i].getGrade());
		}
	}

}
