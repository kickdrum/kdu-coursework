package org.example;

import org.example.logging.LoggingSystem;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
public class SetDemo {
    static final LoggingSystem ls = new LoggingSystem();
    public static Set<Book> treeSetDemo(Comparator<Book> comparator) {
        Book book1 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book2 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book3 = new Book("Walden", "Henry David Thoreau", 1854);
        Book book4 = new Book("Effective Java", "Joshua Bloch", 2008);
        Book book5 = new Book("The Last Lecture", "Randy Pausch", 2008);
        Set<Book> books;
        if (comparator == null) {
            books = new TreeSet<>();
        } else {
            books = new TreeSet<>(comparator);
        }
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        for (Book book : books) {
            ls.logInfo(String.valueOf(book));
        }
        return books;
    }
    public static void main(String[] args) {
        treeSetDemo(null);
        // Ascending order of PubDateAscComparator
        ls.logInfo("\n Increasing Order :");
        treeSetDemo(new PubDateAscComparator());
        // Descending order of PubDateDescComparator
        ls.logInfo("\n Decreasing Order :");
        treeSetDemo(new PubDateDescComparator());
    }
}