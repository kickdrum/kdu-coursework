package kdu.homework;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

    public static Logs logger = new Logs();

    public static Set<Book> treeSetDemo(Comparator comparator) {

        Book book1 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book2 = new Book("The Last Lecture", "Randy Pausch", 2008);
        Book book3 = new Book("Walden", "Henry David Thoreau", 1854);
        Book book4 = new Book("Effective Java", "Joshua Bloch", 2008);

        Set<Book> books = new TreeSet<>(comparator);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        Logs logger = new Logs();

        logger.console("\n\nSorted Tree: \n");
        for (Book book : books) {
            logger.console(book.toString());
        }

        return books;
    }

    public static void main(String[] args) {
        //hashSetDemo();
        PubDateAscComparator pubDateAscComparator = new PubDateAscComparator();
        PubDateDescComparator pubDateDescComparator = new PubDateDescComparator();

        treeSetDemo(pubDateAscComparator);
        treeSetDemo(pubDateDescComparator);
    }

}