package com.example.doancuoikhoa.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tuition")
@Data
public class Tuition implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "tuition_type")
    private String tuitionType;
    @Column(name = "credit_name")
    private String creditName;
    @Column(name = "price")
    private Long price;
    @Column(name = "discount")
    private Long discount;
    @Column(name = "reLearn")
    private Long reLearn;
    @Column(name = "into_money")
    private  Long intoMoney;
    @Column(name = "semester")
    private String semester;
    @Column(name = "user_id")
    private Integer userId;
}
