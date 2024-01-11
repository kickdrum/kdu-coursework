package ques4;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Set;

public class Main {
    private static final Logger logger= LoggerFactory.getLogger(Main.class);

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        logger.info("\nTest case - i:");
        Set<Book> result1 = SetDemo.treeSetDemo(new PubDateAscComparator());
        printBooks(result1);

    }

    /**
     *
     * @param books
     */
    private static void printBooks(Set<Book> books) {
        logger.info("\n");
        for (Book book : books) {
            logger.info("{}",book);
        }
    }
}
