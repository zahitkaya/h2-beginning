package com.example.h2.service;

import com.example.h2.entity.Student;
import com.example.h2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    private static HashMap<Integer, Student> studentHashMap=new HashMap<>();


    public StudentService(){
        studentHashMap=new HashMap<>();
        Student student1=Student.builder()
                .name("Zahit")
                .id(10)
                .build();
        Student student2=Student.builder()
                .name("Emre")
                .id(4)
                .build();

        studentHashMap.put(student1.getId(),student1);
        studentHashMap.put(student2.getId(),student2);

    }

    public static int getMaximumId() {
        int max = 0;
        for (int id : studentHashMap.keySet()) {
            if (max <= id) {
                max = id;
            }
        }
        return max;
    }


    public List<Student> getAllStudents(){
        List <Student>students=new ArrayList<>();

                for (Student student:
             studentHashMap.values()) {
            studentRepository.save(student);
        }

        studentRepository.findAll().forEach(student -> students.add(student));
        return students;
    }


    public Student addStudent(Student student){
          studentHashMap.put(student.getId(),student);
        studentRepository.save(student);
        return student;
    }


    public Student updateStudent(Student student,int id){
        student.setId(id);
        studentHashMap.put(id,student);
        return student;
    }

    public void deleteStudent(int id){
        studentRepository.delete(studentHashMap.get(id));
        studentHashMap.remove(id);
    }

    public Student getStudent(int id){
        return studentHashMap.get(id);
    }

    @Transactional
    public Student getStudentByName(String name){
        return studentRepository.findByName(name);

    }

    public List<Student> getGreater(int id){
        return studentRepository.findByIdGreaterThan(id);
    }






}
