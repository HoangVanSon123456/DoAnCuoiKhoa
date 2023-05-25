package com.example.doancuoikhoa.services.impl;

import com.example.doancuoikhoa.entities.StudyScore;
import com.example.doancuoikhoa.model.StudyScoreDTO;
import com.example.doancuoikhoa.repositories.StudyScoreRepository;
import com.example.doancuoikhoa.services.StudyScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudyScoreServiceImpl implements StudyScoreService {
    @Autowired
    private StudyScoreRepository studyScoreRepository;
    @Override
    public void addStudyScoreService(StudyScoreDTO studyScoreDTO) {
        StudyScore studyScore = new StudyScore();
        studyScore.setCourseName(studyScoreDTO.getCourseName());
        studyScore.setCourseCode(studyScoreDTO.getCourseCode());
        studyScore.setStudyTimes(studyScoreDTO.getStudyTimes());
        studyScore.setTestScore(studyScoreDTO.getTestScore());
        studyScore.setEvaluate(studyScoreDTO.getEvaluate());
        studyScore.setCreditName(studyScoreDTO.getCreditName());
        studyScore.setEndPoint(studyScoreDTO.getEndPoint());
        studyScore.setProcessPoint(studyScoreDTO.getProcessPoint());
        studyScore.setLetterPoint(studyScoreDTO.getLetterPoint());

        studyScoreRepository.save(studyScore);
    }

    @Override
    public void updateStudyScore(StudyScoreDTO studyScoreDTO) throws Exception {
        StudyScore studyScore = studyScoreRepository.findStudyScoreById(studyScoreDTO.getId());
        if(studyScore != null) {
            studyScore.setCourseName(studyScoreDTO.getCourseName());
            studyScore.setCourseCode(studyScoreDTO.getCourseCode());
            studyScore.setStudyTimes(studyScoreDTO.getStudyTimes());
            studyScore.setTestScore(studyScoreDTO.getTestScore());
            studyScore.setEvaluate(studyScoreDTO.getEvaluate());
            studyScore.setCreditName(studyScoreDTO.getCreditName());
            studyScore.setEndPoint(studyScoreDTO.getEndPoint());
            studyScore.setProcessPoint(studyScoreDTO.getProcessPoint());
            studyScore.setLetterPoint(studyScoreDTO.getLetterPoint());

            studyScoreRepository.save(studyScore);
        }
    }

    @Override
    public void deleteStudyScore(Integer id) throws Exception {
        StudyScore studyScore = studyScoreRepository.findStudyScoreById(id);
        if(studyScore != null) {
             studyScoreRepository.delete(studyScore);
        } else  {
            throw new Exception("Không tìm thấy điểm");
        }

    }

    @Override
    public StudyScoreDTO getStudyScoreById(Integer id) {
        StudyScore studyScore = studyScoreRepository.findStudyScoreById(id);
        if(studyScore != null) {
            return converToDTO(studyScore);
        }
        return null;
    }

    private StudyScoreDTO converToDTO(StudyScore studyScore) {
        StudyScoreDTO studyScoreDTO = new StudyScoreDTO();
        studyScoreDTO.setId(studyScore.getId());
        studyScoreDTO.setCourseName(studyScore.getCourseName());
        studyScoreDTO.setCourseCode(studyScore.getCourseCode());
        studyScoreDTO.setStudyTimes(studyScore.getStudyTimes());
        studyScoreDTO.setTestScore(studyScore.getTestScore());
        studyScoreDTO.setEvaluate(studyScore.getEvaluate());
        studyScoreDTO.setCreditName(studyScore.getCreditName());
        studyScoreDTO.setEndPoint(studyScore.getEndPoint());
        studyScoreDTO.setProcessPoint(studyScore.getProcessPoint());
        studyScoreDTO.setLetterPoint(studyScore.getLetterPoint());

        return studyScoreDTO;
    }

    @Override
    public List<StudyScoreDTO> getStudyScore() {
        List<StudyScore> studyScores = studyScoreRepository.findAllBy();
        List<StudyScoreDTO> studyScoreDTOS = new ArrayList<>();
        studyScores.forEach(studyScore -> {
            studyScoreDTOS.add(converToDTO(studyScore));
        });
        return studyScoreDTOS;
    }
}
