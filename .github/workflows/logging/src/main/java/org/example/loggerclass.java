package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class loggerclass {
    public static final Logger logger = LoggerFactory.getLogger(loggerclass.class);

    public void AddStudent(Student student) {
        logger.info("Student added - ID: {}, Name: {}, Age: {}, Grade: {}", student.getID(), student.getName(), student.getAge(), student.getGrade());
    }

    public void RetrieveStudent(int studentId) {
        logger.info("Student retrieved - ID: {}", studentId);
    }

    public void UpdateStudent(Student student) {
        logger.info("Student updated - ID: {}, Name: {}, Age: {}, Grade: {}", student.getID(), student.getName(), student.getAge(), student.getGrade());
    }
}





