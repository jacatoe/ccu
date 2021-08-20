/**
 * Joshua Catoe
 * CSCI 150-02
 * Lab 13
 * (Last Updated)March 14, 2016
 * 
 * This program sorts a created array alphabetically by name, and arranges the associated grades in ascending order. 
 */

import java.util.Arrays;

public class Lab13 
{

	public static void main(String[] args) 
	{
		Student [] stu = new Student[6];
		stu[0] = new Student ("Sam",100);
		stu[1] = new Student ("John",80);
		stu[2] = new Student ("Sue",95);
		stu[3] = new Student ("Sam",65);
		stu[4] = new Student ("Sam",85);
		stu[5] = new Student ("Sue",70);
		
		Arrays.sort(stu);
		
		for(int i=0;i<stu.length;i++)
		{
			System.out.println(stu[i].getName() + "  " + stu[i].getGrade());
		}
	}

}
