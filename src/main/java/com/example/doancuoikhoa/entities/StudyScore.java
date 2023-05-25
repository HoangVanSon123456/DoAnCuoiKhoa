package com.example.doancuoikhoa.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "study_score")
@Data
public class StudyScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "credit_name")
    private Integer creditName;

    @Column(name = "study_times")
    private String studyTimes;

    @Column(name = "evaluate")
    private String evaluate;

    @Column(name = "process_point")
    private Integer processPoint;

    @Column(name = "test_score")
    private Integer testScore;

    @Column(name = "end_point")
    private Integer endPoint;

    @Column(name = "letter_point")
    private Integer letterPoint;


}
