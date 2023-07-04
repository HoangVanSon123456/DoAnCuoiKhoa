package com.example.doancuoikhoa.model;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private String name;
    private String age;
    private String useName;
    private String email;
    private String password;
    private String newPassword;
    private Boolean enabled;
    private String address;
    private String gender;
    private String phone;
    private String userRole;
    private String userPosition;
    private String refreshToken;
    private String accessToken;
    private Integer code;
    private Integer subjectId;
    private String subjectName;
    private String depict;
    private Integer positionId;
    private String positionName;
}
