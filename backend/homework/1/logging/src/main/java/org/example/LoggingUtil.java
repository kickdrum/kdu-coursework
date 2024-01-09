package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtil {
    public static final Logger logger = LoggerFactory.getLogger(LoggingUtil.class);

    public void addLog(Student student){
        logger.info("Student added: {}", student);
    }
    public void getstuid(Student stu){
        logger.info("Student retrieved by ID: {}", stu);
    }

    public void getstuname(Student stu){
        logger.info("Student retrieved by Name: {}", stu);
    }

    public void updlog(Student stu){
        logger.info("Student updated: {}", stu);
    }

}
