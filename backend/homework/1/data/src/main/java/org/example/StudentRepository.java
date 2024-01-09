package org.example;

import java.util.ArrayList;


public class StudentRepository {
    static final  String STUDENTWITHIDMESSAGE = "Student with id: ";
    static final  String NOTFOUNDMESSAGE = " NOT FOUND.";
    private  ArrayList<Student> students = new ArrayList<>();




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
        LogBack.filelogger().debug("Student with name: {} {}", name, NOTFOUNDMESSAGE);
        return null;
    }

    public Student getStudent(int id){
        for( Student student: this.students ){
            if(student.getId() == id){
                LogBack.filelogger().debug("Student found by Id.");
                return student;
            }
        }
        LogBack.filelogger().debug(STUDENTWITHIDMESSAGE + id + NOTFOUNDMESSAGE);
        return null;
    }

    public void updateStudent(Student student, String updatedName) {
        for( Student s: students){
            if(s.getId() == student.getId()){
                student.setName(updatedName);
                LogBack.filelogger().debug(STUDENTWITHIDMESSAGE + student.getId() + " Name Updated successfully.");
                return;
            }
        }
        LogBack.filelogger().debug(STUDENTWITHIDMESSAGE +student.getId()+ NOTFOUNDMESSAGE);
    }
    public void updateStudent(Student student, int updatedAge) {
        for( Student s: students){
            if(s.getId() == student.getId()){
                student.setAge(updatedAge);
                LogBack.filelogger().debug(STUDENTWITHIDMESSAGE + student.getId() +" Age Updated successfully.");
                return;
            }
        }
        LogBack.filelogger().debug( STUDENTWITHIDMESSAGE + student.getId() + NOTFOUNDMESSAGE);
    }
    public void updateStudent(Student student, char updatedGrade) {
        for( Student s: students){
            if(s.getId() == student.getId()){
                student.setAge(updatedGrade);
                LogBack.filelogger().debug(STUDENTWITHIDMESSAGE +student.getId()+" Grade Updated successfully.");
                return;
            }
        }
        LogBack.filelogger().debug(STUDENTWITHIDMESSAGE + student.getId() + NOTFOUNDMESSAGE);
    }






}
