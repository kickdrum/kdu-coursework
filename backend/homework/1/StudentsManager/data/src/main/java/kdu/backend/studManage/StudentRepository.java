package kdu.backend.studManage;
import java.util.Map;
import java.util.HashMap;
public class StudentRepository {
    Map<Integer,Student> students = new HashMap<Integer,Student>();
    Map<String,Integer> nameToIdMap = new HashMap<String,Integer>();

    logger lg = new logger();
    void addStudent(Student stud){
        lg.logmsg("user choose to add student");
        students.put(stud.getId(),stud);
        nameToIdMap.put(stud.getName().toLowerCase(),stud.getId());
        lg.logmsg("Student added");
    }
    Student getStudent(int id){
        lg.logmsg("user choose to retrieve student by id");
        Student stud = students.getOrDefault(id,null);
        if(stud==null) lg.logmsg("No Student Found");
        else lg.logmsg("Student retrieved successfully");
        return stud;
    }

    Student getStudent(String name){
        lg.logmsg("user choose to retrieve student by name");
        int id = nameToIdMap.getOrDefault(name.toLowerCase(),-1);
        Student stud = students.getOrDefault(id,null);
        if(stud==null) lg.logmsg("No Student Found");
        else lg.logmsg("Student retrieved successfully");
        return stud;
    }

    void updateStudent(Student stud,int id){
        lg.logmsg("user choose to update student");
        Student st = getStudent(id);
        if(st==null) lg.logmsg("No such student");
        else lg.logmsg("Updating successful");
        students.put(id,stud);
    }

    void printStudent(Student st){
        System.out.println(st.getId()+" "+st.getName()+" "+st.getAge()+" "+st.getGrade());
    }
}
