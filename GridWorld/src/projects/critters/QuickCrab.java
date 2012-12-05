/**
 * 
 */
package projects.critters;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * @author jack
 *
 */
public class QuickCrab extends CrabCritter {

	/**
	 * @param args
	 */
	
	
	public ArrayList<Location> getMoveLocations()
	{
		ArrayList<Location> result = new ArrayList<Location>();
		
		Location loc1=getLocation().getAdjacentLocation(Location.RIGHT);
		Location loc2=getLocation().getAdjacentLocation(Location.LEFT);
		Location loc3=loc1.getAdjacentLocation(Location.RIGHT);
		Location loc4=loc2.getAdjacentLocation(Location.LEFT);
		
		
		if(getGrid().isValid(loc1)&&getGrid().isValid(loc2))
		{
			if(getGrid().isValid(loc3)&&getGrid().isValid(loc4))
			{
				int choice=(int)(Math.random()*2);
				if(choice<1)
				{
					result.add(loc3);
				}
				else
				{
					result.add(loc4);
				}
				return result;
			}
		}
		
			return super.getMoveLocations();
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ActorWorld world = new ActorWorld();
		world.add(new Location(5, 8), new QuickCrab());
        world.show();
		
	}

}
