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

    @Column(name = "study_times")
    private String studyTimes;

    @Column(name = "evaluate")
    private String evaluate;

    @Column(name = "process_point")
    private Float processPoint;

    @Column(name = "test_score")
    private Float testScore;

    @Column(name = "end_point")
    private Float endPoint;

    @Column(name = "letter_point")
    private String letterPoint;

    @Column(name = "sectionScore_id")
    private Integer sectionScoreId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
