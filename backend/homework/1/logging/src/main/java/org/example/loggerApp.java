package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class loggerApp {
    Logger logger=LoggerFactory.getLogger(loggerApp.class);

    public void logger(String msge){
        logger.debug(msge);
    }
}
