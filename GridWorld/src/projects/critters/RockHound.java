/**
 * 
 */
package projects.critters;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

/**
 * @author croftj
 *
 */
public class RockHound extends Critter {

	/**
	 * @param args
	 */
	
	public void processActors(ArrayList<Actor> actors)
	{
		for(int i=0; i<actors.size();i++)
		{
			if(actors.get(i) instanceof Rock)
			{
				actors.get(i).removeSelfFromGrid();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ActorWorld world = new ActorWorld();
		world.add(new Location(5, 8), new RockHound());
		world.add(new Rock());
		world.add(new Rock());
		world.add(new Rock());
		world.add(new Rock());
        world.show();
	}

}
