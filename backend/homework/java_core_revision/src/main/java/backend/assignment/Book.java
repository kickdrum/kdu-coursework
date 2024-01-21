package backend.assignment;

public class Book {
    private String title;
    private String isbn;
    private boolean checkedOut;
    private String genre;
    private boolean overDue;

    private int chechedOutCount;

    // Constructor
    public Book(String title, String isbn,String genre) {
        this.title = title;
        this.isbn = isbn;
        this.checkedOut = false;
        this.genre = genre;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public String getGenre() {

        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isOverdue() {
        return overDue;
    }
    public void setOverDue(boolean overDue){
        this.overDue = overDue;
    }

    public int getCheckOutCount() {
        return this.chechedOutCount;
    }
    public void setCheckOutCount(int newCheckedOutCount) {
         this.chechedOutCount = newCheckedOutCount;
    }
}