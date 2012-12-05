/**
 * 
 */
package Chomp;

/**
 * @author croftj
 *
 */
public class P15 {

	/**
	 * @param args
	 */
	
	
	private static boolean covers(double[][] m1, double [][] m2)
	{
		int counter=0;
		int elements=0;
		for(int i=0;i<m1.length;i++)
		{
			for(int j=0;j<m1[i].length;j++)
			{
				elements++;
				if(m1[i][j]>m2[i][j])
					counter++;
			}
		}
		return(counter>=elements/2.);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
