package backend.handson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides a logger instance for logging purposes.
 *
 * <p>This class simplifies access to a Logback logger, ensuring consistent logging throughout the application.
 */
public class LogBack {
    static final Logger logger = LoggerFactory.getLogger(LogBack.class);

    /**
     * Prevents instantiation of this utility class.
     */
    private LogBack() {
        throw new IllegalStateException("Utility class");
    }


    public static void outputLogger(String message, String level) {

        switch (level) {
            case "DEBUG": logger.debug(message);break;
            case "INFO":  logger.info(message);break;
            case "TRACE": logger.trace(message);break;
            case "ERROR" : logger.error(message);break;
            default: logger.error("INVALID logger level!");break;
        }
    }
}