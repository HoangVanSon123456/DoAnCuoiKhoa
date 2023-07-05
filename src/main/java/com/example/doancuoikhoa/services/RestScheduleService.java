package com.example.doancuoikhoa.services;

import com.example.doancuoikhoa.model.RestScheduleDTO;
import com.example.doancuoikhoa.model.TuitionDTO;

import java.util.List;

public interface RestScheduleService {
    void addRestSchedule(RestScheduleDTO restScheduleDTO) ;

    void updateRestSchedule(RestScheduleDTO restScheduleDTO) throws Exception;

    void deleteRestSchedule(Integer id) throws Exception;

    RestScheduleDTO getRestScheduleById(Integer id);

    List<RestScheduleDTO> getAll();

    List<RestScheduleDTO> getUserRestSchedule(Integer userId);

    List<RestScheduleDTO> search(String keyword);

}
