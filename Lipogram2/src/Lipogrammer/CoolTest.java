package Lipogrammer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class CoolTest {

	/**
	 * @param args
	 */
	 
	private String text="testing. testing, sweet maybe cool test cat's cat-dog";
	
	public String allWordsWith(char letter)
	{
		String[] words = text.split("[\\s,.;:\"]+");
		HashMap wordMap= new HashMap();
		String result="";
		
		
		for(int i=0; i<words.length;i++)
		{
			if(words[i].indexOf(letter)>-1)
			{
				wordMap.put(words[i],words[i]);
			}
		}
		
		
		Set<String> keys= wordMap.keySet();
		Iterator<String> i = keys.iterator();
		while(i.hasNext())
		{
			String key=i.next();
			result+=(key+'\n');
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CoolTest ct = new CoolTest();
		System.out.println(ct.allWordsWith('t'));
		
		
	}

}
