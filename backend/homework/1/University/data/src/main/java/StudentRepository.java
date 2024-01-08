import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentRepository {

    private static List<Student> studentList = new ArrayList<Student>();

    public void add(Student student){
        studentList.add(student);
    }
    public List<Student> retrieve(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Retrieve using \n1.Id \n2.Name \n3.Grade \n4.Age");
        char ch = sc.next().charAt(0);
        List<Student> myStudent=new ArrayList<>();
            switch (ch) {
                case '1':
                    System.out.println("Enter Id");
                    final String search = sc.next();
                    myStudent = studentList.stream()
                            .filter(s -> s.getId().equals(search))
                            .collect(Collectors.toList());
                    break;
                case '2':
                    System.out.println("Enter Name");
                    final String bb = sc.next();
                    myStudent = studentList.stream()
                            .filter(s -> s.getName().equals(bb))
                            .collect(Collectors.toList());
                    break;
                case '3':
                    System.out.println("Enter Grade");
                    final String cc = sc.next();
                     myStudent = studentList.stream()
                            .filter(s -> s.getGrade().equals(cc))
                            .collect(Collectors.toList());
                     break;
                case '4':
                    System.out.println("Enter Age");
                    final String dd = sc.next();
                    myStudent = studentList.stream()
                            .filter(s -> s.getAge().equals(dd))
                            .collect(Collectors.toList());
                    break;
                default:
                    System.out.println("Enter correct serial number to  retrieve");
            }
        return myStudent;
    }
}
