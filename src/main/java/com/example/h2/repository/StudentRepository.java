package com.example.h2.repository;

import com.example.h2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

   // @Lock(LockModeType.READ)
    @Query("from Student s where s.name= :name")
    Student findByName(@Param("name") String sampleName);

    List<Student> findByIdGreaterThan(int id); //id si girilen parametren büyükler seçilir

    @Query("select s.gpa from Student s")
    List<Double> findGpa();

}
