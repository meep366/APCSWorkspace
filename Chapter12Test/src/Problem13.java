public class Problem13 {

	public int[][] makeMagicSquare(int n)
	{
		int[][] magicSquare=new int[n][n];
		int i=0;
		int j=1;
		
		
		for(int c=0;c<n*n;c++)
		{
			magicSquare[i][j]=c+1;
			
			int checkI=i;
			int checkJ=j;
			
			if(checkJ==n-1)
				checkJ=0;
			else
				checkJ++;
			if(checkI==0)
				checkI=n-1;
			else
				checkI--;
			
			if(magicSquare[checkI][checkJ]==0)
			{
				i=checkI;
				j=checkJ;
			}
			else
			{
				i++;
			}
		}
		
		return magicSquare;
	}
}
