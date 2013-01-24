/**
 * 
 */

/**
 * @author jack
 *
 */
public class Divisible {

	/**
	 * @param args
	 */
	
	public static int sumOfDigits(int n)
	{
		return n;
	}
	
	public static boolean isDivisibleBy9(int n)
	{
		if(n==9)
			return true;
		else if(n<9)
			return false;
		else
			return isDivisibleBy9(sumOfDigits(n));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
