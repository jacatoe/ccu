/**
 * Joshua Catoe
 * CSCI 150-02
 * MergeSorter (Lab 17)
 * (Last Updated) April 4, 2016 *
 */

public class MergeSorter 
{
	public static void sort(String[] array)
	{
		if(array.length <= 1)
		{
			return;
		}
		
		String[] first = new String[array.length / 2];
		String[] second = new String[array.length - first.length];
		
		for (int i=0; i<first.length; i++)
		{
			first[i] = array[i];
		}
		
		for (int i=0; i<second.length; i++)
		{
			second[i] = array[first.length + i];
		}
		
		sort(first);
		sort(second);
		merge(first, second, array);
	}
	
	private static void merge(String[] first, String[] second, String[] array)
	{
		int iFirst = 0;
		int iSecond = 0;
		int j = 0;
		
		while(iFirst < first.length && iSecond < second.length)
		{
			if((first[iFirst].compareTo(second[iSecond])) < 0)
			{
				array[j] = first[iFirst];
				iFirst++;
			}
			else
			{
				array[j] = second[iSecond];
				iSecond ++;
			}
			
			j++;
		}
		
		while(iFirst < first.length)
		{
			array[j] = first[iFirst];
			iFirst++;
			j++;
		}
		
		while(iSecond < second.length)
		{
			array[j] = second[iSecond];
			iSecond++;
			j++;
		}
	}
}
