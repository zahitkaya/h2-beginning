package com.example.h2.controller;

import com.example.h2.entity.Teacher;
import com.example.h2.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/school/v1")
public class TeacherController {
    final TeacherRepository teacherRepository;
    @PostMapping("/teachers")
    public Teacher addNewTeacher(@RequestBody Teacher teacher){
        return teacherRepository.save(teacher);
    }
}
