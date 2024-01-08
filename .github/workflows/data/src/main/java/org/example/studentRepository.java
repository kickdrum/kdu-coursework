package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class studentRepository {
    private final LoggerService logger = new LoggerService();
    ArrayList<student> studentArray = new ArrayList<student>();

    public void addStudent(student newStudent){
        studentArray.add(newStudent);
//        logger.logInfo("Student added: " + newStudent.getName());
    }
    student retrieveStudent(int inputId){
        for(student s : studentArray){
            if(inputId == s.idGetter()){
                return s;
            }
        }
        return null;
    }

    student retrieveStudent(int inputId, String inputName){
        for(student s : studentArray){
            if(inputId == s.idGetter() && Objects.equals(inputName, s.nameGetter())){
                return s;
            }
        }
        return null;
    }

//    void updateStudent(int inputId, String InputS, int temp){

//    }
    void updateStudent(int studID, String studName, int studAge, char studGrade){
        for(student student: studentArray){
            if(studID == student.idGetter()){
                student.ageSetter(studAge);
                student.nameSetter(studName);
                student.gradeSetter(studGrade);
            }
        }
    }




}
