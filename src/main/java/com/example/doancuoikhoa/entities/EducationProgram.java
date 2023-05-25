package com.example.doancuoikhoa.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "education_program")
@Getter
@Setter
@Entity
public class EducationProgram implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "credit_name")
    private int creditName;

    @Column(name = "theory_class")
    private int theoryClass;

    @Column(name = "practical_class")
    private int practicalClass;

    @Column(name = "semester")
    private int semester;
}
