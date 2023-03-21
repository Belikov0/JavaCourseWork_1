package Solution_6;

//Throws this exception when one wants to borrow a book which is already borrowed
public class BookBorrowingNotAvailableException extends LibraryBorrowingException{
    @Override
    public void showExceptionInfo(){
        System.out.println("Sorry, this book is already borrowed.");
    }
}
