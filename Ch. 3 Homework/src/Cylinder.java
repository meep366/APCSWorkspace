import java.util.Scanner;

/**
 * 
 */

/**
 * @author croftj
 *
 */
public class Cylinder {

	/**
	 * @param args
	 */
	private  Circle base;
	private  double  height;
	
	public Cylinder(double r, double h)
	{
		base = new Circle(r);
		height = h;
	}
	
	public double getVolume()
	{
		return base.getArea()*height;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kboard = new Scanner(System.in);
		int h,r;
		
		h = kboard.nextInt();
		r = kboard.nextInt();
		Cylinder c = new Cylinder(h,r);
		System.out.println(c.getVolume());
		
		
	}

}
