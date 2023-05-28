package com.example.doancuoikhoa.model;

import lombok.Data;

@Data
public class CourseDTO {
    private Integer id;
    private String code;
    private String name;
    private int creditName;
    private int theoryClass;
    private int practicalClass;

}
