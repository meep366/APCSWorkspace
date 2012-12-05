/**
 * 
 */
package projects.critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * @author croftj
 *
 */
public class KingCrab extends CrabCritter{

	/**
	 * @param args
	 */
	
	
	public void processActors(ArrayList<Actor> actors)
	{
		boolean[] moved=new boolean[actors.size()];
		
		for(int i=0; i<actors.size();i++)
		{	
			ArrayList<Location> locs = actors.get(i).getGrid().getValidAdjacentLocations(actors.get(i).getLocation());
			ArrayList<Location> locs2= this.getGrid().getValidAdjacentLocations(this.getLocation());
			
			for(int j=0;j<locs2.size();j++)
			{
				if(!locs.contains(locs2.get(j)))
				{
					actors.get(i).moveTo(locs.get(i));
					j=locs.size()+2;
					moved[i]=true;
				}
			}
		}
		
		for(int i=0;i<actors.size();i++)
		{
			if(moved[i]!=true)
				actors.get(i).removeSelfFromGrid();
		}
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ActorWorld world = new ActorWorld();
		world.add(new Location(5, 8), new KingCrab());
		world.add(new Actor());
		world.add(new Critter());
        world.show();
	}

}
