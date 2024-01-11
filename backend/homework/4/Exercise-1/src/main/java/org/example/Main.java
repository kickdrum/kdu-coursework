package org.example;

public class Main {
    public static void main(String[] args) {


        int[] Studentid = {1001, 1002};
        char[][] grades = {{'A', 'A', 'A', 'B'}};

        try {
             StudentUtil.calculateGPA(Studentid, grades);

        } catch (MissingGradeException e) {
            throw new InvalidDataException("Invalid data in calculateGPA method.", e);
        }

     }

    }
