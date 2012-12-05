/**
 * 
 */
package projects.firstProject;
import info.gridworld.actor.Actor;

/**
 * @author croftj
 *
 */
public class TestActor {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Actor alice = new Actor();
		
		System.out.println(alice.getDirection());
		alice.setDirection(90);
		System.out.println(alice.getDirection());
		
	}

}
