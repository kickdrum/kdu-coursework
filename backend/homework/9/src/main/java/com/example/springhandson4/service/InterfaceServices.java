package com.example.springhandson4.service;

import com.example.springhandson4.dto.RequestDTO;
import com.example.springhandson4.dto.ResponseDTO;
import com.example.springhandson4.entity.Subject;

public interface InterfaceServices {
    void addStudent(RequestDTO requestDTO);

    ResponseDTO getStudent(int studentID);

    ResponseDTO getStudent(Subject subject);

    ResponseDTO updateStudent(int studentID, RequestDTO requestDTO);

    boolean deleteStudent(int studentID);

}
