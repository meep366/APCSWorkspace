/**
 * 
 */
package projects.boxBug;

import java.awt.Color;
import info.gridworld.actor.ActorWorld;

import info.gridworld.actor.Bug;

/**
 * @author croftj
 *
 */
public class CircleBug extends Bug {

	static ActorWorld world = new ActorWorld();
	
	/**
	 * @param args
	 */
	
    private int steps;
    private int sideLength;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    
    public CircleBug()
    {
    	sideLength = 0;
    	setColor(Color.RED);
    }
    
    public CircleBug(Color bugColor)
    {
    	setColor(bugColor);
    	sideLength = 0;
    }
    
    public CircleBug(int length, Color bugColor)
    {
    	setColor(bugColor);
    	sideLength = length;
    }
    
    public CircleBug(int length)
    {
        steps = 0;
        sideLength = length;
    }
    
    

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		world.add(new CircleBug(3));
		world.show();
	}

}
