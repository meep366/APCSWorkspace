/**
 * 
 */
package Number14;

import java.util.Scanner;

/**
 * @author croftj
 *
 */
public class Coins {

	/**
	 * @param args
	 */
	
	private int cents;
	private int quarters;
	private int dimes;
	private int nickles;
	private int pennies;
	
	
	public Coins(int c)
	{
		cents=c;
		quarters=coinMod(c, 25);
		c-=quarters*25;
		dimes=coinMod(c, 10);
		c-=dimes*10;
		nickles=coinMod(c, 5);
		c-=nickles*5;
		pennies=c;
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
	
	
	
	private int coinMod(int change, int num)
	{
		if(change==0||change<num)
			return 0;
		else
		{
			if(change%num<0)
				return change&num;
			else
			{
				int i=0;
				for(;change>=num;i++)
				{
					change-=num;
				}
				return i;
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kbod = new Scanner(System.in);
		Coins c = new Coins(kbod.nextInt());
		System.out.println(c.quarters+", "+c.dimes+", "+c.nickles+", "+c.pennies);
	}

}
