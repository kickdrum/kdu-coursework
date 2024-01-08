package org.example;

public class student {
    private int id;
    private String name;
    private int age;
    private char grade;

    public student(){
    }

    public student( int id, String name, int age, char grade){
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    int idGetter(){
        return id;
    }

    void idSetter(int input_id){
        id = input_id;
    }

    String nameGetter(){
        return name;
    }

    void nameSetter(String input_name){
        name = input_name;
    }

    int ageGetter(){
        return age;
    }

    void ageSetter(int input_age){
        age = input_age;
    }

    char gradeGetter(){
        return grade;
    }

    void gradeSetter(char input_grade){
        grade = input_grade;
    }



}
