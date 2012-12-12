package problems1;
/**
 * 
 */

/**
 * @author jack
 *
 */
public class Limerick extends Poem{

	/**
	 * @param args
	 */
	private int lines=5;
	
	public int getSyllables(int k)
	{
		if(k==0||k==1||k==4)
			return 9;
		else
			return 6;
	}
	
	public int numLines()
	{
		return lines;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
