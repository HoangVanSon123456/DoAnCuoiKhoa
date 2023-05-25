package com.example.doancuoikhoa.model;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDTO<T> {
    private List<T> data;
    private boolean success;
}
