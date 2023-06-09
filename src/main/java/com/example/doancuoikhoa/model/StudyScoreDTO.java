package com.example.doancuoikhoa.model;

import lombok.Data;

import javax.net.ssl.SSLSession;

@Data
public class StudyScoreDTO {
    private Integer id;
    private String studyTimes;
    private String evaluate;
    private Integer processPoint;
    private Integer testScore;
    private Integer endPoint;
    private Integer letterPoint;
    private Integer sectionScoreId;
    private Integer userId;
    private String userName;
}
