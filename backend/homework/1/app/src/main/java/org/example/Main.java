package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        StudentRepository students=new StudentRepository();

        System.out.println("Enter the number of students that you want to enter:");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            Student st=new Student();

            sc.nextLine();
            System.out.println("Enter the Student ID: ");
            String id;
            id=sc.nextLine();
            st.setId(id);

            sc.nextLine();

            System.out.println("Enter the Student Name: ");
            String name;
            name=sc.nextLine();
            st.setName(name);

            System.out.println("Enter the Student Age: ");
            int age;
            age=sc.nextInt();
            st.setAge(age);

            System.out.println("Enter the Student Grade: ");
            char grade;
            grade=sc.next().charAt(0);
            st.setGrade(grade);

            students.addStudent(st);
        }

        String id="id01";
        Student st2=students.getStudent(id);
        System.out.println("The attributes of required student are: 1.Name: "+ st2.getName()+" 2.Age: "+st2.getAge()+" 3.Grade: "+st2.getGrade());

        ArrayList<Student> students1= students.updateStudentName("Rakesh", "id02");
        for(int i=0;i<n;i++){
            System.out.println("The attributes of required student are: 1.Name: "+ students1.get(i).getName()+" 2.Age: "+students1.get(i).getAge()+" 3.Grade: "+students1.get(i).getGrade());
        }
        System.out.println();
        ArrayList<Student> students2= students.updateStudentGrade('C', "id03");
        for(int i=0;i<n;i++){
            System.out.println("The attributes of required student are: 1.Name: "+ students2.get(i).getName()+" 2.Age: "+students2.get(i).getAge()+" 3.Grade: "+students2.get(i).getGrade());
        }
        System.out.println();
        ArrayList<Student> students3= students.updateStudentAge(25, "id04");
        for(int i=0;i<n;i++){
            System.out.println("The attributes of required student are: 1.Name: "+ students3.get(i).getName()+" 2.Age: "+students3.get(i).getAge()+" 3.Grade: "+students3.get(i).getGrade());
        }
        System.out.println();
    }
}