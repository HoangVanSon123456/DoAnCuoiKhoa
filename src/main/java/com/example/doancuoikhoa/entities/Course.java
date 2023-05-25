package com.example.doancuoikhoa.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "course")
@Data
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "credit_name")
    private int creditName;

    @Column(name = "theory_class")
    private int theoryClass;

    @Column(name = "practical_class")
    private int practicalClass;

}
