package com.example.doancuoikhoa.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "edu_course")
@Data
public class EduProCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "education_program_id")
    private Integer educationProgramId;

    @Column(name = "course_id")
    private Integer courseId;


}
