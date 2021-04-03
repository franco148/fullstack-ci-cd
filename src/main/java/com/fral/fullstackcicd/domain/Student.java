package com.fral.fullstackcicd.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @SequenceGenerator(
        name = "students_sequence",
        sequenceName = "students_sequence",
        initialValue = 2,
        allocationSize = 1
    )
    @GeneratedValue(
        generator = "students_sequence",
        strategy = GenerationType.SEQUENCE
    )
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
}
