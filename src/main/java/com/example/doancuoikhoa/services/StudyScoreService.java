package com.example.doancuoikhoa.services;

import com.example.doancuoikhoa.model.EducationProgramDTO;
import com.example.doancuoikhoa.model.SectionClassDTO;
import com.example.doancuoikhoa.model.StudyScoreDTO;

import java.util.List;

public interface StudyScoreService {

    void addStudyScoreService(StudyScoreDTO studyScoreDTO, Integer sectionScoreId);

    void updateStudyScore(StudyScoreDTO studyScoreDTO) throws Exception;

    void deleteStudyScore(Integer id) throws Exception;

    StudyScoreDTO getStudyScoreById(Integer id);

    List<StudyScoreDTO> getStudyScore();

    List<StudyScoreDTO> search(String keyword);
    List<StudyScoreDTO> getSectionScoreStudyScore(Integer sectionScoreId);
}
