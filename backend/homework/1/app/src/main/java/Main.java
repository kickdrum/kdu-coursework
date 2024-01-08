import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

import java.util.*;

public class Main {

//    private static final Logger logger
//            = LoggerFactory.getLogger(logger.class);

    public static void main(String args[]) {

        StudentRepo stu = new StudentRepo(5);
        Scanner scanner = new Scanner(System.in);



        System.out.println("sd");

        int choice = 1;
        do {
            System.out.println("Choose an operation:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. Retrieve Student by ID");
            System.out.println("4. Retrieve Student by Name");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();

                    System.out.print("Enter student Age: ");
                    int age = scanner.nextInt();

                    System.out.print("Enter student Name: ");
                    String name = scanner.next();

                    System.out.print("Enter student Grade: ");
                    String grade = scanner.next();
                    Student std = new Student(id, age, name, grade);

                    stu.addStudent(std);
                    logger.msgreceive().info("Student added successfully");
                    break;
                case 2:
                    System.out.println("Enter the id for updation");
                    int idd = scanner.nextInt();
                    System.out.print("Enter student ID: ");
                    int id2 = scanner.nextInt();

                    System.out.print("Enter student Age: ");
                    int age2 = scanner.nextInt();

                    System.out.print("Enter student Name: ");
                    String name2 = scanner.next();

                    System.out.print("Enter student Grade: ");
                    String grade2 = scanner.next();


                    Student std1 = new Student(id2, age2, name2, grade2);

                    stu.updateStudent(std1, idd);
                    logger.msgreceive().info("Student Updated successfully");
                    break;
                case 3:
                    System.out.print("Enter the id for retrieval: ");
                    int id1 = scanner.nextInt();
                    Student retrievedStudentById = stu.retrieveDetails(id1);

                    if (retrievedStudentById != null) {
                        System.out.println("Student details retrieved successfully:");
                        System.out.println("ID: " + retrievedStudentById.getId());
                        System.out.println("Age: " + retrievedStudentById.getAge());
                        System.out.println("Name: " + retrievedStudentById.getName());
                        System.out.println("Grade: " + retrievedStudentById.getGrade());
                        logger.msgreceive().info("Retrieval through ID success: {}", retrievedStudentById);
                    } else {
                        System.out.println("No student found with the provided ID.");
                        logger.msgreceive().info("No student found with ID: {}", id1);
                    }
                    break;
                case 4:
                    System.out.print("Enter the name for retrieval: ");
                    String namee = scanner.next();
                    List<Student> retrievedStudentsByName = (List<Student>) stu.retrieveDetails(namee);

                    if (!retrievedStudentsByName.isEmpty()) {
                        System.out.println("Students with the provided name:");
                        for (Student student : retrievedStudentsByName) {
                            System.out.println("ID: " + student.getId());
                            System.out.println("Age: " + student.getAge());
                            System.out.println("Name: " + student.getName());
                            System.out.println("Grade: " + student.getGrade());
                        }
                        logger.msgreceive().info("Retrieval through Name success: {}", retrievedStudentsByName);
                    } else {
                        System.out.println("No students found with the provided name.");
                        logger.msgreceive().info("No students found with Name: {}", namee);
                    }
                    break;

                case 0:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Enter a valid option.");
            }
        } while (choice != 0);
    }


}
