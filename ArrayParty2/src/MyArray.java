/**
 * 
 */

/**
 * @author croftj
 *
 */
public class MyArray {

	private final int MAXVALUES = 13;
	private int[] myList;
	
	public MyArray()
	{
		myList = new int[MAXVALUES];
	}
	
	//overloaded constructor
	public MyArray(int length)
	{
		myList = new int[length];
	}
	
	public void fillRandom()
	{
		for(int i=0;i<myList.length; i++)
		{
			myList[i]=(int)(Math.random()*100+1);
		}
	}
	
	public void fillInOrder()
	{
		for(int i=0;i<myList.length;i++)
		{
			myList[i]=i;
		}
	}
	
	public void fillInOrder(int x)
	{
		for(int i=0;i<myList.length;i++)
		{
			myList[i]=i+x;
		}
	}
	
	public String toString()
	{
		String nums= "";
		
		for(int i=0; i<myList.length; i++)
		{
			if(i==myList.length-1) //the last one
			{
				nums += myList[i];
			}
			else
				nums += myList[i] + ", ";
		}
		
		return nums;
	}
	
	public int sum()
	{
		int sum=0;
		for(int i=0; i<myList.length;i++)
		{
			sum += myList[i];
		}
		return sum;
	}
	
	public int find(int target)
	{
		for(int i=0;i<myList.length;i++)
		{
			if(myList[i]==target)
				return i;
		}
		return -1;
	}
	
	public int min()
	{
		int min=myList[0];
		
		for(int i=1; i<myList.length;i++)
		{
			if(myList[i-1]>myList[i])
				min=myList[i];
		}
		return min;
	}
	
	public int max()
	{
		int max=myList[0];
		
		for(int i=1; i<myList.length;i++)
		{
			if(myList[i]>myList[i-1])
				max=myList[i];
		}
		return max;
	}
	
	public int countOdds()
	{
		int odds=0;
		for(int i=0;i<myList.length;i++)
		{
			if(myList[i]%2==1)
				odds++;
		}
		return odds;
	}
	
	public void shift()
	{
		int[] temp = new int[myList.length];
		temp[0]=myList[myList.length-1];
		
		for(int i=1;i<myList.length;i++)
		{
			temp[i]=myList[i-1];
		}
		myList=temp;
		
	}
	
	
	public void shift(int n)
	{
		n = n%myList.length;
		int[] temp = new int[myList.length];
		
		for(int i=myList.length-n, j=0; i<myList.length;i++, j++)
		{
			temp[j]=myList[i];
		}
		
		for(int i=n;i<myList.length;i++)
		{
			temp[i]=myList[i-n];
		}
		myList=temp;
	}
	
	public boolean isIncreasing()
	{
		for(int i=0; i<myList.length-1;i++)
		{
			if(myList[i]>myList[i+1])
				return false;
		}
		return true;
	}
	
	public static void swap(int[] list, int x, int y)
	{
		int num1=list[x];
		int num2=list[y];
		
		list[x]=num2;
		list[y]=num1;
	}
	
	public void split()
	{
		int[] negs = new int[myList.length];
		int[] nonnegs = new int[myList.length];
		
		for(int i=0, j=0;i<myList.length;i++)
		{
			if(myList[i]<0)
			{
				negs[j]=myList[i];
				j++;
			}
		}
		
		for(int i=0, j=0;i<myList.length;i++)
		{
			if(myList[i]>=0)
			{
				nonnegs[j]=myList[i];
				j++;
			}
		}
		
		for(int i=0, j=0; i<myList.length;i++)
		{
			if(negs[i]<0)
			{
				myList[i]=negs[i];
			}
			else
			{
				myList[i]=nonnegs[j];
				j++;
			}
		}
	}
	
	public void sort()
	{
		
		for(int i=0; i<myList.length;i++)
		{
			for(int j=i+1;j<myList.length;j++)
			{
				if(myList[i]>myList[j])
				{
					int temp=myList[i];
					myList[i]=myList[j];
					myList[j]=temp;
				}
			}
		}
	}
	
	public void coolRandomize(int min, int max)
	{
		int range = (max-min+1);
		for(int i=0;i<myList.length; i++)
		{
			myList[i]=(int)(Math.random()*range+min);
		}
	}
	
	public int[] myArraytoints()
	{
		return myList;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		MyArray a = new MyArray();
		System.out.println(a.toString());
	}

}
