package com.example.doancuoikhoa.model;

import lombok.Data;

@Data
public class EducationProgramDTO {
    private Integer id;
    private String courseCode;
    private String courseName;
    private int creditName;
    private int theoryClass;
    private int practicalClass;
    private int semester;
}
