package apTerm1ExamFiles;
/**
 * 
 */


import java.util.ArrayList;

/**
 * Jack Croft
 * Problem 4
 *
 */
public class Problem4 {

	/**
	 * @param args
	 */
	
	
	
	public static int linearSearch(String[]a, String target)
	{
		for(int i=0;i<a.length;i++)
		{
			if(a[i].equals(target))
				return i;
		}
		return -1;
	}
	
	public static int binarySearch(int a[], int target)
	{
		int left=0;
		int right=a.length-1;
		
		while(left<=right)
		{
			int middle=(left+right)/2;
			int difference=target-a[middle];
			
			if(difference==0)
				return middle;
			if(difference>0)
				left=middle+1;
			if(difference<0)
				right=middle-1;
			
		}
		return -1;
	}
	
	public static ArrayList<String> merge(ArrayList<String> list1, ArrayList<String> list2)
	{
		ArrayList<String> result=new ArrayList<String>(list1.size()+list2.size());
		
		for(int i=0,j=0,k=0;k<list1.size()+list2.size();k++)
		{
			if(list1.get(i).compareTo(list2.get(j))<0)
			{
				result.add(list1.get(i));
					i++;
			}
			else
			{
				result.add(list2.get(j));
					j++;
			}
			
			if(i==list1.size()-1)
			{
				for(;j<list2.size();k++,j++)
				{
					result.add(list2.get(j));
				}
			}
			if(j==list2.size()-1)
			{
				for(;i<list2.size();k++,i++)
				{
					result.add(list2.get(i));
				}
			}
		}
		
		return result;
	}
	
	public static void splitter(int a[])
	{
		for(int i=0;i<a.length;i++)
		{
			if(a[i]%2==0)
			{
				for(int j=a.length-1;j>i;j--)
				{
					if(a[j]%0==1)
					{
						int temp=a[j];
						a[j]=a[i];
						a[i]=temp;
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
