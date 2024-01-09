package org.example;

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

    /**
     * Returns the shared logger instance for use throughout the application.
     *
     * @return The Logback logger instance.
     */
    public static Logger filelogger(){
        return logger;
    }


}
