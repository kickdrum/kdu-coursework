package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LoggerClass {
    private static final Logger logger = LoggerFactory.getLogger(LoggerClass.class);

    /**
     * @param msg
     * @param logLevel
     */
    public void getLoggerOutput(String msg, String logLevel) {
        switch (logLevel) {
            case "error":
                logger.error(msg);
                break;
            case "warn":
                logger.warn(msg);
                break;
            case "info":
                logger.info(msg);
                break;
            case "debug":
                logger.debug(msg);
                break;
            case "trace":
                logger.trace(msg);
                break;
            default:
                logger.info("Default log");
                break;
        }
    }
}