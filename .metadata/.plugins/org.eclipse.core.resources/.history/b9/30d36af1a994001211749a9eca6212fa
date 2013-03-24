/**
 * @author Bill O'Donoghue
 * Date of Completion: 3/21/13
 * All work here is honestly obtained and is my own
 * Errata:
 */
public class Person  implements Comparable<Person>
{
	private String firstName;
	private String lastName;

	public Person(String fName, String lName) {
		firstName = fName;
		lastName = lName;
	}
	
	/**
	 * The priority for sorting two people is their last names first
	 * and then their first names
	 * Therefore, the two names are concatenated, last then first, and the String class's compareTo
	 * method is used to compare the two combined Strings
	 */
	public int compareTo(Person other) {
		String thisName = lastName + firstName;
		String otherName = other.lastName + other.firstName;
		return thisName.compareTo(otherName);
	}
}