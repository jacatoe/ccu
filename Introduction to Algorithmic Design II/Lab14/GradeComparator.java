/**
 * Joshua Catoe
 * CSCI 150-02
 * GradeComparator(Lab 14)
 * (Last Updated)March 16, 2016
 */
 
import java.util.Comparator;

public class GradeComparator implements Comparator<Student>
{
	public int compare(Student a, Student b)
	{
		if (a.getGrade()< b.getGrade()) return -1;
		else if (a.getGrade()> b.getGrade()) return 1;
		else return 0;
	}
}
