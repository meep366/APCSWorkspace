/*
 * This program takes a text file, creates an index (by line numbers)
 * for all the words in the file and writes the index
 * into the output file.  The program takes input and output file names
 * from the command-line args or prompts the user for the file names.
 */

import java.util.Scanner;
import java.io.*;

public class IndexMaker
{
  public static void main(String[] args) throws IOException
  {
    Scanner keyboard = new Scanner(System.in);
    String fileName;

    // Open input file:

    if (args.length > 0)
      fileName = args[0];
    else
    {
      System.out.print("\nEnter input file name: ");
      fileName = keyboard.nextLine().trim();
    }

    BufferedReader inputFile =
                 new BufferedReader(new FileReader(fileName), 1024);

    // Create output file:

    if (args.length > 1)
      fileName = args[1];
    else
    {
      System.out.print("\nEnter output file name: ");
      fileName = keyboard.nextLine().trim();
    }

    PrintWriter outputFile =
                 new PrintWriter(new FileWriter(fileName));

    // Create index:
    //start timer:
    long startTime=System.currentTimeMillis();

    DocumentIndex index = new DocumentIndex(140000);

    String line;
    int lineNum = 0;
    while ((line = inputFile.readLine()) != null)  //not at end of file & read a valid line
    {
      lineNum++;
      index.addAllWords(line, lineNum);
    }

    //End time:
    long endTime = System.currentTimeMillis();
    long time = (endTime-startTime)/1000;
    System.out.println("Time: "+time);
    
    
    // Save index:
    outputFile.println("Number of Distinct Words: "+index.numWords+'\n');
    outputFile.println("Most Frequent Word: "+index.mostFrequentWord + ", Number of Occurrences: "+index.highestFrequency);
    outputFile.println("Least Frequent Word: "+index.leastFrequentWord + ", Number of Occurrences: "+index.lowestFrequency);
    outputFile.println("Longest Word: " + index.longestWord);
    outputFile.println("Shortest Word: " + index.shortestWord + '\n');
    
    
    for (IndexEntry entry : index)  //assumes index is a Collection (ArrayList)
      outputFile.println(entry);

    // Finish:

    inputFile.close();
    outputFile.close();

    System.out.println("Done.");
  }
}