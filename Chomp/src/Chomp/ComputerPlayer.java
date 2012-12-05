/*

 * Implements a computer player in a board game
 */
package Chomp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class ComputerPlayer
    implements Player, ActionListener
{
  private Chomp program;
  private ChompGame game;
  private BoardPanel board;

  private Timer clock;
  private int clockCount;
  private int moveRow, moveCol;

  private Strategy strategy;
  private EasySound chompSound;

  public ComputerPlayer(Chomp program, ChompGame game, BoardPanel board)
  {
    this.program = program;
    this.game = game;
    this.board = board;
    clock = new Timer(250, this);
    chompSound = new EasySound("chomp.wav");
  }

  /*
   * Sets this player's strategy
   */
  public void setStrategy(Strategy strategy)
  {
    this.strategy = strategy;
  }

  /*
   * Returns a prompt to be displayed before
   * the next move of this player
   */
  public String getPrompt()
  {
    return " Hmm... Let me think...";
  }

  /*
   * Returns a message to be displayed when
   * this player has won
   */
  public String getWinMessage()
  {
    return " Hurray, I won!";
  }

  /*
   * Initiates this player's next move
   */
  public void makeMove()
  {
    Location pos = strategy.findBestMove(game);
    if (pos == null)
      pos = strategy.findRandomMove(game);

    moveRow = pos.getRow();
    moveCol = pos.getCol();
    clockCount = 5;
    board.setMove(moveRow, moveCol);
    board.setDisplayCount(clockCount);
    clock.start();
  }

  /*
   * Called automatically when the timer fires a pulse
   * (to provide visual feedback for the anticipated move, e.g.
   * flashing the changed squares a few times)
   */
  public void actionPerformed(ActionEvent e)
  {
    if (clockCount > 0)
    {
      board.update(game);
      clockCount--;
    }
    else
    {
      clock.stop();
      game.makeMove(moveRow, moveCol);
      program.hasMoved();
      chompSound.play();
    }
  }
}

