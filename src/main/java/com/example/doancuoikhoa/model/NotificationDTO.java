package com.example.doancuoikhoa.model;

import lombok.Data;

@Data
public class NotificationDTO {
    private Integer id;
    private String title;
    private String content;
    private String files;
    private Integer userId;
    private String userName;

}
