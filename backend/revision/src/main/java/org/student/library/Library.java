package org.student.library;

import org.student.logger.Logging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Patron> patrons = new ArrayList<>();
    private List<Book> checkedOutBooks = new ArrayList<>();

    public void setCheckedOutBooks(List<Book> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setPatrons(List<Patron> patrons) {
        this.patrons = patrons;
    }

    public List<Book> findAllAvailableBooks() {
        return books.stream()
                .filter(book -> !book.isCheckedOut())
                .toList();
    }

    public void checkOutBook(Book book, Patron patron) {
        if (!book.isCheckedOut()) {
            book.setCheckedOut(true);
            List<Book> booksPatron = patron.getCheckedOutBooks();
            books.add(book);
            patron.setCheckedOutBooks(booksPatron);
            checkedOutBooks.add(book);
            Logging.logInfo("Book checked out successfully!");
        }
        else{
            Logging.logInfo("Error in checking out book!");
        }
    }

    public List<Book> findBooksByAuthor(Author author) {
        try{
            return author.getBooks();
        }catch (NullPointerException e){
            Logging.logInfo(e.getMessage());
        }
        return Collections.emptyList();
    }

    public List<Book> findOverdueBooks() {
        return checkedOutBooks;
    }

    public List<Book> findPopularBooks(int topN) {
        Map<Book, Long> checkoutFrequency = checkedOutBooks.stream()
                .collect(Collectors.groupingBy(book -> book, Collectors.counting()));

        return checkoutFrequency.entrySet().stream()
                .sorted(Map.Entry.<Book, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, List<Book>> groupBooksByGenre() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
    }

    public Book findBook(String title){
        for(Book book : books){
            if(book.getTitle().equals(title))   return book;
        }
        return null;
    }

    public Patron findPatron(String name){
        for(Patron patron : patrons){
            if(patron.getName().equals(name))   return patron;
        }
        return null;
    }

    public Author findAuthor(String name){
        for(Author author : authors){
            if(author.getName().equals(name))   return author;
        }
        return null;
    }
}
