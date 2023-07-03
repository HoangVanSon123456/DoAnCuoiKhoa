package com.example.doancuoikhoa.model;

import lombok.Data;

@Data
public class RestScheduleDTO {
    private Integer id;
    private String name;
    private Integer courseId;
    private String courseName;
    private Integer creditName;
    private String testDay;
    private String poetry;
    private String examTime;
    private Integer identificatioNumber;
    private String examinationRoom;
    private Integer userId;
    private String userName;
    private Integer userCode;

}
