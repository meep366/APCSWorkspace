/**
 * 
 */
package projects.firstProject;

import info.gridworld.actor.Flower;

/**
 * @author croftj
 *
 */
public class WiltingFlower extends Flower{
    private int lifeSpan;
    private int age;
	public WiltingFlower(int lifeSpan){
    	 this.lifeSpan = lifeSpan;
    	 age = 0;
    	 
     }
	public void act(){
		age++;
		if (age > lifeSpan)
			removeSelfFromGrid();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
