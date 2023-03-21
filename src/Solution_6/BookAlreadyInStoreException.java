package Solution_6;

//Throws this exception when one wants to return a book which is already in the library
public class BookAlreadyInStoreException extends LibraryBorrowingException{
    @Override
    public void showExceptionInfo(){
        System.out.println("Sorry, this book is not borrowed.");
    }
}
