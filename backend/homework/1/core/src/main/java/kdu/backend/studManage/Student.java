package kdu.backend.studManage;

public class Student {
    private int id;
    private String name;
    private int age;
    private char grade;

    void setId(int id){
        this.id = id;
    }
    int getId(){
        return id;
    }
    void setName(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
    void setAge(int age){
        this.age = age;
    }
    int getAge(){
        return age;
    }
    void setGrade(char grade){
        this.grade = grade;
    }
    char getGrade(){
        return grade;
    }
}

