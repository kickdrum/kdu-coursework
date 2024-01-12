package kdu.homework;

public class MissingGradeException extends Exception{
    private final int studentId;

    public MissingGradeException(int studentId){
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String toString(){
        return("missingGradeException: GPAs must be computed only after all students have received grades, Grades not found for student " + getStudentId());
    }
}
