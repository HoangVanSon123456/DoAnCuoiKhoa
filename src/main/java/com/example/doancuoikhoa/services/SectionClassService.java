package com.example.doancuoikhoa.services;

import com.example.doancuoikhoa.model.NotificationDTO;
import com.example.doancuoikhoa.model.SectionClassDTO;

import java.util.List;

public interface SectionClassService {

    void addSectionClassService(SectionClassDTO sectionClassDTO);

    void updateSectionClass(SectionClassDTO sectionClassDTO) throws Exception;

    void deleteSectionClass(Integer id) throws Exception;

    SectionClassDTO getSectionClassById(Integer id);


    List<SectionClassDTO> getListSectionClass();

    List<SectionClassDTO> search(String keyword);

}
