import java.util.PriorityQueue;

/**
 * 
 */

/**
 * @author jack
 *
 */
public class Stock {

	/**
	 * @param args
	 */
	
	private String stockName;
	private String companyName;
	private double lowSellPrice;
	private double highSellPrice;
	private double volume;
	private PriorityQueue<TradeOrder> buyOrders;
	private PriorityQueue<TradeOrder> sellOrders;
	
	public Stock(String stockName, String companyName)
	{
		this.stockName=stockName;
		this.companyName=companyName;
		PriceComparator pc=new PriceComparator();
		buyOrders=new PriorityQueue<TradeOrder>(10,pc);
		sellOrders=new PriorityQueue<TradeOrder>(10, pc);
	}
	
	public void buy(TradeOrder buyOrder)
	{ 
		buyOrders.add(buyOrder);
		execute();
	}
	
	public void sell(TradeOrder sellOrder)
	{
		sellOrders.add(sellOrder);
		execute();
	}
	
	public void execute()
	{
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}