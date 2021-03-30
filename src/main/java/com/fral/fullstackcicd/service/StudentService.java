package com.fral.fullstackcicd.service;

import com.fral.fullstackcicd.domain.Student;
import com.fral.fullstackcicd.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private StudentRepository repository;


    public List<Student> getAll() {
        return this.repository.findAll();
    }

    public void addStudent(Student student) {
        // check if email is taken
        repository.save(student);
    }
}
