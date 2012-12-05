/**
 * 
 */
package projects.boxBug;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;

/**
 * @author croftj
 *
 */
public class ZBug extends Bug {

	/**
	 * @param args
	 */
	static ActorWorld world = new ActorWorld();
	
	private int length = 0;
	private int steps = 0;
	private int turns = 0;
	
	public ZBug(int length)
	{
		setDirection(90);
		this.length=length;
	}
	
	public void act()
	{
		if(steps<length && canMove())
		{
			move();
			steps++;
		}
		else if(steps==length && turns==0)
		{
			setDirection(225);
			steps=0;
			turns++;
		}
		else if(steps==length && turns==1)
		{
			setDirection(90);
			steps=0;
			turns++;
		}
		else if((steps==length && turns == 2)|| !canMove())
		{
			
		}
			
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		world.add(new ZBug(5));
		world.show();
	}

}
