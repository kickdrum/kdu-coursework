package log;

import java.util.logging.Level;
public class Log {
    private Log()
    {

    }
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(Log.class.getName());

    public static void info(String message) {
        LOGGER.log(Level.INFO, message);
    }

    public static void warning(String message) {
        LOGGER.log(Level.WARNING, message);
    }

    public static void error(String message) {
        LOGGER.log(Level.SEVERE, message);
    }
}


