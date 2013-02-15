import java.util.Comparator;

/**
 * 
 */

/**
 * @author Jack,Noah,Benji
 *
 *
 *General Description: comparator for various trade orders and allows for ascending and descending options
 */
public class PriceComparator implements Comparator<TradeOrder>{

	//boolean field for ascending or descending
	private boolean ascending;
	
	//default constructor assuming ascending is true
	public PriceComparator()
	{
		ascending=true;
	}
	
	//constructor with option for ascending being either true or false
	public PriceComparator(boolean asc)
	{
		ascending=asc;
	}
	
	//returns positive if 0 if both are market, 1 if t1 is the only limit order, -1 if t2 is the only limit order
	//returns difference in prices if both are limit and also accounts for ascending or descending
	public int compare(TradeOrder t1,TradeOrder t2)
	{
		if(t1.isMarket()&&t2.isMarket())
		{
			return 0;
		}
		if(t1.isMarket()&&t2.isLimit())
		{
			return -1;
		}
		if(t2.isMarket()&&t1.isLimit())
		{
			return 1;
		}
		
		if(ascending)
			return (int)(t1.getPrice()-t2.getPrice()*100);
		
		return (int)(-t1.getPrice()+t2.getPrice()*100);
	}
}