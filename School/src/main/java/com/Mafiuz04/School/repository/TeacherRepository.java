package com.Mafiuz04.School.repository;

import com.Mafiuz04.School.entity.ChangePhoneNumber;
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
        teacher.setId(teachers.stream()
                .mapToLong(Teacher::getId)
                .max()
                .orElse(0) + 1);
        teachers.add(teacher);
    }

    public Optional<Teacher> getTeacher(Long id) {
        return teachers.stream()
                .filter(teacher -> teacher.getId().equals(id))
                .findFirst();
    }

    public void deleteTeacher(Long id) {
        teachers.removeIf(teacher -> teacher.getId().equals(id));
    }

    public void editTeacher(Teacher teacher, Teacher editedTeacher) {
        teacher.setPesel(editedTeacher.getPesel());
        teacher.setSex(editedTeacher.getSex());
        teacher.setFirstName(editedTeacher.getFirstName());
        teacher.setLastName(editedTeacher.getLastName());
        teacher.setPhoneNumber(editedTeacher.getPhoneNumber());
        teacher.setDateOfBirth(editedTeacher.getDateOfBirth());
    }

    public Teacher changeNumber(Teacher teacher, ChangePhoneNumber newPhoneNumber) {
        teacher.setPhoneNumber(newPhoneNumber.getPhoneNumber());
        return teacher;
    }

    public List<Teacher> getTeachers() {
        return new ArrayList<>(teachers);
    }

    public List<Teacher> getBySex(String sex) {
        return teachers.stream()
                .filter(teacher -> teacher.getSex().equals(sex))
                .toList();
    }
}
