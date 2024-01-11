package org.example;

public class MissingGradeException extends Exception {

    private final int studentId;

    public MissingGradeException(int studentId) {
        super("Missing grade for student with ID: " + studentId);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }
}