package com.fral.fullstackcicd.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fral.fullstackcicd.domain.Gender;
import com.fral.fullstackcicd.domain.Student;
import com.fral.fullstackcicd.repository.StudentRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.BDDAssertions.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-it.properties")
@AutoConfigureMockMvc
public class StudentControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StudentRepository studentRepository;

    private final Faker faker = new Faker();

    @Test
    void canRegisterNewStudent() throws Exception {
        // given
        Student student = new Student();
        student.setName(String.format("%s %s", faker.name().firstName(), faker.name().lastName()));
        student.setEmail(String.format(faker.internet().emailAddress()));
        student.setGender(Gender.MALE);

        // when
        ResultActions result = mockMvc.perform(post("/api/v1/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)));

        // then
        result.andExpect(status().isOk());

        List<Student> students = studentRepository.findAll();
//        assertThat(students)
//                .usingRecursiveComparison()
//                .ignoringFields("id")
//                .asList()
//                .contains(student);
        then(students)
                .usingElementComparatorIgnoringFields("id")
                .contains(student);
    }
}
