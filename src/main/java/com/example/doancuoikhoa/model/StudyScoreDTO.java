package com.example.doancuoikhoa.model;

import lombok.Data;

@Data
public class StudyScoreDTO {
    private Integer id;
    private String courseCode;
    private String courseName;
    private Integer creditName;
    private String studyTimes;
    private String evaluate;
    private Integer processPoint;
    private Integer testScore;
    private Integer endPoint;
    private Integer letterPoint;
}
