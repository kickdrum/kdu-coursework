package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class logger {
    Logger logger=LoggerFactory.getLogger(logger.class);


    public void CreateLog(String loggerMessage)
    {
        logger.debug(loggerMessage);
    }
}
