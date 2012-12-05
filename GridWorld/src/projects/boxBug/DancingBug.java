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
public class DancingBug extends Bug{
	static ActorWorld world = new ActorWorld();
	private int counter = 0;
	
	private int dancing[];
	public DancingBug(int dancing[]){
		this.dancing = dancing;
		
	}
	public void act(){
		if (counter > dancing.length-1){
			counter = 0;
		} else {
		for (int i=0;i<dancing[counter];i++){
			setDirection(getDirection() + 45);
		
		}
		counter++;
		}
		if (canMove()){
			move();
		}else{
			setDirection(getDirection()+45);
		}
			
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {4, 3, 2, 5, 6};
		
		world.add(new DancingBug(array));
		world.show();
	}

}
