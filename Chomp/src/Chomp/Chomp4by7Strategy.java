/*
 * Implements Chomp strategy for a 4 by 7 board
 */
package Chomp;

public class Chomp4by7Strategy implements Strategy
{
  // Represents a few winning Chomp positions for the second player
  // Each array is number of squares in row 0, 1, 2, 3
  //   (a missing element is 0)
  private static int winPositions[][] =
  {
    {1},
    {7,6}, {6,5}, {5,4}, {4,3}, {3,2}, {2,1},
    {7,7,4}, {7,5,2}, {6,4,2}, {4,2,2},
    {7,4,3}, {6,3,3}, {5,5,3},
    {4,1,1,1}, {3,1,1},
    {2,2,2,1},
    {2,2,1}, {3,3,1,1},
    {5,2,1,1},
  };

  // Returns the best move for the current location
  public Location findBestMove(ChompGame game)
  {
    int rows = game.numRows(), cols = game.numCols(), r;
    int wLength, bLength, bestRow, bestCol;
    int wSteps[], bSteps[];

    // Convert the current board location into the same form as
    // winPositions
    bSteps = new int[rows];
    for (r = 0; r < rows; r++)
      bSteps[r] = game.countInRow(r);

    for (int i = 0; i < winPositions.length; i++)
    {
      wSteps = winPositions[i];
      bestRow = -1;
      bestCol = cols;

      // Check whether winPosition[i] can be reached from
      //   the current location in one move; if so save bestRow and bestCol
      //   -- the location of that move
      for (r = 0; r < rows; r++)
      {
        if (r < wSteps.length)
          wLength = wSteps[r];
        else
          wLength = 0;

        bLength = bSteps[r];

        if (bestRow < 0 && bLength != wLength)
        {
          bestRow = r;
          bestCol = wLength;
        }

        if (bLength > bestCol)
          bLength = bestCol;

        if (bLength != wLength)
          break;
      }

      if (r == rows && bestRow >= 0)
      {
        return new Location(bestRow, bestCol);
      }
    }
    return null;
  }

  // Picks a move randomly from pieces on the border
  public Location findRandomMove(ChompGame game)
  {
    int rows = game.numRows(), cols = game.numCols();
    Location[] list = new Location[rows + cols];

    int count = 0;

    // Add all border squares to the list:
    for (int r = 0; r < rows; r++)
    {
      for (int c = 0; c < cols; c++)
      {
        if (r + c > 0 && !game.isEmpty(r, c) &&
                 (game.isEmpty(r + 1, c) || game.isEmpty(r, c + 1)))
          list[count++] = new Location(r, c);
      }
    }

    // Choose a random element from the list:
    if (count == 0)
    {
      return new Location(0, 0);
    }
    else
    {
      int n = (int)(count * Math.random());
      return list[n];
    }
  }
}
