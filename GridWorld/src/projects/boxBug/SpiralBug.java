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
public class SpiralBug extends Bug {

	/**
	 * @param args
	 */
 static ActorWorld world = new ActorWorld();
	private int steps;
    private int sideLength;
	
	
	public void act()
	{
		if(canMove()&&steps<sideLength)
		{
			move();
			steps++;
		}
		else 
		{
			turn();
			turn();
			steps=0;
			sideLength++;
		}
		
	}
	
	public SpiralBug()
	{
		sideLength=1;
	}
	
	public SpiralBug(int length)
	{
		sideLength = length;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		world.add(new SpiralBug());
		world.show();
		
		
	}

}
