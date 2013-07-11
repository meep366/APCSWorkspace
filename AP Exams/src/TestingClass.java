/**
 * 
 */

/**
 * @author jack
 *
 */
public class TestingClass {

	/**
	 * @param args
	 */
	
	
	/**
	 * PCVID, supply short name, dose, quantity, location
	 * 111111, BANDG, 30mg, 50, ACCRA
	 * 
	 * 
	 */
	
	
	
	
	private int PCVID;
	private String supplyCode;
	private int dosage;
	private int quantity;
	private String location;
	
	public void parse(String input)
	{
		String regex=",\\s";
		String[] split=input.split(regex);
		
		for(int i=0;i<split.length;i++)
			System.out.println(split[i]);
	}
	
	public int getPCVID()
	{
		return PCVID;
	}
	
	public String getSupplyCode()
	{
		return supplyCode;
	}
	
	public int getDosage()
	{
		return dosage;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message="111111, BANDG, 30mg, 50, ACCRA";
		TestingClass tc=new TestingClass();
		tc.parse(message);
	}

}
