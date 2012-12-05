import java.util.ArrayList;

/**
 * 
 */

/**
 * @author jack
 *
 */
public class Quicksort {

	/**
	 * @param args
	 */
	
	public static void sort(ArrayList<IndexEntry> a)
	{
		recursiveSort(a, 0, a.size()-1);
	}
	
	private static void recursiveSort(ArrayList<IndexEntry> a, int from, int to)
	{
		if(from>=to)
			return;
		
		int p= (from+to)/2;
		
		int i=from;
		int j=to;
		
		while(i<=j)
		{
			if(a.get(i).compareTo(a.get(p))<=0)
			{
				i++;
			}
			else if(a.get(j).compareTo(a.get(p))>=0)
			{
				j--;
			}
			else
			{
				swap(a, i, j);
				i++;
				j--;
			}
		}
		
		if(p<j)
		{
			swap(a, j, p);
			p=j;
		}
		else if(p>i)
		{
			swap(a, i, p);
			p=i;
		}
		
		recursiveSort(a, from, p-1);
		recursiveSort(a, p+1, to);
	}
	
	
	private static void swap(ArrayList<IndexEntry> a, int i, int j)
	{
		IndexEntry temp=a.get(i);
		a.set(i, a.get(j));
		a.set(j, temp);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
