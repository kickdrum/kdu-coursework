package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBack {
    private static final Logger slf4jLogger = LoggerFactory.getLogger(LogBack.class);

    public static void main(String[] args) {

        slf4jLogger.info("Welcome to the first homework of Backend done by Prashant");

    }
}