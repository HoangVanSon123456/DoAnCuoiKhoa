package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.Academic;
import com.example.doancuoikhoa.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicRepository extends JpaRepository<Academic, Integer> {
    Academic findAcademicById(int id);

    List<Academic> findAllBy();
}
