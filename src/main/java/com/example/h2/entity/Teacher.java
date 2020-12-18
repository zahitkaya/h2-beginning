package com.example.h2.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teachers")//tablonun ismini değiştirir.
public class Teacher {
   @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "sequence_example")

    //@GeneratedValue(strategy = GenerationType.AUTO)
   //@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
   @Id
    int id;
    String teacherName;

}

