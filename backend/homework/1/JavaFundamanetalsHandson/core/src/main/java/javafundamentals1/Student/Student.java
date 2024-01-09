package javafundamentals1.Student;

public class Student {
    private int id;
    private String name;

    private int age;
    private char grade;
    public Student()
    {

    }
    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}
