package handson.partfive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessingLogs {
    private static final Logger logger = LoggerFactory.getLogger(ProcessingLogs.class);

    public void displayLogs(String msg){
        logger.info(msg);
    }
}
