package com.example.h2.controller;

import com.example.h2.entity.Student;
import com.example.h2.repository.StudentRepository;
import com.example.h2.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("school/v1")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentController {
    final StudentService studentService;

    final StudentRepository studentRepository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return student;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/students/{name}")
    public Student getStudentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }



    @GetMapping("/students/getGreater/{id}")
    public List idGreaterThan(@PathVariable int id){
        return studentService.getGreater(id);
    }


    @GetMapping("/students/listGpa")
    public List<Double> listGpa(){
        return studentRepository.findGpa();
    }


}
