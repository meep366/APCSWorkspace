/*
 * Implements a board game program with someone
 * playing against the computer
 */
package Chomp;

import java.awt.*;
import javax.swing.*;

public class Chomp extends JFrame
{
  private ChompGame game;
  private JTextField display;
  private Player players[];
  private int currentPlayer;

  public Chomp()
  {
    Container c = getContentPane();

    display = new JTextField(20);
    display.setBackground(Color.YELLOW);
    display.setEditable(false);
    c.add(display, BorderLayout.NORTH);

   // BoardPanel board = new BoardPanel();
    BoardPanel board = new BoardPanel(4,7);
    c.add(board, BorderLayout.CENTER);

    game = new ChompGame(board);

    HumanPlayer human = new HumanPlayer(this, game, board, "Player 1");
    ComputerPlayer computer = new ComputerPlayer(this, game, board);
    computer.setStrategy(new Chomp4by7Strategy());
    HumanPlayer human2 = new HumanPlayer(this,game,board, "Player 2");

    players = new Player[3];		//extended array for player 3
    players[0] = human;
    players[1] = computer;
    players[2]=human2;			//additional human
    currentPlayer = 0;

    display.setText(" You go first...");
    players[currentPlayer].makeMove();
  }

  // Called by the player when its move is completed.
  public void hasMoved()
  {
    currentPlayer = (currentPlayer + 1) % players.length; //changed from %2 to %3 to account for extra player
    Player p = players[currentPlayer];
    if (game.isWon())
    {
      display.setText(p.getWinMessage());
    }
    else
    {
      display.setText(p.getPrompt());
      p.makeMove();
    }
  }

  public static void main(String[] args)
  {
    Chomp window = new Chomp();
    window.setTitle("Chomp");
    window.setBounds(200, 200, 300, 225);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setVisible(true);
  }
}

