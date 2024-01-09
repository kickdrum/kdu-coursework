package org.example;
import java.util.*;

public class StudentRepository {
    private final List<Student> students;

    public StudentRepository(){
        students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public Student getStudent(int id){
        for(Student stu : students){
            if(stu.getId() == id) {
                return stu;
            }
        }
        System.out.println("Student not found!");
        return null;
    }

    public Student getStudent(String name){
        for(Student stu : students){
            if(Objects.equals(stu.getName(), name)) {
                return stu;
            }
        }
        System.out.println("Student not found!");
        return null;
    }

    public boolean update(Student up){
        for(int i = 0;i < students.size();i++){
            if(students.get(i).getId() == up.getId()){
                students.set(i, up);
                return true;
            }
        }
        return false;
    }
}












