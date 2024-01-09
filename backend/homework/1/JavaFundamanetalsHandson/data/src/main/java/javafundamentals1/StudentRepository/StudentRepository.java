package javafundamentals1.StudentRepository;
import javafundamentals1.Student.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class StudentRepository {

    static int cnt=0;
    Scanner scn=new Scanner(System.in);
    ArrayList<Student> studentRepository;
    public StudentRepository()
    {
        studentRepository=new ArrayList<Student>();
    }
    public void addStudent()
    {
        cnt++;
        Student obj=new Student(cnt);
        System.out.println("Enter name of the student");
        obj.setName(scn.nextLine());
        System.out.println("Enter age of student");
        obj.setAge(scn.nextInt());
        System.out.println("Enter grade of student");
        obj.setGrade(scn.next().charAt(0));
        scn.nextLine();
        studentRepository.add(obj);
        //add details
    }
    public void retrieve(int id)
    {
        for(Student s:studentRepository)
        {
            if(s.getId()==id)
            {
                System.out.println("Student details :");
                System.out.println("Name :"+s.getName());
                System.out.println("Age :"+s.getAge());
                System.out.println("grade :"+s.getGrade());
            }
        }
    }
    public void update(int id)
    {
        for(Student s:studentRepository)
        {            if(s.getId()==id)
            {
                System.out.println("Enter grade of the student");
                char ch=scn.next().charAt(0);
                s.setGrade(ch);
            }
        }
    }
    public void update(String name)
    {
        for(Student s:studentRepository)
        {
            String sname=s.getName();
            if(sname.equals(name))
            {
                System.out.println("Enter age of the student");
                int age=scn.nextInt();
                s.setAge(age);
            }
        }
    }



}
