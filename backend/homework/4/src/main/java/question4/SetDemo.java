package question4;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import question3.Main;

public class SetDemo {

    private static final Logger slf4jLogger = LoggerFactory.getLogger(SetDemo.class);

    private static void hashSetDemo() {
        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("a");

        System.out.println("set1: " +  set1);

        Book book1 = new Book("Walden", "Henry Thoreau", 1854);
        Book book2 = new Book("Walden", "Henry Thoreau", 1854);
        Set<Book> set2 = new HashSet<>();
        set2.add(book1);
        set2.add(book2);
        System.out.println("set2: " +  set2);
    }

    public static Set<Book> treeSetDemo(Comparator comparator) {
        Book book1 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book2 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book3 = new Book("Walden", "Henry David Thoreau", 1854);
        Book book4 = new Book("Effective Java", "Joshua Bloch", 2008);
        Book book5 = new Book("The Last Lecture", "Randy Pausch", 2008);

        Set<Book> books = new TreeSet<>(comparator);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);


        for (Book book : books) {
            System.out.println(book);
        }

        return books;
    }

    public static void main(String[] args) {

        slf4jLogger.info("Original Books"+treeSetDemo(null));

        PubDateAscComparator asc=new PubDateAscComparator();
        slf4jLogger.info("Books in Ascending Order");

        treeSetDemo(asc);

        slf4jLogger.info("Books in Descending Order");
        PubDateDescComparator desc= new PubDateDescComparator();
        treeSetDemo(desc);

    }

}