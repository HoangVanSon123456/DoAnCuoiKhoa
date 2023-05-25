package com.example.doancuoikhoa.services.impl;

import com.example.doancuoikhoa.entities.Course;
import com.example.doancuoikhoa.model.CourseDTO;
import com.example.doancuoikhoa.repositories.CourseRepository;
import com.example.doancuoikhoa.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Override
    public void addCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());

        courseRepository.save(course);
    }

    @Override
    public void updateCourse(CourseDTO courseDTO) throws Exception {
        Course course = courseRepository.findCourseById(courseDTO.getId());
        if(course != null) {
            course.setId(courseDTO.getId());
            course.setName(courseDTO.getName());
        }
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Integer id) throws Exception {
        Course course = courseRepository.findCourseById(id);
        if(course != null) {
            courseRepository.delete(course);
        } else {
            throw new Exception("Không tìm thấy học phần");
        }
    }

    @Override
    public CourseDTO getCourseById(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if(course != null) {
            return converToDTO(course);
        }
        return null;
    }

    private CourseDTO converToDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        return courseDTO;
    }

    @Override
    public List<CourseDTO> getListCourse() {
        List<Course> courses = courseRepository.findAllBy();
        List<CourseDTO> courseDTOS = new ArrayList<>();
        courses.forEach(course -> {
            courseDTOS.add(converToDTO(course));
        });
        return courseDTOS;
    }
}
