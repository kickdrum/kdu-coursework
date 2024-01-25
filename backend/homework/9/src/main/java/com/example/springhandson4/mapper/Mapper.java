package com.example.springhandson4.mapper;

import com.example.springhandson4.dto.RequestDTO;
import com.example.springhandson4.dto.ResponseDTO;
import com.example.springhandson4.entity.Student;
import com.example.springhandson4.entity.Subject;

public class Mapper {
    private Mapper(){

    }
    public static Student requestToStudent(RequestDTO requestDTO){
        int studentId = requestDTO.getStudentID();
        String firstName = requestDTO.getFirstName();
        String lastName = requestDTO.getLastName();
        int age = requestDTO.getAge();
        Subject subject = requestDTO.getSubject();
        return new Student(studentId, firstName, lastName, age, subject);
    }

    public static ResponseDTO studentToResponse(Student student){
        int studentId = student.getStudentID();
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        int age = student.getAge();
        Subject subject = student.getSubject();
        return new ResponseDTO(studentId, firstName, lastName, age, subject);
    }
}
