package org.student.library;

public class Book {
    private String title;
    private String isbn;
    private boolean checkedOut;
    private String genre;

    public Book(String title,String isbn,String genre){
        this.checkedOut = false;
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
