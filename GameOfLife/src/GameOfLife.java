
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Write a description of class GameOfLife here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOfLife extends JApplet implements ActionListener

{
    private LifeCanvas display;
    private LifeControls controls;
    private Timer t;
    private int timeStep;
    private boolean isRunning;
    
    public void setSpeed(int millisecs)
    {
        timeStep = millisecs;
        t.setDelay(timeStep);
        t.restart();
    }
    
    public void next()
    {
        display.next();
        repaint();
    }
    
    public void stop()
    {
        t.stop();
        isRunning = false;
    }
    
    public void start()
    {
        t.start();
        isRunning = true;
    }
    
    /**
	 * Is the applet running?
	 * @return true: applet is running
	 */
	public boolean isRunning() {
		return isRunning;
	}
     
    public void init()
    {
        isRunning = false;
        display = new LifeCanvas(this);
        display.setBackground(Color.green);
        controls = new LifeControls(this);
        
        Container c = getContentPane();
        c.add(display, BorderLayout.CENTER);
        c.add(controls, BorderLayout.SOUTH);
        
        
       timeStep = 3000;
       t = new Timer(timeStep, this);
    }
    
    /* Timer Event */
    public void actionPerformed(ActionEvent e)
    {
         next();
    }

   
    
}
