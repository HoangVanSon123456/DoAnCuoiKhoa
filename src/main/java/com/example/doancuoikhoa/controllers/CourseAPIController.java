package com.example.doancuoikhoa.controllers;

import com.example.doancuoikhoa.model.CourseDTO;
import com.example.doancuoikhoa.model.EduProCourseDTO;
import com.example.doancuoikhoa.model.ResponseDTO;
import com.example.doancuoikhoa.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = -1)
@RestController
@RequestMapping("/v1/api")
public class CourseAPIController {

    @Autowired
    private CourseService courseService;

//    @GetMapping("/admin/course")
//    private ResponseDTO<CourseDTO> getAll() {
//        ResponseDTO<CourseDTO> responseDTO = new ResponseDTO<CourseDTO>();
//        responseDTO.setData(courseService.getListCourse());
//        responseDTO.setStatus(HttpStatus.OK);
//        return responseDTO;
//    }

    @GetMapping("/admin/course")
    private ResponseEntity<?> getAll() {
        return courseService.getListCourse();
    }

    @GetMapping("/admin/course/{id}")
    private CourseDTO getNotifiationById(@PathVariable(name = "id") Integer id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/admin/edu_course/{id}")
    private ResponseEntity<?> getEduProCourseById(@PathVariable(name = "id") Integer id) {
        return courseService.getOneEduCourse(id);
    }

    @GetMapping("/admin/edu-course/{eduId}")
    private List<CourseDTO> getCourseByEdu(@PathVariable(name = "eduId") Integer eduId) {
        return courseService.getCourseByEdu(eduId);
    }

    @DeleteMapping(value = "/admin/course/delete/{id}")
    private void deleteCourse(@PathVariable(name = "id") Integer id) throws Exception {
        courseService.deleteCourse(id);
    }

    @DeleteMapping(value = "/admin/edu-course/delete/{courseId}/{educationProgramId}")
    private void deleteEduCourse(@PathVariable(name = "courseId") Integer courseId,@PathVariable(name = "educationProgramId") Integer educationProgramId) throws Exception {
        courseService.deleteEduCourse(courseId,educationProgramId);
    }

    @PostMapping(value = "/admin/course/add")
    private ResponseEntity<?> addCourse(@RequestBody CourseDTO courseDTO) {
      return courseService.addCourse(courseDTO);
    }
    @PostMapping("/admin/edu-course/add")
    private EduProCourseDTO addCourse(@RequestBody EduProCourseDTO eduProCourseDTO, @RequestHeader("eduId") Integer eduId) {
        courseService.addEduCourse(eduProCourseDTO, eduId);
        return eduProCourseDTO;
    }

    @PutMapping(value = "/admin/course/update/{id}")
    public void updateUser(@PathVariable(name = "id") Long id,@RequestBody CourseDTO courseDTO) throws Exception {
        courseService.updateCourse(courseDTO);
    }

    @GetMapping(value = "/admin/course/search/{keyword}")
    public List<CourseDTO> search(@PathVariable(name = "keyword") String keyword) {
        return courseService.search(keyword);
    }
}
