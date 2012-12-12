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
public class SlowBug extends Bug{

	/**
	 * @param args
	 */
	private int turn=0;
	
	public SlowBug()
	{
		super();
	}
	
	public SlowBug(Color color)
	{
		super(color);
	}
	
	public void act()
	{
		if(turn==2)
			super.act();
		else
			turn++;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
