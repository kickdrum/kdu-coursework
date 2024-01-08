import java.util.Scanner;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LogManager lgmngr = LogManager.getLogManager();

        Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);
        System.out.println("Enter which operation to perform \n1.Add Student\n2.Retrieve Students\n3.Update Student details\n4.Log Deatails");
        char ch = sc.next().charAt(0);
        while(true) {
            switch (ch) {
                case '1':
                    System.out.println("Enter number of Students");
                    int n = sc.nextInt();
                    while (n-- > 0) {
                        log.log(Level.INFO,"Insertion is taking place");
                        insertion();
                    }
                    break;
                case '2':
                    log.log(Level.INFO,"Retrival is taking place");
                    List<Student> retrivedList = new StudentRepository().retrieve();
                    if (retrivedList.isEmpty())
                        System.out.println("No Student Found");
                    else {
                        for (Student retrievedStudent : retrivedList) {
                            print(retrievedStudent);
                            System.out.println();
                        }
                    }
                    break;
                case '3':
                    log.log(Level.INFO,"Updating data entries");
                    System.out.println("First retrieve for update");
                    List<Student> todoUpdate = new StudentRepository().retrieve();
                    if (todoUpdate.isEmpty()) {
                        System.out.println("No Student Found");
                        break;
                    }
                    updation(todoUpdate);
                    break;
                case '5':
                    exit(0);
                default:
                    System.out.println("Enter the correct S.NO. of operation to perform");
            }
            System.out.println("Enter which operation to perform \n1.Add Student\n2.Retrieve Students\n3.Update Student details\n4.Exit");
            ch = sc.next().charAt(0);
        }
    }
    public static void updation(List<Student> todoUpdate){
        Scanner sc= new Scanner(System.in);
        for(Student updateStudent: todoUpdate){
            System.out.println("Old Details:::\n");
            print(updateStudent);
            System.out.println("Enter new Details:::\n");

            System.out.println("Enter Student name");
            updateStudent.setName(sc.nextLine());

            System.out.println("Enter ID");
            updateStudent.setName(sc.next());

            System.out.println("Enter Age");
            updateStudent.setName(sc.next());

            System.out.println("Enter Grade");
            updateStudent.setName(sc.next());
        }
    }

    public static void insertion(){
        Scanner sc = new Scanner(System.in);

        Student student = new Student();

        System.out.println("Enter Student name");
        student.setName(sc.nextLine());

        System.out.println("Enter ID");
        student.setID(sc.next());

        System.out.println("Enter Age");
        student.setAge(sc.next());

        System.out.println("Enter Grade");
        student.setGrade(sc.next());

        new StudentRepository().add(student);
    }

    public static void print(Student student){
            System.out.println("Student name: "+student.getName());

            System.out.println("Student ID: "+student.getId());

            System.out.println("Age of Student "+student.getAge());

            System.out.println("Grade of Student "+student.getGrade());

    }

}
