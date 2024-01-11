package ques4;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SetDemo {

    private static final Logger logger= LoggerFactory.getLogger(Main.class);

    /**
     *
     */
    private static void hashSetDemo() {
        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("a");

        logger.info("set1: " +  set1);

        Book book1 = new Book("Walden", "Henry Thoreau", 1854);
        Book book2 = new Book("Walden", "Henry Thoreau", 1854);
        Set<Book> set2 = new HashSet<>();
        set2.add(book1);
        set2.add(book2);
        logger.info("set2: " +  set2);
    }

    /**
     *
     * @param comparator
     * @return
     */
    public static Set<Book> treeSetDemo(Comparator comparator) {
        Book book1 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book2 = new Book("Harry Potter", "J.K.Rowling", 1997);
        Book book3 = new Book("Walden", "Henry David Thoreau", 1854);
        Book book4 = new Book("Effective Java", "Joshua Bloch", 2008);
        Book book5 = new Book("The Last Lecture", "Randy Pausch", 2008);

        Set<Book> books = new TreeSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        return books;
    }
}