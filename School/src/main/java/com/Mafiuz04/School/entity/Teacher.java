package com.Mafiuz04.School.entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Teacher {
    private int id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String pesel;
    private String sex;
    private Double salary;
}
