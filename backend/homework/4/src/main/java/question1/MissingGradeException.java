package question1;
public class MissingGradeException extends RuntimeException{
    private int studentId;
    public MissingGradeException( int studentId) {

        this.studentId = studentId;
    }
    public int getStudentId() {
        return studentId;
    }

}

