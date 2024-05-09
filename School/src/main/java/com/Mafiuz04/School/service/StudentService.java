package com.Mafiuz04.School.service;

import com.Mafiuz04.School.entity.ChangePhoneNumber;
import com.Mafiuz04.School.entity.Student;
import com.Mafiuz04.School.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        studentRepository.add(student);
        return student;
    }
    public void cleanStudentList(){
        studentRepository.cleanList();
    }

    public Student getStudent(Long id) {
        return studentRepository.getById(id)
                .orElseThrow(() -> new NoSuchElementException("There is no student with given ID"));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student editStudent(Long id, Student newStudent) {
        Student student = studentRepository.getById(id)
                .orElseThrow(() -> new NoSuchElementException("There is no student with given ID"));
        studentRepository.editById(student, newStudent);
        return student;
    }

    public Student changeStudentPhoneNumber(Long id, ChangePhoneNumber newNumber) {
        return studentRepository.changeNumber(getStudent(id), newNumber);
    }

    public List<Student> getStudents(String lastName) {
        return Optional.ofNullable(lastName).isPresent() ? studentRepository.getByLastName(lastName)
                : studentRepository.getStudents();

    }
}
