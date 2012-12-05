/**
 * 
 */
package Lipogrammer;

/**
 * @author croftj
 *
 */
public class LipogramAnalyzer {

	/**
	 * @param args
	 */
	private String text;
	
	public LipogramAnalyzer(String text)
	{
		this.text=text;
	}
	
	public String mark(char letter)
	{
		return text=text.replace(letter, '#');
	}
	
	public String allWordsWith(char letter)
	{
		String list = "";
		int last=0;
		
		for(int i=0;i<text.length()-1;i++)
		{
			String temp="";
			Character c=text.charAt(i);
						
			if(!Character.isLetter(c))
			{
				temp=text.substring(last,i);
			
				
				for(int j=0;i<temp.length()-1;i++)
				{
					System.out.println(temp);
					char e=text.charAt(i);
					if(e==letter)
					{
						temp=temp.trim();
						list+=temp+'\n';
						j=temp.length()+5;
					}
				}
				last=i;
			}
			
		}
		return list;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LipogramAnalyzer la=new LipogramAnalyzer("testing testing cool");
		System.out.println(la.allWordsWith('t'));
		
	}

}
