/**
 * 
 */
package projects.boxBug;

import java.awt.Color;

import info.gridworld.actor.Bug;

/**
 * @author jack
 *
 */
public class FastBug extends Bug{

	/**
	 * @param args
	 */
	private int reps;
	
	public FastBug()
	{
		super();
		reps=1;
	}
	
	public FastBug(Color color, int reps)
	{
		super(color);
		this.reps=reps;
	}
	
	public void act()
	{
		for(int i=0;i<reps;i++)
		{
			super.act();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
