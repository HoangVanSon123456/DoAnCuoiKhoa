package com.example.doancuoikhoa.services.impl;

import com.example.doancuoikhoa.entities.Position;
import com.example.doancuoikhoa.model.PositionDTO;
import com.example.doancuoikhoa.model.PositionDTO;
import com.example.doancuoikhoa.repositories.PositionRepository;
import com.example.doancuoikhoa.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {
    
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public void addPosition(PositionDTO positionDTO) {
        Position position = new Position();
        position.setName(positionDTO.getName());
        positionRepository.save(position);
    }

    @Override
    public void updatePosition(PositionDTO PositionDTO) throws Exception {
        Position position = positionRepository.findPositionById(PositionDTO.getId());
        if(position != null) {
            position.setName(PositionDTO.getName());
            positionRepository.save(position);
        }
    }

    @Override
    public void deletePosition(Integer id) throws Exception {
        Position position = positionRepository.findPositionById(id);
        if(position != null) {
            positionRepository.delete(position);
        }
    }

    @Override
    public PositionDTO getPositionById(Integer id) {
        Position position = positionRepository.findPositionById(id);
        if(position != null) {
            return converToDTO(position);
        }
        return null;
    }

    private PositionDTO converToDTO(Position position) {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setId(position.getId());
        positionDTO.setName(position.getName());
        return positionDTO;
    }

    @Override
    public List<PositionDTO> getAll() {
        List<Position> positions = positionRepository.findAllBy();
        List<PositionDTO> positionDTOS = new ArrayList<>();
        positions.forEach(Position -> {
            positionDTOS.add(converToDTO(Position));
        });
        return positionDTOS;
    }
}
