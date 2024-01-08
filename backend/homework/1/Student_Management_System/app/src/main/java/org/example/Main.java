package org.example;




import java.util.ArrayList;


public class Main {
    private static Logger logger = new Logger();
    public static void addStudent(StudentRepository studentRepo, UserInputHandler userInput) {
        InputValidators validInput = new InputValidators();
        int id,age;
        String name;
        char grade;
        System.out.println("Enter asked details to add a student");
        id = userInput.readId();
        if(studentRepo.doesStudentExists(id)) {
            System.out.println("Student Id already exists");
        }else {
            name = userInput.readName();
            age = userInput.readAge();
            grade = userInput.readGrades();
            if (validInput.validAge(age) && validInput.validId(id) && validInput.validGrade(grade) && validInput.validName(name)) {
                studentRepo.addNewStudent(id, name, age, grade);
                logger.debugLog("Student Added Successfully");
                System.out.println("Student Added Successfully");
            }
        }
    }

    public static void updateStudent(StudentRepository studentRepo, UserInputHandler userInput, UserUtilityMenu  utilityMenu) {
        int id = userInput.readId();
        if(studentRepo.doesStudentExists(id)) {
            while(true) {
                int updateOp = utilityMenu.UpdateMenu();
                logger.debugLog("Selected option in update menu : "+updateOp);

                switch (updateOp) {
                    case 1:
                        studentRepo.updateStudent(id, userInput.readName());
                        logger.debugLog("Student Updated Successfully");
                        break;
                    case 2:
                        studentRepo.updateStudent(id, userInput.readAge());
                        logger.debugLog("Student Updated Successfully");

                        break;
                    case 3:
                        studentRepo.updateStudent(id, userInput.readGrades());
                        logger.debugLog("Student Updated Successfully");

                        break;
                    case -1:
                        System.out.println("Exiting Update Menu");
                        return;
                }
            }
        }else {
            System.out.println("Student Id does not exists");
        }
    }

    public static void printStudent(ArrayList<Student>studList) {
        for(Student stud : studList) {
            System.out.println("ID : "+stud.getStudentId());
            System.out.println("Name  : "+stud.getStudentName());
            System.out.println("Age : "+stud.getStudentAge());
            System.out.println("Grade : "+stud.getStudentGrade());
        }
    }

    public static void retrieveStudent(StudentRepository studentRepo, UserInputHandler userInput, UserUtilityMenu  utilityMenu) {
        while(true) {
            int retrieveOp = utilityMenu.RetrieveMenu();
            logger.debugLog("Selected option in retrieve menu : "+retrieveOp);

            switch (retrieveOp) {

                case 1:
                    int id = userInput.readId();
                    System.out.println("DEBUG ID : "+id);
                    printStudent(studentRepo.retrieveStudent(id));
                    break;
                case 2:
                    String name = userInput.readName();
                    printStudent(studentRepo.retrieveStudent(name));
                    break;
                case -1:
                    System.out.println("Exiting Retrieve Menu");
                    return;
            }
        }
    }

    public static void deleteStudent(StudentRepository studentRepo, UserInputHandler userInput ) {
        InputValidators validInput = new InputValidators();

        int id = userInput.readId();
        if(studentRepo.doesStudentExists(id) && validInput.validId(id)) {
            studentRepo.deleteStudent(id);
            logger.debugLog("Student Deleted Successfully");
        }else {
            System.out.println("Student ID does not exists");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome To Student Management System");
        UserUtilityMenu  utilityMenu = new UserUtilityMenu();
        StudentRepository studentRepo = new StudentRepository();
        UserInputHandler userInput = new UserInputHandler();
        while(true) {
            int operationOp = utilityMenu.operationMenu();
            logger.debugLog("Selected option in main menu : "+operationOp);
            switch (operationOp) {

                case 1:
                    addStudent(studentRepo,userInput);
                    break;
                case 2:
                    updateStudent(studentRepo,userInput,utilityMenu);
                    break;
                case 3:
                    deleteStudent(studentRepo,userInput);
                    break;
                case 4:
                    retrieveStudent(studentRepo,userInput,utilityMenu);
                    break;
                case -1:
                    System.out.println("Exiting Student Management System...");
                    return;
                default:
                    System.out.println("Invalid Operation No. \nTry Again or Press -1 to Exit");
                    break;
            }
        }
    }
}