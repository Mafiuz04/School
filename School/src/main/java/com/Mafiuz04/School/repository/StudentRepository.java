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
        students.add(student);
        return student;
    }

    public Optional<Student> getbyId(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    public void deletById(int id) {
        students.removeIf(student -> student.getId() == id);
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
