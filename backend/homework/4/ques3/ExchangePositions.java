package ques3;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExchangePositions {
    private static final Logger logger = LoggerFactory.getLogger(ques2.Main.class);

    /**
     *
     * @param array
     * @param firstIndex
     * @param secondIndex
     * @param <T>
     */
    public  <T> void swapElements(T[] array, int firstIndex, int secondIndex) {
        if (array == null || firstIndex < 0 || firstIndex >= array.length || secondIndex < 0 || secondIndex >= array.length) {

            logger.info("Invalid input: Unable to swap elements.");
            return;
        }

        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

}
