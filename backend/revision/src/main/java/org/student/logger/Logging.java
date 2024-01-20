package org.student.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {

    private Logging(){}
    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    public static void logInfo(String s){
        logger.info(s);
    }

    public static void logWarn(String s){
        logger.warn(s);
    }

    public static void logErr(String s){
        logger.error(s);
    }
}