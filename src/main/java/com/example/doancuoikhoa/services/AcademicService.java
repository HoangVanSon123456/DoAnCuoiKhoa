package com.example.doancuoikhoa.services;

import com.example.doancuoikhoa.model.AcademicDTO;

import java.util.List;

public interface AcademicService {
    void addAcademic(AcademicDTO academicDTO) ;

    void updateAcademic(AcademicDTO academicDTO) throws Exception;

    void deleteAcademic(Integer id) throws Exception;

    AcademicDTO getAcademicById(Integer id);

    List<AcademicDTO> getAll();
}
