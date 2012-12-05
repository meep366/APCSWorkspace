import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class LifeControls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LifeControls extends JPanel
    implements KeyListener
{
    private JLabel genLabel;
	private final String genLabelText = "Generations: ";
	private final String slow = "Slow";
	private final String fast = "Fast";
	private final String hyper = "Hyper";
	private final String nextLabelText = "Next";
	private final String startLabelText = "Start";
	private final String stopLabelText = "Stop";
	private JButton go;
	private JButton nextButton;
	private GameOfLife app;

  public LifeControls(GameOfLife app)
  {
      this.app = app;
      
      // pulldown menu with speeds
		Choice speedChoice = new Choice();
	
		// add speeds
		speedChoice.addItem(slow);
		speedChoice.addItem(fast);
		speedChoice.addItem(hyper);
	
		// when item is selected
		speedChoice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String arg = (String) e.getItem();
				if (slow.equals(arg)) // slow
					getGameOfLife().setSpeed(1000);
				else if (fast.equals(arg)) // fast
					getGameOfLife().setSpeed(100);
				else if (hyper.equals(arg)) // hyperspeed
					getGameOfLife().setSpeed(10);
			}
		});
	
		// number of generations
		genLabel = new JLabel(genLabelText+"0             ");
	
		// start and stop buttom
		go = new JButton(stopLabelText);
			
		// when start/stop button is clicked
		go.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					startStopButtonClicked();
				}
			}
		);
	
		// next generation button
		nextButton = new JButton(nextLabelText);
			
		// when next button is clicked
		nextButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getGameOfLife().next();
				}
			}
		);
	
		// create panel with controls
		this.add(nextButton);
		this.add(go);
		this.add(speedChoice);
		this.add(genLabel);
		this.validate();
	
      
  }
    
  

  /**
   *  Implement KeyListener interface:
   */
  public void keyPressed (KeyEvent e)
  {
    int code = e.getKeyCode();

    switch(code)
    {
      case KeyEvent.VK_ENTER:
        
        break;

      case KeyEvent.VK_SPACE:
        
        break;

      case KeyEvent.VK_UP:
      case KeyEvent.VK_KP_UP:
        
        break;

      case KeyEvent.VK_DOWN:
      case KeyEvent.VK_KP_DOWN:
        
        break;

      case KeyEvent.VK_LEFT:
      case KeyEvent.VK_KP_LEFT:
        
        break;

      case KeyEvent.VK_RIGHT:
      case KeyEvent.VK_KP_RIGHT:
        
        break;

      case KeyEvent.VK_S:
        break;

      case KeyEvent.VK_F:
        
        break;
    }
  }

  public void keyReleased (KeyEvent e)
  {
  }

  public void keyTyped (KeyEvent e)
  {
  }

	/**
	 * Set the number of generations in the control bar.
	 * @param generations number of generations
	 */
	public void setGeneration( int generations ) {
		genLabel.setText(genLabelText + generations);
	}
	
	/**
	 * Change the label of the start/stop-button to "Stop".
	 */
	public void start() {
		go.setText(stopLabelText);
	}

	/**
	 * Change the label of the start/stop-button to "Start".
	 */
	public void stop() {
		go.setText(startLabelText);
	}

	/**
	 * Called when the start/stop-button is clicked.
	 */
	public void startStopButtonClicked() {
		if ( app.isRunning() ) {
			app.stop();
			stop();
		} else {
		    start();
			app.start();
		}
	}

	/**
	 * Return GameOfLife applet object.
	 * @return GameOfLife applet object
	 */
	public GameOfLife getGameOfLife() {
		return app;
	}


  /**
   *  Control panel's drawing method
   */
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

   }
}
