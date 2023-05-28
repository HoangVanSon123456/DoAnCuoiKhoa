package com.example.doancuoikhoa.services;

import com.example.doancuoikhoa.model.CourseDTO;

import java.util.List;

public interface CourseService {

    void addCourse(CourseDTO courseDTO);

    void updateCourse(CourseDTO courseDTO) throws Exception;

    void deleteCourse(Integer id) throws Exception;

    CourseDTO getCourseById(Integer id);

    List<CourseDTO> getCourseByEdu(Integer eduId);



    List<CourseDTO> getListCourse();
}
