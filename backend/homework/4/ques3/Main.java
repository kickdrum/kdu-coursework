package ques3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(ques2.Main.class);

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        ExchangePositions exchangePositions=new ExchangePositions();
        Integer[] intArray = {22,4,67,88,2};
        logger.info("Before swapping: " + Arrays.toString(intArray));
        exchangePositions.swapElements(intArray, 1, 3);
        logger.info("After swapping: " + Arrays.toString(intArray));


        String[] strArray = {"hp","sony","apple","lenovo"};
        logger.info("Before swapping: " + Arrays.toString(strArray));
        exchangePositions.swapElements(strArray, 0, 2);
        logger.info("After swapping: " + Arrays.toString(strArray));

//        String[] strArray={};
//        logger.info("Before swapping: " + Arrays.toString(strArray));
//        exchangePositions.swapElements(strArray, 0, 2);
//        logger.info("After swapping: " + Arrays.toString(strArray));

    }
}
