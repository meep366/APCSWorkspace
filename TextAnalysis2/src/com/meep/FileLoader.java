/**
 * 
 */
package com.meep;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author jack
 *
 */
public class FileLoader {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	public static String load(String fileName) throws IOException
	{
		FileInputStream stream=null;
		
		  try {
			stream= new FileInputStream(new File(fileName));
		    FileChannel fc = stream.getChannel();
		    MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
		    /* Instead of using default, pass in a decoder. */
		    return Charset.defaultCharset().decode(bb).toString();
		  }
		  catch(FileNotFoundException fnf)
		  {
			  System.err.println(fnf.getMessage());
		  }
		  catch(IOException ioe){
			  System.err.println(ioe.getMessage());
		  }
		  finally {
		    stream.close();
		  }
		  return null;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	}
}