package org.handson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLogging {
    static final Logger logger = LoggerFactory.getLogger(CustomLogging.class);

    public static Logger getLoggerCustom()
    {
        return logger;
    }
}
