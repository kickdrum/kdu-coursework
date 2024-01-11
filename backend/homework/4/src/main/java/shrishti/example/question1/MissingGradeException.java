package shrishti.example.question1;

public class MissingGradeException extends Exception {
    private final int studentId;

    MissingGradeException(int studentId) {
        this.studentId = studentId;
    }
    public int getStudentId() {
        return studentId;
    }

}
