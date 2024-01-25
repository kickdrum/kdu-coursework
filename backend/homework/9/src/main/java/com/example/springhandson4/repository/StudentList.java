package com.example.springhandson4.repository;

import com.example.springhandson4.entity.Student;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class StudentList {
    List<Student> students = new ArrayList<>();
}
