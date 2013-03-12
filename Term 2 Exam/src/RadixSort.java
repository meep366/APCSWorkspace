import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * @author croftj
 *Problem 7
 */
public class RadixSort {

	/**
	 * @param args
	 */
	
	
	
	private static int getDigit(int number,int k)
	{
		k+=1;
		int mod=1;
		
		for(int i=0;i<k-1;i++)
		{
			mod*=10;
		}
		
		number/=(mod);
		return number%10;
	}
	
	private static Queue[] itemsToQueues(int[] nums, int k)
	{
		Queue<Integer>[] buckets=(Queue<Integer>[])new LinkedList[10];
		
		for(int i=0;i<buckets.length;i++)
		{
			buckets[i]=new LinkedList<Integer>();
		}
		
		for(int i=0;i<nums.length;i++)
		{
			buckets[getDigit(nums[i],k)].add(nums[i]);
		}
		
		return buckets;
	}
	
	private static int[] queuesToArray(Queue[] queues, int numVals)
	{
		int[] result=new int[numVals];
		int counter=0;
		
		for(int i=0;i<queues.length;i++)
		{
			while(!queues[i].isEmpty())
			{
				result[counter++]=(Integer) queues[i].remove();
			}
		}
		return result;
	}
	
	public static int[] sort(int[] nums, int numDigits)
	{
		for(int i=0;i<numDigits;i++)
		{
			nums=queuesToArray(itemsToQueues(nums,i),nums.length);
		}
		return nums;
	}
}
