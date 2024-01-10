package shrishti.example.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class logger {
    private static final Logger logger
            = LoggerFactory.getLogger(logger.class);

    public static void printLogger(String message) {
        logger.info(message);
    }
}
