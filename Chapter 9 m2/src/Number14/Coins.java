/**
 * 
 */
package Number14;

import java.util.Scanner;

/**
 * @author croftj
 * Date of Completion: 9/26/12
 * Assignment: Ch.9 #14
 * Attribution: Bill O'Donoghue for the reminder of integer division
 * All work here is honestly obtained and is my own.
 * 
 * A coins class to find the correct number of coins to make a certain amount of change
 *
 */
public class Coins {

	/**
	 * @param cents-total amount of change
	 * @param quarters-total number of quarters needed
	 * @param dimes-total number of dimes needed
	 * @param nickels-total number of nickles needed
	 * @param pennies-total number of pennies needed
	 * 
	 */
	// One constructor which takes the total change and calculates the coins needed
	//Fields for total change and each individual coin
	//Accessors for getting numbers of coins
	
	private int cents;
	private int quarters;
	private int dimes;
	private int nickles;
	private int pennies;
	
	
	public Coins(int c)
	{
		cents = c;           //sets cents
		quarters=c/25;       //integer division for # of coins
		c-=quarters*25;      //decrease change total and repeat
		dimes=c/10;
		c-=dimes*10;
		nickles=c/5;
		c-=nickles*5;
		pennies=c;            //whatever is left over
	}
	
	public int getQuarters()
	{
		return quarters;
	}
	public int getDimes()
	{
		return dimes;
	}
	public int getNickles()
	{
		return nickles;
	}
	public int getPennies()
	{
		return pennies;
	}
	
	
	
	
	/**
	 * Creates an instance of Coins
	 * creates a scanner to take an integer value for the total change
	 * prints out the coins in decreasing order
	 * 
	 */
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kbod = new Scanner(System.in);
		Coins c = new Coins(kbod.nextInt());
		System.out.println(c.quarters+", "+c.dimes+", "+c.nickles+", "+c.pennies);
	}

}
