package org.example;


import java.util.logging.*;


public class logService {

    private static final Logger LOGGER = Logger.getLogger(logService.class.getName());

    public void initializeLogger() {
        try {
            // Create a file handler for logging
            Handler fileHandler = new FileHandler("log.txt");
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);

            // Set the logger level (you can adjust the level based on your needs)
            LOGGER.setLevel(Level.ALL);

            // Log a message to indicate that the logger has been initialized
            LOGGER.info("Logger initialized successfully.");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error initializing logger", e);
        }
    }
}