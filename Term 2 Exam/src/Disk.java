/**
 * 
 */

/**
 * @author croftj
 *
 */
public class Disk implements Comparable<Disk>{

	/**
	 * @param args
	 */
	
	private int radius;
	
	public Disk(int r)
	{
		radius=r;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int compareTo(Disk other) {
		
		return this.radius-other.radius;
	}

}
