package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass, Integer> {

    List<StudentClass> findAllBySectionClassId(Integer sectionClassId);
}
