package backend.assignment;

import java.util.List;
import java.util.ArrayList;

public class Patron {
    private String name;
    private int checkoutLimit;
    private List<Book> checkedOutBooks;
    public String getName() {
        return name;
    }
    public Patron(String name, int checkoutLimit) {
        this.name = name;
        this.checkoutLimit = checkoutLimit;
        this.checkedOutBooks = new ArrayList<>();
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getCheckoutLimit() {
        return checkoutLimit;
    }

    public void setCheckoutLimit(int checkoutLimit) {
        this.checkoutLimit = checkoutLimit;
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }
    public void checkOutBook(Book book) {
        if (checkedOutBooks.size() < checkoutLimit && !book.isCheckedOut()) {
            checkedOutBooks.add(book);
            book.setCheckedOut(true);
        } else {
            LogBack.debugLogger("Patron cannot check out any more books.");
        }
    }

    public void checkInBook(Book book) {
        if (checkedOutBooks.contains(book)) {
            checkedOutBooks.remove(book);
            book.setCheckedOut(false);
        } else {
           LogBack.debugLogger("Patron cannot check in a book they did not check out.");
        }
    }
}
