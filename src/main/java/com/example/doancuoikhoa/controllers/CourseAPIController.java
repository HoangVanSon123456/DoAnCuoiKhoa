package com.example.doancuoikhoa.controllers;

import com.example.doancuoikhoa.model.CourseDTO;
import com.example.doancuoikhoa.model.ResponseDTO;
import com.example.doancuoikhoa.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = -1)
@RestController
@RequestMapping("/v1/api")
public class CourseAPIController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/admin/course")
    private ResponseDTO<CourseDTO> getAll() {
        ResponseDTO<CourseDTO> responseDTO = new ResponseDTO<CourseDTO>();
        responseDTO.setData(courseService.getListCourse());
        return responseDTO;
    }

    @GetMapping("/admin/course/{id}")
    private CourseDTO getNotifiationById(@PathVariable(name = "id") Integer id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping(value = "/admin/course/delete/{id}")
    private void deleteCourse(@PathVariable(name = "id") Integer id) throws Exception {
        courseService.deleteCourse(id);
    }

    @PostMapping(value = "/admin/course/add")
    private CourseDTO addCourse(@RequestBody CourseDTO courseDTO) {
        courseService.addCourse(courseDTO);
        return courseDTO;
    }

    @PutMapping(value = "/admin/course/update/{id}")
    public void updateUser(@PathVariable(name = "id") Long id,@RequestBody CourseDTO courseDTO) throws Exception {
        courseService.updateCourse(courseDTO);
    }
}