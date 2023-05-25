package com.example.doancuoikhoa.repositories;

import com.example.doancuoikhoa.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course , Integer> {

    Course findCourseById(int id);
    List<Course> findAllBy();
}
