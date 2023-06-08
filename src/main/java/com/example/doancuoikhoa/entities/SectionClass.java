package com.example.doancuoikhoa.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "section_class")
public class SectionClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "semester")
    private Integer semester;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "education_program_id")
    private EducationProgram educationProgram;


}
