package com.Mafiuz04.School.repository;

import com.Mafiuz04.School.entity.Student;
import com.Mafiuz04.School.entity.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
@AllArgsConstructor
public class TeacherRepository {
    private final List<Teacher> teachers;

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public Optional<Teacher> getTeacher(int id) {
        return teachers.stream()
                .filter(teacher -> teacher.getId() == id)
                .findFirst();
    }

    public void deleteTeacher(int id) {
        teachers.removeIf(student -> student.getId() == id);
    }

    public void editTeacher(Teacher teacher, Teacher editedTeacher) {
        teacher.setPesel(editedTeacher.getPesel());
        teacher.setSex(editedTeacher.getSex());
        teacher.setFirstName(editedTeacher.getFirstName());
        teacher.setLastName(editedTeacher.getLastName());
        teacher.setPhoneNumber(editedTeacher.getPhoneNumber());
        teacher.setDateOfBirth(editedTeacher.getDateOfBirth());
    }

    public void changeNumber(Teacher teacher, String newPhoneNumber) {
        teacher.setPhoneNumber(newPhoneNumber);
    }

    public List<Teacher> getTeachers() {
        return new ArrayList<>(teachers);
    }

    public List<Teacher> getByLastName(String lastName) {
        return teachers.stream()
                .filter(teacher -> teacher.getLastName().equals(lastName))
                .toList();
    }
}
