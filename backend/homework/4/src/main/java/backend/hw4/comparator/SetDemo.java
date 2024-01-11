package backend.hw4.comparator;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SetDemo {

    private static final Logger logger = LoggerFactory.getLogger(SetDemo.class);

    /**This treeSetDemo method showcs the application of a TreeSet to store and sort a collection of Book objects
     * This method accepts a Comparator<Book> for customizable sorting criteria,here the main steps are creating Book instances, adding them to the TreeSet, and logging Book details using SLF4J.
     * The logged output, including title, author, and publication year, reflects the sorted order based on the provided comparator or natural ordering if null.
     * Overall, it illustrates the TreeSet's role in maintaining a sorted Book collection.
     * @param comparator
     */
    public static void treeSetDemo(Comparator<Book> comparator) {
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
            logger.info("Book [title={}, author={}, year={}]", book.getTitle(), book.getAuthor(), book.getYear());
        }
    }

    public static void main(String[] args) {
        logger.info("\nBooks in Normal Order");
        treeSetDemo(null);
        logger.info("\nBooks in Ascending Order");
        treeSetDemo(new PubDataAscComparator());
        logger.info("\nBooks in Descending Order");
        treeSetDemo(new PubDataDscComparator());
    }
}
