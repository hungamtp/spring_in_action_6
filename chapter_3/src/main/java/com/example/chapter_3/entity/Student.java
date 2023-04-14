package com.example.chapter_3.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String studentCode;
    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<StudentClass> classes;
}
