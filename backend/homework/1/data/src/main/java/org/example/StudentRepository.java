package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StudentRepository {

    loggerApp lg=new loggerApp();
    ArrayList<Student> students = new ArrayList<>();
    public void add(Student student){
        students.add(student);
        lg.logger("Data added successfully");
    }
    public Student retrieve(int id){
        for(Student st:students){
            if(st.getID()==id){
                lg.logger("Retrieval done successfully through ID");
                return st;
            }
        }
        lg.logger("retrieval through ID not done");
        return null;
    }
    public Student retrieve(String name){
        for(Student st:students){
            if(st.getName().equalsIgnoreCase(name)){
                lg.logger("Retrieval done successfully through name");
                return st;
            }
        }
        lg.logger("retrieval through name not done");
        return null;
    }

    public void update(int id,Student student){
        for(Student st:students){
            if(st.getID()==id){
                st.setId(student.getID());
                st.setName(student.getName());
                st.setGrade(student.getGrade());
                st.setAge(student.getAge());
                lg.logger("Updation Done Successfully");
            }
        }
    }
}
