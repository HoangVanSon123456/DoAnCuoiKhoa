package com.example.doancuoikhoa.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "academic")
public class Academic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "year")
    private String year;

    @Column(name = "punishment_level")
    private String punishmentLevel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
