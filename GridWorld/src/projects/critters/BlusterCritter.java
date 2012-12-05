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
 *
 */
public class BlusterCritter extends Critter{

	/**
	 * @param args
	 */
	//.05
	
	private static final double DARKENING_FACTOR = 0.05;
	private int courage=0;
	
	public BlusterCritter(int c)
	{
		courage=c;
	}
	
	
	public ArrayList<Actor> getActors()
	{
		ArrayList<Actor> actors = new ArrayList<Actor>();
		Location loc=new Location(getLocation().getCol(),getLocation().getRow());
		Location loc2=new Location(getLocation().getCol()-1,getLocation().getRow()-1);
		Location loc3=new Location(getLocation().getCol()+1,getLocation().getRow()+1);
		Location loc4=new Location(getLocation().getCol()-1,getLocation().getRow()+1);
		Location loc5=new Location(getLocation().getCol()+1,getLocation().getRow()-1);
		
		actors.addAll(getGrid().getNeighbors(loc2));
		actors.addAll(getGrid().getNeighbors(loc3));
		actors.addAll(getGrid().getNeighbors(loc4));
		actors.addAll(getGrid().getNeighbors(loc5));
		actors.addAll(getGrid().getNeighbors(loc));
		
		for(int i=0;i<actors.size();i++)
		{
			for(int j=i+1;j<actors.size();j++)
			{
				if(actors.get(i)==actors.get(j))
				{
					actors.remove(j);
					j--;
				}
			}
		}
		
		for(int i=0; i<actors.size();i++)
		{
			if(actors.get(i)==this)
				actors.remove(i);
		}
		
		return actors;
	}
	
	
	public void processActors(ArrayList<Actor> actors)
	{
		//System.out.println(actors.size());
		
		int critterCount=0;
		for(int i=0;i<actors.size();i++)
		{
			if(actors.get(i) instanceof Critter)
				critterCount++;
		}
		
		if(critterCount<courage)
		{
			lightenColor();
		}
		else
		{
			darkenColor();
		}
			
	}
	
	private void darkenColor()
	{
		setColor(getColor().darker());
	}
	
	private void lightenColor()
	{
	
		setColor(getColor().brighter());
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ActorWorld world = new ActorWorld();
		world.add(new Location(5, 8), new BlusterCritter(1));
	//	world.add(new Critter());
	//	world.add(new Critter());
	//	world.add(new Critter());
		world.add(new Critter());
        world.show();
		
		
	}

}
