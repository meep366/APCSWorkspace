/**
 * 
 */
package critters;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * @author jack
 *
 */
public class ChargingKnightCritter extends Critter{

	/**
	 * @param args
	 */
	
	private Color teamColor;
	
	public ChargingKnightCritter(Color tColor)
	{
		teamColor=tColor;
	}
	
	public ArrayList<Location> getMoveLocations()
	{
		ArrayList<Location> moves=new ArrayList<Location>();
		int col=getLocation().getCol();
		int row=getLocation().getRow();
		Grid grid=getGrid();
		
		moves.add(new Location(col+1,row-2));
		moves.add(new Location(col+1,row+2));
		moves.add(new Location(col+2,row-1));
		moves.add(new Location(col+2,row+1));
		moves.add(new Location(col-1,row-2));
		moves.add(new Location(col-1,row+2));
		moves.add(new Location(col-2,row-1));
		moves.add(new Location(col-2,row+1));
		
		
		for(int i=0;i<moves.size();i++)
		{
			if(!grid.isValid(moves.get(i)))
				moves.remove(i);
		}
		
		ArrayList<Location> temp=new ArrayList<Location>();
		for(int i=0;i<moves.size();i++)
		{
			if(grid.get(moves.get(i))!=null)
				temp.add(moves.get(i));
		}
		if(temp.size()!=0)
			moves=temp;
		
		return moves;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
