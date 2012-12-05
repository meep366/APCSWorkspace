/*
 * Implements a Chomp game
 */
package Chomp;

public class ChompGame extends CharMatrix
{
  private BoardPanel board;

  public ChompGame(BoardPanel board)
  {
    super(board.numRows(), board.numCols(), 'x');
    this.board = board;
    board.update(this);
  }

  /*
   * Returns true if row, col is out of bounds or the character
   * at row, col is a space, false otherwise.
   */
  public boolean isEmpty(int row, int col)
  {
    return row < 0 || row >= numRows() || col < 0 || col >= numCols() ||
           super.isEmpty(row, col);
  }

  /*
   * Returns true if the location on the board is a win
   * for the player whose turn is to move
   */
  public boolean isWon()
  {
    return isEmpty(0, 0);
  }

  /*
   * Adjusts and repaints the board after the move at row, col
   */
  public void makeMove(int row, int col)
  {
    clearRect(row, col, numRows() - 1, numCols() - 1);
    board.setDisplayCount(0);
    board.update(this);
  }
}
