import java.util.ArrayList;

/**
 * 
 */

/**
 * Process file line by line then break up line into String[]
 * word is string broken up by string.split() and the contents of the regex
 * Will convert everything to lower case
 * keep apostrophes, everything else doesn't matter, does leave slight issues with quotations
 * reading file line by line passing into DocumentIndex
 * Must pass through the text multiple times as its written now
 * used the QuickSort code from the textbook
 * everything primarily works with the exception of the apostrophe sometimes
 */




/**
 * @author croftj
 *Date of Completion: 10/26/12
 *Assignment: IndexEntry and DocumentIndex
 *Attribution: textbook for QuickSort
 *All work here is honestly obtained an dis my own
 */
public class DocumentIndex extends ArrayList<IndexEntry> {
//we are an ArrayList, and this.add() works
	/**
	 * @param args
	 */

	
	//useful statistical information
	public int numWords=size();
	public String longestWord="";
	public String shortestWord="123123123132123132132";
	public String mostFrequentWord="";
	public String leastFrequentWord="";
	public int highestFrequency=1;
	public int lowestFrequency=1;
	
	
	//new doucumentIndex with capacity
	public DocumentIndex(int initalCapacity)
	{
		super(initalCapacity);
	}

	//@param line a String of a line of a text
	//@param lineNUm an int of the line number
	public void addAllWords(String line, int lineNum)
	{
		if(line.equals(""))
			return;
		
		//split up string
		String[] words = line.split("[\\s,!.;:()\"]+");
		
		
		for(int i=0;i<words.length;i++)
		{
			String word=words[i];
			word=word.toLowerCase();
			IndexEntry current = new IndexEntry(word);
			
			//check if has the entry
			if(contains(current))
			{
				get(indexOf(current)).add(lineNum);
			}
			else
			{
				add(current);
				get(indexOf(current)).add(lineNum);
			}
			
			//statistical checks
			if(current.getEntry().length()<=shortestWord.length())
				shortestWord=current.getEntry();
			
			if(current.getEntry().length()>=longestWord.length())
				longestWord=current.getEntry();
			
			if(get(indexOf(current)).getOccurences()>=highestFrequency)
			{
				mostFrequentWord=current.getEntry();
				highestFrequency=get(indexOf(current)).getOccurences();
			}
			
			if(get(indexOf(current)).getOccurences()<=lowestFrequency)
			{
				leastFrequentWord=current.getEntry();
				lowestFrequency=get(indexOf(current)).getOccurences();
			}
			
		}
		numWords=size();
		Quicksort.sort(this);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
