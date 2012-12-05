package Chomp;
/**
 * 
 * @author croftj
 *Date of Completion: 11/30/12
 *Assignment: CharMatrix/Chomp
 *Attribution:none
 *All work here is honestly obtained and is my own.
 *Description: Class to control a 2D array to be used in Chomp
 *Errata:none
 */


/*
 * Implements a 2-D array of characters
 */

public class CharMatrix
{
  // Fields:
	
	//2D array for class
  private char[][] matrix;
  

  /*
   * Constructor: creates a grid with dimensions rows, cols,
   * and fills it with spaces
   */
  
  public CharMatrix(int rows, int cols)
  {
	  new CharMatrix(rows, cols, ' ');		//use below constructor with space
  }

  /*
   * Constructor: creates a grid with dimensions rows , cols ,
   * and fills it with the fill  character
   */
  public CharMatrix(int rows, int cols, char fill)
  {
	  matrix=new char[rows][cols];
	  
	  for(int i=0;i<rows;i++)		//nested for loops for every spot
	  {
		  for(int j=0;j<cols;j++)
		  {
			  matrix[i][j]=fill;
		  }
	  }
  }

  /*
   * Returns the number of rows in grid
   */
  public int numRows()
  {
    return matrix.length;
  }

  /*
   * Returns the number of columns in grid
   */
  public int numCols()
  {
    return matrix[0].length;
  }

  /*
   * Returns the character at row, col location
   */
  public char charAt(int row, int col)
  {
    return matrix[row][col];
  }

  /*
   * Sets the character at row, col location to ch
   */
  public void setCharAt(int row, int col, char ch)
  {
     matrix[row][col]=ch;
  }

  /*
   * Returns true if the character at row, col is a SPACE,
   * false otherwise
   */
  public boolean isEmpty(int row, int col)
  {
	  if(matrix[row][col]==' ')	
		  return true;
	  return false;
  }

  /*
   * Fills the given rectangle with the fill characters.
   * row0, col0 is the upper left corner and row1, col1 is the
   * lower right corner of the rectangle.
   */
  public void fillRect(int row0, int col0, int row1, int col1, char fill)
  {
	  for(int i=row0;i<=row1;i++)				//nested for loops that fill all the sopts, including the ends
	  {
		  for(int j=col0;j<=col1;j++)
		  {
			  matrix[i][j]=fill;
		  }
	  }
  }

  /*
   * Fills the given rectangle with the SPACE characters.
   * row0, col0 is the upper left corner and row1, col1 is the
   * lower right corner of the rectangle.
   */
  public void clearRect(int row0, int col0, int row1, int col1)
  {
	  fillRect(row0,col0,row1,col1,' ');	//using bove method with spaces
  }

  /*
   * Returns the count of all non-SPACE characters in row.
   */
  public int countInRow(int row)
  {
	  int result=0;
	  
	  for(int i=0;i<matrix[row].length;i++)		//find row length and loop through for spaces
	  {
		  if(matrix[row][i]!=' ')
			  result++;
	  }
	  return result;
  }

  /*
   * Returns the count of all non-SPACE characters in col.
   */
  public int countInCol(int col)
  {
	  int result=0;
	  
	  for(int i=0;i<matrix.length;i++)		//find column length and loop through for spaces
	  {
		  if(matrix[i][col]!=' ')
			  result++;
	  }
	  return result;
  }
}
