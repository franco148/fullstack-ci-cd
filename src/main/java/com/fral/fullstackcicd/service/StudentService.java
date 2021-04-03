package com.fral.fullstackcicd.service;

import com.fral.fullstackcicd.domain.Student;
import com.fral.fullstackcicd.exception.BadRequestException;
import com.fral.fullstackcicd.exception.NotFoundException;
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
        if (repository.existsByEmail(student.getEmail())) {
            // throw new IllegalArgumentException("The student cannot be stored. The email is already taken.");
        	throw new BadRequestException("The student cannot be stored. The email= " + student.getEmail() + " is already taken.");
        }

        repository.save(student);
    }

    public void deleteStudent(Long studentId) {
        // check if student exists
        if (!repository.existsById(studentId)) {
            // throw new IllegalArgumentException("Student with id " + studentId + " does not exist. Operation can not be completed");
        	throw new NotFoundException("Student with id " + studentId + " does not exist. Operation can not be completed");
        }

        repository.deleteById(studentId);
    }
}
