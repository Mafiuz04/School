package com.Mafiuz04.School.service;

import com.Mafiuz04.School.entity.Student;
import com.Mafiuz04.School.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

    public Student addStudent(Student student){
        studentRepository.add(student);
        return student;
    }
    public Student getStudent(int id){
       return studentRepository.getbyId(id)
               .orElseThrow(()->new NoSuchElementException("There is no student with given ID"));
    }
    public void deleteStudent(int id){
        studentRepository.deletById(id);
    }
    public Student editStudent(int id, Student newStudent){
        Student student = studentRepository.getbyId(id)
                .orElseThrow(() -> new NoSuchElementException("There is no student with given ID"));
        studentRepository.editById(student, newStudent);
        return student;
    }
    public Student changeStudentPhoneNumber(int id, String newNumber){
       return studentRepository.changeNumber(getStudent(id),newNumber);
    }
    public List<Student> getStudents(){
        return studentRepository.getStudents();
    }
    public List<Student> getStudentsByLastName(String lastName){
       return studentRepository.getByLastName(lastName);
    }
}
