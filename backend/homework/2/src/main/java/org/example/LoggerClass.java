package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerClass {
    static final Logger logger = LoggerFactory.getLogger(LoggerClass.class);
    public static Logger getLoggerOutput()
    {
        return logger;
    }
}
