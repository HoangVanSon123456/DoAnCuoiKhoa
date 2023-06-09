package com.example.doancuoikhoa.controllers;

import com.example.doancuoikhoa.model.CourseDTO;
import com.example.doancuoikhoa.model.EducationProgramDTO;
import com.example.doancuoikhoa.model.SectionClassDTO;
import com.example.doancuoikhoa.model.StudyScoreDTO;
import com.example.doancuoikhoa.services.StudyScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = -1)
@RestController
@RequestMapping("/v1/api")
public class StudyScoreController {

    @Autowired
    private StudyScoreService studyScoreService;

    @GetMapping("/admin/studyscore")
    private List<StudyScoreDTO> getAll() {
        return studyScoreService.getStudyScore();
    }

    @GetMapping("/admin/studyscore/{id}")
    private StudyScoreDTO getStudyScoreById(@PathVariable(name = "id") Integer id) {
        return studyScoreService.getStudyScoreById(id);
    }

    @DeleteMapping(value = "/admin/studyscore/delete/{id}")
    private void deleteStudyScore(@PathVariable(name = "id") Integer id) throws Exception {
        studyScoreService.deleteStudyScore(id);
    }

    @PostMapping(value = "/admin/studyscore/add")
    private StudyScoreDTO addEducationProgram(@RequestBody StudyScoreDTO studyScoreDTO, @RequestHeader("sectionScoreId") Integer sectionScoreId) {
        studyScoreService.addStudyScoreService(studyScoreDTO, sectionScoreId);
        return studyScoreDTO;
    }

    @PutMapping(value = "/admin/studyscore/update/{id}")
    public void updateUser(@PathVariable(name = "id") Integer id, @RequestBody StudyScoreDTO studyScoreDTO) throws Exception {
        studyScoreService.updateStudyScore(studyScoreDTO);
    }

    @GetMapping(value = "/admin/studyscore/search/{keyword}")
    public List<StudyScoreDTO> search(@PathVariable(name = "keyword") String keyword) {
        return studyScoreService.search(keyword);
    }

    @GetMapping("/admin/sectionScore_studyScore/{sectionScoreId}")
    private List<StudyScoreDTO> getAllBySectionScoreId(@PathVariable(name = "sectionScoreId") Integer sectionScoreId) {
        return studyScoreService.getSectionScoreStudyScore(sectionScoreId);
    }
}
