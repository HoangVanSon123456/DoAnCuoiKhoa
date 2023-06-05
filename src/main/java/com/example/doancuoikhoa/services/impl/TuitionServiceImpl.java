package com.example.doancuoikhoa.services.impl;

import com.example.doancuoikhoa.entities.Tuition;
import com.example.doancuoikhoa.model.TuitionDTO;
import com.example.doancuoikhoa.repositories.TuitionRepository;
import com.example.doancuoikhoa.services.TuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class TuitionServiceImpl implements TuitionService {

    @Autowired
    private TuitionRepository tuitionRepository;
    @Override
    public void addTuition(TuitionDTO tuitionDTO , Integer userId) {
        Tuition tuition = new Tuition();
        tuition.setTuitionType(tuitionDTO.getTuitionType());
        tuition.setPrice(tuitionDTO.getPrice());
        tuition.setDiscount(tuitionDTO.getDiscount());
        tuition.setIntoMoney(tuitionDTO.getIntoMoney());
        tuition.setCreditName(tuitionDTO.getCreditName());
        tuition.setReLearn(tuitionDTO.getReLearn());
        tuition.setSemester(tuitionDTO.getSemester());
        tuition.setUserId(userId);
        tuitionRepository.save(tuition);
    }

    @Override
    public void updateTuition(TuitionDTO tuitionDTO) throws Exception {
        Tuition tuition = tuitionRepository.findTuitionById(tuitionDTO.getId());
        if(tuition != null) {
            tuition.setId(tuitionDTO.getId());
            tuition.setTuitionType(tuition.getTuitionType());
            tuition.setPrice(tuitionDTO.getPrice());
            tuition.setDiscount(tuitionDTO.getDiscount());
            tuition.setIntoMoney(tuitionDTO.getIntoMoney());
            tuition.setCreditName(tuitionDTO.getCreditName());
            tuition.setReLearn(tuitionDTO.getReLearn());
            tuition.setSemester(tuitionDTO.getSemester());
        }
        tuitionRepository.save(tuition);
    }

    @Override
    public void deleteTuition(Integer id) throws Exception {
        Tuition tuition = tuitionRepository.findTuitionById(id);
        if(tuition != null) {
            tuitionRepository.delete(tuition);
        } else {
            throw new Exception("Không tìm thấy");
        }
    }

    @Override
    public TuitionDTO getTuitionById(Integer id) {
        Tuition tuition = tuitionRepository.findTuitionById(id);
        if(tuition != null) {
            return converToDTO(tuition);
        }
        return null;
    }

    private TuitionDTO converToDTO(Tuition tuition) {
        TuitionDTO tuitionDTO = new TuitionDTO();
        tuitionDTO.setId(tuition.getId());
        tuitionDTO.setTuitionType(tuition.getTuitionType());
        tuitionDTO.setPrice(tuition.getPrice());
        tuitionDTO.setDiscount(tuition.getDiscount());
        tuitionDTO.setIntoMoney(tuition.getIntoMoney());
        tuitionDTO.setCreditName(tuition.getCreditName());
        tuitionDTO.setReLearn(tuition.getReLearn());
        tuitionDTO.setSemester(tuition.getSemester());
        tuitionDTO.setUserId(tuition.getUserId());
        return tuitionDTO;
    }

    @Override
    public List<TuitionDTO> getListTuition() {
        List<Tuition> tuitions = tuitionRepository.findAllBy();
        List<TuitionDTO> tuitionDTOS = new ArrayList<>();
        tuitions.forEach(tuition -> {
            tuitionDTOS.add(converToDTO(tuition));
        });
        return tuitionDTOS;
    }

    @Override
    public List<TuitionDTO> getUserTuition(Integer userId) {
        List<Tuition> tuitions = tuitionRepository.findAllByUserId(userId);
        List<TuitionDTO> tuitionDTOS = new ArrayList<>();
        tuitions.forEach(tuition -> {
            tuitionDTOS.add(converToDTO(tuition));
        });
        return tuitionDTOS;
    }
}
