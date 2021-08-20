/**
 * Joshua Catoe
 * CSCI 150-02
 * NameGradeComparator(Lab 14)
 * (Last Updated)March 16, 2016
 */

import java.util.Comparator;

public class NameGradeComparator implements Comparator<Student>
{
	public int compare(Student a, Student b)
	{
		if (a.getName().compareTo(b.getName())<0) return -1;
		else if (a.getName().compareTo(b.getName())>0) return 1;
		else if (a.getName().compareTo(b.getName())==0) return 0;
		{
			if (a.getGrade()< b.getGrade()) return -1;
			else if (a.getGrade()> b.getGrade()) return 1;
			else return 0;
		}
	}
}
