package com.example.doancuoikhoa.services.impl;

import com.example.doancuoikhoa.entities.StudyScore;
import com.example.doancuoikhoa.entities.User;
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
    public void addStudyScoreService(StudyScoreDTO studyScoreDTO, Integer sectionScoreId) {
        StudyScore studyScore = new StudyScore();
        studyScore.setStudyTimes(studyScoreDTO.getStudyTimes());
        studyScore.setTestScore(studyScoreDTO.getTestScore());
        studyScore.setProcessPoint(studyScoreDTO.getProcessPoint());
        Float average = ((studyScoreDTO.getTestScore() + studyScoreDTO.getProcessPoint())/2);
        if(average >= 8.5) {
            studyScore.setLetterPoint("A");
        } else if(average >= 7.5) {
            studyScore.setLetterPoint("B");
        } else if(average >= 6.5) {
            studyScore.setLetterPoint("C");
        }else if(average >= 5.5) {
            studyScore.setLetterPoint("D");
        } else {
            studyScore.setLetterPoint("F");
        }
        if(average <= 4.5) {
            studyScore.setEvaluate("Chưa Đạt");
        } else  {
            studyScore.setEvaluate("Đạt");
        }
        studyScore.setEndPoint(average);
        User user = new User();
        user.setId(studyScoreDTO.getUserId());
        user.setName(studyScoreDTO.getUserName());
        studyScore.setUser(user);
        studyScore.setSectionScoreId(sectionScoreId);
        studyScoreRepository.save(studyScore);
    }

    @Override
    public void updateStudyScore(StudyScoreDTO studyScoreDTO) throws Exception {
        StudyScore studyScore = studyScoreRepository.findStudyScoreById(studyScoreDTO.getId());
        if(studyScore != null) {
            studyScore.setStudyTimes(studyScoreDTO.getStudyTimes());
            studyScore.setTestScore(studyScoreDTO.getTestScore());
            studyScore.setProcessPoint(studyScoreDTO.getProcessPoint());
            Float average = ((studyScoreDTO.getTestScore() + studyScoreDTO.getProcessPoint())/2);
            if(average >= 8.5) {
                studyScore.setLetterPoint("A");
            } else if(average >= 7.5) {
                studyScore.setLetterPoint("B");
            } else if(average >= 6.5) {
                studyScore.setLetterPoint("C");
            }else if(average >= 5.5) {
                studyScore.setLetterPoint("D");
            } else {
                studyScore.setLetterPoint("F");
            }
            if(average <= 4.5) {
                studyScore.setEvaluate("Chưa Đạt");
            } else  {
                studyScore.setEvaluate("Đạt");
            }
            studyScore.setEndPoint(average);
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
        studyScoreDTO.setStudyTimes(studyScore.getStudyTimes());
        studyScoreDTO.setTestScore(studyScore.getTestScore());
        studyScoreDTO.setEvaluate(studyScore.getEvaluate());
        studyScoreDTO.setEndPoint(studyScore.getEndPoint());
        studyScoreDTO.setProcessPoint(studyScore.getProcessPoint());
        studyScoreDTO.setLetterPoint(studyScore.getLetterPoint());
        studyScoreDTO.setUserId(studyScore.getUser().getId());
        studyScoreDTO.setUserName(studyScore.getUser().getName());
        studyScoreDTO.setSectionScoreId(studyScore.getSectionScoreId());
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

    @Override
    public List<StudyScoreDTO> search(String keyword) {
//        List<StudyScore> studyScores = studyScoreRepository.search(keyword);
//        List<StudyScoreDTO> studyScoreDTOS = new ArrayList<>();
//        studyScores.forEach(studyScore -> {
//            studyScoreDTOS.add(converToDTO(studyScore));
//        });
//        return studyScoreDTOS;
        return null;
    }


    @Override
    public List<StudyScoreDTO> getSectionScoreStudyScore(Integer sectionScoreId) {
        List<StudyScore> studyScores = studyScoreRepository.findAllBySectionScoreId(sectionScoreId);
        List<StudyScoreDTO> studyScoreDTOS = new ArrayList<>();
        studyScores.forEach(studyScore -> {
            studyScoreDTOS.add(converToDTO(studyScore));
        });
        return studyScoreDTOS;
    }
}
