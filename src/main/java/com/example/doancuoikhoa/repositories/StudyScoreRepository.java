package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.Notification;
import com.example.doancuoikhoa.entities.StudyScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyScoreRepository extends JpaRepository<StudyScore , Integer> {
    StudyScore findStudyScoreById(int id);

    List<StudyScore> findAllBy();

    List<StudyScore> findAllByUserId(Integer userId);

//        @Query(value = "SELECT n FROM Course n JOIN n.id WHERE CONCAT(n.name, '') LIKE %?1%")
//    List<StudyScore> search(String keyword);

}
