/**
 * 
 */

/**
 * @author jack
 *
 */
public class MoreProblems {

	/**
	 * @param args
	 */
	public char[] p20()
	{
	
		char[] hello={' ','h','e','l','l','o'};
	
		int i=1;
		
		while(i<6)
		{
			hello[i-1]=hello[i];
			i++;
		}
	
		hello[5]='!';
		
		return hello;
	}
	
	public boolean isMedian(double[] sample, double m)
	{
		int greaterThan=0;
		int lessThan=0;
		
		for(int i=0;i<sample.length;i++)		//two variables for greater or less than
		{
			if(sample[i]>m)
				greaterThan++;
			if(sample[i]<m)
				lessThan++;
		}
		return greaterThan==lessThan;
	}
	
	/**
	 * Problem 22:
	 * 
	 * One,Two,Three b/c the for each loop changes the local variable, not the elements in the array
	 * 
	 */
	
	public static void rotateLeft(int[] a)
	{
		int temp=a[0];
		
		for(int i=0;i<a.length-1;i++)		//shift array and use temp for extra space
		{
			a[i]=a[i+1];
		}
		a[a.length-1]=temp;
	}
	
	public static void rotateRight(int[] a)
	{
		int temp=a[a.length-1];
											//shift array and use temp for extra space
		for(int i=a.length-1;i>0;i--)
		{
			a[i]=a[i-1];
		}
		a[0]=temp;
	}
	
	public static void rotate(int[] a, int d)
	{	
		for(int i=0;i<Math.abs(d);i++)
		{											//do many rotations based on d
			if(d<0)
				rotateLeft(a);
			if(d>0)
				rotateRight(a);
		}
	}
	
	private static final int N=30;
	
	public static int[] add(int[] a, int[] b)
	{
		int[] sum=new int[N];
		
		for(int i=0;i<N;i++)
		{
			if(a[i]+b[i]<10)				//if the sum is less than 10, just add it into the space
				sum[i]=a[i]+b[i];
			else
			{
				sum[i]=(a[i]+b[i])%10;			//else increase the next slot by one and the remainder in the current one
				sum[i+1]++;
			}
		}
		return sum;
	}
	
	public static double averageTopTwo(int[] scores)
	{
		int i,n=scores.length;
		int iMax1=0;
		int iMax2=1;
		
		if(scores[iMax2]>scores[iMax1])
		{
			i=iMax1;				//basic switching to make sure that max1 is greater than max2
			iMax1=iMax2;
			iMax2=i;
			...
		}
		for(i=2;i<n;i++)		//rotate through scores to find biggest two
		{
			if(scores[i]>scores[iMax1])
			{
				iMax1=i;
			}
			else if(scores[i]>scores[iMax2])
			{
				iMax2=i;
				...
			}
		}
		return (int)((scores[iMax1]+scores[iMax2])/2.);		//return average
	}
}
