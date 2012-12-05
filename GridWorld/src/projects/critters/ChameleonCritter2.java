/**
 * 
 */
package projects.critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;


/**
 * @author croftj
 *
 */
public class ChameleonCritter2 extends Critter {

	private static final double DARKENING_FACTOR = 0.05;
	
	/**
	 * @param args
	 */
	
	/**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */
    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0)
        {
        	Color c = getColor();
            int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
            int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
            int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
            
            setColor(new Color(red, green, blue));
        	
            return;
        }
        int r = (int) (Math.random() * n);

        Actor other = actors.get(r);
        setColor(other.getColor());
    }

    /**
     * Turns towards the new location as it moves.
     */
    public void makeMove(Location loc)
    {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ActorWorld world = new ActorWorld();
		world.add(new Location(5, 8), new ChameleonCritter2());
        world.show();
		
	}

}
