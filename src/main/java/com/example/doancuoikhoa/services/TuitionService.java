package com.example.doancuoikhoa.services;

import com.example.doancuoikhoa.model.TuitionDTO;

import java.util.List;

public interface TuitionService {

    void addTuition(TuitionDTO tuitionDTO);

    void updateTuition(TuitionDTO tuitionDTO) throws Exception;

    void deleteTuition(Integer id) throws Exception;

    TuitionDTO getTuitionById(Integer id);


    List<TuitionDTO> getListTuition();
}
