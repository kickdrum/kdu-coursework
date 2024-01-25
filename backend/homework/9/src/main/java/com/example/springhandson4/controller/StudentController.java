package com.example.springhandson4.controller;

import com.example.springhandson4.dto.RequestDTO;
import com.example.springhandson4.dto.ResponseDTO;
import com.example.springhandson4.entity.Subject;
import com.example.springhandson4.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {
    private Services services;
    @Autowired
    public StudentController(Services services) {
        this.services = services;
    }

    @PostMapping("/student")
    public ResponseEntity<String> addStudent(@RequestBody RequestDTO studentRequestDTO){
        services.addStudent(studentRequestDTO);
        return ResponseEntity.ok("Added Successfully");
    }

    @GetMapping("/student")
    public ResponseDTO searchStudent(@RequestParam Subject subject){
        return services.getStudent(subject);
    }

    @GetMapping("/student/{studentID}")
    public ResponseDTO searchStudent(@PathVariable Integer studentID){
        return services.getStudent(studentID);
    }

    @PutMapping("/student/{studentID}")
    public ResponseEntity<ResponseDTO> updateVehicle(@PathVariable int studentID, @RequestBody RequestDTO requestDTO) {
        ResponseDTO updatedStudent = services.updateStudent(studentID, requestDTO);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/student/{studentID}")
    public ResponseEntity<String> deleteVehicle(@PathVariable int studentID) {
        boolean isDeleted = services.deleteStudent(studentID);
        if (isDeleted) {
            return ResponseEntity.ok("Student info deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}