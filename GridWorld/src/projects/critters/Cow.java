/**
 * 
 */
package projects.critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * @author croftj
 *
 */

	



public class Cow extends Critter{

	/**
	 * @param args
	 */
	
	
	private int steps=0;
	
	//Post: cannot move this actor
	//@param actors: actors from getActors()
	//eats eggs and flowers
	public void processActors(ArrayList<Actor> actors)
	{
		for(int i=0;i<actors.size();i++)
		{
			if(actors.get(i) instanceof MosquitoEgg || actors.get(i) instanceof Flower)
			{
				if(actors.get(i).getLocation()!=null)
					actors.get(i).removeSelfFromGrid();
			}
		} 
	}
	
	//Post:cannot change anything
	//@param locs: possible move locations
	//@return move location
	//only moves every three turns
	public Location selectMoveLocation(ArrayList<Location> locs)
	{
		if(steps!=2)
		{
			steps++;
			return getLocation();
		}
		else
		{
			steps=0;
			return super.selectMoveLocation(locs);
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
