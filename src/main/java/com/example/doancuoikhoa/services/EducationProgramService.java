package com.example.doancuoikhoa.services;


import com.example.doancuoikhoa.model.CourseDTO;
import com.example.doancuoikhoa.model.EducationProgramDTO;

import java.util.List;

public interface EducationProgramService {
    void addEducationProgramService(EducationProgramDTO EducationProgramDTO);

    void updateEducationProgram(EducationProgramDTO EducationProgramDTO) throws Exception;

    void deleteEducationProgram(Integer id) throws Exception;

    EducationProgramDTO getEducationProgramById(Integer id);

    List<EducationProgramDTO> getListEducationProgram();

}
