package com.example.doancuoikhoa.model;

import lombok.Data;

@Data
public class TuitionDTO {
    private Integer id;
    private String tuitionType;
    private Long intoMoney;
    private String semester;
    private Integer userId;
    private String userName;
    private Integer userCode;
    private String status;

}
