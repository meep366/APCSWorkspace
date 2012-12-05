/**
 * 
 */
package projects.firstProject;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
/**
 * @author croftj
 *
 */

public class RollingRock extends Rock{
	private static final Color DEFAULT_COLOR = Color.BLACK;
	private int direction = 0;
	static ActorWorld world = new ActorWorld();
	public RollingRock(){
		setColor(DEFAULT_COLOR);
		direction = 135;
	}
	public RollingRock(Color rock){
		setColor(rock);
		direction = 135;
	}
	public void roll(){
		 Grid<Actor> gr = getGrid();
	        if (gr == null)
	            return;
	        Location loc = getLocation();
	        Location next = loc.getAdjacentLocation(getDirection());
	        if (gr.isValid(next))
	            moveTo(next);
	        else
	            removeSelfFromGrid();
	      
	}
	public void act(){
		if (canMove())
            roll();
        else
            turn();
		
	}
	 public boolean canMove()
	    {
	        Grid<Actor> gr = getGrid();
	        if (gr == null)
	            return false;
	        Location loc = getLocation();
	        Location next = loc.getAdjacentLocation(getDirection());
	        if (!gr.isValid(next))
	            return false;
	        Actor neighbor = gr.get(next);
	        return (neighbor == null);
	        // ok to move into empty location or onto flower
	        // not ok to move onto any other actor
	    }
	 public void turn()
	    {
	        setDirection(getDirection() + Location.HALF_RIGHT);
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		world.add (new RollingRock());
		world.show();
	}

}
