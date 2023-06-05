package com.example.doancuoikhoa.services.impl;

import com.example.doancuoikhoa.entities.SectionClass;
import com.example.doancuoikhoa.model.SectionClassDTO;
import com.example.doancuoikhoa.repositories.SectionClassRepository;
import com.example.doancuoikhoa.services.SectionClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SectionClassServiceImpl implements SectionClassService {

    @Autowired
    private SectionClassRepository sectionClassRepository;

    @Override
    public void addSectionClassService(SectionClassDTO sectionClassDTO) {
        SectionClass sectionClass = new SectionClass();
        sectionClass.setName(sectionClassDTO.getName());
        sectionClassRepository.save(sectionClass);
    }

    @Override
    public void updateSectionClass(SectionClassDTO sectionClassDTO) throws Exception {
        SectionClass sectionClass = sectionClassRepository.findSectionClassById(sectionClassDTO.getId());
        if (sectionClass != null) {
            sectionClass.setName(sectionClassDTO.getName());
            sectionClassRepository.save(sectionClass);
        }
    }

    @Override
    public void deleteSectionClass(Integer id) throws Exception {
        SectionClass sectionClass = sectionClassRepository.findSectionClassById(id);
        if (sectionClass != null) {
            sectionClassRepository.delete(sectionClass);
        }
    }

    @Override
    public SectionClassDTO getSectionClassById(Integer id) {
        SectionClass sectionClass = sectionClassRepository.findSectionClassById(id);
        if (sectionClass != null) {
            return convertToDTO(sectionClass);
        }
        return null;
    }

    private SectionClassDTO convertToDTO(SectionClass sectionClass) {
        SectionClassDTO sectionClassDTO = new SectionClassDTO();
        sectionClassDTO.setId(sectionClass.getId());
        sectionClassDTO.setName(sectionClass.getName());
        return sectionClassDTO;
    }


    @Override
    public List<SectionClassDTO> getListSectionClass() {
        List<SectionClass> sectionClasses = sectionClassRepository.findAllBy();
        List<SectionClassDTO> sectionClassDTOS = new ArrayList<>();
        sectionClasses.forEach(sectionClass -> {
            sectionClassDTOS.add(convertToDTO(sectionClass));
        });
        return sectionClassDTOS;
    }


    @Override
    public List<SectionClassDTO> search(String keyword) {
        List<SectionClass> sectionClasses = sectionClassRepository.search(keyword);
        List<SectionClassDTO> sectionClassDTOS = new ArrayList<>();
        sectionClasses.forEach(sectionClass -> {
            sectionClassDTOS.add(convertToDTO(sectionClass));
        });
        return sectionClassDTOS;
    }
}
