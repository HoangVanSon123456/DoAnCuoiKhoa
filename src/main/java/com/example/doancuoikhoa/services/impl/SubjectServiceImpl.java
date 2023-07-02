package com.example.doancuoikhoa.services.impl;

import com.example.doancuoikhoa.entities.Subject;
import com.example.doancuoikhoa.model.SubjectDTO;
import com.example.doancuoikhoa.repositories.SubjectRepository;
import com.example.doancuoikhoa.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public void addSubject(SubjectDTO subjectDTO) {
        Subject subject = new Subject();
        subject.setName(subjectDTO.getName());
        subjectRepository.save(subject);
    }

    @Override
    public void updateSubject(SubjectDTO subjectDTO) throws Exception {
        Subject subject = subjectRepository.findSubjectById(subjectDTO.getId());
        if(subject != null) {
            subject.setName(subjectDTO.getName());
            subjectRepository.save(subject);
        }
    }

    @Override
    public void deleteSubject(Integer id) throws Exception {
        Subject subject = subjectRepository.findSubjectById(id);
        if(subject != null) {
            subjectRepository.delete(subject);
        }
    }

    @Override
    public SubjectDTO getSubjectById(Integer id) {
        Subject subject = subjectRepository.findSubjectById(id);
        if(subject != null) {
            return converToDTO(subject);
        }
        return null;
    }

    private SubjectDTO converToDTO(Subject subject) {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(subject.getId());
        subjectDTO.setName(subject.getName());
        return subjectDTO;
    }

    @Override
    public List<SubjectDTO> getAll() {
        List<Subject> subjects = subjectRepository.findAllBy();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjects.forEach(subject -> {
            subjectDTOS.add(converToDTO(subject));
        });
        return subjectDTOS;
    }
}
