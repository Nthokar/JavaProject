package com.example.javaproject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Student(){}
    public Student(String birthday){
        super.Birthday = birthday;
    }

    @OneToMany
    public List<StudentScore> scores = new ArrayList<>();
}
