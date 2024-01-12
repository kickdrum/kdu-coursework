package kdu.homework;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logs {

    // loggerFactory instance
    public static final Logger logger = LoggerFactory.getLogger(Logs.class);

    // @overloaded - to log int
    public void console(int s){
        String string = Integer.toString(s);
        logger.info(string);
    }

    // @overloaded - to log string
    public void console(String s){
        logger.info(s);
    }
}
