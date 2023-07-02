package com.example.doancuoikhoa.model;

import lombok.Data;

@Data
public class AcademicDTO {
    private Integer id;
    private String year;
    private String punishmentLevel;
    private Integer userId;
    private String userName;
    private Integer userCode;
}
