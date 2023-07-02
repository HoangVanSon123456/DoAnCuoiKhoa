package com.example.doancuoikhoa.services;

import com.example.doancuoikhoa.model.SubjectDTO;
import com.example.doancuoikhoa.model.SubjectDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubjectService {

    void addSubject(SubjectDTO subjectDTO) ;

    void updateSubject(SubjectDTO subjectDTO) throws Exception;

    void deleteSubject(Integer id) throws Exception;

    SubjectDTO getSubjectById(Integer id);

    List<SubjectDTO> getAll();
}
