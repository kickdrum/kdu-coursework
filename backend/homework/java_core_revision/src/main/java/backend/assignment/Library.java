package backend.assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Patron> patrons = new ArrayList<>();
    private List<Book> checkedOutBooks = new ArrayList<>();

    // Methods for managing books
    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    /**
     * find all books whose checkedout field is none
     * @return List of all available books
     */
    public List<Book> findAllAvailableBooks() {
        return books.stream()
                .filter(book -> !book.isCheckedOut())
                .collect(Collectors.toList());
    }

    /**
     * Ensure the book is available for checkout
     * Verify that the patron hasn't reached their checkout limit
     * Mark the book as checked out
     * Add the book to the patron's list of checked out books
     * Add the book to the library's list of checked out books
     * @param book book to be checked out
     * @param patron patron who is checkingout the book
     */
    public void checkOutBook(Book book, Patron patron) {
        if (!book.isCheckedOut()) {
            //
            if (patron.getCheckedOutBooks().size() < patron.getCheckoutLimit()) {
                book.setCheckedOut(true);
                patron.checkOutBook(book);
                checkedOutBooks.add(book);

                LogBack.debugLogger(patron.getName() + " checked out " + book.getTitle());
            } else {
                LogBack.debugLogger("Patron has reached their checkout limit.");
            }
        } else {
            LogBack.debugLogger("Book is already checked out.");
        }
    }

    /**
     *
     * @param author take author name
     * @return List of books from author class
     */
    public List<Book> findBooksByAuthor(Author author) {
        return author.getBooks();
    }
    /**
     *
     * @return groupBooksByGenre() - returns a Map<String, List<Book>>
     */
    public Map<String, List<Book>> groupBooksByGenre() {
        // Assuming you have a getGenre() method in the Book class
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
    }
    /**
     *
     * @param topN number books required
     * @return  list of popular books
     */
    public List<Book> findPopularBooks(int topN) {
        return books.stream()
                .sorted(Comparator.comparingInt(Book::getCheckOutCount).reversed())
                .limit(topN)
                .collect(Collectors.toList());
    }

    /**
     *
     * @return List of checked out books
     */
    public List<Book> findOverdueBooks() {
        return checkedOutBooks.stream()
                .filter(Book::isOverdue)
                .collect(Collectors.toList());
    }



}
