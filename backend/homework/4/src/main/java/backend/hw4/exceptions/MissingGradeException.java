package backend.hw4.exceptions;


/*creating a custom "checked" exception and will throw it from within calculateGPA. */
public class MissingGradeException extends Exception{

    private final int studentId;
    MissingGradeException(int studentId){
        this.studentId = studentId;
    }

    public int getStudentId(){
        return studentId;
    }

}
