/**
 * 
 */

/**
 * @author croftj
 *Problem 1
 *
 */
public class LongDistanceCall extends PhoneCall{

	/**
	 * @param args
	 */
	
	
	public LongDistanceCall(int duration)
	{
		super(duration);
	}
	
	public double getRate()
	{
		return 6;
	}
	
	public String toString()
	{
		return super.toString()+" "+getRateString();
	}
	
	public String getRateString()
	{
		return "LD";
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(new LongDistanceCall(3));
	}

}
