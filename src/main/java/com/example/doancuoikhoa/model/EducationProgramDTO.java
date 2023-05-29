package com.example.doancuoikhoa.model;

import com.example.doancuoikhoa.entities.Course;
import lombok.Data;

import java.util.List;

@Data
public class EducationProgramDTO {
    private Integer id;
    private String name;
    private Integer semester;
}
