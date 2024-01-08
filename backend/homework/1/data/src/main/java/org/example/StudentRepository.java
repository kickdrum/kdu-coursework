package org.example;

import java.util.ArrayList;

public class StudentRepository {

    private final ArrayList<Student> students = new ArrayList<>();



    public void addStudent(Student student){

            this.students.add(student);
            LogBack.filelogger().debug("Added Student Successfully.");
    }


    public Student getStudent(String name){
        for(Student student: this.students){
           if(student.getName().equals(name)){
               LogBack.filelogger().debug("Student found by Name.");
               return student;
           }
        }
        LogBack.filelogger().debug("Student with name:"+name+" Not found.");
        return null;
    }

    public Student getStudent(int id){
        for( Student student: this.students ){
            if(student.getId() == id){
                LogBack.filelogger().debug("Student found by Id.");
                return student;
            }
        }
        LogBack.filelogger().debug("Student with id:"+id+" Not found.");
        return null;
    }

    public void updateStudent(Student student, String updatedName) {
        for( Student s: students){
            if(s.getId() == student.getId()){
                student.setName(updatedName);
                LogBack.filelogger().debug("Student ("+student.getId()+") Name Updated successfully.");
                return;
            }
        }
        LogBack.filelogger().debug("Student with id:"+student.getId()+" Not found.");
    }
    public void updateStudent(Student student, int updatedAge) {
        for( Student s: students){
            if(s.getId() == student.getId()){
                student.setAge(updatedAge);
                LogBack.filelogger().debug("Student("+student.getId()+") Age Updated successfully.");
                return;
            }
        }
        LogBack.filelogger().debug("Student with id:"+student.getId()+" Not found.");
    }
    public void updateStudent(Student student, char updatedGrade) {
        for( Student s: students){
            if(s.getId() == student.getId()){
                student.setAge(updatedGrade);
                LogBack.filelogger().debug("Student("+student.getId()+") Grade Updated successfully.");
                return;
            }
        }
        LogBack.filelogger().debug("Student with id:"+student.getId()+" Not found.");
    }






}
