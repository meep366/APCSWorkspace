/**
 * 
 */
package boxBug;

import java.util.ArrayList;



import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;

/**
 * @author jack
 *
 */
public class Bee extends Critter{

	/**
	 * @param args
	 */
	
	public void processActors(ArrayList<Actor> actors)
	{
		for(int i=0;i<actors.size();i++)
		{
			if(actors.get(i) instanceof Clover)
				((Clover) actors.get(i)).pollinate();
		}
	}
	
//	public Location selectMoveLocation(ArrayList<Location> locs)
//	{
//		if(!locs.contains(getLocation()))
//			locs.add(getLocation());
//		
//		ArrayList<Location> bestLocs=new ArrayList<Location>(locs.size());
//		int[] distances=new int[locs.size()];
//		
//		for(int i=0;i<locs.size();i++)
//		{
//			
//		}
//		
//		return super.selectMoveLocation(bestLocs);
//	}
	
	
	public Location selectMoveLocation(ArrayList<Location> locs)
	{
		ArrayList<Location> occupiedLocs=getGrid().getOccupiedLocations();	//finds things
		int shortest=584564465;
		ArrayList<Clover> clovers=new ArrayList<Clover>(occupiedLocs.size());
		Clover clover=new Clover();	
		
		for(int i=0;i<occupiedLocs.size();i++)
		{
			if(getGrid().get(occupiedLocs.get(i)) instanceof Clover)
			{
				clovers.add((Clover) (getGrid().get(occupiedLocs.get(i))));
				
				if(shortest>distance(this.getLocation(), occupiedLocs.get(i)))	//finds nearest clover
					shortest=distance(this.getLocation(), occupiedLocs.get(i));
			}
		}
		
		
		for(int i=0;i<clovers.size();i++)
		{
			if(distance(this.getLocation(), clovers.get(i).getLocation())>shortest)
				clovers.remove(i);
		}
		
		clover=clovers.get((int)(Math.random()*clovers.size()));
		

		Location cloverLoc;
		
		if(clover.getLocation()!=null)	//makes sure clover is in grid
		{
			cloverLoc=clover.getLocation();
		}
		else
		{
			cloverLoc=this.getLocation();
		}
		
		ArrayList<Location> bestlocs=new ArrayList<Location>(locs.size());
		int shortestDistance=distance(this.getLocation(), cloverLoc);
		
		for(int i=0;i<locs.size();i++) //finds shortest move towards clover
		{
			if(shortestDistance>distance(locs.get(i), cloverLoc))
				shortestDistance=distance(locs.get(i), cloverLoc);
		}
		
		for(int i=0;i<locs.size();i++)	//adds all equal locations to return
		{
			if(distance(locs.get(i), cloverLoc)==shortestDistance)
				bestlocs.add(locs.get(i));
		}
		
		return super.selectMoveLocation(bestlocs);
	}
	
	private int distance(Location loc1, Location loc2)
	{
		return Math.max(Math.abs(loc1.getRow()-loc2.getRow()), Math.abs(loc1.getCol()-loc2.getCol()));
	}
	
	public void makeMove(Location loc)
	{
		setDirection(getLocation().getDirectionToward(loc));
		super.makeMove(loc);
	}
}
