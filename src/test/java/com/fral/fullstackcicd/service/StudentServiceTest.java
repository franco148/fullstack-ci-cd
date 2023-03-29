package com.fral.fullstackcicd.service;

import com.fral.fullstackcicd.domain.Gender;
import com.fral.fullstackcicd.domain.Student;
import com.fral.fullstackcicd.exception.BadRequestException;
import com.fral.fullstackcicd.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
//    private AutoCloseable autoCloseable; //This does not need @ExtendWith annotation

    private StudentService underTest;


    @BeforeEach
    void setUp() {
//        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new StudentService(studentRepository);
    }

//    @AfterEach
//    void tearDown() throws Exception {
//        autoCloseable.close();
//    }

    @Test
    void canGetAllStudents() {
        // when
        underTest.getAll();

        // then
        verify(studentRepository).findAll();
    }

    @Test
    void canAddStudent() {
        // given
        Student student = new Student();
        student.setName("Franco Arratia");
        student.setEmail("franco.arratia@localhost.com");
        student.setGender(Gender.MALE);

        // when
        underTest.addStudent(student);

        // then
        ArgumentCaptor<Student> captor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(captor.capture());

        Student capturedStudent = captor.getValue();

        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void willThrowWhenEmailIsTaken() {
        // given
        Student student = new Student();
        student.setName("Franco Arratia");
        student.setEmail("franco.arratia@localhost.com");
        student.setGender(Gender.MALE);

        given(studentRepository.existsByEmail(student.getEmail()))
                .willReturn(true);

        // when
        // then
        assertThatThrownBy(() -> underTest.addStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessage("The student cannot be stored. The email= " + student.getEmail() + " is already taken.");

        verify(studentRepository, never()).save(any());
    }

    @Test
    @Disabled
    void deleteStudent() {
    }
}