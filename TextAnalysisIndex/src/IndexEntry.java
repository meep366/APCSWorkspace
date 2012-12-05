import java.util.ArrayList;

/**
 * 
 */

/**
 * @author croftj
 *
 */
public class IndexEntry implements Comparable<IndexEntry> {

	/**
	 * @param args
	 */
	//basic info about word
	private String entry;
	private int numOccurences;
	private ArrayList<Integer> lineNums;
	
	//new indexentry with given word
	public IndexEntry(String entry)
	{
		this.entry=entry;
		numOccurences=0;
		lineNums= new ArrayList<Integer>();
	}
	//copy constructor
	public IndexEntry(IndexEntry e)
	{
		entry=e.entry;
		numOccurences=e.numOccurences;
		lineNums=e.lineNums;
	}
	//add a new line number and increase occurences
	//@param lineNumber an int which is the line number
	public void add(int lineNumber)
	{
		if(!lineNums.contains(new Integer(lineNumber)))
			lineNums.add(lineNumber);
		
		numOccurences++;
	}
	//@return the number of occurences
	public int getOccurences()
	{
		return numOccurences;
	}
	//@return the word
	public String getEntry()
	{
		return entry;
	}
	//@return true if the objects are equal, false otherwise
	public boolean equals(Object other)
	{
		if(other instanceof IndexEntry)
		{
			if(((IndexEntry) other).getEntry().equals(entry))
			{
				return true;
			}
		}
		return false;
	}
 	//@return string representing class
	public String toString()
	{
		String str="";
		
		str+=(entry+"\n");
		if(numOccurences==1)
		{
			str+=("Occurs "+numOccurences+ " time" + '\n');
			str+=("LineNumber: ");
			str+=lineNums.toString().substring(1,lineNums.toString().length()-1);
		}
		else
		{
			str+=("Occurs "+numOccurences+ " times" + '\n');
			str+=("LineNumbers: ");
			str+=lineNums.toString().substring(1,lineNums.toString().length()-1);
		}
		str+='\n';
		
		return str;
	}
	//@return int comparing entries of indexentries
	public int compareTo(IndexEntry other)
	{
		return(entry.compareTo(other.entry));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
