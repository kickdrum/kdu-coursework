package javafundamentals1;

import javafundamentals1.StudentRepository.StudentRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentRepository obj=new StudentRepository();
        obj.addStudent();
        obj.addStudent();
        obj.retrieve(1);
    }
}