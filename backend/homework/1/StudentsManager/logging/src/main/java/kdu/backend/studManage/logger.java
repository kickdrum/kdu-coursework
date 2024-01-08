package kdu.backend.studManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class logger {
    Logger log = LoggerFactory.getLogger(logger.class);
    public void logmsg(String msg){
        log.info(msg);
    }
}
