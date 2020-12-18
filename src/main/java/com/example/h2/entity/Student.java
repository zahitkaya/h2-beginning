package com.example.h2.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

import javax.persistence.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")//tablonun ismini değiştirir.
@JsonNaming(value= PropertyNamingStrategy.KebabCaseStrategy.class)
public class Student {

    //SEQUENCE
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "sequence_example")
    @SequenceGenerator(name = "sequence_example",initialValue = 55, allocationSize = 100)

    //Tablo
    /*
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "table-generator")
    @TableGenerator(name = "table-generator",
            table = "dep_ids",
            pkColumnName = "seq_id",
            valueColumnName = "seq_value",
    allocationSize = 20)

    */
    @Id
    int id;
    @Column(name = "isim")
    String name;
    double gpa;


}
