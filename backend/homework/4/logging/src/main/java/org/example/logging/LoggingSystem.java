package org.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LoggingSystem {
    private static final Logger logger = LoggerFactory.getLogger(LoggingSystem.class);

    public void logError(String log) {
        logger.error(log);
    }

    public void logInfo(String log) {
        logger.info(log);
    }

    public void logDebug(String log) {
        logger.debug(log);
    }

    public void logTrace(String log) {
        logger.trace(log);
    }

    public void logWarn(String log) {
        logger.warn(log);
    }
}
