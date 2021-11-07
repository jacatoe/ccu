/**
 * Joshua Catoe
 * CSCI 150-02
 * NameComparator(Lab 14)
 * (Last Updated)March 16, 2016
 */

import java.util.Comparator;

public class NameComparator implements Comparator<Student>
{
	public int compare(Student a, Student b)
	{
		if (a.getName().compareTo(b.getName())<0) return -1;
		else if (a.getName().compareTo(b.getName())>0) return 1;
		else return 0;
	}
}
