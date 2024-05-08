package com.Mafiuz04.School.controller;

import com.Mafiuz04.School.entity.Student;
import com.Mafiuz04.School.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/students")
@AllArgsConstructor
@RestController
public class StudentController {
    StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @GetMapping("/{lastName}")
    public List<Student> getStudentsByLastName(@PathVariable String lastName){
        return studentService.getStudentsByLastName(lastName);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
    @PutMapping("/{id}")
    public Student editStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.editStudent(id, student);
    }

    @PatchMapping("/{id}")
    public Student changeStudentPhoneNumber(@PathVariable Long id, @RequestBody String newPhoneNumber){
        studentService.changeStudentPhoneNumber(id,newPhoneNumber);
        return studentService.getStudent(id);
    }

}
