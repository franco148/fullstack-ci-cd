package com.fral.fullstackcicd.controller;

import com.fral.fullstackcicd.domain.Student;
import com.fral.fullstackcicd.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public void addStudent(@Valid @RequestBody Student student) {
        service.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId) {
        service.deleteStudent(studentId);
    }
}
