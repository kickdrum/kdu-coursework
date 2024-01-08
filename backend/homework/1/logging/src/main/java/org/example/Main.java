package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Logback {
    private static final Logger LOGGER = LoggerFactory.getLogger(Logback.class);

    public static void main(String[] args) {
        LOGGER.info("This is an INFO level log message!");
        LOGGER.error("This is an ERROR level log message!");
    }
    public static Logger getMsg(){
        return LOGGER;
    }
}
