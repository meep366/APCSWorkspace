import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * @author jack
 *
 */
public class ClassVersion {

	/**
	 * @param args
	 */
	
	
	private static int getDigit(int number, int k)
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
	
	private static Queue<Integer>[] itemsToQueues(int[] nums, int k)
	{
		Queue<Integer>[] qs=new Queue<Integer>[10];
		
		for(int i=0;i<qs.length;i++)
		{
			qs[i]=new LinkedList<Integer>();
		}
		
		for(int i=0;i<nums.length;i++)
		{
			int digit=getDigit(nums[i],k);
			qs[i].add(nums[i]);
		}
		
		return qs;
	}
	
	private static int[] queuesToArray(Queue<Integer>[] queues, int numVals)
	{
		int[] results=new int[numVals];
		int counter=0;
		
		for(int i=0;i<queues.length;i++)
		{
			while(!queues[i].isEmpty())
			{
				results[counter]= queues[i].remove();
				counter++;
			}
		}
		return results;
	}
	
	public static int[] sort(int[] nums, int numDigits)
	{
		for(int i=0;i<numDigits;i++)
		{
			nums=queuesToArray(itemsToQueues(nums,i),nums.length);
		}
		return nums;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
