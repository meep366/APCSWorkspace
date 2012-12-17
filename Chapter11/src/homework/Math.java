/**
 * 
 */
package homework;

/**
 * @author jack
 *
 */
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
