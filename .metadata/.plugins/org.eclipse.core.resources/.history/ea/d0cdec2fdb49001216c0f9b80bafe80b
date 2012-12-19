/**
 * 
 */
package apTerm1ExamFiles;

/**
 * Jack Croft
 * Problem 3
 *
 */
public class Problem3 {

	/**
	 * @param args
	 */
	
	public int translate(boolean[] info, int index)
	{
		int sum=0;
		if(index>=0&&index<info.length-2)
		{
			if(info[index])
				sum+=4;
			if(info[index+1])
				sum+=2;
			if(info[index+2])
				sum+=1;
			
			return sum;
		}
		return -1;
		
		
	}
	
	public int[] translateAll(boolean[] info)
	{
		
		if(info.length%3==0)
		{
			int[] result=new int[info.length/3];
			for(int i=0,j=0;i<info.length/3;i+=3,j++)
			{
				boolean[] b={info[i],info[i+1],info[i+2]};
				result[j]=translate(b,0);
			}
			return result;
		}
		return null;
	}

}
