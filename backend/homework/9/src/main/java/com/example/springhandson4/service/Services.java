package com.example.springhandson4.service;

import com.example.springhandson4.dto.RequestDTO;
import com.example.springhandson4.dto.ResponseDTO;
import com.example.springhandson4.entity.Student;
import com.example.springhandson4.entity.Subject;
import com.example.springhandson4.exception.custom.BadRequestException;
import com.example.springhandson4.exception.custom.ResourceNotFoundException;
import com.example.springhandson4.mapper.Mapper;
import com.example.springhandson4.repository.StudentList;
import com.example.springhandson4.util.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class Services implements InterfaceServices {
    private final Logging logger;
    private final StudentList studentList;

    @Autowired
    public Services(Logging logger, StudentList studentList) {
        this.logger = logger;
        this.studentList = studentList;
    }

    public void addStudent(RequestDTO requestDTO) {
        try {
            logger.logApiRequest("/student", "POST", requestDTO.toString());
            Student student = Mapper.requestToStudent(requestDTO);
            studentList.getStudents().add(student);
            logger.logApiResponse("/student", "Student added with ID: " + student.getStudentID());
        } catch (Exception e) {
            logger.logException("Error adding student: " + e.getMessage());
            throw new BadRequestException("Invalid request format");
        }
    }

    public ResponseDTO getStudent(int studentID) {
        try {
            logger.logApiRequest("/student/" + studentID, "GET", "");
            Student student = studentList.getStudents().stream()
                    .filter(s -> s.getStudentID() == studentID)
                    .findFirst()
                    .orElseThrow(() -> {
                        logger.logException("Student not found with ID: " + studentID);
                        return new ResourceNotFoundException("Student not found with ID: " + studentID);
                    });

            logger.logApiResponse("/student/" + studentID, "Student found with ID: " + student.getStudentID());
            return Mapper.studentToResponse(student);
        } catch (Exception e) {
            logger.logException("Error getting student: " + e.getMessage());
            throw new BadRequestException("Invalid request format");
        }
    }

    public ResponseDTO getStudent(Subject subject) {
        try {
            logger.logApiRequest("/student?subject=" + subject, "GET", "");
            Student student = studentList.getStudents().stream()
                    .filter(s -> s.getSubject() == subject)
                    .findFirst()
                    .orElseThrow(() -> {
                        logger.logException("Student not found with subject: " + subject);
                        return new ResourceNotFoundException("Student not found with subject: " + subject);
                    });

            logger.logApiResponse("/student?subject=" + subject, "Student found with subject: " + student.getSubject());
            return Mapper.studentToResponse(student);
        } catch (Exception e) {
            logger.logException("Error getting student: " + e.getMessage());
            throw new BadRequestException("Invalid request format");
        }
    }


    public ResponseDTO updateStudent(int studentID, RequestDTO requestDTO) {
        try {
            logger.logApiRequest("/student/" + studentID, "PUT", requestDTO.toString());
            Student student = studentList.getStudents().stream()
                    .filter(s -> s.getStudentID() == studentID)
                    .findFirst()
                    .orElseThrow(() -> {
                        logger.logException("Student not found with ID: " + studentID);
                        return new ResourceNotFoundException("Student not found with ID: " + studentID);
                    });

            student.setAge(requestDTO.getAge());
            student.setSubject(requestDTO.getSubject());
            student.setFirstName(requestDTO.getFirstName());
            student.setLastName(requestDTO.getLastName());

            logger.logApiResponse("/student/" + studentID, "Student updated with ID: " + studentID);
            return Mapper.studentToResponse(student);
        } catch (Exception e) {
            logger.logException("Error updating student: " + e.getMessage());
            throw new BadRequestException("Invalid request format");
        }
    }

    public boolean deleteStudent(int studentID) {
        try {
            logger.logApiRequest("/student/" + studentID, "DELETE", "");
            Iterator<Student> iterator = studentList.getStudents().iterator();
            while (iterator.hasNext()) {
                Student student = iterator.next();
                if (student.getStudentID() == studentID) {
                    iterator.remove();
                    logger.logApiResponse("/student/" + studentID, "Student deleted with ID: " + student.getStudentID());
                    return true;
                }
            }

            throw new ResourceNotFoundException("Student not found with ID: " + studentID);
        } catch (Exception e) {
            logger.logException("Error deleting student: " + e.getMessage());
            throw new BadRequestException("Invalid request format");
        }
    }
}
