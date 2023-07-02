package com.example.doancuoikhoa.services;

import com.example.doancuoikhoa.model.RestScheduleDTO;

import java.util.List;

public interface RestScheduleService {
    void addRestSchedule(RestScheduleDTO restScheduleDTO) ;

    void updateRestSchedule(RestScheduleDTO restScheduleDTO) throws Exception;

    void deleteRestSchedule(Integer id) throws Exception;

    RestScheduleDTO getRestScheduleById(Integer id);

    List<RestScheduleDTO> getAll();
}
