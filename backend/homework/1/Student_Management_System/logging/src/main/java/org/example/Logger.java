package org.example;

//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logger {
    public static final org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);

    public void debugLog(String msg) {
        logger.debug(msg);
    }

    public void debugLog(String msg, Exception e) {
        logger.debug(msg,e);
    }

    public void errorLog(String msg) {
        logger.error(msg);
    }

    public void errorLog(String msg,Exception e) {
        logger.error(msg,e);
    }
}
