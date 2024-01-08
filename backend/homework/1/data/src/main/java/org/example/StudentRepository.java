package org.example;

import java.util.ArrayList;

public class StudentRepository {
    ArrayList<Student> studentlist = new ArrayList<>();
    Logging logger = new Logging();
    public void addStudent(int Id,String Name,int age,String grade){
        Student newStudent = new Student(Id,Name,age,grade);
        studentlist.add(newStudent);
        logger.addStudent(newStudent);
    }

    // function overloading for retrieving student
    public Student retrieve(int id){
        System.out.println("id is "+ id);
        for (Student student : studentlist) {
            System.out.println("-->" + student);
            if (student.getId() == id) {
                logger.retrieval(student);
                return student;
            }
        }
        logger.notFound();
        return null;
    }
    public Student retrieve(String Name){
        for (Student student : studentlist) {
            if (student.getName().equals(Name)) {
                logger.retrieval(student);
                return student;
            }
        }
        logger.notFound();
        return null;
    }

    public void update(int id,String name,int age,String grade){
        for (Student student : studentlist) {
            if (student.getId() == id) {
                student.setName(name);
                student.setAge(age);
                student.setGrade(grade);
                logger.update(student);
            }
        }
        logger.notFound();
    }

    public void printAll(){
        String allStudents="";
        for(Student student: studentlist){
            allStudents+="Name: "+student.getName()+" Age: "+student.getAge()+" id: "+student.getId()+" grade: "+student.getGrade()+"\n";
        }
        logger.printAll(allStudents);
    }

}
