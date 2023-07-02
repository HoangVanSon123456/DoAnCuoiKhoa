package com.example.doancuoikhoa.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "rest_schedule")
@Data
public class RestSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private Integer name;
    @Column(name = "testDay")
    private String testDay;
    @Column(name = "poetry")
    private String poetry;
    @Column(name = "examTime")
    private String examTime;
    @Column(name = "identificatio_number")
    private Integer identificatioNumber;
    @Column(name = "examination_room")
    private String examinationRoom;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
