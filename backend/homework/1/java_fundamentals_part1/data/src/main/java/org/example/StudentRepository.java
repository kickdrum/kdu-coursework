package org.example;

import java.util.ArrayList;

public class StudentRepository {
    logger loggerMessage=new logger();

    private ArrayList<Student> studentArrayList=new ArrayList<>();

    public void addStudent(Student newStudent){
        studentArrayList.add(newStudent);
        loggerMessage.CreateLog("Student added successfully");
    }

    public Student retriveStudent(int studentIdValue)
    {

        for(Student currentStudent:studentArrayList) {
            if (currentStudent.getStudentId() == studentIdValue) {
                loggerMessage.CreateLog("Student found successfully");
                return currentStudent;
            }
        }
        loggerMessage.CreateLog("Failed : student not found");
        return null;
    }
    public Student retriveStudent(String studentNameValue)
    {
        for(Student currentStudent:studentArrayList) {
            if (currentStudent.getStudentName().equalsIgnoreCase(studentNameValue)) {
                loggerMessage.CreateLog("Student found successfully");
                return currentStudent;
            }
        }
        loggerMessage.CreateLog("Failed : student not found");
        return null;
    }

    public void updateStudent(int studentIdValue,Student newStudent){
        for(Student currentStudent:studentArrayList) {
            if (currentStudent.getStudentId() == studentIdValue){
                currentStudent.setStudentId(newStudent.getStudentId());
                currentStudent.setStudentName(newStudent.getStudentName());
                currentStudent.setStudentGrade(newStudent.getStudentGrade());
                currentStudent.setStudentAge(newStudent.getStudentAge());
                loggerMessage.CreateLog("Student updated successfully");
            }
        }
    }
}
