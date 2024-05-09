package com.Mafiuz04.School.entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student {
    private Long id;// zmiana na Longa!!Bo był int, a nie powinno być typów prostych-> chodzi o to żeby był null.
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String pesel;
    private String sex;
}
