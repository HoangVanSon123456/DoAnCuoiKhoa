package com.example.doancuoikhoa.services.impl;

import com.example.doancuoikhoa.entities.Tuition;
import com.example.doancuoikhoa.entities.User;
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
    public void addTuition(TuitionDTO tuitionDTO) {
        Tuition tuition = new Tuition();
        tuition.setTuitionType(tuitionDTO.getTuitionType());
        tuition.setIntoMoney(tuitionDTO.getIntoMoney());
        tuition.setSemester(tuitionDTO.getSemester());
        tuition.setStatus(tuitionDTO.getStatus());
        User user = new User();
        user.setId(tuitionDTO.getUserId());
        user.setName(tuitionDTO.getUserName());
        tuition.setUser(user);
        tuitionRepository.save(tuition);
    }

    @Override
    public void updateTuition(TuitionDTO tuitionDTO) throws Exception {
        Tuition tuition = tuitionRepository.findTuitionById(tuitionDTO.getId());
        if(tuition != null) {
            tuition.setId(tuitionDTO.getId());
            tuition.setTuitionType(tuitionDTO.getTuitionType());
            tuition.setIntoMoney(tuitionDTO.getIntoMoney());
            tuition.setSemester(tuitionDTO.getSemester());
            tuition.setStatus(tuitionDTO.getStatus());
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

    @Override
    public List<TuitionDTO> search(String keyword) {
        List<Tuition> tuitions = tuitionRepository.search(keyword);
        List<TuitionDTO> tuitionDTOS = new ArrayList<>();
        tuitions.forEach(tuition -> {
            tuitionDTOS.add(converToDTO(tuition));
        });
        return tuitionDTOS;
    }

    private TuitionDTO converToDTO(Tuition tuition) {
        TuitionDTO tuitionDTO = new TuitionDTO();
        tuitionDTO.setId(tuition.getId());
        tuitionDTO.setTuitionType(tuition.getTuitionType());
        tuitionDTO.setIntoMoney(tuition.getIntoMoney());
        tuitionDTO.setSemester(tuition.getSemester());
        tuitionDTO.setUserId(tuition.getUser().getId());
        tuitionDTO.setUserName(tuition.getUser().getName());
        tuitionDTO.setUserCode(tuition.getUser().getCode());
        tuitionDTO.setStatus(tuition.getStatus());
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
