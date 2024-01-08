package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        System.out.println( "Hello, user!" );
        logger.trace("Hello");
        logger.debug("Hello");
        logger.info("Hello");
        logger.warn("Hello");
        logger.error("Hello");
        logger.fatal("Hello");
    }
}

