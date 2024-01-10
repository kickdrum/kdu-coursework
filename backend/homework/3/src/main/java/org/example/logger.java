package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class logger {
    private static final Logger logger = LoggerFactory.getLogger(logger.class);

    public void logInfo(String message) {
        logger.info(message);
    }

}

