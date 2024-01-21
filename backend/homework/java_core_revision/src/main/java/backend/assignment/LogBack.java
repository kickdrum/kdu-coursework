package backend.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LogBack {
    static final Logger logger = LoggerFactory.getLogger(LogBack.class);

    /**
     * Prevents instantiation of this utility class.
     */
    private LogBack() {
        throw new IllegalStateException("Logging Class");
    }

    public static void infoLogger(String message) {
        logger.info(message);
    }

    public static void debugLogger(String message) {
        logger.debug(message);
    }

    public static void errorLogger(String message) {
        logger.error(message);
    }

    public static void traceLogger(String message) {
        logger.trace(message);
    }
}

