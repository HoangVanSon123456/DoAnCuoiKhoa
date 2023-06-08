package com.example.doancuoikhoa.services.impl;

import com.example.doancuoikhoa.entities.Course;
import com.example.doancuoikhoa.entities.EduProCourse;
import com.example.doancuoikhoa.entities.EducationProgram;
import com.example.doancuoikhoa.model.CourseDTO;
import com.example.doancuoikhoa.model.EduProCourseDTO;
import com.example.doancuoikhoa.model.EducationProgramDTO;
import com.example.doancuoikhoa.model.ResponseDTO;
import com.example.doancuoikhoa.repositories.CourseRepository;
import com.example.doancuoikhoa.repositories.EduProCourseRepository;
import com.example.doancuoikhoa.services.CourseService;
import com.example.doancuoikhoa.services.EducationProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EduProCourseRepository eduProCourseRepository;
    
    @Override
    public ResponseEntity<?> addCourse(CourseDTO courseDTO)  {
        ResponseDTO<CourseDTO> responseDTO = new ResponseDTO<>();
        try {
            Course course = new Course();
            course.setName(courseDTO.getName());
            course.setCode(courseDTO.getCode());
            course.setTheoryClass(courseDTO.getTheoryClass());
            course.setPracticalClass(courseDTO.getPracticalClass());
            course.setCreditName(courseDTO.getCreditName());
            courseRepository.save(course);
            responseDTO.setStatus(HttpStatus.OK.value());
            responseDTO.setMessage("Thêm thành Công");
        } catch (Exception e)  {
            responseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseDTO.setMessage("Có lỗi xảy ra");
        }
        return ResponseEntity.ok(responseDTO);
    }

    @Override
    public void updateCourse(CourseDTO courseDTO) throws Exception {
        Course course = courseRepository.findCourseById(courseDTO.getId());
        if (course != null) {
            course.setId(courseDTO.getId());
            course.setName(courseDTO.getName());
            course.setCode(courseDTO.getCode());
            course.setTheoryClass(courseDTO.getTheoryClass());
            course.setPracticalClass(courseDTO.getPracticalClass());
            course.setCreditName(courseDTO.getCreditName());
        }
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Integer id) throws Exception {
        Course course = courseRepository.findCourseById(id);
        if (course != null) {
            courseRepository.delete(course);
        } else {
            throw new Exception("Không tìm thấy học phần");
        }
    }

    @Override
    public CourseDTO getCourseById(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if (course != null) {
            return converToDTO(course);
        }
        return null;
    }

    @Override
    public List<CourseDTO> getCourseByEdu(Integer eduId) {
        List<EduProCourse> eduProCourse = eduProCourseRepository.findAllByEducationProgramId(eduId);
        List<Integer> courseIds = new ArrayList<>();
        for (EduProCourse data : eduProCourse) {
            courseIds.add(data.getCourseId());
        }
        List<Course> courses = courseRepository.findAllByIdIn(courseIds);
        List<CourseDTO> courseDTOS = new ArrayList<>();
        courses.forEach(course -> {
            courseDTOS.add(converToDTO(course));
        });
        return courseDTOS;
    }

    @Override
    public void addEduCourse(EduProCourseDTO eduProCourseDTO, Integer eduId) {
        List<EduProCourse> saveEduProCourse = new ArrayList<>();
        for (Integer courseId : eduProCourseDTO.getCourseIds()) {
            EduProCourse eduProCourse = new EduProCourse();
            eduProCourse.setCourseId(courseId);
            eduProCourse.setEducationProgramId(eduId);
            saveEduProCourse.add(eduProCourse);
        }
        eduProCourseRepository.saveAll(saveEduProCourse);
    }

    private CourseDTO converToDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setCode(course.getCode());
        courseDTO.setTheoryClass(course.getTheoryClass());
        courseDTO.setPracticalClass(course.getPracticalClass());
        courseDTO.setCreditName(course.getCreditName());
        return courseDTO;
    }

    @Override
    public ResponseEntity<?> getListCourse() {
        ResponseDTO<CourseDTO> responseDTO = new ResponseDTO<>();
        try {
            List<Course> courses = courseRepository.findAllBy();
            List<CourseDTO> courseDTOS = new ArrayList<>();
            courses.forEach(course -> {
                courseDTOS.add(converToDTO(course));
            });
            responseDTO.setStatus(HttpStatus.OK.value());
            responseDTO.setData(courseDTOS);
            responseDTO.setMessage("Thành Công");
        } catch (Exception e) {
            responseDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseDTO.setMessage("Có lỗi xảy ra");
        }
        return ResponseEntity.ok(responseDTO);
    }

    @Override
    public List<CourseDTO> search(String keyword) {
        List<Course> courses = courseRepository.search(keyword);
        List<CourseDTO> courseDTOS = new ArrayList<>();
        courses.forEach(course -> {
            courseDTOS.add(converToDTO(course));
        });
        return courseDTOS;
    }
}
