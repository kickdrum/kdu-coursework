package org.example;

import java.util.logging.Logger;

public class Logging {
    private static final Logger log = Logger.getLogger(Logging.class.getName());
    public static void print(String s){
        log.info(s);
    }
    public static void main(String args[]){
        log.info("hello");
    }
}
