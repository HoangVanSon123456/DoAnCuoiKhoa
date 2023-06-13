package com.example.doancuoikhoa.model;

import lombok.Data;

import javax.net.ssl.SSLSession;

@Data
public class StudyScoreDTO {
    private Integer id;
    private String studyTimes;
    private String evaluate;
    private Float processPoint;
    private Float testScore;
    private Float endPoint;
    private String letterPoint;
    private Integer sectionScoreId;
    private Integer userId;
    private String userName;
}
