/**
 * 
 */
package projects.critters;

import info.gridworld.grid.Location;



/**
 * @author croftj
 *
 */
public class DistanceBetweenLocations {

	/**
	 * @param args
	 */
	
	public static int distance(Location loc1, Location loc2)
	{
		return Math.max(Math.abs(loc1.getRow()-loc2.getRow()), Math.abs(loc1.getCol()-loc2.getCol()));
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}







	

}
