package question3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Main {
    private static final Logger slf4jLogger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        slf4jLogger.info("Before swapping: " + Arrays.toString(intArray));
        ExchangePositions.swapElements(intArray, 1, 3);
        slf4jLogger.info("After swapping: " + Arrays.toString(intArray));

    }
}
