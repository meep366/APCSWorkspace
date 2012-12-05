/**
 * 
 */
package projects.critters;


import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
/**
 * @author jack
 *
 */
public class PastureRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 ActorWorld world = new ActorWorld();
		 world.add(new Rock());
		 world.add(new Rock());
		 world.add(new Bug());
		 world.add(new Bug());
		 world.add(new Cow());
		 world.add(new Cow());
		 world.add(new Cow());
		 world.add(new MosquitoEgg());
		 world.add(new MosquitoEgg());
		 world.add(new MosquitoEgg());
		 world.add(new MosquitoEgg());
		 world.add(new MosquitoEgg());
		 world.add(new MosquitoEgg());
		 world.add(new MosquitoEgg());
		 
		 world.show();
		
	}

}
