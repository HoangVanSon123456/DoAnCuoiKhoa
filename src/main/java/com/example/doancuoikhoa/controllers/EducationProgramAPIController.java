package com.example.doancuoikhoa.controllers;

import com.example.doancuoikhoa.model.EducationProgramDTO;
import com.example.doancuoikhoa.services.EducationProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = -1)
@RestController
@RequestMapping("/v1/api")
public class EducationProgramAPIController {

    @Autowired
    private EducationProgramService educationProgramService;

    @GetMapping("/admin/educationProgram")
    private List<EducationProgramDTO> getAll() {
        return educationProgramService.getListEducationProgram();
    }

    @GetMapping("/admin/educationProgram/{id}")
    private EducationProgramDTO getEducationProgramById(@PathVariable(name = "id") Integer id) {
        return educationProgramService.getEducationProgramById(id);
    }
    @DeleteMapping(value = "/admin/educationProgram/delete/{id}")
    private void deleteEducationProgram(@PathVariable(name = "id") Integer id) throws Exception {
        educationProgramService.deleteEducationProgram(id);
    }

    @PostMapping(value = "/admin/educationProgram/add")
    private EducationProgramDTO addEducationProgram(@RequestBody EducationProgramDTO educationProgramDTO) {
        educationProgramService.addEducationProgramService(educationProgramDTO);
        return educationProgramDTO;
    }

    @PutMapping(value = "/admin/educationProgram/update/{id}")
    public void updateUser(@PathVariable(name = "id") Long id,@RequestBody EducationProgramDTO educationProgramDTO) throws Exception {
        educationProgramService.updateEducationProgram(educationProgramDTO);
    }
}
