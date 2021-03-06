/**
 * 
 */

/**
 * @author jack
 *
 */
public class NumberCube {

	/**
	 * @param args
	 */
	
	private int[] tosses;
	
	public void setTosses(int[] tosses)
	{
		this.tosses=tosses;
	}
	
	public int[] getTosses()
	{
		return tosses;
	}
	
	public static int toss()
	{
		return ((int)(Math.random()*6))+1;
	}
	
	public static int[] getCubeTosses(NumberCube cube, int numTosses)
	{
		int[] random=new int[numTosses];
		
		for(int i=0;i<random.length;i++)
		{
			random[i]=cube.toss();
		}
		
		return random;
	}
	
	public static int getLongestRun(int[] values)
	{
		int longestRun=1;
		int index=0;
		
		for(int i=0;i<values.length-1;i++)
		{
			int j=i;
			int currentRun=1;
			
			if(values[i]==values[i+1])
			{
				while(values[j]==values[i]&&j<values.length)
				{
					currentRun++;
					j++;
				}
			}
			if(currentRun>longestRun)
			{
				index=i;
				longestRun=currentRun;
			}
				
		}
		if(index==0&&values[0]!=values[1])
			return -1;
		
		return index;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NumberCube nm=new NumberCube();
		nm.setTosses(NumberCube.getCubeTosses(nm,10));
		int[] tosses=nm.getTosses();
		for(int i=0;i<tosses.length;i++)
		{
			System.out.println(tosses[i]);
		}
		System.out.println("break");
		System.out.println(NumberCube.getLongestRun(tosses));
		
	}

}
