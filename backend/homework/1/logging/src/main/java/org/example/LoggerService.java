package org.example;

//public class LoggerService {

//}
//package org.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerService {

    private static final Logger logger = LoggerFactory.getLogger(LoggerService.class);

    public void logInfo(String message) {
        logger.info(message);
    }

    public void logError(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
}

