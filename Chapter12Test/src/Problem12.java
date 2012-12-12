public class Problem12 {

	public void three(int[][] grid)
	{
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[i].length;j++)
			{
				int place=grid[i][j];
				int rowCount=0;
				int colCount=0;
				
				for(int k=0;k<grid.length;k++)
				{
					if(grid[i][k]==place)
						rowCount++;
				}
				for(int k=0;k<grid[j].length;k++)
				{
					if(grid[k][j]==place)
						colCount++;
				}
				if(rowCount>2&&colCount>2)
				{
					System.out.println("Row: "+i);
					System.out.println("Col:"+j);
					System.out.println("Value: "+grid[i][j]);
				}
			}
		}
	}

}
