package org.example;

/**
 * Represents a student with their basic information.
 */
public class Student {
    /**
     * The student's unique ID.
     */
    private final int id;
    /**
     * The student's name.
     */
    private String name;
    /**
     * The student's age.
     */
    private int age;
    /**
     * The student's grade.
     */
    private char grade;

    /**
     * Creates a new Student object with the specified information.
     *
     * @param id    The student's ID.
     * @param name  The student's name.
     * @param age   The student's age.
     * @param grade The student's grade.
     */
    public Student(int id,String name,int age,char grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    //getters
    /**
     * Gets the student's ID.
     *
     * @return The student's ID.
     */
    public int getId(){
        return this.id;
    }

    /**
     * Gets the student's name.
     *
     * @return The student's name.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the student's age.
     *
     * @return The student's age.
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Gets the student's grade.
     *
     * @return The student's grade.
     */
    public int getGrade(){
        return this.grade;
    }

    //setters
    /**
     * Sets the student's name.
     *
     * @param updatedName The new name for the student.
     */
    public void setName(String updatedName){
        this.name = updatedName;
    }

    /**
     * Sets the student's age.
     *
     * @param updatedAge The new age for the student.
     */
    public void setAge(int updatedAge){
        this.age = updatedAge;
    }

    /**
     * Sets the student's grade.
     *
     * @param updatedGrade The new grade for the student.
     */
    public void setGrade(char updatedGrade){
        this.grade = updatedGrade;
    }


}
