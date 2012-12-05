
/*
 * A player in a board game
 */
package Chomp;

public interface Player
{
  /*
   * Returns a prompt to be displayed before
   * the next move of this player
   */
  String getPrompt();

  /*
   * Returns a message to be displayed when
   * this player has won
   */
  String getWinMessage();

  /*
   * Initiates this player's next move
   */
  void makeMove();
}

