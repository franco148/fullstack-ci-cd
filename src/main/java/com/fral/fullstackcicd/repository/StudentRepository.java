package com.fral.fullstackcicd.repository;

import com.fral.fullstackcicd.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
