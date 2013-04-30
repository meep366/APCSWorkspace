/**
 * 
 */

/**
 * @author jack
 *
 */
public class APLine {

	/**
	 * @param args
	 */
	
	int a,b,c;
	
	public APLine(int a1, int b1, int c1)
	{
		a=a1;
		b=b1;
		c=c1;
	}
	
	public double getSlope()
	{
		return -(double)a/b;
	}
	
	public boolean isOnLine(int x, int y)
	{
		return x*a+y*b+c==0;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		APLine line2=new APLine(-25,40,30);
		System.out.println(line2.getSlope());
		System.out.println(line2.isOnLine(5,-2));

	}

}
