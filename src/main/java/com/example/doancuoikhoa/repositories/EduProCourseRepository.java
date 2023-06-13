package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.Course;
import com.example.doancuoikhoa.entities.EduProCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EduProCourseRepository extends JpaRepository<EduProCourse, Integer> {
    List<EduProCourse> findAllByEducationProgramId(int eduProgramId);

    @Query(value = "select edu from  EduProCourse edu where edu.courseId = :courseId and edu.educationProgramId = :educationProgramId")
    EduProCourse findEduProCourseById(Integer courseId , Integer educationProgramId);

    List<EduProCourse> findAllBy();
}
