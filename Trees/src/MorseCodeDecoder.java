/**
 * 
 */

/**
 * @author jack
 *
 */
public class MorseCodeDecoder {

	/**
	 * @param args
	 */
	private final String LEFT="-";
	private final String RIGHT=".";
	private TreeNode root;
	private String[] morseCode={"-T","--M","---O","--.G","--.-Q","--..Z","-.N","-.-K","-.--Y","-.-.C","-..D","-...B",".E",".-A",".--W",".---J",".--.P",".-.R",".-..L","..I","..-U","..-.F","...S","...-V","....H"};
	
	public MorseCodeDecoder()
	{
		root=new TreeNode("");
		for(String letter:morseCode)
		{
			setup(root,letter);
		}
	}
	
	private void setup(TreeNode node,String letter)
	{
		String firstLetter=letter.charAt(0)+"";
		if(firstLetter.equals(LEFT))
		{
			if (node.getLeft() == null)
				node.setLeft(new TreeNode(letter.substring(1)));
			else
				setup(node.getLeft(),letter.substring(1));
		}
		else //if(firstLetter.equals(RIGHT))
		{
			if (node.getRight() == null)
				node.setRight(new TreeNode(letter.substring(1)));
			else
				setup(node.getRight(),letter.substring(1));
		}
	}
	
	public String toString() {
		return toString(root);
	}
	
	private String toString(TreeNode node) {
		if (node == null)
			return "";
		
		return  node.getValue() + toString(node.getLeft()) + toString(node.getRight());
	}
	
	public static void main(String[] args) {
		MorseCodeDecoder mcd = new MorseCodeDecoder();
		System.out.println(mcd);

	}

}
