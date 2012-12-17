/**
 * 
 */
package homework;

/**
 * @author jack
 *
 */
public class AlarmClock extends Clock{

	/**
	 * @param args
	 */
	
	private int hours,mins,aHours,aMins;
	
	public AlarmClock(int hours, int mins, int aHours, int aMins)
	{
		super(hours, mins);
		this.hours=hours;
		this.mins=mins;
		this.aHours=aHours;
		this.aMins=aMins;
	}
	
	public void advance()
	{
		if(hours==aHours&&mins==aMins)
			System.out.println("Alarm!");
		super.advance();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
