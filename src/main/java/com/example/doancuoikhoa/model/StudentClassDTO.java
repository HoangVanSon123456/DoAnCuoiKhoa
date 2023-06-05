package com.example.doancuoikhoa.model;

import lombok.Data;

import java.util.List;

@Data
public class StudentClassDTO {
    private Integer id;
    private Integer sectionClassId;
    private List<Integer> userId;

}
