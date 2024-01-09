package org.example;

import java.util.ArrayList;
import java.util.List;
public class StudentReposittory {
    private final Student[] students;
    private int size;

    public StudentReposittory(int capacity) {
        students = new Student[capacity];
        size = 0;
    }


    public void addStudent(Student student) {
        if (size < students.length) {
            students[size] = student;
            size++;
            return ;
        } else {
            return ;
        }
    }

    public Student getStudentById(int id) {
        for (int i = 0; i < size; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }
        return null;
    }


}