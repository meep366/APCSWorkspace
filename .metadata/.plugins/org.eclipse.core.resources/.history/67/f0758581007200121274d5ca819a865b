import java.util.HashMap;

/**
 * 
 */

/**
 * @author jack
 *
 */
public class StockExchange {

	/**
	 * @param args
	 */
	private Brokerage myBrokerage;
	private HashMap<String,Stock> stockList;
	
	
	public double getQuote(String stockSymbol)
	{
		return stockList.get(stockSymbol).returnQuote();
	}
	
	public void placeOrder(TradeOrder to)
	{
		if(to.getBuy())										//checks if buy or sell
			stockList.get(to.getStockSymbol()).buy(to);		//sends buy to Stock
		else
			stockList.get(to.getStockSymbol()).sell(to);	//sends sell to Stock
			
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
