package org.example;

import javax.swing.text.html.Option;
import java.util.*;

public class StudentRepository {

    HashMap<Integer,Student> studentListMap = new HashMap<>();

    public boolean doesStudentExists(int id) {
        return studentListMap.containsKey(id);
    }
    public void addNewStudent(int id,String name,int age,char grade) {

        studentListMap.put(id,new Student(id,name,age,grade));

    }

    public ArrayList<Student> retrieveStudent(int id) {
        ArrayList<Student> studentList = new ArrayList<>();
        if(!doesStudentExists(id)) {
            System.out.println("No Student Found");
        }else {
            studentList.add(studentListMap.get(id));
        }
        return studentList;

    }

    public ArrayList<Student> retrieveStudent(String name) {
        ArrayList<Student> studentList = new ArrayList<>();
        for(Map.Entry<Integer,Student> entry : studentListMap.entrySet()) {
            if(entry.getValue().getStudentName().equals(name)) {
                studentList.add(entry.getValue());
            }
        }
        if(studentList.isEmpty()) {
            System.out.println("No Student Found!");
        }
        return studentList;
    }

    public void deleteStudent(int id) {
        if(!doesStudentExists(id)) {
            System.out.println("No Student Found");
        }else {
            studentListMap.remove(id);
        }
    }

    public void updateStudent(int id,String name) {
        studentListMap.get(id).setStudentName(name);
    }

    public void updateStudent(int id,int age) {
        studentListMap.get(id).setStudentAge(age);
    }

    public void updateStudent(int id,char grade) {
        studentListMap.get(id).setStudentGrade(grade);
    }

    public void updateStudent(int id,String name,int age,char grade) {
        updateStudent(id,name);
        updateStudent(id,age);
        updateStudent(id,grade);
    }

}
