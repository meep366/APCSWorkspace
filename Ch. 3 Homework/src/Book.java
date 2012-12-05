/**
 * 
 */

/**
 * @author croftj
 *
 */


public class Book {
private int numPages;
private int currentPage;
	
	public Book(int nextPage){
		numPages = nextPage;
		currentPage = 1;
		
	}
	public int getNumPages(){
		return numPages;
	}
	public int currentPage(){
		return currentPage;
	}
	public void nextPage(){
		if (currentPage < numPages)
			currentPage++;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b = new Book (3);
		b.nextPage();
		System.out.println(b.currentPage());
		b.nextPage();
		System.out.println(b.currentPage());
		b.nextPage();
		System.out.println(b.currentPage());
	}

}
