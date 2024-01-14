package org.models;

import org.services.CryptoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {
    private static final Logger logger= LoggerFactory.getLogger(CryptoApplication.class);

    public static Logger getMsg(){
        return logger;
    }
}
