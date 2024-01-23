package com.example.demo.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logging utility class providing a common logger for the application.
 */
public class Logging {
    private Logging() {
        Logging.getmsg().info("Logging created");
    }

    public static final Logger logger = LoggerFactory.getLogger(Logging.class);

    // Logger function to use in other modules
    public static Logger getmsg() {
        return logger;
    }
}
