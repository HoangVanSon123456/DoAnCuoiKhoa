package com.example.doancuoikhoa.controllers;

import com.example.doancuoikhoa.model.AcademicDTO;
import com.example.doancuoikhoa.model.SectionClassDTO;
import com.example.doancuoikhoa.services.AcademicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = -1)
@RestController
@RequestMapping("/v1/api")
public class AcademicController {

    @Autowired
    private AcademicService academicService;

    @GetMapping("/admin/academic")
    private List<AcademicDTO> getAll() {
        return academicService.getAll();
    }

    @PostMapping(value = "/admin/academic/add")
    private AcademicDTO addAcademic(@RequestBody AcademicDTO academicDTO) {
        academicService.addAcademic(academicDTO);
        return academicDTO;
    }
    @GetMapping("/admin/academic/{id}")
    private AcademicDTO getAcademicById(@PathVariable(name = "id") Integer id) {
        return academicService.getAcademicById(id);
    }
    @DeleteMapping(value = "/admin/academic/delete/{id}")
    private void deleteAcademic(@PathVariable(name = "id") Integer id) throws Exception {
        academicService.deleteAcademic(id);
    }

    @PutMapping(value = "/admin/academic/update/{id}")
    public void updateAcademic(@PathVariable(name = "id") Long id,@RequestBody AcademicDTO academicDTO) throws Exception {
        academicService.updateAcademic(academicDTO);
    }
}
