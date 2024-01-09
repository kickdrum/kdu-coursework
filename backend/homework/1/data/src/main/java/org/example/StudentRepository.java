package org.example;

import java.util.ArrayList;


public class StudentRepository {
    static final  String STUDENTWITHIDMESSAGE = "Student with id: ";
    static final  String NOTFOUNDMESSAGE = " NOT FOUND.";
    private  ArrayList<Student> students = new ArrayList<>();

    public String studentNotFoundMessage(int ID){
        return String.format("Student with id: {} NOT FOUND",ID);
    }


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
        LogBack.filelogger().debug("Student with name: {} {}",name, NOTFOUNDMESSAGE);
        return null;
    }

    public Student getStudent(int id){
        for( Student student: this.students ){
            if(student.getId() == id){
                LogBack.filelogger().debug("Student found by Id.");
                return student;
            }
        }
        LogBack.filelogger().debug(studentNotFoundMessage(student.getID()));
        return null;
    }

    public void updateStudent(Student student, String updatedName) {
        for( Student s: students){
            if(s.getId() == student.getId()){
                student.setName(updatedName);
                LogBack.filelogger().debug("{} {} Name Updated successfully.",STUDENTWITHIDMESSAGE,student.getId());
                return;
            }
        }
        LogBack.filelogger().debug(studentNotFoundMessage(student.getID()));
    }
    public void updateStudent(Student student, int updatedAge) {
        for( Student s: students){
            if(s.getId() == student.getId()){
                student.setAge(updatedAge);
                LogBack.filelogger().debug("{} {} Age Updated successfully.",STUDENTWITHIDMESSAGE,student.getId());
                return;
            }
        }
        LogBack.filelogger().debug(studentNotFoundMessage(student.getID()));
    }
    public void updateStudent(Student student, char updatedGrade) {
        for( Student s: students){
            if(s.getId() == student.getId()){
                student.setAge(updatedGrade);
                LogBack.filelogger().debug("{} {} Grade Updated successfully.",STUDENTWITHIDMESSAGE,student.getId());
                return;
            }
        }
        LogBack.filelogger().debug(studentNotFoundMessage(student.getID()));
    }






}
