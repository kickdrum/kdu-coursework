package org.example;

import java.util.Comparator;

public class PubDateAscComparator implements Comparator<Book> {


    @Override
    public int compare(Book book, Book t1) {
        if(book.getYear()>t1.getYear()){
            return 1;
        }
        else if(book.getYear()< t1.getYear()){
            return -1;
        }
        else {
            return book.getTitle().compareTo(t1.getTitle());
        }
    }
}
