package apTerm1ExamFiles;

/**  Please comment fully with NAME and Problem Number.


	Jack Croft
	Problem 1

 * 	 Do Not Forget to printout your work and organize them in order and stapling them together before
 *   you leave please.
 *  
 *  Good Luck. -- Mr. Yoder
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.applet.AudioClip;



public class Problem1 extends JApplet implements ActionListener
{
	private String[] fortunes=new String[3];

	private JTextField display;
	private AudioClip ding;

	public void init()
	{
		ding = getAudioClip(getDocumentBase(), "ding.wav'");

		
		fortunes[0]="Tomorrow you will be visited by aliens";
		fortunes[1]="You will see a ghost by the end of the week";
		fortunes[2]="The next time you go camping, you will meet Bigfoot";

		display = new JTextField(" Press\"Next\' to see your fortune...', 30)");
		display.setBackground(Color.WHITE);
		display.setEditable(false);

		JButton go = new JButton("Next");
		go.addActionListener(this);

		Container c = getContentPane();

		c.setLayout(new FlowLayout());
		c.add(display);
		c.add(go);
	}

	public void actionPerformed(ActionEvent e)
	{
		ding.play();
		int random=(int)(Math.random()*3);


		display.setText(" " + fortunes[random]);  
	}


	public String getshorty(String[] words)
	{
		int shortest=0;
		for(int i=1;i<words.length;i++)
		{
			if(words[i].length()<words[shortest].length())
				shortest=i;
		}
		
		return words[shortest];
	}

}
