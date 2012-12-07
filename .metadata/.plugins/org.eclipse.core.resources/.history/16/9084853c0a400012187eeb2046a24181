/**
 * 
 */
package com.meep;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

/**
 * @author jack
 *
 */
public class WordCountThread implements Runnable {

	/**
	 * @param args
	 */
	private String data;
	
	
	public WordCountThread(String data)
	{
		this.data=data;
	}
	
	public void countWords()
	{
		String regex="[\\s,!.;:{}\"]+";
		
		String[] words=data.replaceFirst("^"+regex, "").split(regex);
		System.out.println("Words: "+words.length);
		TextAnalyzer.WORDCOUNT=words.length;
		TextAnalyzer.WORDS=words;
	}
	
	@Override
	public void run() 
	{
		countWords();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

}
