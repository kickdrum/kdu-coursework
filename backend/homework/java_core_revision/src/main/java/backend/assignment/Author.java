package backend.assignment;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private List<Book> books;

    // Constructor
    public Author(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
