package org.example;

public class MissingGradeException extends Exception{

    private int studentId;

    MissingGradeException(int studentId){
        this.studentId=studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Exception occurred as there is a missing grade for student "+getStudentId();
    }
}

