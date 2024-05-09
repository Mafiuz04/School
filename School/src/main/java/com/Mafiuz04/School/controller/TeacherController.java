package com.Mafiuz04.School.controller;


import com.Mafiuz04.School.entity.ChangePhoneNumber;
import com.Mafiuz04.School.entity.Teacher;
import com.Mafiuz04.School.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/teachers")
@AllArgsConstructor
@RestController
public class TeacherController {
    TeacherService teacherService;

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        return teacherService.getTeacher(id);
    }

    @GetMapping
    public List<Teacher> getTeachers(@RequestParam(required = false) String sex) {
        return teacherService.getTeachers(sex);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }

    @PutMapping("/{id}")
    public Teacher editTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        return teacherService.editTeacher(id, teacher);
    }

    @PatchMapping("/{id}")
    public Teacher chane(@PathVariable Long id, @RequestBody ChangePhoneNumber newPhoneNumber) {
        teacherService.changeTeacherPhoneNumber(id, newPhoneNumber);
        return teacherService.getTeacher(id);
    }
}
