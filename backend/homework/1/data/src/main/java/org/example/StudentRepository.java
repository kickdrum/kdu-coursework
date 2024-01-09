package org.example;

import java.util.ArrayList;

/**
 * A repository for managing student information.
 *
 * <p>This class provides methods for adding, retrieving, and updating student records. It stores
 * student data in an in-memory {@code ArrayList}.
 *
 * <p>The class uses {@code LogBack} for logging purposes.
 */
public class StudentRepository {
    static final  String STUDENTWITHIDMESSAGE = "Student with id: ";
    static final  String NOTFOUNDMESSAGE = " NOT FOUND.";
    private  ArrayList<Student> students = new ArrayList<>();


    /**
     * Adds a new student to the repository.
     *
     * @param student The student to add.
     */
    public void addStudent(Student student){

        this.students.add(student);
        LogBack.filelogger().debug("Added Student Successfully.");
    }

    /**
     * Retrieves a student by their name.
     *
     * @param name The name of the student to retrieve.
     * @return The student with the specified name, or null if no student is found.
     */
    public Student getStudent(String name){
        for(Student student: this.students){
            if(student.getName().equals(name)){
                LogBack.filelogger().debug("Student found by Name.");
                return student;
            }
        }
        LogBack.filelogger().debug("Student with name: {} {}", name, NOTFOUNDMESSAGE);
        return null;
    }

    /**
     * Retrieves a student by their ID.
     *
     * @param id The ID of the student to retrieve.
     * @return The student with the specified ID, or null if no student is found.
     */
    public Student getStudent(int id){
        for( Student student: this.students ){
            if(student.getId() == id){
                LogBack.filelogger().debug("Student found by Id.");
                return student;
            }
        }
        LogBack.filelogger().debug(STUDENTWITHIDMESSAGE + id + NOTFOUNDMESSAGE);
        return null;
    }

    /**
     * Updates the name of a student.
     *
     * @param student The student whose name to update.
     * @param updatedName The new name for the student.
     */
    public void updateStudent(Student student, String updatedName) {
        for( Student s: students){
            if(s.getId() == student.getId()){
                student.setName(updatedName);
                LogBack.filelogger().debug(STUDENTWITHIDMESSAGE + student.getId() + " Name Updated successfully.");
                return;
            }
        }
        LogBack.filelogger().debug(STUDENTWITHIDMESSAGE +student.getId()+ NOTFOUNDMESSAGE);
    }

    /**
     * Updates the age of a student.
     *
     * @param student The student whose age to update.
     * @param updatedAge The new age for the student.
     */
    public void updateStudent(Student student, int updatedAge) {
        for( Student s: students){
            if(s.getId() == student.getId()){
                student.setAge(updatedAge);
                LogBack.filelogger().debug(STUDENTWITHIDMESSAGE + student.getId() +" Age Updated successfully.");
                return;
            }
        }
        LogBack.filelogger().debug( STUDENTWITHIDMESSAGE + student.getId() + NOTFOUNDMESSAGE);
    }

    /**
     * Updates the grade of a student.
     *
     * @param student The student whose grade to update.
     * @param updatedGrade The new grade for the student.
     */
    public void updateStudent(Student student, char updatedGrade) {
        for( Student s: students){
            if(s.getId() == student.getId()){
                student.setAge(updatedGrade);
                LogBack.filelogger().debug(STUDENTWITHIDMESSAGE +student.getId()+" Grade Updated successfully.");
                return;
            }
        }
        LogBack.filelogger().debug(STUDENTWITHIDMESSAGE + student.getId() + NOTFOUNDMESSAGE);
    }


}
