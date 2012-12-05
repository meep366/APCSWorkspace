import java.awt.Color;

/**
 * 
 */

/**
 * @author jack
 *
 */
public class Problems {

	/**
	 * @param args
	 */
	
	public boolean diagonal(int[][] matrix, int element)
	{
		for(int i=0;i<matrix.length;i++)
		{
			if(matrix[i][i]==element)
				return true;
			if(matrix[matrix.length-i+1][i]==element)
			{
				return true;
			}
		}
		return false;
	}
	
	public int positiveMax(int[][] m)
	{
		int largest=0;
		for(int i=0;i<m.length;i++)
		{
			for(int j=0;j<m[i].length;j++)
			{
				if(m[i][j]>largest)
					largest=m[i][j];
			}
		}
		return largest;
	}
	
	public void fillCheckerboard(Color[][] board)
	{
		int counter=0;
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				if(counter%2==1)
				{
					counter=0;
					board[i][j]=Color.white;
				}
				else
				{
					board[i][j]=Color.black;
					counter=1;
				}
			}
		}
	}
	
	private static boolean covers(double[][] m1, double[][] m2)
	{
		int elements=0;
		int counter=0;
		
		for(int i=0;i<m1.length;i++)
		{
			for(int j=0;j<m1[i].length;j++)
			{
				elements++;
				if(m1[i][j]>m2[i][j])
					counter++;
			}
		}
		return counter>=elements/2.;
	}
	
	public int[][] pascalTriangle(int n)
	{
		int[][] triangle= new int[n][];
		
		
		for(int i=0;i<n;i++)
		{
			triangle[i]=new int[i+1];
			
			for(int j=0;j<triangle[i].length;j++)
			{
				if(j==0||j==triangle[i].length-1)
					triangle[i][j]=1;
				else
				{
					triangle[i][j]=triangle[i-1][j-1]+triangle[i-1][j];
				}
			}
		}
		return triangle;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
