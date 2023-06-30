package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.StudyScore;
import com.example.doancuoikhoa.entities.Tuition;
import com.example.doancuoikhoa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TuitionRepository extends JpaRepository<Tuition, Integer> {
    Tuition findTuitionById(int id);

    List<Tuition> findAllBy();

    List<Tuition> findAllByUserId(Integer userId);

    @Query(value = "SELECT t FROM Tuition t inner join  User u on u.id = t.user.id WHERE CONCAT(u.code,'') LIKE %?1%")
    List<Tuition> search(String keyword);
}
