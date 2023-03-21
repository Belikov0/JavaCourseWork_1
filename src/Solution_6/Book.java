package Solution_6;

//Describes a book and its status in a library
public class Book {
    private String title;
    private String date;
    private boolean borrowed;

    // Creates a new Book with book entry time
    public Book(String bookTitle, String bookDate) {
        // Implement this method
        this.title = bookTitle;
        this.date = bookDate;
    }

    // Marks the book as rented and updates the date to borrowed date
    public void borrowed(String brwDate) {
        // Implement this method
        this.date = brwDate;
        this.borrowed = true;
    }

    // Marks the book as not rented and updates the returned date
    public void returned(String rtnDate) {
        // Implement this method
        this.date = rtnDate;
        this.borrowed = false;
    }

    // Returns true if the book is rented, false otherwise
    public boolean isBorrowed() {
        // Implement this method
        return this.borrowed;
    }

    // Returns the title of the book
    public String getTitle() {
        // Implement this method
        return this.title;
    }

    //Returns the date of the book
    public String getDate() {
        // Implement this method
        return this.date;
    }

    @Override
    public String toString(){
        return getTitle() + ", "
                + (isBorrowed() ? "borrowed, " : "available, ")
                + getDate();
    }

    public static void main(String[] args) {
        // Small test of the Book class
        Book example = new Book("The Da Vinci Code", "2002-01-19");
        System.out.println("Title (should be The Da Vinci Code): "
                + example.getTitle() + ", "
                + example.getDate());
        System.out.println("Borrowed? (should be false): "
                + example.isBorrowed()
                + ", book entry time: "
                + example.getDate());
        example.borrowed("2011-10-25");
        System.out.println("Borrowed? (should be true): "
                + example.isBorrowed()
                + ", borrowed on "
                + example.getDate());
        example.returned("2011-12-06");
        System.out.println("Borrowed? (should be false): "
                + example.isBorrowed()
                + ", returned on "
                + example.getDate());
    }
}

