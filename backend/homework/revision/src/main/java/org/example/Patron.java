package org.example;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private int checkoutLimit;

    public String getName() {
        return name;
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

    public void setCheckedOutBooks(List<Book> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    public Patron(String name, int checkoutLimit) {
        this.name = name;
        this.checkoutLimit = checkoutLimit;
    }

    private List<Book> checkedOutBooks = new ArrayList<>(0);
// add constructor and getter and setter methods
}