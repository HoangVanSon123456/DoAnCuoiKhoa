package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.Course;
import com.example.doancuoikhoa.entities.SectionClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionClassRepository extends JpaRepository<SectionClass , Integer> {

    SectionClass findSectionClassById(int id);

    List<SectionClass> findAllBy();

    @Query(value = "SELECT c FROM SectionClass c WHERE CONCAT(c.name,' ') LIKE %?1%")
    List<SectionClass> search(String keyword);
}
