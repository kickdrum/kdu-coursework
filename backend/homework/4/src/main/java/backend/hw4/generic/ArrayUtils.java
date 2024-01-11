package backend.hw4.generic;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ArrayUtils {

    private static final Logger logger = LoggerFactory.getLogger(ArrayUtils.class);


    /**
     * Generic method that is implemented to exchange the positions of 2 elements irrespective of their type as we are exchanging the integer array also and the string array too.
     * @param array
     * @param index1
     * @param index2
     * @param <T>
     */
    public static <T> void exchangeElements(T[] array, int index1, int index2) {
        if (index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
            logger.warn("Invalid indices. Please provide valid indices within the array size.");
            return;
        }

        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


    public static void main(String[] args) {

        //for integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        String intArrayStr = Arrays.toString(intArray);
        logger.info("Original Integer array: {}" ,intArrayStr);
        exchangeElements(intArray, 1, 3);
        intArrayStr = Arrays.toString(intArray);
        logger.info("After exchanging elements: {}",intArrayStr );

        //for string array
        String[] strArray = {"apple", "banana", "cherry", "date", "elderberry"};
         String arrayStr = Arrays.toString(strArray);
        logger.info("Original String array: {}",arrayStr);
        exchangeElements(strArray, 0, 4);
        arrayStr = Arrays.toString(strArray);
        logger.info("Original Integer array: {}", arrayStr);

    }
}

