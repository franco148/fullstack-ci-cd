package com.fral.fullstackcicd.controller;

import com.fral.fullstackcicd.domain.Student;
import com.fral.fullstackcicd.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/students")
@AllArgsConstructor
public class StudentsController {

    private StudentService service;

    @GetMapping
    public List<Student> getAllStudents() {

        return service.getAll();
    }
}
