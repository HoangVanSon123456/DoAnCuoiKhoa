package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.EducationProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EducationProgramRepository extends JpaRepository<EducationProgram, Integer> {

    EducationProgram findEducationProgramById(int id);

    List<EducationProgram> findAllBy();
}
