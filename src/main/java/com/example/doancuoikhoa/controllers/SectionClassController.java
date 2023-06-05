package com.example.doancuoikhoa.controllers;

import com.example.doancuoikhoa.model.CourseDTO;
import com.example.doancuoikhoa.model.SectionClassDTO;
import com.example.doancuoikhoa.services.SectionClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = -1)
@RestController
@RequestMapping("/v1/api")
public class SectionClassController {

    @Autowired
    private SectionClassService sectionClassService;

    @GetMapping("/admin/sectionClass")
    private List<SectionClassDTO> getAll() {
        return sectionClassService.getListSectionClass();
    }

    @GetMapping("/admin/sectionClass/{id}")
    private SectionClassDTO getSectionClassById(@PathVariable(name = "id") Integer id) {
        return sectionClassService.getSectionClassById(id);
    }
    @DeleteMapping(value = "/admin/sectionClass/delete/{id}")
    private void deleteSectionClass(@PathVariable(name = "id") Integer id) throws Exception {
        sectionClassService.deleteSectionClass(id);
    }

    @PostMapping(value = "/admin/sectionClass/add")
    private SectionClassDTO addSectionClass(@RequestBody SectionClassDTO SectionClassDTO) {
        sectionClassService.addSectionClassService(SectionClassDTO);
        return SectionClassDTO;
    }

    @PutMapping(value = "/admin/sectionClass/update/{id}")
    public void updateUser(@PathVariable(name = "id") Long id,@RequestBody SectionClassDTO SectionClassDTO) throws Exception {
        sectionClassService.updateSectionClass(SectionClassDTO);
    }

    @GetMapping(value = "/admin/sectionClass/search/{keyword}")
    public  List<SectionClassDTO> search(@PathVariable(name = "keyword") String keyword) {
        return sectionClassService.search(keyword);
    }
}