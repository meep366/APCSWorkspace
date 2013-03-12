/**
 * 
 */

/**
 * @author croftj
 * Problem 1
 *
 */
public abstract class PhoneCall {

	/**
	 * @param args
	 */
	
	
	private int duration;
	
	public PhoneCall(int duration)
	{
		this.duration=duration;
	}
	
	public int getDuration()
	{
		return duration;
	}
	
	public abstract double getRate();
	
	private int totalCost()
	{
		return (int)getRate()*duration;
	}
	
	public String toString()
	{
		String r="";
		
		r+="Duration "+ duration+" Rate "+getRate()+ " Total "+ totalCost();
		
		return r;
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
