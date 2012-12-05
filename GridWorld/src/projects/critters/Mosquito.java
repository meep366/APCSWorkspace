/**
 * 
 */
package projects.critters;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

/**
 * @author croftj
 * Date of Completion: 11/14/12
 * Assignment: Mosquito Lab
 * Attribution:none
 * All work here is honestly obtained and is my own
 *
 *
 *
 */
public class Mosquito extends Critter {

	/**
	 * @param args
	 */
	
	
	
	
	private int steps=0;
	private boolean living=true;
	
	//Post:cannot move this actor
	//@param actors: an arraylist of actors from getActors()
	//checks for a cow and if it finds one, stings it and drops eggs, only lives for 6 turns
	public void processActors(ArrayList<Actor> actors)
	{
		if(steps>6) //checks number of turns
			living=false;
		else
		{
			steps++;
			for(int i=0;i<actors.size();i++)
			{
				if(actors.get(i) instanceof Cow)  //checks for cow
				{
					if(getLocation()!=null)
					{
						ArrayList<Location> locs=getGrid().getEmptyAdjacentLocations(getLocation());
							
						for(int j=0;j<locs.size();j++)  //lays eggs
						{
							MosquitoEgg m= new MosquitoEgg();
							m.putSelfInGrid(getGrid(), locs.get(j));
						}
						living=false;
					}
				}
			}
		}
	}
	//Post:cannot change anything
	//@return returns possible locations to move
	public ArrayList<Location> getMoveLocations()  //makes sure mosquito is in grid
	{
		if(living==false)
			return null;
		
		else
			return super.getMoveLocations();
	} 
	
	//Post:cannot change anything
	//@param locs: possible move locations
	//@return move location
	//finds and moves towards the closest cow
	public Location selectMoveLocation(ArrayList<Location> locs)  
	{
		if(living==false)
			return null;
		
		ArrayList<Location> occupiedLocs=getGrid().getOccupiedLocations();	//finds things
		int shortest=584564465;
		ArrayList<Cow> cows=new ArrayList<Cow>(occupiedLocs.size());
		Cow cow=new Cow();	
		
		for(int i=0;i<occupiedLocs.size();i++)
		{
			if(getGrid().get(occupiedLocs.get(i)) instanceof Cow)
			{
				cows.add((Cow) (getGrid().get(occupiedLocs.get(i))));
				
				if(shortest>DistanceBetweenLocations.distance(this.getLocation(), occupiedLocs.get(i)))	//finds nearest cow
					shortest=DistanceBetweenLocations.distance(this.getLocation(), occupiedLocs.get(i));
			}
		}
		
		
		for(int i=0;i<cows.size();i++)
		{
			if(DistanceBetweenLocations.distance(this.getLocation(), cows.get(i).getLocation())>shortest)
				cows.remove(i);
		}
		
		cow=cows.get((int)(Math.random()*cows.size()));
		

		Location cowLoc;
		
		if(cow.getLocation()!=null)	//makes sure cow is in grid
		{
			cowLoc=cow.getLocation();
		}
		else
		{
			cowLoc=this.getLocation();
		}
		
		ArrayList<Location> bestlocs=new ArrayList<Location>(locs.size());
		int shortestDistance=DistanceBetweenLocations.distance(this.getLocation(), cowLoc);
		
		for(int i=0;i<locs.size();i++) //finds shortest move towards cow
		{
			if(shortestDistance>DistanceBetweenLocations.distance(locs.get(i), cowLoc))
				shortestDistance=DistanceBetweenLocations.distance(locs.get(i), cowLoc);
		}
		
		for(int i=0;i<locs.size();i++)	//adds all equal locations to return
		{
			if(DistanceBetweenLocations.distance(locs.get(i), cowLoc)==shortestDistance)
				bestlocs.add(locs.get(i));
		}
		
		return super.selectMoveLocation(bestlocs);
	}
	
	//Post: can only move and place things
	//@param loc: move location
	//moves and turns mosquito
	public void makeMove(Location loc)	
    {
		if(living==false)	//makes sure its in a grid
			removeSelfFromGrid();
		else
		{
			setDirection(getLocation().getDirectionToward(loc));	//set direction and move
			super.makeMove(loc);
		}
    }
	
	
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ActorWorld world = new ActorWorld();
		world.add(new Mosquito());
		world.add(new Cow());
		world.show();
		
	}

}
