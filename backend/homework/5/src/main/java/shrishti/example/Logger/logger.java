package shrishti.example.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class logger {
    private static final Logger Mylogger
            = LoggerFactory.getLogger(logger.class);

    public static void printOutput(String message) {
        Mylogger.info(message);
    }
    public static void printMessage(String message) {
        Mylogger.info(message);
    }

}
