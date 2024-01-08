package org.student;

import java.util.ArrayList;

public class StudentRepository {
    private ArrayList<Student> stList = new ArrayList<>();

    public ArrayList<Student> getStList(){
        return stList;
    }

    public void setStList(ArrayList<Student> newStList){
        this.stList = newStList;
    }

    public void addStudent(Student st){
        stList.add(st);
    }

    public Student getStudent(int id){
        for(Student st : stList){
            if(st.getId() == id){
                return st;
            }
        }
        return null;
    }

    public Student getStudent(String name){
        for(Student st : stList){
            if(st.getName().equals(name)){
                return st;
            }
        }
        return null;
    }

    public void updateStudentName(int id, String name){
        for(Student st : stList) {
            if (st.getId() == id) {
                st.setName(name);
            }
        }
    }

    public void updateStudentAge(int id, int age){
        for(Student st : stList) {
            if (st.getId() == id) {
                st.setAge(age);
            }
        }
    }

    public void updateStudentGrade(int id, int grade){
        for(Student st : stList) {
            if (st.getId() == id) {
                st.setGrade(grade);
            }
        }
    }
}
