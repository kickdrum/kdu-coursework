package org.handson.question4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

enum LogLevel
{
    DEBUG,
    INFO,
    ERROR
}
public class MyLogger {
    private MyLogger(){}

    /**
     * @param message Message to be passed to the logger
     * @param type Type of the message passed to the logger
     */
    static void customLogger(String message, String type) {

        switch (LogLevel.valueOf(String.valueOf(type).toUpperCase()))  {
            case ERROR -> logger.error(message);
            case DEBUG -> logger.debug(message);
            default -> logger.info(message);
        }
    }
    /**
     * A function that logs a message based on the specified log level.
     *
     * @param  messageDouble  the message to be logged as a Double
     * @param  type           the log level as a String
     */
    static void customLogger(Double messageDouble, String type) {
    String message = messageDouble.toString();
        switch (LogLevel.valueOf(String.valueOf(type).toUpperCase()))  {
            case ERROR -> logger.error(message);
            case DEBUG -> logger.debug(message);
            default -> logger.info(message);
        }
    }

    private static Logger logger = LoggerFactory.getLogger(MyLogger.class);
}
