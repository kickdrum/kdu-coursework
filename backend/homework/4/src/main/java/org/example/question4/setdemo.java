package org.example.question4;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class setdemo {


    public static Set<book> treeSetDemo(Comparator comparator) {
        book book1 = new book("Harry Potter", "J.K.Rowling", 1997);
        book book2 = new book("Harry Potter", "J.K.Rowling", 1997);
        book book3 = new book("Walden", "Henry David Thoreau", 1854);
        book book4 = new book("Effective Java", "Joshua Bloch", 2008);
        book book5 = new book("The Last Lecture", "Randy Pausch", 2008);

        //Set<Book> books = null;
        Set<book> books = new TreeSet<>(comparator);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        for (org.example.question4.book book : books) {
            System.out.println(book);
        }

        return books;
    }
}