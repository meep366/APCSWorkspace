/**
 * 
 */
package homework;

import info.gridworld.actor.Bug;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author jack
 *
 */
public class AllWork {

	
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
	
		public abstract class Math {

			/**
			 * @param args
			 */
			private int aValue,bValue,result;
			
			
			public void setA(int a)
			{
				setaValue(a);
			}
			
			public void setB(int b)
			{
				setbValue(b);
			}
			
			public int getResult()
			{
				return result;
			}
			
			public abstract void process();
			
			
			public int getaValue() {
				return aValue;
			}

			public void setaValue(int aValue) {
				this.aValue = aValue;
			}

			public int getbValue() {
				return bValue;
			}

			public void setbValue(int bValue) {
				this.bValue = bValue;
			}

			public void setResult(int result) {
				this.result = result;
			}

		}
		
		public class Multiplier extends Math{

			/**
			 * @param args
			 */
			
			public void process()
			{
				setResult(getaValue()*getbValue());
			}
		}

		
		
		public class Adder extends Math{
			/**
			 * @param args
			 */
			
			public void process()
			{
				setResult(getaValue()+getbValue());
			}

		}

	
	
		public abstract class Face {

			/**
			 * @param args
			 */
			
			public void draw(Graphics g)
			{
				g.drawOval(20,20,30,30);
				drawEyes(g);
				drawLips(g);
			}
			
			public void drawEyes(Graphics g)
			{
				g.fillOval(28,28,5,5);
				g.fillOval(38,28,5,5);
			}
			
			public abstract void drawLips(Graphics g);
			
			

		}
		
		
		
		public class SmileyFace extends Face{

			/**
			 * @param args
			 */
			
			public void drawLips(Graphics g)
			{
				g.drawArc(25,25,20,20,225,90);
			}

		}

	
		public class AlarmClock extends Clock{

			/**
			 * @param args
			 */
			
			private int hours,mins,aHours,aMins;
			
			public AlarmClock(int hours, int mins, int aHours, int aMins)
			{
				super(hours, mins);
				this.hours=hours;
				this.mins=mins;
				this.aHours=aHours;
				this.aMins=aMins;
			}
			
			public void advance()
			{
				if(hours==aHours&&mins==aMins)
					System.out.println("Alarm!");
				super.advance();
			}
			
			
			public interface Car {

				
				public int getMaximumCarryingWeight();
				
				public int getNumSeats();
				
			}

			/**
			 * The advantage of using an interface over an abstract class is that another class can implement this and other interfaces
			 * as well as extend one class
			 * 
			 * 
			 */

	
	
	
	
}