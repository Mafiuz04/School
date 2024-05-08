package com.Mafiuz04.School.service;

import com.Mafiuz04.School.entity.Teacher;
import com.Mafiuz04.School.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
@AllArgsConstructor
public class TeacherService {
    private TeacherRepository teacherRepository;

    public Teacher addTeacher(Teacher teacher){
        teacherRepository.addTeacher(teacher);
        return teacher;
    }
    public Teacher getTeacher(Long id){
        return teacherRepository.getTeacher(id)
                .orElseThrow(()->new NoSuchElementException("There is no student with given ID"));
    }
    public void deleteTeacher(Long id){
        teacherRepository.deleteTeacher(id);
    }
    public Teacher editTeacher(Long id, Teacher newTeacher){
        Teacher teacher = teacherRepository.getTeacher(id)
                .orElseThrow(() -> new NoSuchElementException("There is no student with given ID"));
        teacherRepository.editTeacher(teacher, newTeacher);
        return teacher;
    }
    public Teacher changeTeacherPhoneNumber(Long id, String newNumber){
        return teacherRepository.changeNumber(getTeacher(id),newNumber);
    }
    public List<Teacher> getTeachers(){
        return teacherRepository.getTeachers();
    }
    public List<Teacher> getTeacherBySex(String sex){
        return teacherRepository.getBySex(sex);
    }
}
