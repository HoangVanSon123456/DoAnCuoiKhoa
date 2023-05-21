package com.example.doancuoikhoa.model;

import lombok.Data;

@Data
public class UserDTO {

    private String email;

    private String password;

    private Boolean enabled;

    private String refreshToken;
}
