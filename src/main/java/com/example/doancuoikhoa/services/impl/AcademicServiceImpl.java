package com.example.doancuoikhoa.services.impl;

import com.example.doancuoikhoa.entities.Academic;
import com.example.doancuoikhoa.entities.User;
import com.example.doancuoikhoa.model.AcademicDTO;
import com.example.doancuoikhoa.repositories.AcademicRepository;
import com.example.doancuoikhoa.services.AcademicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AcademicServiceImpl implements AcademicService {

    @Autowired
    private AcademicRepository academicRepository;
    @Override
    public void addAcademic(AcademicDTO academicDTO) {
        Academic academic = new Academic();
        academic.setYear(academicDTO.getYear());
        academic.setPunishmentLevel(academicDTO.getPunishmentLevel());
        User user = new User();
        user.setId(academicDTO.getUserId());
        user.setName(academicDTO.getUserName());
        user.setCode(academicDTO.getUserCode());
        academic.setUser(user);

        academicRepository.save(academic);
    }

    @Override
    public void updateAcademic(AcademicDTO academicDTO) throws Exception {
        Academic academic = academicRepository.findAcademicById(academicDTO.getId());
        if(academic != null) {
            academic.setYear(academicDTO.getYear());
            academic.setPunishmentLevel(academicDTO.getPunishmentLevel());
            User user = new User();
            user.setId(academicDTO.getUserId());
            user.setName(academicDTO.getUserName());
            user.setCode(academicDTO.getUserCode());
            academic.setUser(user);

            academicRepository.save(academic);
        }
    }

    @Override
    public void deleteAcademic(Integer id) throws Exception {
        Academic academic = academicRepository.findAcademicById(id);
        if(academic != null) {
            academicRepository.delete(academic);
        }
    }

    @Override
    public AcademicDTO getAcademicById(Integer id) {
        Academic academic = academicRepository.findAcademicById(id);
        if(academic != null) {
            return convertToDTO(academic);
        }
        return null;
    }

    private AcademicDTO convertToDTO(Academic academic) {
        AcademicDTO academicDTO = new AcademicDTO();
        academicDTO.setId(academic.getId());
        academicDTO.setYear(academic.getYear());
        academicDTO.setPunishmentLevel(academic.getPunishmentLevel());
        academicDTO.setUserId(academic.getUser().getId());
        academicDTO.setUserName(academic.getUser().getName());
        academicDTO.setUserCode(academic.getUser().getCode());
        return academicDTO;
    }

    @Override
    public List<AcademicDTO> getAll() {
        List<Academic> academics = academicRepository.findAllBy();
        List<AcademicDTO> academicDTOS = new ArrayList<>();
        academics.forEach(academic -> {
            academicDTOS.add(convertToDTO(academic));
        });
        return academicDTOS;
    }
}
