package com.example.doancuoikhoa.controllers;

import com.example.doancuoikhoa.model.SubjectDTO;
import com.example.doancuoikhoa.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = -1)
@RestController
@RequestMapping("/v1/api")
public class SubjectController {
    
    @Autowired
    private SubjectService subjectService;
    @GetMapping("/admin/subject")
    private List<SubjectDTO> getAll() {
        return subjectService.getAll();
    }

    @GetMapping("/admin/subject/{id}")
    private SubjectDTO getSubjectById(@PathVariable(name = "id") Integer id) {
        return subjectService.getSubjectById(id);
    }
    @DeleteMapping(value = "/admin/subject/delete/{id}")
    private void deleteSubject(@PathVariable(name = "id") Integer id) throws Exception {
        subjectService.deleteSubject(id);
    }

    @PostMapping(value = "/admin/subject/add")
    private SubjectDTO addSubject(@RequestBody SubjectDTO SubjectDTO) {
        subjectService.addSubject(SubjectDTO);
        return SubjectDTO;
    }

    @PutMapping(value = "/admin/subject/update/{id}")
    public void updateUser(@PathVariable(name = "id") Long id,@RequestBody SubjectDTO SubjectDTO) throws Exception {
        subjectService.updateSubject(SubjectDTO);
    }
}
