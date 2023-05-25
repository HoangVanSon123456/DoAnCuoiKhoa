package com.example.doancuoikhoa.services.impl;

import com.example.doancuoikhoa.entities.EducationProgram;
import com.example.doancuoikhoa.model.EducationProgramDTO;
import com.example.doancuoikhoa.repositories.EducationProgramRepository;
import com.example.doancuoikhoa.services.EducationProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EducationProgramServiceImpl implements EducationProgramService {
    
    @Autowired
    private EducationProgramRepository educationProgramRepository;

    @Override
    public void addEducationProgramService(EducationProgramDTO EducationProgramDTO) {
        EducationProgram educationProgram =  new EducationProgram();
        educationProgram.setSemester(EducationProgramDTO.getSemester());
        educationProgram.setCourseCode(EducationProgramDTO.getCourseCode());
        educationProgram.setCourseName(EducationProgramDTO.getCourseName());
        educationProgram.setCreditName(EducationProgramDTO.getCreditName());
        educationProgram.setPracticalClass(EducationProgramDTO.getPracticalClass());
        educationProgram.setTheoryClass(EducationProgramDTO.getTheoryClass());

        educationProgramRepository.save(educationProgram);
    }

    @Override
    public void updateEducationProgram(EducationProgramDTO EducationProgramDTO) throws Exception {
        EducationProgram educationProgram = educationProgramRepository.findEducationProgramById(EducationProgramDTO.getId());
        if(educationProgram != null) {
            educationProgram.setId(EducationProgramDTO.getId());
            educationProgram.setSemester(EducationProgramDTO.getSemester());
            educationProgram.setCourseCode(EducationProgramDTO.getCourseCode());
            educationProgram.setCourseName(EducationProgramDTO.getCourseName());
            educationProgram.setCreditName(EducationProgramDTO.getCreditName());
            educationProgram.setPracticalClass(EducationProgramDTO.getPracticalClass());
            educationProgram.setTheoryClass(EducationProgramDTO.getTheoryClass());
        }
        educationProgramRepository.save(educationProgram);
    }

    @Override
    public void deleteEducationProgram(Integer id) throws Exception {
        EducationProgram educationProgram = educationProgramRepository.findEducationProgramById(id);
        if(educationProgram != null) {
            educationProgramRepository.delete(educationProgram);
        }else {
            throw new Exception("Không tìm thấy chuong trinh dao tao");
        }
    }

    @Override
    public EducationProgramDTO getEducationProgramById(Integer id) {
        EducationProgram educationProgram =  educationProgramRepository.findEducationProgramById(id);
        if(educationProgram != null) {
            return converToDTO(educationProgram);
        }
        return null;
    }

    @Override
    public List<EducationProgramDTO> getListEducationProgram() {
        List<EducationProgram> educationPrograms = educationProgramRepository.findAllBy();
        List<EducationProgramDTO> educationProgramDTOS = new ArrayList<>();
        educationPrograms.forEach(educationProgram -> {
            educationProgramDTOS.add(converToDTO(educationProgram));
        });
        return educationProgramDTOS;
    }

    private EducationProgramDTO converToDTO(EducationProgram educationProgram) {
        EducationProgramDTO educationProgramDTO = new EducationProgramDTO();
        educationProgramDTO.setId(educationProgram.getId());
        educationProgramDTO.setSemester(educationProgram.getSemester());
        educationProgramDTO.setCourseCode(educationProgram.getCourseCode());
        educationProgramDTO.setCourseName(educationProgram.getCourseName());
        educationProgramDTO.setCreditName(educationProgram.getCreditName());
        educationProgramDTO.setPracticalClass(educationProgram.getPracticalClass());
        educationProgramDTO.setTheoryClass(educationProgram.getTheoryClass());
        return educationProgramDTO;
    }
}
