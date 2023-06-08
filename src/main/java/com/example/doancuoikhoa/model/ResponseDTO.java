package com.example.doancuoikhoa.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ResponseDTO<T> {
    private List<T> data;
    private Integer status;
    private String message;
}
