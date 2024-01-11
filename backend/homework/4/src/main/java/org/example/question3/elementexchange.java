package org.example.question3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class elementexchange {

    private static final Logger logger = LoggerFactory.getLogger(elementexchange.class);

    public static <T> void exchangeElements(T[] array, int index1, int index2) {
        if (array == null || index1 < 0 || index2 < 0 || index1 >= array.length || index2 >= array.length) {
            logger.error("Invalid array or indices");
            throw new IllegalArgumentException("Invalid array or indices");
        }

        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        logger.info("Original Integer Array: {}", Arrays.toString(intArray));


        exchangeElements(intArray, 1, 2);
        logger.info("Array after exchanging elements: {}", Arrays.toString(intArray));


        String[] strArray = {"Raghav", "nandwana", "is", "a"};
        logger.info("Original String Array: {}", Arrays.toString(strArray));


        exchangeElements(strArray, 0, 2);
        logger.info("Array after exchanging elements: {}", Arrays.toString(strArray));
    }
}
