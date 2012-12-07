/**
 * 
 */
package com.meep;

/**
 * @author jack
 *
 */
public class LineCountThread implements Runnable {

	/**
	 * @param args
	 */
	private String data;
	
	
	public LineCountThread(String data)
	{
		this.data=data;
	}
	
	public void countLines()
	{
		String[] lines=data.split("\\r?\\n");
		System.out.println("Lines: "+lines.length);
		TextAnalyzer.LINECOUNT=lines.length;
		TextAnalyzer.LINES=lines;
	}
	
	@Override
	public void run() 
	{
		countLines();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}