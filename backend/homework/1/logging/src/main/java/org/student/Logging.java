package org.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {

    public static final Logger logger = LoggerFactory.getLogger(Logging.class);

    public static void main(String[] args) {
        logger.warn("hello");
    }

}

