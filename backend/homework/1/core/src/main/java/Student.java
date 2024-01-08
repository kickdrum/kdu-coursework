import java.util.*;


public class Student {

    private int id;
    private String name;
    private int age;
    private String grade;

    public Student(int id, int age, String name, String grade){
        this.id = id;
        this.age = age;
        this.name = name;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }



//    public static void main(String args[])
//    {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("enter the number of students");
//        int n = sc.nextInt();
//
//        Student[] st = new Student[n];
//
//        for(int i = 0; i < n; i++){
//
//            st[i] = new Student();
//            System.out.println("Enter student id");
//            st[i].setId(sc.nextInt());
//            System.out.println("Enter student name");
//            st[i].setName(sc.next());
//            System.out.println("Enter student age");
//            st[i].setAge(sc.nextInt());
//            System.out.println("Enter student grade");
//            st[i].setGrade(sc.next());
//        }
//
//    }
}
