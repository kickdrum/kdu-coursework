package org.example.ques1;
public class MissingGradeException extends RuntimeException{
    private int studentId;

    /**
     *
     * @param studentId
     */
    public MissingGradeException( int studentId) {
        this.studentId = studentId;
    }

    /**
     *
     * @return
     */
    public int getStudentId() {
        return studentId;
    }
}