/**
 * 
 */

/**
 * @author jack
 *
 */
public class BatteryCharger {

	/**
	 * @param args
	 */
	
	private int[] rateTable;
	
	public void setTable(int[] table)
	{
		rateTable=table;
	}
	
	private int getChargingCost(int startHour, int chargeTime)
	{
		int totalCost=0;
		for(int i=0;i<chargeTime;i++)
		{
			totalCost+=rateTable[(startHour+i)%24];
		}
		return totalCost;
	}
	
	public int getStartTime(int chargeTime)
	{
		int cost=getChargingCost(0,chargeTime);
		int time=0;
		
		for(int i=1;i<24;i++)
		{
			if(getChargingCost(i,chargeTime)<cost)
			{
				cost=getChargingCost(i,chargeTime);
				time=i;
			}
		}
		return time;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] table={50,60,160,60,80,100,100,120,150,150,150,200,40,240,220,220,200,200,180,180,140,100,80,60};
		BatteryCharger bc=new BatteryCharger();
		bc.setTable(table);
		System.out.println(bc.getChargingCost(22,30));
		System.out.println(bc.getStartTime(30));
		
	}

}
