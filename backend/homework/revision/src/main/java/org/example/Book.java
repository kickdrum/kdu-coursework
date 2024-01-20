package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book {
    private String title;
    private int isbn;
    private boolean checkedOut;
    private int checkedOutCount;
    private String genre;

    public Book(String title, int isbn, boolean checkedOut, String genre) {
        this.title = title;
        this.isbn = isbn;
        this.checkedOut = checkedOut;
        this.checkedOutCount = 0;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCheckedOutCount() {
        return checkedOutCount;
    }
    public void setCheckedOutCount(Book book, int checkedOutCount) {
        book.checkedOutCount = checkedOutCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
// add constructor and getter and setter methods
}