package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.EduProCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EduProCourseRepository extends JpaRepository<EduProCourse, Integer> {
    List<EduProCourse> findAllByEducationProgramId(int eduProgramId);
}
