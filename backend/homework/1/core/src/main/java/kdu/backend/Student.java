package kdu.backend;

public class Student {
    int Id,Age;
    String Name;
    String Grade;

    public Student(int id, int age, String name, String grade) {
        Id = id;
        Age = age;
        Name = name;
        Grade = grade;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        this.Grade = grade;
    }
    @Override
    public String toString() {
        return  "id=" + Id + ", Age=" + Age + ", Name=" + Name + ", Grade=" + Grade;
    }
}
