package org.rahul;

import java.util.ArrayList;

public class StudentRepository {
    ArrayList<Student> students = new ArrayList<Student>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int id) {
        Student toBeRemoved = null;
        for (Student student : students) {
            if (student.getId() == id) {
                toBeRemoved = student;
            }
        }
        students.remove(toBeRemoved);
    }

    public void getAllStudents() {
        for (Student student : students) {
            System.out.println("ID: " + student.getId() + "      Name: " + student.getName() + "       Age: " + student.getAge() + "     Grade: " + student.getGrade());
        }
    }

    public ArrayList<Student> getStudent(int id) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getId() == id) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public ArrayList<Student> getStudent(String name) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getName().equals(name)) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public ArrayList<Student> getStudent(char grade) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getGrade() == grade) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public void updateStudent(Student student) {
        for (Student stu : students) {
            if (stu.getId() == student.getId()) {
                stu.setName(student.getName());
                stu.setAge(student.getAge());
                stu.setGrade(student.getGrade());
            }
        }
    }

    public void updateStudentName(int id, String name) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
            }
        }
    }

    public void updateStudentAge(int id, int age) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setAge(age);
            }
        }
    }

    public void updateStudentGrade(int id, char grade) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setGrade(grade);
            }
        }
    }


}
