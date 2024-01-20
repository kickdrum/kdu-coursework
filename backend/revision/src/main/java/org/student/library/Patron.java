package org.student.library;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private int checkoutLimit;
    private List<Book> checkedOutBooks;

    public Patron(String name, int checkoutLimit){
        this.name = name;
        this.checkoutLimit = checkoutLimit;
        this.checkedOutBooks = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCheckoutLimit() {
        return checkoutLimit;
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public void setCheckedOutBooks(List<Book> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    public void setCheckoutLimit(int checkoutLimit) {
        this.checkoutLimit = checkoutLimit;
    }
}
