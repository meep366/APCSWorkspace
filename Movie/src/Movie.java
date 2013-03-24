import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class Movie {
//(FOR MOVIECOMPARATOR: 1 = Director, 2 = numactors)
private String title;
private Person director;
private ArrayList<Person> actors;

	public Movie(String title1, ArrayList<Person> actors1, Person director)
	{
		title = title1;
		this.director=director;
		actors = actors1;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public Person getDirector()
	{
		return director;
	}
	
	public ArrayList<Person> getActors()
	{
		return actors;
	}
	
	public int getNumActors()
	{
		return actors.size();
	}
	
	public String toString()
	{
		return title;
	}
	
}

