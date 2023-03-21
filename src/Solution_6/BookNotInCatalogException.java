package Solution_6;

//Throws this exception when one wants a book which is not in library's catalog
public class BookNotInCatalogException extends LibraryBorrowingException{
    @Override
    public void showExceptionInfo(){
        System.out.println("Sorry, this book is not in our catalog.");
    }
}
