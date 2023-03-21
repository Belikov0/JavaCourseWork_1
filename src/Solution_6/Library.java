package Solution_6;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

//Describes a library with function of borrowing and returning books
public class Library {
	/*
		Uses hashmap to store book
		the key is book's title
		the value is the instance of class Book defined by its title
	 */
	private String addr;	//The address of the library
	private final HashMap<String, Book> storedBooks;

	//constructors
	Library(){
		//initializes storedBooks
		storedBooks = new HashMap<String, Book>();
	}
	Library(String _addr){
		this.addr = _addr;
		//initializes storedBooks
		storedBooks = new HashMap<String, Book>();
	}

	//Adds book into current library
	public void addBook(Book _b){
		storedBooks.put(_b.getTitle(), _b);
	}

	//Getter
	public String getAddr(){
		return this.addr;
	}

	//Prints the address of current library
	public void printAddress(){
		System.out.println(this.getAddr());
	}

	//Borrows a book by title
	public void borrowBook(String _bookTitle) throws LibraryBorrowingException {
		try {
			//If the title is not found, throw an exception
			searchBook(_bookTitle);
			//Judge the book whether is borrowed or not
			Book curBook = storedBooks.get(_bookTitle);
			if (curBook.isBorrowed()){
				throw new BookBorrowingNotAvailableException();
			}else {
				curBook.borrowed((new Date()).toString());
				System.out.println("You successfully borrowed " + curBook.getTitle());
			}
		} catch (BookNotInCatalogException e){
			//Handles the exception that the targeted book is not in catalog
			e.showExceptionInfo();;
		} catch (BookBorrowingNotAvailableException e){
			//Handles the exception that the book is already borrowed
			e.showExceptionInfo();;
		}
	}

	//Prints available books in current library
	public void printAvailableBooks(){
		ArrayList<Book> availableBooks = new ArrayList<Book>();
		//if the book is not borrowed, add it into waiting list for printing
		for (Book b : storedBooks.values()){
			if (!b.isBorrowed()){
				availableBooks.add(b);
			}
		}
		for (Book b : availableBooks){
			System.out.println(b.getTitle());
		}
	}

	//Returns a book by its title
	public void returnBook(String _bookTitle) throws LibraryBorrowingException {
		try{
			//Search if the book is in catalog
			searchBook(_bookTitle);
			//Judge if the book is borrowed
			Book curBook = storedBooks.get(_bookTitle);

			if (!curBook.isBorrowed()){
				throw new BookAlreadyInStoreException();
			}else{
				System.out.println("You successfully returned " + curBook.getTitle());
				curBook.returned((new Date()).toString());
			}
		}catch (BookNotInCatalogException e){
			//Handles the exception that the targeted book is not in catalog
			e.showExceptionInfo();
		}catch (BookAlreadyInStoreException e){
			//Handles the exception that the targeted book is already in the library
			e.showExceptionInfo();
		}
	}

	//search a book by title whether it is in catalog
	public void searchBook(String _bookTitle) throws LibraryBorrowingException {
		// if the title is not in the list, throw an exception
		if (!storedBooks.containsKey(_bookTitle)){
			throw new BookNotInCatalogException();
		}
	}

	//print opening time
	static public void printOpeningHours(){
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}

	@Override //override toString method
	public String toString(){
		return this.getAddr() + "\n" + this.storedBooks.toString();
	}

	// Add the missing implementation to this class 
	public static void main(String[] args) throws LibraryBorrowingException {
		// Create two libraries 
		Library firstLibrary = new Library("10 Main St."); 
		Library secondLibrary = new Library("228 Liberty St."); 
		
		//Add four books to the first library 
		firstLibrary.addBook(new Book("The Da Vinci Code","2011-12-24"));
		firstLibrary.addBook(new Book("Le Petit Prince","2013-10-24"));
		firstLibrary.addBook(new Book("A Tale of Two Cities","2013-10-24"));
		firstLibrary.addBook(new Book("The Lord of the Rings","2011-12-24"));

		// Print opening hours and the addresses 
		System.out.println("Library hours:");
		printOpeningHours();
		System.out.println();
		System.out.println("Library addresses:");
		firstLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();

		// Try to borrow The Lords of the Rings from both libraries 
		System.out.println("Borrowing The Lord of the Rings:");
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		secondLibrary.borrowBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of all available books from both libraries 
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.printAvailableBooks();
		System.out.println();

		//Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:"); 
		firstLibrary.returnBook("The Lord of the Rings"); 
		System.out.println(); 
		// Print the titles of available from the first library 
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
		System.out.println();
	}
}
