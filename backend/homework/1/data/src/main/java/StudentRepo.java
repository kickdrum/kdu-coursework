import java.util.*;
//import org.backend1.*;
public class StudentRepo {

//    multiple student objects
    private Student[] st;
    private int index;

    public StudentRepo(int size){
        st = new Student[size];
        index = 0;
    }

    // methods to add, update and retreive

    public void addStudent(Student obj)
    {
        // checking repo size
        if(index < st.length - 1){
            st[index++] = obj;
        }else System.out.println("Repository Full");
    }

    public void updateStudent(Student obj, int idx)
    {
        if(idx < st.length - 1) st[idx] = obj;
        else System.out.println("Update not Possible, out of bounds");
    }

    public Student retrieveDetails(int id){
        for (Student student : st) {
            if (student != null && student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student retrieveDetails(String name){
        for (Student student : st) {
            if (student != null && student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

}
