
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;


public class Main {
    public static void main(String[] args)
    {

        LogManager lgmngr = LogManager.getLogManager();

        Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);

        log.log(Level.INFO, "This is a log message");
    }
}
