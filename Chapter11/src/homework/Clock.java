/**
 * 
 */
package homework;

/**
 * @author jack
 *
 */
public class Clock {

	/**
	 * @param args
	 */
	
	private int hours,mins;
	
	public Clock(int h, int m)
	{
		hours=h;
		mins=m;
	}
	
	public int getHours()
	{
		return hours;
	}
	
	public int getMins()
	{
		return mins;
	}
	
	public void advance()
	{
		mins++;
		
		if(mins>=60)
		{
			mins=0;
			hours++;
		}
		if(hours>=12)
		{
			hours=0;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
