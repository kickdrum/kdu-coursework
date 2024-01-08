package org.example;

public class InputValidators {
    public boolean validAge(int age) {
        return age!=-1;
    }
    public boolean validName(String name) {
        return !name.isEmpty();
    }
    public boolean validId(int id) {
        return id!=-1;
    }
    public boolean validGrade(char grade) {
        return grade!=' ';
    }
}
