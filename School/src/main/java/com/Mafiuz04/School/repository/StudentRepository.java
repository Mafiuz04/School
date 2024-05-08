package com.Mafiuz04.School.repository;

import com.Mafiuz04.School.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@AllArgsConstructor
public class StudentRepository {
    private final List<Student> students;

    public Student add(Student student) {
        student.setId(students.stream()
                .mapToLong(Student::getId)
                .max().orElse(1) + 1);
        students.add(student);
        return student;
    }

    public Optional<Student> getbyId(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    public void deletById(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public void editById(Student student, Student editedStudent) {
        student.setPesel(editedStudent.getPesel());
        student.setSex(editedStudent.getSex());
        student.setFirstName(editedStudent.getFirstName());
        student.setLastName(editedStudent.getLastName());
        student.setPhoneNumber(editedStudent.getPhoneNumber());
        student.setDateOfBirth(editedStudent.getDateOfBirth());
    }

    public Student changeNumber(Student student, String newPhoneNumber) {
        student.setPhoneNumber(newPhoneNumber);
        return student;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public List<Student> getByLastName(String lastName) {
        return students.stream()
                    .filter(student -> student.getLastName().equals(lastName))
                    .toList();
    }
}
