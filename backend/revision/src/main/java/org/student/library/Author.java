package org.student.library;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private List<Book> books;

    public Author(String name){
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
