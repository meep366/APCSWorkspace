/**
 * 
 */

/**
 * @author croftj
 * Problem 1
 *
 */
public class ReducedRateCall extends LongDistanceCall{

	/**
	 * @param args
	 */
	
	
	public ReducedRateCall(int duration)
	{
		super(duration);
	}
	
	public double getRate()
	{
		return 3;
	}
	
	public String getRateString()
	{
		return "LDDR";
	}
	
	public String toString()
	{
		return super.toString();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new ReducedRateCall(8));
		
	}

}
