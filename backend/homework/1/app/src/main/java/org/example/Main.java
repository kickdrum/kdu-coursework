package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        StudentReposittory repository = new StudentReposittory(1);

        // Adding a student
        Student newStudent1 = new Student(1, "NeerPatel", 22, 3);
        repository.addStudent(newStudent1);
        logger.fatal("Added student: {}", newStudent1.getName());
        Student newStudent2 = new Student(1, "pavan", 22, 5);
        repository.addStudent(newStudent2);
        logger.fatal("Added student: {}", newStudent2.getName());



        // Retrieving a student
        Student retrievedStudent = repository.getStudentById(1);
        if (retrievedStudent != null) {
            logger.fatal("Retrieved Student: {}", retrievedStudent.getName());
        }
    }
}