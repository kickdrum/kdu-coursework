package org.example;




//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
//public class LogbackHello {
//    public static final Logger slf4jLogger = LoggerFactory.getLogger(LogbackHello.class);
//
//
//
//    public static void main(String[] args) {
//        slf4jLogger.trace("Hello World!");
//
//        String name = "Abhijit";
//        slf4jLogger.debug("Hi, {}", name);
//        slf4jLogger.info("Welcome to the HelloWorld example of Logback.");
//        slf4jLogger.warn("Dummy warning message.");
//        slf4jLogger.error("Dummy error message.");
//    }
//}
//package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackHello {
    public static final Logger logger = LoggerFactory.getLogger(LogbackHello.class);

    public void logStudentAddition(Student student) {
        logger.info("Student added - ID: {}, Name: {}, Age: {}, Grade: {}", student.getId(), student.getName(), student.getAge(), student.getGrade());
    }

    public void logStudentRetrieval(int studentId) {
        logger.info("Student retrieved - ID: {}", studentId);
    }

    public void logStudentUpdate(Student student) {
        logger.info("Student updated - ID: {}, Name: {}, Age: {}, Grade: {}", student.getId(), student.getName(), student.getAge(), student.getGrade());
    }
}
