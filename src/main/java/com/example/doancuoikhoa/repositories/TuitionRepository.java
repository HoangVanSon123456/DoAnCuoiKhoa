package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.Tuition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TuitionRepository extends JpaRepository<Tuition, Integer> {
    Tuition findTuitionById(int id);

    List<Tuition> findAllBy();


}
