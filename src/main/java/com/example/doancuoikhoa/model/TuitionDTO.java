package com.example.doancuoikhoa.model;

import lombok.Data;

@Data
public class TuitionDTO {
    private Integer id;
    private String tuitionType;
    private String creditName;
    private Long price;
    private Long discount;
    private Long reLearn;
    private Long intoMoney;
    private String semester;
    private Integer userId;
    private String userName;
}
