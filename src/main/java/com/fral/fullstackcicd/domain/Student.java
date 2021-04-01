package com.fral.fullstackcicd.domain;


import lombok.*;

import javax.persistence.*;

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
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
