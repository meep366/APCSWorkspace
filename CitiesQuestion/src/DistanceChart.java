import java.util.List;


public class DistanceChart {

	/**
	 * @param args
	 */
	
	private List<String> cityNames;
	private int[][] distances;
	
	public int findRemotesetCity()
	{
		int[] sums=new int[distances.length];
		
		for(int i=0;i<distances.length;i++)
		{
			for(int j=0;j<distances[i].length;j++)
			{
				sums[i]+=distances[i][j];
			}
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
