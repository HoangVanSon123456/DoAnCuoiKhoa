package com.example.doancuoikhoa.services;

import com.example.doancuoikhoa.model.CourseDTO;
import com.example.doancuoikhoa.model.EduProCourseDTO;

import java.util.List;

public interface CourseService {

    void addCourse(CourseDTO courseDTO);

    void updateCourse(CourseDTO courseDTO) throws Exception;

    void deleteCourse(Integer id) throws Exception;

    CourseDTO getCourseById(Integer id);

    List<CourseDTO> getCourseByEdu(Integer eduId);

    void addEduCourse(EduProCourseDTO eduProCourseDTO);

    List<CourseDTO> getListCourse();
}
