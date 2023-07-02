package com.example.doancuoikhoa.services;

import com.example.doancuoikhoa.model.PositionDTO;

import java.util.List;

public interface PositionService {

    void addPosition(PositionDTO positionDTO) ;

    void updatePosition(PositionDTO positionDTO) throws Exception;

    void deletePosition(Integer id) throws Exception;

    PositionDTO getPositionById(Integer id);

    List<PositionDTO> getAll();
    
}
