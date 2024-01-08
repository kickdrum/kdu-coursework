package org.example;
import java.util.*;
public class StudentRepository{
    ArrayList<Student> studentList;

    {
        studentList = new ArrayList<Student>();
    }

    public StudentRepository(){
        this.studentList = new ArrayList<>();
    }

    void addStudentDetails(Student newStud){
        studentList.add(newStud);
    }

    Student retrieveStudentDetails(int studID){
        for(Student student: studentList){
            if(studID == student.get_ID()){
                return student;
            }
        }
        return null;
    }

    Student retrieveStudentDetails(int studID, String studName){
        for(Student student: studentList){
            if(studID == student.get_ID() && Objects.equals(studName, student.get_name())){
                return student;
            }
        }
        return null;
    }

    void updateStudentDetails(int studID, String studName, int studAge, String studGrade){
        for(Student student: studentList){
            if(studID == student.get_ID()){
                student.set_age(studAge);
                student.set_name(studName);
                student.set_grade(studGrade);
            }
        }
    }
}
