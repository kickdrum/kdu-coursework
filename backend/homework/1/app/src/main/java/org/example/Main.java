package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        StudentReposittory repository = new StudentReposittory(1);

        // Adding a student
        Student newStudent = new Student(1, "Bhuvan", 20, 3);
        repository.addStudent(newStudent);
        logger.fatal("Added student: {}", newStudent.getName());



        // Retrieving a student
        Student retrievedStudent = repository.getStudentById(1);
        if (retrievedStudent != null) {
            logger.fatal("Retrieved Student: {}", retrievedStudent.getId());
        }
    }
}