package org.student;

import ch.qos.logback.classic.spi.ILoggingEvent;

import java.util.ArrayList;
import java.util.Scanner;

import static org.student.Logging.logger;

public class Main {
    public static void main(String[] args) {
        StudentRepository repo = new StudentRepository();

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\nWhich operation do you want to perform ? ");
            System.out.println("1. Add student \n2. Update student detail\n3. Retrieve Student detail\n4. Exit");
            System.out.print("Enter the option : ");
            int opt = sc.nextInt();
            boolean found = false;

            if(opt == 1) {
                System.out.print("\nEnter id : ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter name : ");
                String name = sc.nextLine();
                System.out.print("Enter age : ");
                int age = sc.nextInt();
                System.out.print("Enter grade : ");
                float grade = sc.nextFloat();

                ArrayList<Student> stList = repo.getStList();
                for(Student st : stList){
                    if(st.getId() == id){
                        found = true;
                        logger.error("Student with given id already exists!");
                        break;
                    }
                }

                if(!found){
                    Student st = new Student(id,name,age,grade);
                    logger.info("A new student has been created successfully!!");
                    System.out.println("A new student has been created successfully!!");
                    repo.addStudent(st);
                }

            }

            else if(opt == 2){
                System.out.print("\nEnter id : ");
                int id = sc.nextInt();

                ArrayList<Student> stList = repo.getStList();
                for(Student st : stList){
                    if(st.getId() == id){
                        found = true;
                        System.out.print("\nWhich parameter do you want to update ? \n1. Name\n2. Age\n3. Grades");
                        System.out.print("\nEnter the option : ");
                        int opt1 = sc.nextInt();

                        if(opt1 == 1){
                            sc.nextLine();
                            System.out.print("\nEnter name : ");
                            String name = sc.nextLine();
                            st.setName(name);
                            logger.info("Name updated successfully to " + name);
                            System.out.println("Name updated successfully to " + name);
                        }
                        else if (opt1 == 2) {
                            System.out.print("\nEnter age : ");
                            int age = sc.nextInt();
                            st.setAge(age);
                            logger.info("Age updated successfully to" + age);
                            System.out.println("Age updated successfully to" + age);
                        }
                        else{
                            System.out.print("\nEnter grade : ");
                            float grade = sc.nextFloat();
                            st.setGrade(grade);
                            logger.info("Grade updated successfully to " + grade);
                            System.out.println("Grade updated successfully to " + grade);;
                        }
                    }
                }

                if(!found){
                    System.out.println("No student found with the given id !\n");
                    logger.error("Invalid id " + id);
                }

            }

            else if(opt == 3){
                System.out.print("\nEnter id : ");
                int id = sc.nextInt();

                ArrayList<Student> stList = repo.getStList();
                for(Student st : stList){
                    if(st.getId() == id){
                        found = true;
                        System.out.println("Name : " + st.getName() + "\nAge : " + st.getAge() + "\nGrades : " + st.getGrade());
                        logger.info("Details fetched successfully!");
                    }
                }

                if(!found){
                    System.out.println("No student found with the given id !\n");
                    logger.error("Invalid id " + id);
                }
            }

            else{
                break;
            }
        }
    }
}