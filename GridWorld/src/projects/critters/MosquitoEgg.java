/**
 * 
 */
package projects.critters;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

/**
 * @author croftj
 *
 */
public class MosquitoEgg extends Actor{

	/**
	 * @param args
	 */
	
	private int steps=0;
	
	//after five turns becomes a mosquito
	public void act()
	{
		Location loc=this.getLocation();
		
		if(steps>5) //checks age of egg
		{
			Mosquito m=new Mosquito();  //creates and places a new mosquito
			m.putSelfInGrid(getGrid(), loc);
		}
		else
		{
			steps++;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
