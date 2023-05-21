package com.example.doancuoikhoa.model;

import lombok.Data;

@Data
public class TokenInfo {
    private Integer userId;
    private String email;
    private String password;
    private String accessToken;
    private String refreshToken;
}
