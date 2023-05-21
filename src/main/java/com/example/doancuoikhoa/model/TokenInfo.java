package com.example.doancuoikhoa.model;

import lombok.Data;

@Data
public class TokenInfo {
    private Integer userId;
    private String accessToken;
    private String refreshToken;
}
