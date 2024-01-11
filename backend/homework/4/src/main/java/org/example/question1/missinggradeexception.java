package org.example.question1;

public class missinggradeexception extends Exception {
    int studentId = 0;

    public missinggradeexception(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }
}
