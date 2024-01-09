package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBack {
     static final Logger logger = LoggerFactory.getLogger(LogBack.class);

    private LogBack() {
        throw new IllegalStateException("Utility class");
    }

    public static Logger filelogger(){
        return logger;
    }


}
