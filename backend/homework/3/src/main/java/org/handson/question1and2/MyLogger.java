package org.handson.question1and2;
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
     * Logs a message with a specified type.
     *
     * @param  messageDouble  the message to be logged as a double
     * @param  type           the type of log level (e.g., "ERROR", "INFO", "DEBUG")
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
