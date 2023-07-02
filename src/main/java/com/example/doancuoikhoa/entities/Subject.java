package com.example.doancuoikhoa.entities;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
}
