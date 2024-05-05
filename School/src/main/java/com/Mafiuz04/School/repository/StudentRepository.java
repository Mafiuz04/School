package com.Mafiuz04.School.repository;

import com.Mafiuz04.School.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Repository
@AllArgsConstructor
public class StudentRepository {
    private final List<Student> students;

    public void addStudent(Student student) {
        students.add(student);
    }

    public Optional<Student> getStudent(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public void editStudent(Student student, Student editedStudent) {
        student.setPesel(editedStudent.getPesel());
        student.setSex(editedStudent.getSex());
        student.setFirstName(editedStudent.getFirstName());
        student.setLastName(editedStudent.getLastName());
        student.setPhoneNumber(editedStudent.getPhoneNumber());
        student.setDateOfBirth(editedStudent.getDateOfBirth());
    }

    public void changeNumber(Student student, String newPhoneNumber) {
        student.setPhoneNumber(newPhoneNumber);
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
