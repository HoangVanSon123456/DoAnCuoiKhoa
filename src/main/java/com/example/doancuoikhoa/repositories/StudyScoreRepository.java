package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.StudyScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyScoreRepository extends JpaRepository<StudyScore , Integer> {
    StudyScore findStudyScoreById(int id);

    List<StudyScore> findAllBy();
}
